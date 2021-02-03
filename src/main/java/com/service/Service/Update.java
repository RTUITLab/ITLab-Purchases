package com.service.Service;

import com.service.Items.Data;
import org.springframework.http.HttpStatus;

import java.sql.*;

public class Update {

    private final String url = "jdbc:mysql://localhost:3306/lab_expenses";
    private final String username = "root";
    private final String password = "9999";

    public HttpStatus update(Data data)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement stmtObj = connection.createStatement();
            stmtObj.execute("update lab_expenses.expenses set price = \""+data.getPrice()+"\", amount = \""+
                    data.getAmount()+"\", datePurchase = \""+data.getDatePurchase()+"\" where id =\""+data.getId()+"\"");

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;

    }
}
