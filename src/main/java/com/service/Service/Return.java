package com.service.Service;

import com.service.Items.Data;
import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Return {

    private final String url = "jdbc:mysql://localhost:3306/lab_expenses";
    private final String username = "root";
    private final String password = "9999";

//    @Value("${url}")
//    String url;
//    @Value("${username}")
//    String username;
//    @Value("${password}")
//    String password;
    public ArrayList<Data> get(String dateEnd, String dateStart){

        Data dt;
        ArrayList<Data> dtSql = new ArrayList<Data>();

        Date checkStart, checkEnd;

        try {
            checkEnd = new SimpleDateFormat("yyyy.MM.dd").parse(dateEnd);
            checkStart = new SimpleDateFormat("yyyy.MM.dd").parse(dateStart);

            if (checkEnd.getTime() >= checkStart.getTime())
            {

                try (Connection connection = DriverManager.getConnection(url, username, password)) {

                    Statement stmtObj = connection.createStatement();

                    ResultSet resObj = stmtObj.executeQuery("SELECT  expenses.id, costname.name, expenses.price, expenses.datePurchase, expenses.amount, " +
                            "expenses.dateTimeCreate, expenses.dateTimeInDB, expenses.userName " +
                            "FROM lab_expenses.expenses " +
                            "inner join lab_expenses.costname on costname.id = expenses.idCname " +
                            "where expenses.datePurchase >= \""+dateStart+"\" and expenses.datePurchase <= \""+dateEnd+"\"");

                    while (resObj.next()) {
                        dt = new Data(
                                resObj.getInt("id"),
                                resObj.getString("name"),
                                resObj.getFloat("price"),
                                resObj.getString("datePurchase"),
                                resObj.getInt("amount"),
                                resObj.getString("dateTimeCreate"),
                                resObj.getString("dateTimeInDB"),
                                resObj.getString("userName"));

                        dtSql.add(dt);
                    }

                    stmtObj.close();
                    connection.close();

                } catch (SQLException e) {
                    System.out.println("Connection failed!");
                    e.printStackTrace();
                }

                return dtSql;

            }else
            {
                System.out.println("End date less in start date");
                return null;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Invalid date format");
            return null;
        }
    }

}
