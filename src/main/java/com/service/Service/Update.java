package com.service.Service;

import com.service.Items.Data;
import org.springframework.http.HttpStatus;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Update {

    private final String url = "jdbc:mysql://localhost:3306/lab_expenses";
    private final String username = "root";
    private final String password = "9999";

    public HttpStatus update(Data data)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Data dt;
            Date dateTimeInDB = new Date();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

            String stringTimeInDB = df.format(dateTimeInDB);

            Statement stmtObj = connection.createStatement();

            ResultSet resObj = stmtObj.executeQuery("SELECT  expenses.id, costname.name, expenses.price, expenses.datePurchase, expenses.amount, " +
                    "expenses.dateTimeCreate, expenses.dateTimeInDB, expenses.userName " +
                    "FROM lab_expenses.expenses " +
                    "inner join lab_expenses.costname on costname.id = expenses.idCname " +
                    "where expenses.id = \""+data.getId()+"\"");

                resObj.next();

                dt = new Data(
                        resObj.getInt("id"),
                        resObj.getString("name"),
                        resObj.getFloat("price"),
                        resObj.getString("datePurchase"),
                        resObj.getInt("amount"),
                        resObj.getString("dateTimeCreate"),
                        resObj.getString("dateTimeInDB"),
                        resObj.getString("userName"));


            stmtObj.execute("insert into lab_expenses.archive (idExpenses, name, price, datePurchase, amount, " +
                    "dateTimeCreate, dateTimeInDB, userName, dateTimeInArchive) value (\""+dt.getId()+"\", \""+
                            dt.getName()+"\", \""+dt.getPrice()+"\", \""+dt.getDatePurchase()+"\", \""+dt.getAmount()+
                    "\", \""+dt.getDateTimeCreate()+"\", \""+dt.getDateTimeInDB()+"\", \""+dt.getUserName()+"\", \""+stringTimeInDB+"\")");

            stmtObj.execute("update lab_expenses.expenses set price = \""+data.getPrice()+"\", amount = \""+
                    data.getAmount()+"\", datePurchase = \""+data.getDatePurchase()+"\" where id =\""+data.getId()+"\"");


            stmtObj.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;

    }
}
