package GUI;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

public class ReflectionPrint {

    /**
     * se preia capul de tabel din baza de date
     *
     * @param object
     * @return
     */
    public static Vector<String> print_tablename(Object object) {
        Vector<String> tablename = new Vector<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                tablename.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return tablename;
    }

    public static Vector<String> print_tablename_cont(Object object) {
        Vector<String> tablename = new Vector<>();
        for (Field field : object.getClass().getSuperclass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                tablename.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                tablename.add(field.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return tablename;
    }

    /**
     * se preiau datele din baza de date
     *
     * @param object
     * @return
     */
    public static Vector<String> print_data(Object object) {
        Vector<String> data = new Vector<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
                data.add(value + "");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static Vector<String> print_data_cont(Object object) {
        Vector<String> data = new Vector<>();
        for (Field field : object.getClass().getSuperclass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
                data.add(value + "");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(object);
                data.add(value + "");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }


    /**
     * se formeaza un JTable cu datele din baza de date
     *
     * @param list
     * @return
     */
    public static JTable print_table(List<Object> list) {

        JTable jTable;
        try {

            Vector<String> tablename;
            tablename = print_tablename(list.get(0));
            Vector<Vector<String>> data = new Vector<>();
            for (Object object : list) {
                data.add(print_data(object));
            }
            jTable = new JTable(data, tablename);
            jTable.setDefaultEditor(Object.class, null);
            return jTable;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public static JTable print_table_cont(List<Object> list) {

        JTable jTable;
        try {

            Vector<String> tablename;
            tablename = print_tablename_cont(list.get(0));
            Vector<Vector<String>> data = new Vector<>();
            for (Object object : list) {
                data.add(print_data_cont(object));
            }
            jTable = new JTable(data, tablename);
            jTable.setDefaultEditor(Object.class, null);
            return jTable;
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        return null;
    }

}
