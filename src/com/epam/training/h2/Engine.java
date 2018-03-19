package com.epam.training.h2;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

class Engine {

    static void lets() {
        
        final String DRIVER = "org.h2.Driver";
        final String DATABASE = "jdbc:h2:~/test";
        final String DATABASE_USER = "sa";
        final String DATABASE_USER_PASSWORD = "";

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("Подключение к базе данных...");
            Connection conn = DriverManager.getConnection(DATABASE, DATABASE_USER, DATABASE_USER_PASSWORD);
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS books (ISBN BIGINT not NULL, addedDate DATE, author VARCHAR(255), title VARCHAR(255), PRIMARY KEY ( ISBN ))");
            ResultSet rs = st.executeQuery("SELECT * FROM books");
            if (!rs.next()) {
                System.out.println("Записи в таблице books не обнаружены, используется заглушка из 10 записей для демо-режима");
                st.execute("INSERT INTO books VALUES (1234567890123, '1992-10-30', 'Athor1', 'title1')");
                st.execute("INSERT INTO books VALUES (2234567890123, '1995-11-02', 'Athor2', 'title2')");
                st.execute("INSERT INTO books VALUES (3234567890123, '1999-10-23', 'Athor3', 'title3')");
                st.execute("INSERT INTO books VALUES (4234567890123, '1993-10-30', 'Athor4', 'title4')");
                st.execute("INSERT INTO books VALUES (5234567890123, '1998-10-30', 'Athor5', 'title5')");
                st.execute("INSERT INTO books VALUES (6234567890123, '2000-10-30', 'Athor6', 'title6')");
                st.execute("INSERT INTO books VALUES (7234567890123, '2008-10-30', 'Athor7', 'title7')");
                st.execute("INSERT INTO books VALUES (8234567890123, '2017-10-30', 'Athor8', 'title8')");
                st.execute("INSERT INTO books VALUES (9234567890123, '2012-10-30', 'Athor9', 'title9')");
                st.execute("INSERT INTO books VALUES (1434567890123, '2001-10-30', 'Athor10', 'title10')");
            }
            PreparedStatement pr = conn.prepareStatement("SELECT * FROM books WHERE ISBN = ?");
            Scanner sc = new Scanner(System.in);
            while (true) {
                try {

                    System.out.println("Для ввода книги нажмите 1, для получения списка книг нажмите 2, для получения книги по ISBN нажмите 3, для выхода из программы 4");
                    int mainKey = sc.nextInt();
                    if (mainKey == 1) {
                        System.out.println("Введите ISBN");
                        long isbn = sc.nextLong();

                        pr.setLong(1, isbn);
                        rs = pr.executeQuery();
                        if (rs.next()) {
                            System.out.println("Введён уже существующий ISBN");
                            continue;
                        } else {
                            Date dateNow = new Date();
                            SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
                            System.out.println("Введите имя автора");
                            String name = sc.next();
                            System.out.println("Введите название книги");
                            String title = sc.next();
                            pr = conn.prepareStatement("INSERT INTO books VALUES (?, ?, ?, ?,)");
                            pr.setLong(1, isbn);
                            pr.setString(2, formatForDateNow.format(dateNow));
                            pr.setString(3, name);
                            pr.setString(4, title);
                            pr.execute();
                        }
                    } else if (mainKey == 2) {

                        System.out.println("Вывести книги в порядке ISBN нажмите 1, по дате добавления нажмите 2, по автору 3, по названию книг 4, вывести по диапазону ISBN 5");
                        int key = sc.nextInt();
                        if (key == 1) {
                            rs = st.executeQuery("SELECT * FROM books");
                            while (rs.next())
                                System.out.println("ISBN: " + rs.getLong("ISBN") + " Date: " + rs.getString(2) + " Author: " + rs.getString(3) + " Title: " + rs.getString(4));
                        } else if (key == 2) {
                            rs = st.executeQuery("SELECT * FROM books ORDER BY addedDate");
                            while (rs.next())
                                System.out.println("ISBN: " + rs.getLong("ISBN") + " Date: " + rs.getString(2) + " Author: " + rs.getString(3) + " Title: " + rs.getString(4));
                        } else if (key == 3) {
                            rs = st.executeQuery("SELECT * FROM books ORDER BY author");
                            while (rs.next())
                                System.out.println("ISBN: " + rs.getLong("ISBN") + " Date: " + rs.getString(2) + " Author: " + rs.getString(3) + " Title: " + rs.getString(4));
                        } else if (key == 4) {
                            rs = st.executeQuery("SELECT * FROM books ORDER BY title");
                            while (rs.next())
                                System.out.println("ISBN: " + rs.getLong("ISBN") + " Date: " + rs.getString(2) + " Author: " + rs.getString(3) + " Title: " + rs.getString(4));
                        } else if (key == 5) {
                            System.out.println("Введите нижнюю грницу ISBN");
                            long isbn1 = sc.nextLong();
                            System.out.println("Введите верхнюю грницу ISBN");
                            long isbn2 = sc.nextLong();
                            pr = conn.prepareStatement("SELECT * FROM books WHERE ISBN >= ? AND ISBN <= ?");
                            if (isbn1 <= isbn2) {
                                pr.setLong(1, isbn1);
                                pr.setLong(2, isbn2);
                            } else {
                                pr.setLong(1, isbn2);
                                pr.setLong(2, isbn1);
                            }
                            rs = pr.executeQuery();
                            while (rs.next())
                                System.out.println("ISBN: " + rs.getLong("ISBN") + " Date: " + rs.getString(2) + " Author: " + rs.getString(3) + " Title: " + rs.getString(4));
                        }

                    } else if (mainKey == 3) {
                        System.out.println("Введите ISBN");
                        pr = conn.prepareStatement("SELECT * FROM books WHERE ISBN = ? ");
                        long isbn = sc.nextLong();
                        pr.setLong(1, isbn);
                        rs = pr.executeQuery();
                        if (rs.next())
                            System.out.println("ISBN: " + rs.getLong("ISBN") + " Date: " + rs.getString(2) + " Author: " + rs.getString(3) + " Title: " + rs.getString(4));
                        else
                            System.out.println("Такого ISBN в базе не сущестует");
                    } else if (mainKey == 4) {
                        pr.close();
                        rs.close();
                        st.close();
                        conn.close();
                        sc.close();
                        System.exit(0);
                    }
                } catch (InputMismatchException e) {
                    sc.nextLine();
                    System.out.println("Введено некорректное значение");
                    continue;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

