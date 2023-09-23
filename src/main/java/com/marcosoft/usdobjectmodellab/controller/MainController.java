package com.marcosoft.usdobjectmodellab.controller;

import com.marcosoft.usdobjectmodellab.exception.UsdCrNotFoundException;
import com.marcosoft.usdobjectmodellab.exception.UsdRestException;
import com.marcosoft.usdobjectmodellab.model.UsdCr;
import com.marcosoft.usdobjectmodellab.service.UsdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usd")
public class MainController {

    @Autowired
    UsdService usdService;

    @GetMapping("/cr/{id}")
    public ResponseEntity<UsdCr> findCrById(@PathVariable int id){
        return usdService.findCrById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }
}
