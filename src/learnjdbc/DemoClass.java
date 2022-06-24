package learnjdbc;

/*
* import java.sql.*;
* load and register a driver
* create connection
* create a statement
* execute the query
* process the results
* close
* */

import java.sql.*;

public class DemoClass {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/learnjdbc";
        String uname="root";
        String pass="Password@123";
        String query="select * from student";
//        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,uname,pass);
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(query);
        String userData="";
        while(rs.next()){
            userData=rs.getInt(1)+":"+rs.getString(2);
            System.out.println(userData);
        }
        st.close();
        con.close();
    }
}
