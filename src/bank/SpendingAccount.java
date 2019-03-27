package bank;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.Date;

public class SpendingAccount extends Account implements Serializable {

    public SpendingAccount(int accountId, int personId, int sold, int cod, Date data) {
        super(accountId, personId, sold, cod, data);
    }

    public void retrage(int money) throws Exception {
        if (money > 0) {
            if (super.getSold() >= money) {
                super.setSold(super.getSold() - money);
            } else {
                JOptionPane.showMessageDialog(new Frame(),
                        "Bani insuficienti");
                throw new Exception("Bani insuficienti");
            }
        } else {
            JOptionPane.showMessageDialog(new Frame(),
                    "Cantitate de bani incorecta");
            throw new Exception("Cantitate de bani incorecta");
        }
    }

}
