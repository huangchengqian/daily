package com.hcq.daily.hikari;

import com.hcq.daily.Async.AsyncService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.sql.SQLException;


@SpringBootTest
@RunWith(SpringRunner.class)
public class HikariTest {

    @Resource
    private AsyncService asyncService;

    @Test
    public void hikariNew() throws SQLException, InterruptedException {
        asyncService.asyncTest("meta", 1);
        asyncService.asyncTest("meta", 2);
        asyncService.asyncTest("meta", 3);
        asyncService.asyncTest("meta", 4);
        asyncService.asyncTest("meta", 5);
        Thread.sleep(500);
        System.out.println("==============测试程序循环结束！===============");
        while (true) {

        }
    }

}
