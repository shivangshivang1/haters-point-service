package com.haterspoint.controller;


import com.haterspoint.dto.BrandDTO;
import com.haterspoint.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BrandController {

    @Autowired
    BrandService brandService;


    @GetMapping(value = "/getBrands")
    public ResponseEntity<List<BrandDTO>> getBrands(){

        List<BrandDTO> brands = brandService.getBrands();

        return new ResponseEntity<List<BrandDTO>>(brands, HttpStatus.OK);

    }

}
