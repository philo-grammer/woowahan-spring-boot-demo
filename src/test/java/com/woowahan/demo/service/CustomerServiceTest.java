package com.woowahan.demo.service;

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

import static org.junit.Assert.*;

/**
 * Created by sykim on 2016. 2. 10..
 * TODO : 고객생성(create) Service 만들기
 * TODO : 고객조회(read)
 * TODO : 고객수정(update)
 * TODO : 고객삭제(delete)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
@WebAppConfiguration
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Before
    public void setUp() throws Exception {

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
}