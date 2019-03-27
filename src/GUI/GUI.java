package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class GUI {

    protected static final Logger LOGGER = Logger.getLogger(GUI.class.getName());
    private JFrame frame = new JFrame("Tema4 Bank.Bank");

    private JPanel PersonJPanel = new JPanel();
    private JPanel ContJPanel = new JPanel();

    private JPanel downPanelPerson = new JPanel();
    private JPanel downPanelCont = new JPanel();

    private JPanel centerPanelPerson = new JPanel();
    private JPanel centerPanelCont = new JPanel();

    private JPanel leftPanelPerson = new JPanel();
    private JPanel leftPanelCont = new JPanel();

    private JPanel rightPanelPerson = new JPanel();
    private JPanel rightPanelCont = new JPanel();

    private JPanel leftSubPanelCont5 = new JPanel();
    private JPanel leftSubPanelCont6 = new JPanel();
    private JPanel leftSubPanelCont7 = new JPanel();
    private JPanel leftSubPanelCont8 = new JPanel();
    private JPanel leftSubPanelCont9 = new JPanel();

    private JLabel newPersonL = new JLabel("Persoana:");
    private JLabel idPersonL = new JLabel("ID:");
    private JLabel numePersonL = new JLabel("Nume:");
    private JLabel prenumePersonL = new JLabel("Prenume:");
    private JLabel CNPPersonL = new JLabel("CNP:");
    private JLabel adresaPersonL = new JLabel("Adresa:");
    private JLabel emailPersonL = new JLabel("E-mail:");
    private JLabel telefonPersonL = new JLabel("Telefon:");

    private JTextField idPerson = new JTextField();
    private JTextField numePerson = new JTextField();
    private JTextField prenumePerson = new JTextField();
    private JTextField CNPPerson = new JTextField();
    private JTextField adresaPerson = new JTextField();
    private JTextField emailPerson = new JTextField();
    private JTextField telefonPerson = new JTextField();

    private JLabel cont = new JLabel("Cont:");
    private JLabel idContL = new JLabel("ID Cont:");
    private JLabel idPersonContL = new JLabel("ID Persoana:");
    private JLabel soldL = new JLabel("Sold:");
    private JLabel PINL = new JLabel("PIN:");
    private JLabel tipContL = new JLabel("Tip cont:");
    private JLabel dataTermenL = new JLabel("Data ridicare:");


    private JLabel dataL = new JLabel("Data:");

    String[] tipActiuneString = new String[]{"Depunere", "Retragere"};
    private JComboBox tipActiuneL = new JComboBox(tipActiuneString);

    private JTextField idCont = new JTextField();
    private JTextField idPersonCont = new JTextField();
    private JTextField sold = new JTextField();
    private JTextField PIN = new JTextField();
    String[] tip = new String[]{"Saving Bank.Account", "Spending Bank.Account"};
    private JComboBox tipCont = new JComboBox(tip);
    private JTextField dataDepunere = new JTextField();
    private JTextField dataTermen = new JTextField();
    private JTextField data = new JTextField();
    private JTextField actiune = new JTextField();

    private JScrollPane scrollPanePerson;
    private JScrollPane scrollPaneSpendingCont;
    private JScrollPane scrollPaneSavingCont;

    private JButton personAddB = new JButton("Adauga");
    private JButton personEditB = new JButton("Editare");
    private JButton personDeleteB = new JButton("Stergere");
    private JButton personB = new JButton("Persoane");

    private JButton accountAddB = new JButton("Adauga");
    private JButton accountEditB = new JButton("Editare");
    private JButton accountDeleteB = new JButton("Stergere");
    private JButton accountB = new JButton("Conturi");


    private JButton accountActualizareB = new JButton("Actualizeaza conturi");

    private JButton accountDepunereRetragereB = new JButton("Depune/Retrage");

    public GUI() {

        frame.setSize(1200, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridLayout(1, 1));
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.addTab("Bank.Person", PersonPanel());
        tabbedPane.addTab("Cont", ContPanel());
        frame.getContentPane().add(tabbedPane);
    }

    public JPanel PersonPanel() {

        PersonJPanel.setLayout(new BorderLayout());

        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanelPerson.setLayout(new BoxLayout(leftPanelPerson, BoxLayout.Y_AXIS));
        leftPanelPerson.setPreferredSize(new Dimension(350, 20));
        leftPanelPerson.add(newPersonL);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanel0 = new JPanel();
        leftSubPanel0.setLayout(new BoxLayout(leftSubPanel0, BoxLayout.X_AXIS));
        leftSubPanel0.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanel0.add(idPersonL);
        setSizeLabel(idPersonL);
        leftSubPanel0.add(idPerson);
        setSizeTextField(idPerson);
        leftSubPanel0.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelPerson.add(leftSubPanel0);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanel1 = new JPanel();
        leftSubPanel1.setLayout(new BoxLayout(leftSubPanel1, BoxLayout.X_AXIS));
        leftSubPanel1.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanel1.add(numePersonL);
        setSizeLabel(numePersonL);
        leftSubPanel1.add(numePerson);
        setSizeTextField(numePerson);
        leftSubPanel1.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelPerson.add(leftSubPanel1);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanel2 = new JPanel();
        leftSubPanel2.setLayout(new BoxLayout(leftSubPanel2, BoxLayout.X_AXIS));
        leftSubPanel2.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanel2.add(prenumePersonL);
        setSizeLabel(prenumePersonL);
        leftSubPanel2.add(prenumePerson);
        setSizeTextField(prenumePerson);
        leftSubPanel2.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelPerson.add(leftSubPanel2);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanel3 = new JPanel();
        leftSubPanel3.setLayout(new BoxLayout(leftSubPanel3, BoxLayout.X_AXIS));
        leftSubPanel3.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanel3.add(CNPPersonL);
        setSizeLabel(CNPPersonL);
        leftSubPanel3.add(CNPPerson);
        setSizeTextField(CNPPerson);
        leftSubPanel3.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelPerson.add(leftSubPanel3);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanel4 = new JPanel();
        leftSubPanel4.setLayout(new BoxLayout(leftSubPanel4, BoxLayout.X_AXIS));
        leftSubPanel4.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanel4.add(adresaPersonL);
        setSizeLabel(adresaPersonL);
        leftSubPanel4.add(adresaPerson);
        setSizeTextField(adresaPerson);
        leftSubPanel4.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelPerson.add(leftSubPanel4);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanel5 = new JPanel();
        leftSubPanel5.setLayout(new BoxLayout(leftSubPanel5, BoxLayout.X_AXIS));
        leftSubPanel5.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanel5.add(emailPersonL);
        setSizeLabel(emailPersonL);
        leftSubPanel5.add(emailPerson);
        setSizeTextField(emailPerson);
        leftSubPanel5.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelPerson.add(leftSubPanel5);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanel6 = new JPanel();
        leftSubPanel6.setLayout(new BoxLayout(leftSubPanel6, BoxLayout.X_AXIS));
        leftSubPanel6.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanel6.add(telefonPersonL);
        setSizeLabel(telefonPersonL);
        leftSubPanel6.add(telefonPerson);
        setSizeTextField(telefonPerson);
        leftSubPanel6.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelPerson.add(leftSubPanel6);
        leftPanelPerson.add(Box.createRigidArea(new Dimension(0, 30)));

        PersonJPanel.add(leftPanelPerson, BorderLayout.WEST);

        centerPanelPerson.add(Box.createRigidArea(new Dimension(10, 60)));
        centerPanelPerson.setLayout(new BoxLayout(centerPanelPerson, BoxLayout.Y_AXIS));
//        centerPanelClient.setPreferredSize(new Dimension(900, 100));
//        centerPanelClient.add(Box.createRigidArea(new Dimension(75, 30)));
//
        PersonJPanel.add(centerPanelPerson, BorderLayout.EAST);

        downPanelPerson.setLayout(new BoxLayout(downPanelPerson, BoxLayout.X_AXIS));
        downPanelPerson.setPreferredSize(new Dimension(1200, 60));
        downPanelPerson.add(Box.createRigidArea(new Dimension(5, 0)));
        downPanelPerson.add(personAddB);
        downPanelPerson.add(Box.createRigidArea(new Dimension(5, 0)));
        downPanelPerson.add(personEditB);
        downPanelPerson.add(Box.createRigidArea(new Dimension(5, 0)));
        downPanelPerson.add(personDeleteB);
        downPanelPerson.add(Box.createRigidArea(new Dimension(10, 0)));
        downPanelPerson.add(personB);

        PersonJPanel.add(downPanelPerson, BorderLayout.SOUTH);

        return PersonJPanel;
    }

    public JPanel ContPanel() {

        ContJPanel.setLayout(new BorderLayout());

        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 15)));
        leftPanelCont.setLayout(new BoxLayout(leftPanelCont, BoxLayout.Y_AXIS));
        leftPanelCont.setPreferredSize(new Dimension(350, 20));
        leftPanelCont.add(cont);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanelCont0 = new JPanel();
        leftSubPanelCont0.setLayout(new BoxLayout(leftSubPanelCont0, BoxLayout.X_AXIS));
        leftSubPanelCont0.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont0.add(idContL);
        setSizeLabel(idContL);
        leftSubPanelCont0.add(idCont);
        setSizeTextField(idCont);
        leftSubPanelCont0.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont0);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanelCont1 = new JPanel();
        leftSubPanelCont1.setLayout(new BoxLayout(leftSubPanelCont1, BoxLayout.X_AXIS));
        leftSubPanelCont1.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont1.add(idPersonContL);
        setSizeLabel(idPersonContL);
        leftSubPanelCont1.add(idPersonCont);
        setSizeTextField(idPersonCont);
        leftSubPanelCont1.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont1);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanelCont2 = new JPanel();
        leftSubPanelCont2.setLayout(new BoxLayout(leftSubPanelCont2, BoxLayout.X_AXIS));
        leftSubPanelCont2.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont2.add(soldL);
        setSizeLabel(soldL);
        leftSubPanelCont2.add(sold);
        setSizeTextField(sold);
        leftSubPanelCont2.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont2);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanelCont3 = new JPanel();
        leftSubPanelCont3.setLayout(new BoxLayout(leftSubPanelCont3, BoxLayout.X_AXIS));
        leftSubPanelCont3.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont3.add(PINL);
        setSizeLabel(PINL);
        leftSubPanelCont3.add(PIN);
        setSizeTextField(PIN);
        leftSubPanelCont3.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont3);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));

        JPanel leftSubPanelCont4 = new JPanel();
        leftSubPanelCont4.setLayout(new BoxLayout(leftSubPanelCont4, BoxLayout.X_AXIS));
        leftSubPanelCont4.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont4.add(tipContL);
        setSizeLabel(tipContL);
        leftSubPanelCont4.add(tipCont);
        leftSubPanelCont4.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont4);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));
/*
        leftSubPanelCont5 = new JPanel();
        leftSubPanelCont5.setLayout(new BoxLayout(leftSubPanelCont5, BoxLayout.X_AXIS));
        leftSubPanelCont5.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont5.add(dobandaL);
        setSizeLabel(dobandaL);
        leftSubPanelCont5.add(dobanda);
        setSizeTextField(dobanda);
        leftSubPanelCont5.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont5);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));

        leftSubPanelCont6 = new JPanel();
        leftSubPanelCont6.setLayout(new BoxLayout(leftSubPanelCont6, BoxLayout.X_AXIS));
        leftSubPanelCont6.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont6.add(dataDepunereL);
        setSizeLabel(dataDepunereL);
        leftSubPanelCont6.add(dataDepunere);
        setSizeTextField(dataDepunere);
        leftSubPanelCont6.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont4);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));
*/

        leftSubPanelCont7 = new JPanel();
        leftSubPanelCont7.setLayout(new BoxLayout(leftSubPanelCont7, BoxLayout.X_AXIS));
        leftSubPanelCont7.add(Box.createRigidArea(new Dimension(10, 0)));
        leftSubPanelCont7.add(dataTermenL);
        setSizeLabel(dataTermenL);
        leftSubPanelCont7.add(dataTermen);
        setSizeTextField(dataTermen);
        leftSubPanelCont7.add(Box.createRigidArea(new Dimension(10, 0)));
        leftPanelCont.add(leftSubPanelCont7);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));

        leftSubPanelCont8 = new JPanel();
        leftSubPanelCont8.setLayout(new BoxLayout(leftSubPanelCont8, BoxLayout.X_AXIS));
        leftSubPanelCont8.add(Box.createRigidArea(new Dimension(10, 5)));
        leftSubPanelCont8.add(tipActiuneL);
        leftSubPanelCont8.add(Box.createRigidArea(new Dimension(15, 0)));
        leftSubPanelCont8.add(actiune);
        setSizeTextField(actiune);
        leftSubPanelCont8.add(Box.createRigidArea(new Dimension(10, 5)));
        leftPanelCont.add(leftSubPanelCont8);
        leftPanelCont.add(Box.createRigidArea(new Dimension(0, 30)));
/*
        leftSubPanelCont9 = new JPanel();
        leftSubPanelCont9.setLayout(new BoxLayout(leftSubPanelCont9, BoxLayout.X_AXIS));
        leftSubPanelCont9.add(Box.createRigidArea(new Dimension(10, 5)));
        leftSubPanelCont9.add(dataL);
        setSizeLabel(dataL);
        leftSubPanelCont9.add(data);
        setSizeTextField(data);
        leftSubPanelCont9.add(Box.createRigidArea(new Dimension(10, 5)));
*/

        ContJPanel.add(leftPanelCont, BorderLayout.WEST);

        //savingSpending();

        ContJPanel.add(leftPanelCont, BorderLayout.WEST);

        centerPanelCont.add(Box.createRigidArea(new Dimension(10, 60)));
        centerPanelCont.setLayout(new BoxLayout(centerPanelCont, BoxLayout.Y_AXIS));

        ContJPanel.add(centerPanelCont, BorderLayout.EAST);

        downPanelCont.setLayout(new BoxLayout(downPanelCont, BoxLayout.X_AXIS));
        downPanelCont.setPreferredSize(new Dimension(1200, 60));
        downPanelCont.add(Box.createRigidArea(new Dimension(5, 0)));
        downPanelCont.add(accountAddB);
        downPanelCont.add(Box.createRigidArea(new Dimension(5, 0)));
        downPanelCont.add(accountEditB);
        downPanelCont.add(Box.createRigidArea(new Dimension(5, 0)));
        downPanelCont.add(accountDeleteB);
        downPanelCont.add(Box.createRigidArea(new Dimension(10, 0)));
        downPanelCont.add(accountB);
        downPanelCont.add(Box.createRigidArea(new Dimension(10, 0)));
        downPanelCont.add(accountDepunereRetragereB);
        downPanelCont.add(Box.createRigidArea(new Dimension(15, 0)));
        downPanelCont.add(Box.createRigidArea(new Dimension(10, 0)));
        downPanelCont.add(accountActualizareB);

        ContJPanel.add(downPanelCont, BorderLayout.SOUTH);

        return ContJPanel;

    }


    public void setSizeLabel(JLabel jLabel) {
        jLabel.setPreferredSize(new Dimension(100, 0));
    }

    public void setSizeTextField(JTextField jTextField) {
        jTextField.setPreferredSize(new Dimension(50, 0));
    }


    public void close(WindowListener a) {
        frame.addWindowListener(a);
    }

    public void insertPerson(ActionListener a) {
        personAddB.addActionListener(a);
    }

    public void updatePerson(ActionListener a) {
        personEditB.addActionListener(a);
    }

    public void deletePerson(ActionListener a) {
        personDeleteB.addActionListener(a);
    }


    public void insertCont(ActionListener a) {
        accountAddB.addActionListener(a);
    }

    public void updateCont(ActionListener a) {
        accountEditB.addActionListener(a);
    }

    public void deleteCont(ActionListener a) {
        accountDeleteB.addActionListener(a);
    }

    public void depunereCont(ActionListener a) {
        accountDepunereRetragereB.addActionListener(a);
    }


    public void PersonAdminActionListener(ActionListener a) {
        personB.addActionListener(a);
    }

    public void ContAdminActionListener(ActionListener a) {
        accountB.addActionListener(a);
    }

    public void TipContActionListener(ActionListener a) {
        tipCont.addActionListener(a);
    }

    public void TipActiuneActionListener(ActionListener a) {
        tipActiuneL.addActionListener(a);
    }


    public void ContActualizareActionListener(ActionListener a) {
        accountActualizareB.addActionListener(a);
    }

    public void setJlabelPerson(JTable jTable) {
        this.scrollPanePerson = new JScrollPane
                (jTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        centerPanelPerson.add(scrollPanePerson);
        PersonJPanel.add(centerPanelPerson, BorderLayout.CENTER);
        PersonJPanel.revalidate();
        PersonJPanel.repaint();
    }

    public void resetJlabelPerson() {
        if (scrollPanePerson != null) {
            centerPanelPerson.remove(scrollPanePerson);
            PersonJPanel.add(centerPanelPerson, BorderLayout.CENTER);
            PersonJPanel.revalidate();
            PersonJPanel.repaint();
        }
    }

    public void setJlabelCont(JTable jTableSaving, JTable jTableSpending) {
        this.scrollPaneSavingCont = new JScrollPane
                (jTableSaving, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        this.scrollPaneSpendingCont = new JScrollPane
                (jTableSpending, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        centerPanelCont.add(scrollPaneSpendingCont);
        centerPanelCont.add(scrollPaneSavingCont);
        ContJPanel.add(centerPanelCont, BorderLayout.CENTER);
        ContJPanel.revalidate();
        ContJPanel.repaint();

    }

    public void resetJlabelCont() {
        if (scrollPaneSavingCont != null) {
            centerPanelCont.remove(scrollPaneSavingCont);
            ContJPanel.add(centerPanelCont, BorderLayout.CENTER);
            ContJPanel.revalidate();
            ContJPanel.repaint();
        }
        if (scrollPaneSpendingCont != null) {
            centerPanelCont.remove(scrollPaneSpendingCont);
            ContJPanel.add(centerPanelCont, BorderLayout.CENTER);
            ContJPanel.revalidate();
            ContJPanel.repaint();
        }
    }

    public int getIdPersona() {
        return Integer.parseInt(idPerson.getText());
    }

    public String getNumePersoana() {
        return numePerson.getText();
    }

    public String getPrenumePersoana() {
        return prenumePerson.getText();
    }

    public long getCNPPersoana() {
        return (Long.parseLong(CNPPerson.getText()));
    }

    public String getAdresaPersoana() {
        return adresaPerson.getText();
    }

    public String getEmailPersoana() {
        return emailPerson.getText();
    }

    public int getTelefonPersoana() {
        return (Integer.parseInt(telefonPerson.getText()));
    }

    public void setIdPersoana(int idClient) {
        this.idPerson.setText(idClient + "");
    }

    public void setNumePersoana(String numeClient) {
        this.numePerson.setText(numeClient + "");
    }

    public void setPrenumPersoana(String prenumeClient) {
        this.prenumePerson.setText(prenumeClient + "");
    }

    public void setCNPPersoana(long CNPClient) {
        this.CNPPerson.setText(CNPClient + "");
    }

    public void setAdresaPersoana(String adresaClient) {
        this.adresaPerson.setText(adresaClient + "");
    }

    public void setEmailPersoana(String emailClient) {
        this.emailPerson.setText(emailClient + "");
    }

    public void setTelefonPersoana(int telefonClient) {
        this.telefonPerson.setText(telefonClient + "");
    }

    public int getIdCont() {
        return Integer.parseInt(idCont.getText());
    }

    public int getIdPersonCont() {
        return Integer.parseInt(idPersonCont.getText());
    }

    public int getSold() {
        return Integer.parseInt(sold.getText());
    }

    public int getPIN() {
        return Integer.parseInt(PIN.getText());
    }


    public Date getDataTermen() {
        Date data = new Date();
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            data = (Date) formatter.parse(dataTermen.getText().toString());
            return data;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getActiune() {
        return Integer.parseInt(actiune.getText());
    }

    public int getTipActiune() {
        return tipActiuneL.getSelectedIndex();
    }

    public int getTipCont() {
        return tipCont.getSelectedIndex();
    }


    public void setIdCont(int idCont) {
        this.idCont.setText(idCont + "");
    }

    public void setIdPersonCont(int idPersonCont) {
        this.idPersonCont.setText(idPersonCont + "");
    }

    public void setSold(int sold) {
        this.sold.setText(sold + "");
    }

    public void setPIN(int PIN) {
        this.PIN.setText(PIN + "");
    }

    public void setTipCont(int tipCont) {
        this.tipCont.setSelectedIndex(tipCont);
    }

    public void setDataDepunere(Date dataDepunere) {
        SimpleDateFormat formatter2;
        formatter2 = new SimpleDateFormat("yyyy-MM-dd");

        this.dataDepunere.setText(formatter2.format(dataDepunere));
    }

    public void setDataTermen(Date dataTermen) {

        SimpleDateFormat formatter2;
        formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        this.dataTermen.setText(formatter2.format(dataTermen));
    }

    public void setTipActiuneL(int tipActiuneL) {
        this.tipActiuneL.setSelectedIndex(tipActiuneL);
    }

    public void setActiune(int actiune) {
        this.actiune.setText(actiune + "");
    }

    public void setData(Date data) {
        SimpleDateFormat formatter2;
        formatter2 = new SimpleDateFormat("yyyy-MM-dd");
        this.data.setText(formatter2.format(data));
    }
/*
    public void savingSpending() {
        if (getTipCont() == 0) {
            if (accountDepunereRetragereB.getParent() == downPanelCont) {
                downPanelCont.remove(accountDepunereRetragereB);
                downPanelCont.revalidate();
                downPanelCont.repaint();
            }
            if (leftSubPanelCont8.getParent() == leftPanelCont) {
                leftPanelCont.remove(leftSubPanelCont8);
                leftPanelCont.revalidate();
                leftPanelCont.repaint();
            }
            if (leftSubPanelCont9.getParent() == leftPanelCont) {
                leftPanelCont.remove(leftSubPanelCont9);
                leftPanelCont.revalidate();
                leftPanelCont.repaint();
            }
            leftPanelCont.add(leftSubPanelCont5);
            leftPanelCont.add(leftSubPanelCont6);
            leftPanelCont.add(leftSubPanelCont7);

            ContJPanel.add(leftPanelCont, BorderLayout.WEST);
            ContJPanel.revalidate();
            ContJPanel.repaint();

        } else if (getTipCont() == 1) {

            if (leftSubPanelCont5.getParent() == leftPanelCont) {
                leftPanelCont.remove(leftSubPanelCont5);
                leftPanelCont.revalidate();
                leftPanelCont.repaint();
            }
            if (leftSubPanelCont6.getParent() == leftPanelCont) {
                leftPanelCont.remove(leftSubPanelCont6);
                leftPanelCont.revalidate();
                leftPanelCont.repaint();
            }
            if (leftSubPanelCont7.getParent() == leftPanelCont) {
                leftPanelCont.remove(leftSubPanelCont7);
                leftPanelCont.revalidate();
                leftPanelCont.repaint();
            }

            leftPanelCont.add(leftSubPanelCont8);
            leftPanelCont.add(leftSubPanelCont9);

            ContJPanel.add(leftPanelCont, BorderLayout.WEST);

            downPanelCont.add(accountDepunereRetragereB);

            ContJPanel.add(downPanelCont, BorderLayout.SOUTH);

            ContJPanel.revalidate();
            ContJPanel.repaint();
        }
    }
    */
}
