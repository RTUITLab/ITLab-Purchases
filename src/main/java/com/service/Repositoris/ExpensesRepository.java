package com.service.Repositoris;

import com.service.Items.Expenses;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ExpensesRepository extends CrudRepository<Expenses, Integer> {

    List findAllByDatePurchaseAfterAndDatePurchaseBefore(String dateStart, String dateEnd);

    Expenses findFirstById(int id);

}
