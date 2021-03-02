package com.service.Controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.service.Items.*;
import com.service.Repositoris.*;
import com.service.Repositoris.ArchRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class MainController {
    private final CostRepository costRepository;
    private final ExpensesRepository expensesRepository;
    private final ArchRepository archiveRepository;

    public MainController(CostRepository costRepository, ExpensesRepository expensesRepository, ArchRepository archiveRepository) {
        this.costRepository = costRepository;
        this.expensesRepository = expensesRepository;
        this.archiveRepository = archiveRepository;
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus check()
    {
        return HttpStatus.OK;

    }

    @GetMapping()
    public List gets(@RequestParam(value = "dateStart", defaultValue = "0000.00.00") String dateStart,
                                @RequestParam(value = "dateEnd", defaultValue = "9999.12.30") String dateEnd) {

            return expensesRepository.find(dateStart, dateEnd);

    }

    @DeleteMapping()
    public HttpStatus remove(@RequestParam (value = "id") ArrayList<Integer> arrayId) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

        try {
            for (Integer id : arrayId) {

                Date dateTimeInDB = new Date();

                Expenses ex = expensesRepository.findFirstById(id);
                CostName cn = ex.getIdCname();

                ArchiveDB saveArchiveDB = new ArchiveDB();

                saveArchiveDB.setIdExpenses(ex.getId());
                saveArchiveDB.setName(cn.getName());
                saveArchiveDB.setAmount(ex.getAmount());
                saveArchiveDB.setPrice(ex.getPrice());
                saveArchiveDB.setDatePurchase(ex.getDatePurchase());
                saveArchiveDB.setDateTimeCreate(ex.getDateTimeCreate());
                saveArchiveDB.setDateTimeInDB(ex.getDateTimeInDB());
                saveArchiveDB.setDateTimeInArchive(dateTimeInDB);
                saveArchiveDB.setUserName(ex.getUserName());
                saveArchiveDB.setActToChange("Delete");

                archiveRepository.save(saveArchiveDB);

                expensesRepository.deleteById(id);
            }
        }catch (Exception e)
        {
            System.out.println(e);
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public HttpStatus set(@RequestBody ArrayList<ReceivingData> data) {

        Expenses saveExpenses;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date dateTimeInDB  = new Date();

        try {

            for (ReceivingData d : data) {

                CostName costName = costRepository.find(d.getName().toUpperCase());

                    if (costName != null) {

                        saveExpenses = new Expenses();
                        saveExpenses.setIdCname(costName);
                        saveExpenses.setAmount(d.getAmount());
                        saveExpenses.setPrice(d.getPrice());
                        saveExpenses.setDatePurchase(d.getDatePurchase());
                        saveExpenses.setDateTimeCreate(d.getDateTimeCreate());
                        saveExpenses.setUserName(d.getUserName());
                        saveExpenses.setDateTimeInDB(dateTimeInDB);

                        expensesRepository.save(saveExpenses);
                        System.out.println(saveExpenses.getId());

                    } else {
                        CostName cn = new CostName();
                        cn.setName(d.getName());
                        cn.setCheckName(d.getName().toUpperCase());

                        costRepository.save(cn);

                        saveExpenses = new Expenses();
                        saveExpenses.setIdCname(costRepository.find(d.getName().toUpperCase()));
                        saveExpenses.setAmount(d.getAmount());
                        saveExpenses.setPrice(d.getPrice());
                        saveExpenses.setPrice(d.getPrice());
                        saveExpenses.setDatePurchase(d.getDatePurchase());
                        saveExpenses.setDateTimeCreate(d.getDateTimeCreate());
                        saveExpenses.setUserName(d.getUserName());
                        saveExpenses.setDateTimeInDB(dateTimeInDB);

                        expensesRepository.save(saveExpenses);
                        System.out.println(saveExpenses.getId());

                    }

            }
        }catch (Exception e)
        {
            System.out.println(e);
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;

    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public HttpStatus put(@RequestBody Data data)
    {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        Date dateTimeInDB  = new Date();

        try {

            Expenses ex = expensesRepository.findFirstById(data.getId());
            CostName cn = ex.getIdCname();

            ArchiveDB saveArchiveDB = new ArchiveDB();

            saveArchiveDB.setIdExpenses(ex.getId());
            saveArchiveDB.setName(cn.getName());
            saveArchiveDB.setAmount(ex.getAmount());
            saveArchiveDB.setPrice(ex.getPrice());
            saveArchiveDB.setDatePurchase(ex.getDatePurchase());
            saveArchiveDB.setDateTimeCreate(ex.getDateTimeCreate());
            saveArchiveDB.setDateTimeInDB(ex.getDateTimeInDB());
            saveArchiveDB.setDateTimeInArchive(dateTimeInDB);
            saveArchiveDB.setUserName(ex.getUserName());
            saveArchiveDB.setActToChange("Update");

            archiveRepository.save(saveArchiveDB);

            if (data.getPrice() != 0.0)
                ex.setPrice(data.getPrice());

            if (data.getAmount() != 0.0)
                ex.setAmount(data.getAmount());

            if (!data.getDatePurchase().equals(""))
                ex.setDatePurchase(data.getDatePurchase());

            if (!data.getUserName().equals(""))
                ex.setUserName(data.getUserName());

            expensesRepository.save(ex);

        }catch (Exception e)
        {
            System.out.println(e);
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.OK;

    }

}
