package com.service.Service;

import org.springframework.http.HttpStatus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Delete {

    private final String url = "jdbc:mysql://localhost:3306/lab_expenses";
    private final String username = "root";
    private final String password = "9999";

    public HttpStatus remove(ArrayList<String> arrayId)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement stmtObj = connection.createStatement();

            for (String id: arrayId) {

                if (id != null)
                {
                    stmtObj.execute("DELETE FROM lab_expenses.expenses WHERE id = \"" + id + "\"");
                }
            }


            stmtObj.close();

        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;


    }
}
