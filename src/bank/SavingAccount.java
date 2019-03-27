package bank;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SavingAccount extends Account implements Serializable {

    private int dobanda = 20;
    private Date dataDepunere;
    private Date laTermen;
    private boolean exista;


    public SavingAccount(int accountId, int personId, int sold, Date data, Date perioada, int cod, Date dateActualizat) {
        super(accountId, personId, sold, cod, dateActualizat);
        this.dataDepunere = data;
        this.laTermen = perioada;
        this.exista = true;
    }

    public void actualizareSold() throws Exception {

        if (exista == true) {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            if ((fmt.format(date)).equals(fmt.format(laTermen))) {
                long diff = dataDepunere.getTime() - laTermen.getTime();
                int days = (int) (diff / (1000 * 60 * 60 * 24));
                days = 1;
                int soldnou = super.getSold() * dobanda * days / 360;
                if (soldnou != 0) {
                    super.setSold(super.getSold() + soldnou);
                }
            }
        } else {
            throw new Exception("Depozit invalid");
        }
    }

    public void depune(int money) throws Exception {
        if (exista == true) {
            super.depune(money);
        } else {
            throw new Exception("Depozit invalid");
        }
    }

    public void retrage(int money) throws Exception {
        if (exista == true) {
            if (money > 0) {
                if (super.getSold() == money) {
                    super.setSold(super.getSold() - money);
                    exista = false;
                } else {
                    JOptionPane.showMessageDialog(new Frame(),
                            "Suma de bani incorecta. Ai voie sa soti o singura data intreaga suma de bani.");
                    throw new Exception("Suma de bani incorecta. Ai voie sa soti o singura data intreaga suma de bani.");
                }
            } else {
                JOptionPane.showMessageDialog(new Frame(),
                        "Cantitate de bani incorecta");
                throw new Exception("Cantitate de bani incorecta");
            }
        } else {
            throw new Exception("Depozit invalid");
        }
    }

    public Date getDataDepunere() {

        return dataDepunere;
    }

    public void setDataDepunere(Date dataDepunere) {
        this.dataDepunere = dataDepunere;
        setChanged();
        notifyObservers(dataDepunere);
    }

    public Date getDataRidicare() {
        return laTermen;
    }

    public void setDataRidicare(Date laTermen) throws Exception {
        if (exista == true) {
            this.laTermen = laTermen;
            setChanged();
            notifyObservers(laTermen);
        } else {
            throw new Exception("Depozit invalid");
        }
    }

    public boolean isExista() {
        return exista;
    }

    public void setExista(boolean exista) {
        this.exista = exista;
    }
}
