package bank;

import GUI.File;
import observer.*;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class Bank implements BankProc, Serializable {

    private HashMap<Person, ArrayList<Account>> bank;

    public Bank() {

        //this.bank = new HashMap<Person,ArrayList<Account>>();
        this.bank = File.deSerialization("bank.txt");

    }

    public HashMap<Person, ArrayList<Account>> getBank() {
        return bank;
    }

    @Override
    public void addPerson(Person persoana) {
        assert (persoana != null) : "Persoana nu poate fi nula";
        assert !bank.containsKey(persoana) : "Personana poate sa existe deja";
        assert isWellFormed() : "Format incorect";
        int sizePre = bank.size();

        Person p = null;
        for (Person person : bank.keySet()) {
            if (person.getCNP() == persoana.getCNP() || person.getPersonId() == persoana.getPersonId()) {
                p = person;
            }
        }
        if (p == null) {
            bank.put(persoana, new ArrayList<>());
            //File.serialization("bank.txt", bank);
            int sizePost = bank.size();
            assert sizePost == sizePre + 1 : "Nu s-a adaugat";
            assert bank.containsKey(persoana) : "Persoana nu se regaseste";
            assert isWellFormed() : "Format incorect";
        } else {
            JOptionPane.showMessageDialog(new Frame(),
                    "Date incorecte sau persoana deja exista.");
            int sizePost = bank.size();
            assert sizePost == sizePre : "S-a adaugat";
            assert bank.containsKey(persoana) : "Persoana nu se regaseste";
            assert isWellFormed() : "Format incorect";
        }
    }

    @Override
    public void removePerson(Person persoana) {
        assert persoana != null : "Persoana nu poate fi nula";
        assert bank.containsKey(persoana) : "Personana nu exista";
        assert isWellFormed() : "Date incorecte";
        int sizePre = bank.size();

        bank.remove(persoana);

        //File.serialization("bank.txt", bank);
        int sizePost = bank.size();
        assert sizePost == sizePre - 1 : "Personana nu a fost stearsa";
        assert !bank.containsKey(persoana) : "Personana nu a fost stearsa";
        assert isWellFormed() : "Date incorecte";
    }

    @Override
    public void editPerson(Person persoana) {
        assert persoana != null : "Persoana nu poate fi nula";
        assert bank.containsKey(persoana) : "Persoana nu exista";
        assert isWellFormed() : "Date incorecte";
        int sizePre = bank.size();

        for (Person person : bank.keySet()) {
            if (persoana.equals(person)) {
                person.setNume(persoana.getNume());
                person.setPrenume(persoana.getPrenume());
                person.setAdresa(persoana.getAdresa());
                person.setEmail(persoana.getEmail());
                person.setTelefon(persoana.getTelefon());
            }
        }
        //File.serialization("bank.txt", bank);
        int sizePost = bank.size();
        assert sizePost == sizePre;
        assert bank.containsKey(persoana) : "Persoana nu exista";
        assert isWellFormed() : "Date incorecte";
    }

    @Override
    public void addAcount(Account cont) {
        assert cont != null : "Contul nu poate fi nul";
        assert isWellFormed() : "Date incorecte";
        int sizePre = 0;

        PinObserver pinObserver = new PinObserver();
        RidicareDobandaObserver ridicareDobandaObserver = new RidicareDobandaObserver();
        DepunereObserver depunereObserver = new DepunereObserver();
        RetragereObserver retragereObserver = new RetragereObserver();

        cont.addObserver(pinObserver);
        cont.addObserver(ridicareDobandaObserver);
        cont.addObserver(depunereObserver);
        cont.addObserver(retragereObserver);

        Account account = null;
        ArrayList<Account> arrayList = null;
        for (Person person : bank.keySet()) {
            if (person.getPersonId() == cont.getPersonId()) {
                arrayList = bank.get(person);
                for (Account account1 : arrayList) {
                    if (account1.equals(cont)) {
                        account = account1;
                    }
                }
                if (account == null) {
                    sizePre = arrayList.size();
                    cont.addObserver(pinObserver);
                    cont.addObserver(ridicareDobandaObserver);
                    cont.addObserver(depunereObserver);
                    cont.addObserver(retragereObserver);
                    arrayList.add(cont);
                }
            }
        }

        //File.serialization("bank.txt", bank);
        int sizePost = arrayList.size();
        assert sizePost == sizePre + 1 : "Cont neadaugat";
        assert isWellFormed() : "Date incorecte";
    }

    @Override
    public void removeAcount(Account cont) {
        assert cont != null : "Contul nu poate fi nul";
        assert isWellFormed() : "Date incorecte";
        int sizePre = 0;
        int sizePost = 0;

        ArrayList<Account> arrayList = null;
        for (Person person : bank.keySet()) {
            if (person.getPersonId() == cont.getPersonId()) {
                arrayList = bank.get(person);
                sizePre = arrayList.size();
                for (Account account : arrayList) {
                    if (account.equals(cont)) {
                        arrayList.remove(account);
                        break;
                    }
                }
            }
        }
        //File.serialization("bank.txt", bank);
        sizePost = arrayList.size();
        assert sizePost == sizePre - 1 : "Contul nu a fost sters";
        assert isWellFormed() : "Date incorecte";
    }

    @Override
    public void writeAccount(Account cont) throws Exception {
        assert isWellFormed() : "Date incorecte";
        assert cont != null : "Contul nu poate fi nul";

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<Account> arrayList = null;
        for (Person person : bank.keySet()) {
            if (person.getPersonId() == cont.getPersonId()) {
                arrayList = bank.get(person);
                for (Account account : arrayList) {
                    if (account.equals(cont)) {
                        if (account.getCod() != cont.getCod()) {
                            addObserverPin(account);
                            account.setCod(cont.getCod());
                        }
                        addObserverData(account);
                        account.setData(new Date());
                        if (account.getDataRidicare() != null && cont.getDataRidicare() != null) {
                            if (!fmt.format(account.getDataRidicare()).equals(fmt.format(cont.getDataRidicare()))) {
                                addObserverRidicareDobanda(account);
                                account.setDataRidicare(cont.getDataRidicare());
                            }
                        }
                    }
                }
            }
        }
        //File.serialization("bank.txt", bank);
        assert isWellFormed() : "Date incorecte";
    }

    public void depuneRetrageAccount(Account cont, int i, int money) throws Exception {
        assert isWellFormed();
        assert cont != null : "Contul nu poate fi nul";

        ArrayList<Account> arrayList = null;
        for (Person person : bank.keySet()) {
            if (person.getPersonId() == cont.getPersonId()) {
                arrayList = bank.get(person);
                for (Account account : arrayList) {
                    if (account.equals(cont)) {
                        if (i == 0) {
                            addObserverDepunere(account);
                            account.depune(money);
                        } else {
                            addObserverRidicare(account);
                            account.retrage(money);
                        }
                    }
                }
            }
        }
        //File.serialization("bank.txt", bank);
        assert isWellFormed() : "Date incorecte";
    }

    public boolean isWellFormed() {
        Set set = bank.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry m = (Map.Entry) iterator.next();
            if (m.getKey() == null && m.getValue() != null)
                return false;
            if (m.getKey() != null && m.getValue() == null)
                return false;
            if (!isWellFormedPerson(m.getKey()))
                return false;
            ArrayList<Account> accountArrayList = (ArrayList<Account>) m.getValue();
            for (Account account : accountArrayList) {
                if (!isWellFormedAccount(account))
                    return false;
            }
        }
        return true;
    }

    public boolean isWellFormedPerson(Object person) {
        if (person == null)
            return false;
        if (((Person) person).getPersonId() == 0) {
            return false;
        }
        if (((Person) person).getNume().equals("")) {
            return false;
        }
        if (((Person) person).getPrenume().equals("")) {
            return false;
        }
        if (((Person) person).getAdresa().equals("")) {
            return false;
        }
        if (((Person) person).getEmail().equals("")) {
            return false;
        }
        if (((Person) person).getTelefon() == 0) {
            return false;
        }
        return true;
    }

    public boolean isWellFormedAccount(Object account) {
        if (account == null)
            return false;
        if (((Account) account).getAccountId() == 0)
            return false;
        if (((Account) account).getCod() <= 0)
            return false;
        if (((Account) account).getSold() < 0)
            return false;
        if (((Account) account).getPersonId() == 0)
            return false;
        return true;
    }

    public Person getPerson(int index) {
        Set setPerson = bank.entrySet();
        Person person = null;
        Iterator i = setPerson.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            person = (Person) m.getKey();
            if (person.getPersonId() == index)
                return person;
        }
        return person;
    }

    public ArrayList<Object> getAllPersons() {
        ArrayList<Object> listPersons = new ArrayList<>();
        Set setPerson = bank.entrySet();
        Person person = null;
        Iterator i = setPerson.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            person = (Person) m.getKey();
            listPersons.add(person);
        }
        return listPersons;
    }

    public ArrayList<Object> getAllSavingAccounts() {
        ArrayList<Object> listAccounts = new ArrayList<>();
        Set set = bank.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            ArrayList<Account> accountArrayList = (ArrayList<Account>) m.getValue();
            for (Account account1 : accountArrayList) {
                if (account1 instanceof SavingAccount) {
                    listAccounts.add(account1);
                }
            }
        }
        return listAccounts;
    }

    public ArrayList<Object> getAllSpendingAccounts() {
        ArrayList<Object> listAccounts = new ArrayList<>();
        Set set = bank.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            ArrayList<Account> accountArrayList = (ArrayList<Account>) m.getValue();
            for (Account account1 : accountArrayList) {
                if (account1 instanceof SpendingAccount) {
                    listAccounts.add(account1);
                }
            }
        }
        return listAccounts;
    }

    public void setSoldAllAccounts() throws Exception {
        Set set = bank.entrySet();
        SoldSavingAccountObserver soldSavingAccountObserver = new SoldSavingAccountObserver();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry m = (Map.Entry) i.next();
            ArrayList<Account> accountArrayList = (ArrayList<Account>) m.getValue();
            for (Account account1 : accountArrayList) {
                if (account1 instanceof SavingAccount) {
                    if (account1.countObservers() != 0)
                        account1.deleteObservers();
                    account1.addObserver(soldSavingAccountObserver);
                    account1.actualizareSold();
                }
            }
        }
        //File.serialization("bank.txt", bank);
    }

    public void addObservers() {
        PinObserver pinObserver = new PinObserver();
        RidicareDobandaObserver ridicareDobandaObserver = new RidicareDobandaObserver();
        DepunereObserver depunereObserver = new DepunereObserver();
        RetragereObserver retragereObserver = new RetragereObserver();

        ArrayList<Account> arrayList = null;
        for (Person person : bank.keySet()) {
            arrayList = bank.get(person);
            for (Account account1 : arrayList) {
                account1.addObserver(pinObserver);
                account1.addObserver(ridicareDobandaObserver);
                account1.addObserver(depunereObserver);
                account1.addObserver(retragereObserver);
            }
        }
    }

    public void addObserverDepunere(Account account) {

        DepunereObserver depunereObserver = new DepunereObserver();
        if (account.countObservers() != 0)
            account.deleteObservers();
        account.addObserver(depunereObserver);
    }

    public void addObserverRidicare(Account account) {

        RetragereObserver ridicareObserver = new RetragereObserver();
        if (account.countObservers() != 0)
            account.deleteObservers();
        account.addObserver(ridicareObserver);
    }

    public void addObserverPin(Account account) {

        PinObserver pinObserver = new PinObserver();
        if (account.countObservers() != 0)
            account.deleteObservers();
        account.addObserver(pinObserver);
    }

    public void addObserverRidicareDobanda(Account account) {
        RidicareDobandaObserver ridicareDobandaObserver = new RidicareDobandaObserver();
        if (account.countObservers() != 0)
            account.deleteObservers();
        account.addObserver(ridicareDobandaObserver);
    }

    public void addObserverData(Account account) {
        if (account.countObservers() != 0)
            account.deleteObservers();
    }

}
