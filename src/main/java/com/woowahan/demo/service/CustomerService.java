package com.woowahan.demo.service;

import com.woowahan.demo.domain.Customer;
import com.woowahan.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Service
 *  서비스 클래스를 나타내는 애너테이션입니다. 기능 면에서는 @Component와 다르지 않습니다.
 *  서비스 클래스는 Repository가 올바르게 동작한다는 전제하에 구현하도록 합니다.
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

    public Customer read(long id) {
        return customerRepository.findOne(id);
    }

    /**
     * @Transactional = 메소드 단위의 BEGIN ~ COMMIT
     */
    @Transactional
    public Customer update(long id, String firstName, String lastName) {
        Customer updatedCustomer = customerRepository.findOne(id);
        updatedCustomer.setFirstName(firstName);
        updatedCustomer.setLastName(lastName);
        return updatedCustomer;
    }

    /**
     * 고객삭제(Delete) Service 만들기
     * 인자로 넘겨받은 id값을 가진 Customer 객체의 존재여부에 따라 처리한다.
     */
    @Transactional
    public boolean delete(long id) {
        Customer customer = customerRepository.findOne(id);
        boolean result;
        if(customer == null){
            result = false;
        } else {
            customerRepository.delete(id);
            result = true;
        }
        return result;
    }
}
