package GUI;

import bank.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ActionL {

    private GUI gui;
    private JTable jTablePerson;
    private JTable jTableSavingCont;
    private JTable jTableSpendingCont;
    private Bank bank;


    public ActionL() {
        gui = new GUI();
        gui.PersonAdminActionListener(new PersonActionListener());
        gui.ContAdminActionListener(new ContActionListener());
        gui.insertPerson(new InsertPerson());
        gui.updatePerson(new UpdatePerson());
        gui.deletePerson(new DeletePerson());
        gui.insertCont(new InsertCont());
        gui.updateCont(new UpdateCont());
        gui.deleteCont(new DeleteCont());
        gui.depunereCont(new DepunereRetragereCont());
        gui.TipContActionListener(new TipContActionListener());
        gui.TipActiuneActionListener(new TipActiuneActionListener());
        gui.close(new Close());
        gui.ContActualizareActionListener(new ActualizareConturi());
        bank = new Bank();
    }

    class Close implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            File.serialization("bank.txt", bank.getBank());
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }


    class PersonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.resetJlabelPerson();
            ArrayList<Object> personList = bank.getAllPersons();
            if (personList.size() != 0) {
                jTablePerson = ReflectionPrint.print_table(personList);
            }
            ListSelectionModel listSelectionModel = jTablePerson.getSelectionModel();
            listSelectionModel.addListSelectionListener(new PersonListSelectionListener());
            jTablePerson.setSelectionModel(listSelectionModel);
            jTablePerson.setFillsViewportHeight(true);
            gui.setJlabelPerson(jTablePerson);
        }
    }

    class PersonListSelectionListener implements ListSelectionListener {

        /**
         * se preiau datele din tabela JTable si sunt introduse in interfata
         *
         * @param e
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (lsm.isSelectionEmpty()) {
            } else {
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                int id = 0, telefon = 0;
                long CNP = 0;
                String nume = "", prenume = "", adresa = "", email = "";
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                        id = Integer.parseInt((String) jTablePerson.getValueAt(i, 0));
                        nume = (String) jTablePerson.getValueAt(i, 2);
                        prenume = (String) jTablePerson.getValueAt(i, 3);
                        CNP = Long.parseLong((String) jTablePerson.getValueAt(i, 1));
                        adresa = (String) jTablePerson.getValueAt(i, 4);
                        email = (String) jTablePerson.getValueAt(i, 5);
                        telefon = Integer.parseInt((String) jTablePerson.getValueAt(i, 6));
                    }
                }
                gui.setIdPersoana(id);
                gui.setNumePersoana(nume);
                gui.setPrenumPersoana(prenume);
                gui.setCNPPersoana(CNP);
                gui.setAdresaPersoana(adresa);
                gui.setEmailPersoana(email);
                gui.setTelefonPersoana(telefon);
            }
        }
    }

    class ContActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.resetJlabelCont();
            ArrayList<Object> savingContList = bank.getAllSavingAccounts();
            ArrayList<Object> spendingContList = bank.getAllSpendingAccounts();
            if (savingContList.size() != 0) {
                jTableSavingCont = ReflectionPrint.print_table_cont(savingContList);
            } else {
                jTableSavingCont = new JTable();
            }
            if (spendingContList.size() != 0) {
                jTableSpendingCont = ReflectionPrint.print_table_cont(spendingContList);
            } else {
                jTableSpendingCont = new JTable();
            }
            ListSelectionModel listSelectionModelSaving = jTableSavingCont.getSelectionModel();
            listSelectionModelSaving.addListSelectionListener(new SavingContListSelectionListener());
            jTableSavingCont.setSelectionModel(listSelectionModelSaving);
            jTableSavingCont.setFillsViewportHeight(true);

            ListSelectionModel listSelectionModelSpending = jTableSpendingCont.getSelectionModel();
            listSelectionModelSpending.addListSelectionListener(new SpendingContListSelectionListener());
            jTableSpendingCont.setSelectionModel(listSelectionModelSpending);
            jTableSpendingCont.setFillsViewportHeight(true);

            gui.setJlabelCont(jTableSavingCont, jTableSpendingCont);
        }
    }


    class SavingContListSelectionListener implements ListSelectionListener {

        /**
         * se preiau datele din tabela JTable si sunt introduse in interfata
         *
         * @param e
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (lsm.isSelectionEmpty()) {
            } else {
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                int idCont = 0, idPersonCont = 0, sold = 0, pin = 0, indexTipCont = 0;
                Date dataDepunere = new Date(), dataTermen = new Date();
                SimpleDateFormat formatter;
                formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                        idCont = Integer.parseInt((String) jTableSavingCont.getValueAt(i, 0));
                        idPersonCont = Integer.parseInt((String) jTableSavingCont.getValueAt(i, 1));
                        sold = Integer.parseInt((String) jTableSavingCont.getValueAt(i, 2));
                        pin = Integer.parseInt((String) jTableSavingCont.getValueAt(i, 3));
                        //dobanda = Integer.parseInt((String) jTableSavingCont.getValueAt(i, 4));
                        try {
                            String ceva = jTableSavingCont.getValueAt(i, 7).toString();
                            dataDepunere = formatter.parse(ceva);
                            dataTermen = formatter.parse(jTableSavingCont.getValueAt(i, 6).toString());
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                gui.setIdCont(idCont);
                gui.setIdPersonCont(idPersonCont);
                gui.setSold(sold);
                gui.setPIN(pin);
                gui.setTipCont(indexTipCont);
                gui.setDataDepunere(dataDepunere);
                gui.setDataTermen(dataTermen);
            }
        }
    }

    class SpendingContListSelectionListener implements ListSelectionListener {

        /**
         * se preiau datele din tabela JTable si sunt introduse in interfata
         *
         * @param e
         */
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            if (lsm.isSelectionEmpty()) {
            } else {
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                int idCont = 0, idPersonCont = 0, sold = 0, pin = 0, indexTipCont = 1;
                Date data = new Date();
                SimpleDateFormat formatter;
                formatter = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                        idCont = Integer.parseInt((String) jTableSpendingCont.getValueAt(i, 0));
                        idPersonCont = Integer.parseInt((String) jTableSpendingCont.getValueAt(i, 1));
                        sold = Integer.parseInt((String) jTableSpendingCont.getValueAt(i, 2));
                        pin = Integer.parseInt((String) jTableSpendingCont.getValueAt(i, 3));
                        try {
                            String ceva = jTableSpendingCont.getValueAt(i, 4).toString();
                            data = formatter.parse(ceva);
                        } catch (ParseException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                gui.setIdCont(idCont);
                gui.setIdPersonCont(idPersonCont);
                gui.setSold(sold);
                gui.setPIN(pin);
                gui.setTipCont(indexTipCont);
                gui.setData(data);
            }
        }
    }

    class ActualizareConturi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                bank.setSoldAllAccounts();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new Frame(),
                        "Verifica contul " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    class InsertPerson implements ActionListener {

        /**
         * Se insereaza un client in baza de date
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idPersoana = gui.getIdPersona();
                String nume = gui.getNumePersoana();
                String prenume = gui.getPrenumePersoana();
                long CNP = gui.getCNPPersoana();
                String adresa = gui.getAdresaPersoana();
                String email = gui.getEmailPersoana();
                int telefon = gui.getTelefonPersoana();
                Person person = new Person(idPersoana, CNP, nume, prenume, adresa, email, telefon);
                bank.addPerson(person);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(new Frame(),
                        "A-ti introdus datele gresit! " + ex.getMessage());
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new Frame(),
                        "Introduceti date valide! " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    class UpdatePerson implements ActionListener {

        /**
         * Se editeaza clientii din baza de date
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idPersoana = gui.getIdPersona();
                String nume = gui.getNumePersoana();
                String prenume = gui.getPrenumePersoana();
                long CNP = gui.getCNPPersoana();
                String adresa = gui.getAdresaPersoana();
                String email = gui.getEmailPersoana();
                int telefon = gui.getTelefonPersoana();
                Person person = new Person(idPersoana, CNP, nume, prenume, adresa, email, telefon);
                bank.editPerson(person);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(new Frame(),
                        "Introduceti date valide! " + ex.getMessage());
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new Frame(),
                        "Introduceti date valide! " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    class DeletePerson implements ActionListener {
        /**
         * Se sterge o persoana din baza de date
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int id = gui.getIdPersona();
                long CNP = gui.getCNPPersoana();
                Person person = new Person(id, CNP, "", "", "", "", 0);
                bank.removePerson(person);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(new Frame(),
                        "Introduceti date valide! " + ex.getMessage());
                ex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(new Frame(),
                        "Introduceti date valide! " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }

    class InsertCont implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idCont = gui.getIdCont();
            int idPersonCont = gui.getIdPersonCont();
            int sold = gui.getSold();
            int PIN = gui.getPIN();
            int tipCont = gui.getTipCont();
            if (tipCont == 0) {
                Date dataDepunere = new Date();
                Date dataTermen = gui.getDataTermen();
                SavingAccount account = new SavingAccount(idCont, idPersonCont, sold, dataDepunere, dataTermen, PIN, new Date());
                bank.addAcount(account);
            } else if (tipCont == 1) {
                Date date = new Date();
                SpendingAccount account = new SpendingAccount(idCont, idPersonCont, sold, PIN, date);
                bank.addAcount(account);
            }
        }
    }

    class UpdateCont implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idCont = gui.getIdCont();
            int idPersonCont = gui.getIdPersonCont();
            int sold = gui.getSold();
            int PIN = gui.getPIN();
            int tipCont = gui.getTipCont();
            if (tipCont == 0) {
                Date dataDepunere = new Date();
                Date dataTermen = gui.getDataTermen();
                SavingAccount account = new SavingAccount(idCont, idPersonCont, sold, dataDepunere, dataTermen, PIN, new Date());
                try {
                    bank.writeAccount(account);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else if (tipCont == 1) {
                Date date = new Date();
                SpendingAccount account = new SpendingAccount(idCont, idPersonCont, sold, PIN, date);
                try {
                    bank.writeAccount(account);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    class DeleteCont implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idCont = gui.getIdCont();
            int idPersonCont = gui.getIdPersonCont();
            int sold = gui.getSold();
            int PIN = gui.getPIN();
            int tipCont = gui.getTipCont();
            if (tipCont == 0) {
                Date dataDepunere = new Date();
                Date dataTermen = gui.getDataTermen();
                SavingAccount account = new SavingAccount(idCont, idPersonCont, sold, dataDepunere, dataTermen, PIN, new Date());
                bank.removeAcount(account);
            } else if (tipCont == 1) {
                Date date = new Date();
                SpendingAccount account = new SpendingAccount(idCont, idPersonCont, sold, PIN, date);
                bank.removeAcount(account);
            }
        }
    }

    class DepunereRetragereCont implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int idCont = gui.getIdCont();
            int idPersonCont = gui.getIdPersonCont();
            int sold = gui.getSold();
            int PIN = gui.getPIN();
            int tipCont = gui.getTipCont();
            if (tipCont == 0) {
                int tipActiune = gui.getTipActiune();
                int money = gui.getActiune();
                Date date = new Date();
                Account account = new SavingAccount(idCont, idPersonCont, sold, new Date(), new Date(), PIN, date);
                try {
                    bank.depuneRetrageAccount(account, tipActiune, money);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            } else if (tipCont == 1) {
                int tipActiune = gui.getTipActiune();
                int money = gui.getActiune();
                Date date = new Date();
                Account account = new SpendingAccount(idCont, idPersonCont, sold, PIN, date);
                try {
                    bank.depuneRetrageAccount(account, tipActiune, money);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    class TipContActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //gui.savingSpending();
        }
    }

    class TipActiuneActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
