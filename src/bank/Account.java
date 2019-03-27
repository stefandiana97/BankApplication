package bank;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

public class Account extends Observable implements Serializable {
    private int accountId;
    private int personId;
    private int sold;
    private int cod;
    private Date data;

    public Account(int accountId, int personId, int sold, int cod, Date data) {
        this.accountId = accountId;
        this.personId = personId;
        this.sold = sold;
        this.cod = cod;
        this.data = data;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getPersonId() {
        return personId;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
        setChanged();
        notifyObservers(sold);
        clearChanged();
    }

    public void actualizareSold() throws Exception {
        throw new Exception("Verifica contul cu id" + accountId);
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
        setChanged();
        notifyObservers(cod);
        clearChanged();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
        setChanged();
        notifyObservers(data);
        clearChanged();
    }

    public Date getDataDepunere() throws Exception {
        throw new Exception("Verifica contul");
    }

    public void setDataDepunere(Date dataDepunere) throws Exception {
        throw new Exception("Verifica contul");
    }

    public Date getDataRidicare() throws Exception {
        //throw new Exception("Verifica contul");
        return null;
    }

    public void setDataRidicare(Date laTermen) throws Exception {
        //throw new Exception("Verifica contul");
    }

    public void depune(int money) throws Exception {
        if (money > 0) {
            this.sold += money;
            setChanged();
            notifyObservers(sold);
            clearChanged();
        } else {
            JOptionPane.showMessageDialog(new Frame(),
                    "Cantitate de bani incorecta");
            throw new Exception("Cantitate de bani incorecta");
        }
    }

    public void retrage(int money) throws Exception {
        throw new Exception("Nu se poate face retragerea");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return (getAccountId() == account.getAccountId());
    }

    @Override
    public String toString() {
        return "Bank.Account{" +
                "accountId=" + accountId +
                ", personId=" + personId +
                ", sold=" + sold +
                '}';
    }
}
