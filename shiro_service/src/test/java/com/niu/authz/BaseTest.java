package com.niu.authz;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BaseTest
 * @Description TODO
 * @Author admin
 * @Date 2019/12/19 10:30
 * @Version 1.0
 **/
@Slf4j
public class BaseTest<T> {
    Class<T> t = (Class<T>) getClass();
  //  final Logger logger  =  LoggerFactory.getLogger(t);
    public BaseTest(Class<T> t) {
        this.t = t;
        log.info(t.getName());
    }
}
