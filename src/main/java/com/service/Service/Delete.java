package com.service.Service;

import org.springframework.http.HttpStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    private final String url = "jdbc:mysql://localhost:3306/lab_expenses";
    private final String username = "root";
    private final String password = "9999";

    public HttpStatus remove(String id)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement stmtObj = connection.createStatement();

            stmtObj.execute("DELETE FROM lab_expenses.expenses WHERE id = \""+id+"\"");

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;


    }
}
