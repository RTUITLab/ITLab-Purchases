package com.service.Repositoris;

import com.service.Items.CostName;
import com.service.Items.DataGet;
import com.service.Items.Expenses;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface ExpensesRepository extends CrudRepository<Expenses, Integer> {

    List findAllByDatePurchaseAfterAndDatePurchaseBefore(String dateStart, String dateEnd);

    List findAllByDatePurchaseBetween(Date dateStart, Date dateEnd);

    @Query("SELECT e FROM Expenses e where e.datePurchase >= :dateStart and e.datePurchase <= :dateEnd")
    List<Expenses> find(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);

    Expenses findFirstById(int id);

}
