package com.woowahan.demo.service;

import com.woowahan.demo.domain.Customer;
import com.woowahan.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Service
 * : 서비스 클래스를 나타내는 애너테이션입니다. 기능 면에서는 @Component와 다르지 않습니다.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * @Transactional = 메소드 단위의 BEGIN ~ COMMIT
     */
    @Transactional
    public Customer create(Customer customer) {
        // JPA에서는 넣을 때 Entity 객체와 리턴 받은 Entity 객체가 동기화 된다.
        return customerRepository.save(customer);
    }

    public Customer read(Long id) {
        return customerRepository.findOne(id);
    }

    /**
     * @Transactional = 메소드 단위의 BEGIN ~ COMMIT
     */
    @Transactional
    public Customer update(Long id, String firstName, String lastName) {
        Customer updatedCustomer = customerRepository.findOne(id);
        updatedCustomer.setFirstName(firstName);
        updatedCustomer.setLastName(lastName);
        return updatedCustomer;
    }
}
