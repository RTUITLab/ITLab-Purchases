package com.service.Service;

import com.service.Items.CostNameData;
import com.service.Items.ReceivingData;
import org.springframework.http.HttpStatus;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Set {

    private final String url = "jdbc:mysql://localhost:3306/lab_expenses";
    private final String username = "root";
    private final String password = "9999";

    public HttpStatus set(ArrayList<ReceivingData> data)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            Statement stmtObj = connection.createStatement();
            String st = "";
            ResultSet resObj = stmtObj.executeQuery("SELECT * FROM lab_expenses.costname");
            ResultSet resObj2;

            ArrayList<CostNameData> dtSql = new ArrayList<CostNameData>();
            CostNameData dt = new CostNameData();
            CostNameData d2;

            Date dateTimeInDB;
            String stringTimeInDB;
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

            while (resObj.next()) {
                dt.setId(resObj.getInt("id"));
                dt.setName(resObj.getString("name"));
                dt.setСheckName(resObj.getString("checkName"));
                dtSql.add(dt);

                dt = new CostNameData();
            }

            for (ReceivingData d:data) {
                for (int i = 0; i < dtSql.size(); i++) {
                    d2 = dtSql.get(i);
                    if (d2.getСheckName().equals(d.getName().toUpperCase())) {

                        dateTimeInDB  = new Date();
                        stringTimeInDB = df.format(dateTimeInDB.getTime());

                        st = "(\"" + d2.getId() + "\",\"" + d.getPrice() + "\",\"" + d.getDatePurchase() + "\",\""
                                + d.getAmount() + "\",\"" + d.getDateTimeCreate() + "\",\"" + stringTimeInDB + "\",\""
                                + d.getUserName() + "\")";

                    } else if (i + 1 == dtSql.size()) {

                        stmtObj.execute("insert into costname(name, checkName) value (\"" + d.getName() + "\",\"" + d.getName().toUpperCase() + "\")");

                        resObj2 = stmtObj.executeQuery("SELECT id FROM costname where name = \"" + d.getName() + "\"");
                        resObj2.next();

                        dateTimeInDB  = new Date();
                        stringTimeInDB = df.format(dateTimeInDB.getTime());

                        st = "(\"" + resObj2.getInt("id") + "\",\"" + d.getPrice() + "\",\""
                                + d.getDatePurchase() + "\",\"" + d.getAmount() + "\",\"" + d.getDateTimeCreate()
                                + "\",\"" + stringTimeInDB + "\",\"" + d.getUserName() + "\")";
                    }

                    if (!st.equals("")) {

                        stmtObj.execute("insert into expenses(idCname, price, datePurchase, amount, dateTimeCreate, dateTimeInDB, userName) value " + st);
                        st = "";
                        break;
                    }
                }
            }
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
