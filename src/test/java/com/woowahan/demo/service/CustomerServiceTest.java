package com.woowahan.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.woowahan.demo.DemoApplication;
import com.woowahan.demo.domain.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by sykim on 2016. 2. 10..
 * DONE : 고객생성(create) Service 만들기
 * DONE : 고객조회(read)
 * DONE : 고객수정(update)
 * TODO : 고객삭제(delete)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
@WebAppConfiguration
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    private Customer lastCreatedCustomer;

    @Before
    public void setUp() throws Exception {
        Customer customer = new Customer(null, "소프트", "승킬");
        this.lastCreatedCustomer = customerService.create(customer);
    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * 고객생성(create) service 만들기
     * 예 : USP_Super_Customer_M01
     */
    @Test
    public void testCustomerCreate() {
        // OUTPUT : 어떤 데이터가 나와야 할까?
        Customer created
                = customerService.create(new Customer(null, "소프트", "승킬"));
        assertEquals(new Customer(created.getId(), "소프트", "승킬"), created);
    }

    /**
     * 고객조회(read) service 만들기
     * 예 : USP_Super_Customer_S01
     */
    @Test
    public void testCustomerRead() {
        Long lastCustomerId = this.lastCreatedCustomer.getId();
        Customer readCustomer = customerService.read(lastCustomerId);
        assertEquals(new Customer(lastCustomerId, "소프트", "승킬"), readCustomer);
    }

    /**
     * 고객수정(update) service 만들기
     * 예 : USP_Super_Customer_M02
     */
    @Test
    public void testCustomerUpdate() {
        Long lastCustomerId = this.lastCreatedCustomer.getId();
        Customer updated
                = customerService.update(lastCustomerId, "소프트웨어", "야인");
        assertEquals(new Customer(lastCustomerId, "소프트웨어", "야인"), updated);
    }

    /**
     * 고객삭제(Delete) service 테스트
     * 예 : USP_Super_Customer_M03
     */
    @Test
    public void testCustomerDelete() {
        Long id = this.lastCreatedCustomer.getId();
        assertTrue(customerService.delete(id));
        assertFalse(customerService.delete(id));
    }
}