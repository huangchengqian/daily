package com.hcq.daily.Async;


import com.hcq.daily.db.DBHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class AsyncService {
    @Autowired
    private DBHelper dbHelper;

    @Async("testExecutor")
    public void asyncTest(String ds, int i) throws InterruptedException, SQLException {
        System.out.printf("^^^^^^^^^^%d号线程开始运行^^^^^^^^^\n", i);
        Connection connection = dbHelper.getConnection(ds);
        String sql = "Insert into hcq.people values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, i);
        preparedStatement.setString(2, i + "号成员");
        preparedStatement.setInt(3, 17);
        preparedStatement.setString(4, i + "");
        preparedStatement.setString(5, "职员");
        preparedStatement.setString(6, "职员");
        preparedStatement.execute();
        Thread.sleep(1000 * 60 * 120);
        System.out.println("************关闭连接***********");
        connection.close();
    }

}
