package com.bit.mediHouse.Services;

import com.bit.mediHouse.Models.Pricing;
import com.bit.mediHouse.Repository.PricingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {

    private final PricingRepository pricingRepository;

    @Autowired
    public PricingService(PricingRepository pricingRepository) {
        this.pricingRepository = pricingRepository;
    }

    public Pricing addPricing(Pricing pricing) {
        return pricingRepository.save(pricing);
    }

    public List<Pricing> findAllPricing() {
        return pricingRepository.findAll();
    }
//    public List<Pricing> findDistinctUser_Id() {
//        return pricingRepository.findDistinctUser_Id();
//    }


    public Integer sumtotal_bill() {
        return pricingRepository.sumtotal_bill();
    }

    public List<Object[]> findAllByTotal_bill(Integer total_bill) {

        return pricingRepository.findAllByTotal_bill(total_bill);
    }
    public List<Object[]> findPricingGroupByUser() {

        return pricingRepository.getPricing();
    }


}
