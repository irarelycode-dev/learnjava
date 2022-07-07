package designpatterns.singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSingleton {
    private static JDBCSingleton jdbc;
    private JDBCSingleton(){}
    private static JDBCSingleton getInstance(){
        if(jdbc==null){
            jdbc=new JDBCSingleton();
        }
        return jdbc;
    }
    private Connection getConnection() throws ClassNotFoundException,SQLException{
        String url="jdbc:mysql://localhost:3306/learnjdbc";
        String uname="root";
        String pass="Password@123";
        Connection conn=DriverManager.getConnection(url,uname,pass);
        return conn;
    }
    public int insertRecord(int id,String name) throws SQLException{
        Connection c=null;
        PreparedStatement ps=null;
        int recordCounter=0;
        try{
            c=this.getConnection();
            ps=c.prepareStatement("insert into student(id,student) values(?,?)");
            ps.setString(id,name);
            recordCounter=ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(ps!=null){
                ps.close();
            }if(c!=null){
                c.close();
            }
        }
        return recordCounter;
    }
}
