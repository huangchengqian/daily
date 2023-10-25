package com.hcq.daily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.sql.SQLException;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ComponentScan("com.hcq.daily.*")
public class DailyApplication {

	public static void main(String[] args) throws SQLException, InterruptedException {
		SpringApplication.run(DailyApplication.class, args);
	}

}
