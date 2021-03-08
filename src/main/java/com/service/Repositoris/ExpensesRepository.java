package com.service.Repositoris;

import com.service.Items.CostName;
import com.service.Items.Expenses;
import com.service.Items.dataGet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpensesRepository extends CrudRepository<Expenses, Integer> {

    List findAllByDatePurchaseAfterAndDatePurchaseBefore(String dateStart, String dateEnd);

    @Query("SELECT e.id, c.name, e.price, e.datePurchase, e.amount, e.dateTimeCreate, e.dateTimeInDB, e.userName FROM Expenses e inner join CostName c on e.idCname.id = c.id")
    List find(@Param("dateStart") String dateStart, @Param("dateEnd") String dateEnd);

    Expenses findFirstById(int id);

}
