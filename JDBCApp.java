import java.util.*;
import java.sql.*;
public class JDBCApp
{
 public static void main(String args[])
 {
  String url="jdbc:mysql://localhost:3306/testdb?";
  String user="testuser";
  String password="testpass";
  try
  {
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con=DriverManager.getConnection(url,user,password);
   Statement st=con.createStatement();
   String fquery="CREATE TABLE IF NOT EXISTS Student("+"Rollno INT PRIMARY KEY,"+"Name VARCHAR(50),"+"Address VARCHAR(100))";
   st.executeUpdate(fquery);
   System.out.println("Table created Successfully.");
   st.executeUpdate("INSERT INTO Student VALUES(6,'rav','yedrabad')");
   st.executeUpdate("INSERT INTO Student values(7,'sit','hennai')");
   st.executeUpdate("INSERT INTO Student values(8,'iran','angalore')");
   System.out.println("Initial records inserted.");
   System.out.println("\nInitial Records:");
   displayRecords(st);
   st.executeUpdate("INSERT INTO Student values(9,'eena','une')");
   st.executeUpdate("INSERT INTO Student values(10,'ram','goa')");
   System.out.println("\nTwo new records inserted>");
   st.executeUpdate("Update Student set Address='delhi' where Rollno=2");
   System.out.println("one record updated");
   st.executeUpdate("Delete from Student where Rollno=3");
   System.out.println("one record deleted");
   System.out.println("\n Final Records:");
   displayRecords(st);
   con.close();
  }
  catch(Exception e)
  {
   e.printStackTrace();
   }
  }
  public static void displayRecords(Statement st) throws SQLException
  {
   ResultSet rs=st.executeQuery("SELECT * from Student");
   System.out.println("Rollno\tName\tAddress");
   while(rs.next())
   {
    int roll=rs.getInt("Rollno");
    String name=rs.getString("name");
    String address=rs.getString("Address");
    System.out.println(roll+"\t"+name+"\t"+address);
   } 
  }
}




output:
Table created Successfully.
Initial records inserted.

Initial Records:
Rollno	Name	Address
1	ravi	hyedrabad
2	sita	chennai
3	kiran	bangalore
6	rav	yedrabad
7	sit	hennai
8	iran	angalore

Two new records inserted>
one record updated
one record deleted

 Final Records:
Rollno	Name	Address
1	ravi	hyedrabad
2	sita	delhi
6	rav	yedrabad
7	sit	hennai
8	iran	angalore
9	eena	une
10	ram	goa


