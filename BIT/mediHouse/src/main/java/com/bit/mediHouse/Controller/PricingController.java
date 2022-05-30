package com.bit.mediHouse.Controller;

import com.bit.mediHouse.Models.Pricing;
import com.bit.mediHouse.Services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PricingController {
    @Autowired
    private PricingService pricingService;

    public PricingController(PricingService pricingService){
        this.pricingService = pricingService;
    }

    @GetMapping("/pricing/find")
    public ResponseEntity<List<Pricing>> getAllPricing() {
        List<Pricing> pricing = pricingService.findAllPricing();
        return new ResponseEntity <>(pricing, HttpStatus.OK);
    }

    @PostMapping("/pricing/add")
    public ResponseEntity <Pricing> addPricing(@RequestBody Pricing pricing){
        Pricing newPricing = pricingService.addPricing(pricing);
        return new ResponseEntity <>(newPricing, HttpStatus.CREATED);
    }

    @GetMapping("/pricing/find/total_bill")
    public ResponseEntity<List<Object[]>> findAllByTotal_bill(Integer total_bill) {
        List<Object[]> pricing = pricingService.findAllByTotal_bill(total_bill);
        return new ResponseEntity <>(pricing, HttpStatus.OK);
   }
    @GetMapping("/pricing/find/userbybill")
    public ResponseEntity <List<Object[]>>  findPricingGroupByUser() {
        List<Object[]> pricing = pricingService.findPricingGroupByUser();
        return new ResponseEntity <>(pricing, HttpStatus.OK);
    }
}
