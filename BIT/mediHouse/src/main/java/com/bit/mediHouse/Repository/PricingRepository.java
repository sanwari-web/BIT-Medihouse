package com.bit.mediHouse.Repository;

import com.bit.mediHouse.Models.Patient;
import com.bit.mediHouse.Models.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PricingRepository extends JpaRepository<Pricing,Integer> {



    Pricing getById(Integer pricingId);


    @Query(value = "SELECT total_bill FROM pricing " )
    List<Object[]> findAllByTotal_bill(Integer total_bill);



    @Query(value = "SELECT sum(total_bill) FROM pricing")
    public Integer sumtotal_bill();

    @Query(value = "SELECT sum(pc.total_bill),pc.user.first_name FROM pricing pc inner join user u on pc.user.id=u.id Group by pc.user.first_name")
    public  List<Object[]> getPricing();

}
