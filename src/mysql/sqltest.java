package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by LiuSitong on 2016/12/6.
 */
public class sqltest {
    public static void main(String[] args) {
        Connection con= null;
        Statement stm = null;
        String sql;
        String url = "jdbc:mysql://localhost:3306/productsale?user=root&password=root&useUnicode=true&characterEncoding=UTF8";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url);
            stm = con.createStatement();
            sql  = "CREATE  TABLE  student(no char(20),name varchar(20),primary key(NO)";
            int  result = stm.executeUpdate(sql);

            if (result != -1) {
                System.out.println("创建数据表成功");
                sql = "insert into student(NO,name) values('2012001','陶伟基')";
                result = stm.executeUpdate(sql);
                sql = "insert into student(NO,name) values('2012002','周小俊')";
                result = stm.executeUpdate(sql);
                sql = "select * from student";
                ResultSet rs = stm.executeQuery(sql);// executeQuery会返回结果的集合，否则返回空值
                System.out.println("学号\t姓名");
                while (rs.next()) {
                    System.out
                            .println(rs.getString(1) + "\t" + rs.getString(2));// 入如果返回的是int类型可以用getInt()
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
