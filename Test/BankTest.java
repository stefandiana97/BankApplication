import bank.Bank;
import bank.Person;
import bank.SavingAccount;
import bank.SpendingAccount;

import java.util.Date;

public class BankTest {

    Bank bank;

    public BankTest(){
        bank=new Bank();
    }
    @org.junit.Test
    public void addPerson() throws Exception {
        Person person=new Person(50,258963,"Sav","Alexandru","Cluj","sav@alex",253952251);
        bank.addPerson(person);
        //assert person.equals(bank.getPerson(1));
    }

    @org.junit.Test
    public void removePerson() throws Exception {
        Person person=new Person(53,258985263,"Sav","Alexandru","Cluj","sav@alex",253952251);
        bank.addPerson(person);
        bank.removePerson(person);
    }

    @org.junit.Test
    public void editPerson() throws Exception {
        Person person=new Person(75,25963,"Sav","Alexandru","Cluj","sav@alex",253952251);
        bank.addPerson(person);
        Person persoana=new Person(75,25963,"Sav","Alex","ClujNapoca","savvvvv@alex",2228);
        bank.editPerson(persoana);
    }

    @org.junit.Test
    public void addAcount() throws Exception {
        Person person=new Person(136,253,"Sav","Alexandru","Cluj","sav@alex",253952251);
        bank.addPerson(person);
        SavingAccount savingAccount=new SavingAccount(1,136,10,new Date(),new Date(),110,new Date());
        SpendingAccount spendingAccount=new SpendingAccount(2,136,150,202,new Date());
        bank.addAcount(savingAccount);
        bank.addAcount(spendingAccount);
    }

    @org.junit.Test
    public void removeAcount() throws Exception {
        Person person=new Person(33,333,"Sav","Alexandru","Cluj","sav@alex",253952251);
        bank.addPerson(person);
        SavingAccount savingAccount=new SavingAccount(1,33,100,new Date(),new Date(),110,new Date());
        SpendingAccount spendingAccount=new SpendingAccount(2,33,150,202,new Date());
        bank.addAcount(savingAccount);
        bank.addAcount(spendingAccount);
        bank.removeAcount(savingAccount);
        bank.removeAcount(spendingAccount);
    }

    @org.junit.Test
    public void writeAccount() throws Exception {
        Person person=new Person(13,963,"Sav","Alexandru","Cluj","sav@alex",253952251);
        bank.addPerson(person);
        SavingAccount savingAccount=new SavingAccount(1,13,100,new Date(),new Date(),110,new Date());
        SpendingAccount spendingAccount=new SpendingAccount(2,13,150,202,new Date());
        bank.addAcount(savingAccount);
        bank.addAcount(spendingAccount);
        SavingAccount savingAccount1=new SavingAccount(1,13,1000,new Date(),new Date(),110, new Date());
        SpendingAccount spendingAccount1=new SpendingAccount(2,13,1500,2202,new Date());
        bank.writeAccount(spendingAccount1);
        bank.writeAccount(savingAccount1);
    }



}
