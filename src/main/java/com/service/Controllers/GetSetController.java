package com.service.Controllers;

import java.util.ArrayList;

import com.service.Items.Data;
import com.service.Items.ReceivingData;
import com.service.Service.Delete;
import com.service.Service.Return;
import com.service.Service.Set;
import com.service.Service.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class GetSetController {

//    @Value("${url}")
//    String url;
//    @Value("${username}")
//    String username;
//    @Value("${password}")
//    String password;
    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus check()
    {
        return HttpStatus.OK;

    }

    @GetMapping()
    public ArrayList<Data> gets(@RequestParam(value = "dateStart", defaultValue = "0000.00.00") String dateStart,
                                @RequestParam(value = "dateEnd", defaultValue = "9999.12.30") String dateEnd) {

        Return rd = new Return();
        return  rd.get(dateEnd, dateStart);

    }

    @DeleteMapping()
    public  HttpStatus remove(@RequestParam (value = "id") String id) {

        Delete dd = new Delete();
        return dd.remove(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public HttpStatus set(@RequestBody ArrayList<ReceivingData> data) {

        Set sd = new Set();
        return sd.set(data);

    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    public HttpStatus put(@RequestBody Data data)
    {
        Update ud = new Update();
        return ud.update(data);

    }

}
