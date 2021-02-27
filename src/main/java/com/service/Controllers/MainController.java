package com.service.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.service.Items.CostName;
import com.service.Items.Expenses;
import com.service.Items.Data;
import com.service.Items.ReceivingData;
import com.service.Repositoris.CostRepository;
import com.service.Repositoris.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class MainController {
    @Autowired
    private CostRepository costRepository;
    @Autowired
    private ExpensesRepository expensesRepository;

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus check()
    {
        return HttpStatus.OK;

    }

    @GetMapping()
    public List gets(@RequestParam(value = "dateStart", defaultValue = "0000.00.00") String dateStart,
                                @RequestParam(value = "dateEnd", defaultValue = "9999.12.30") String dateEnd) {

        return expensesRepository.findAllByDatePurchaseAfterAndDatePurchaseBefore(dateStart,dateEnd);

    }

    @DeleteMapping()
    public HttpStatus remove(@RequestParam (value = "id") ArrayList<Integer> arrayId) {

        for (Integer id : arrayId)
        {
            expensesRepository.deleteById(id);
        }
        return HttpStatus.OK;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public HttpStatus set(@RequestBody ArrayList<ReceivingData> data) {

        Iterable<CostName> costNames = costRepository.findAll();
        Expenses saveExpenses;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date dateTimeInDB  = new Date();
        String stringTimeInDB = df.format(dateTimeInDB.getTime());

        for (ReceivingData d : data) {
            for (CostName costName : costNames) {
                if (d.getName().toUpperCase().equals(costName.getCheckName())) {
                    saveExpenses = new Expenses();
                    saveExpenses.setIdCname(costName.getId());
                    saveExpenses.setAmount(d.getAmount());
                    saveExpenses.setPrice(d.getPrice());
                    saveExpenses.setDatePurchase(d.getDatePurchase());
                    saveExpenses.setDateTimeCreate(d.getDateTimeCreate());
                    saveExpenses.setUserName(d.getUserName());
                    saveExpenses.setDateTimeInDB(stringTimeInDB);

                    expensesRepository.save(saveExpenses);
                    System.out.println(saveExpenses.getId());
                    break;

                }else
                    if (!costNames.iterator().hasNext())
                    {

                        CostName cn = new CostName();
                        cn.setName(d.getName());
                        cn.setCheckName(d.getName().toUpperCase());

                        costRepository.save(cn);

                        saveExpenses = new Expenses();
                        saveExpenses.setIdCname(costRepository.findId(d.getName().toUpperCase()));
                        saveExpenses.setAmount(d.getAmount());
                        saveExpenses.setPrice(d.getPrice());
                        saveExpenses.setDatePurchase(d.getDatePurchase());
                        saveExpenses.setDateTimeCreate(d.getDateTimeCreate());
                        saveExpenses.setUserName(d.getUserName());
                        saveExpenses.setDateTimeInDB(stringTimeInDB);

                        expensesRepository.save(saveExpenses);
                        System.out.println(saveExpenses.getId());
                    }
            }

        }
        return HttpStatus.OK;

    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public HttpStatus put(@RequestBody Data data)
    {
        Expenses ex = expensesRepository.findFirstById(data.getId());
        ex.setPrice(data.getPrice());
        ex.setAmount(data.getAmount());
        ex.setDatePurchase(data.getDatePurchase());
        expensesRepository.save(ex);

        return HttpStatus.OK;

    }

}
