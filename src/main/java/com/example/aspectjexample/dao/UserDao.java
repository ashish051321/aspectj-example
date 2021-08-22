package com.example.aspectjexample.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserDao {

    @Modifying
    @Query(value = "insert into  trans_details(customer_id,transaction_type,session_date,session_duration) " +
            "VALUES (:customer_id,'LOGIN/LOGOUT',sysdate,0)", nativeQuery = true)
    public void registerLogin(@Param("customer_id") String customer_id);

//    public void registerLogin(String customerId) {
//        System.out.println("registering login");
//    }

//    public void registerLogout(String customerId) {
//        System.out.println("registering logout");
//
//    }

}
