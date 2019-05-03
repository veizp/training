package com.veizp.training;


import com.veizp.training.util.JsonUtil;
import org.apache.commons.lang.time.StopWatch;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:springMVC.xml", "classpath:spring-config.xml",
        "classpath:applicationContext.xml", "classpath:spring-mybatis.xml" })
public class BaseTest {

    private StopWatch watch = new StopWatch();

    @Before
    public void setUp() {
        DOMConfigurator.configureAndWatch("classpath:log4.xml", 3000);
        watch.start();
    }

    @After
    public void tearDown() {
        watch.stop();
        System.out.println("[Unit Test]It cost:" + watch.getTime() + "ms.");
    }

    protected void print(Object obj) {
        System.out.println(JsonUtil.toJson(obj));
    }

    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
