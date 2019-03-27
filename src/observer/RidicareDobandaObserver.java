package observer;

import bank.Account;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

public class RidicareDobandaObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");

        if (arg instanceof Date) {
            String s = fmt.format(arg);
            System.out.println("S-a efectuat o modificare a datei ridicarii dobanzii pentru persoana cu id-ul:" + ((Account) o).getPersonId() + ", noua data este " + s + ".");

        }
    }
}
