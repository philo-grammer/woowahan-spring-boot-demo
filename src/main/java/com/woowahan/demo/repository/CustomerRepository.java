package com.woowahan.demo.repository;

import com.woowahan.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sykim on 2016. 2. 10..
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
