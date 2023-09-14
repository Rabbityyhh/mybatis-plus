package com.rabbit.mybatisPlus.differentImpl.controller;

import com.rabbit.mybatisPlus.differentImpl.service.TestService;
import com.rabbit.mybatisPlus.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rabbit
 */
@RestController
@RequestMapping("diffService")
public class TestController {

    private final TestService testService01;

    private final TestService testService02;

    private final TestService testService03;

    @Autowired
    public TestController(
            @Qualifier("serviceA") TestService testService01,
            @Qualifier("serviceB") TestService testService02,
            @Qualifier("serviceC") TestService testService03
    ) {
        this.testService01 = testService01;
        this.testService02 = testService02;
        this.testService03 = testService03;
    }

    @GetMapping("ser/{num}")
    public String testMulService(@PathVariable("num") String num) {
        if ("1".equals(num)) {
            return testService01.getUserInformation(new User());
        } else if ("2".equals(num)) {
            return testService02.getUserInformation(new User());
        } else {
            return testService03.getUserInformation(new User());
        }

    }

}
