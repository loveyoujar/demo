package com.ltq.demo;

import com.ltq.demo.util.email.EmailConfig;
import com.ltq.demo.util.email.EmailEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private EmailConfig emailConfig;

    @Test
    public void contextLoads() {
        emailConfig.sendSimpleMail( new EmailEntity("192779705@qq.com","测试","","测试通过!"));
    }

}
