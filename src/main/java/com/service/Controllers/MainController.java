package com.service.Controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.service.Items.*;
import com.service.Repositoris.*;
import com.service.Repositoris.ArchRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class MainController {
    private final CostRepository costRepository;
    private final ExpensesRepository expensesRepository;
    private final ArchRepository archiveRepository;

    //    docker-mysql
    public MainController(CostRepository costRepository, ExpensesRepository expensesRepository, ArchRepository archiveRepository) {
        this.costRepository = costRepository;
        this.expensesRepository = expensesRepository;
        this.archiveRepository = archiveRepository;
    }

    @Value("${Key}")
        String getToken;

    @GetMapping("/check")
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity check(@RequestHeader(value="Authentication") String header)
    {
        if(header.equals(getToken))
            return ResponseEntity.ok().body("OK");
        return  ResponseEntity.badRequest().body("Неверный токен");
    }

    @GetMapping()
    public ResponseEntity<List> gets(@RequestParam(value = "dateStart", defaultValue = "0000.00.00") String dateStart,
                                @RequestParam(value = "dateEnd", defaultValue = "9999.12.30") String dateEnd,
                                @RequestHeader(value="Authentication") String header) {

        if(header.equals(getToken))
            return new ResponseEntity<List>(expensesRepository.find(dateStart, dateEnd), HttpStatus.OK);
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping()
    public ResponseEntity remove(@RequestParam (value = "id") ArrayList<Integer> arrayId,
                                 @RequestHeader(value="Authentication") String header) {

        if(!header.equals(getToken))
            return ResponseEntity.badRequest().body("Неверный токен");

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
            System.out.println("Ошибка при удалении");
            return ResponseEntity.badRequest().body("Ошибка при удалении");
        }
        return ResponseEntity.ok().body("ОК");
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ResponseEntity set(@RequestBody ArrayList<ReceivingData> data,
                              @RequestHeader(value="Authentication") String header) {

        if(!header.equals(getToken))
            return ResponseEntity.badRequest().body("Неверный токен");

        Expenses saveExpenses;
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
            System.out.println("Ошибка при добавлении");
            return ResponseEntity.badRequest().body("Ошибка при добавлении");
        }
        return ResponseEntity.ok().body("OK");

    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity put(@RequestBody Data data,
                              @RequestHeader(value="Authentication") String header) {

        if(!header.equals(getToken))
            return ResponseEntity.badRequest().body("Неверный токен");

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
            System.out.println("Ошибка при обновлении данных");
            return ResponseEntity.badRequest().body("Ошибка при обновлении данных");
        }

        return ResponseEntity.ok().body("OK");

    }

}
