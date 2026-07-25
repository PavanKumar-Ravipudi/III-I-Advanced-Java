import java.sql.*;
public class lab2
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
   String ct="CREATE TABLE IF NOT EXISTS student ("+"rollno INT PRIMARY KEY,"+"name VARCHAR(50),"+"address varchar(100))";
   con.createStatement().executeUpdate(ct);
   System.out.println("Table created successfully.");
   Statement st=con.createStatement();
   st.executeUpdate("DELETE FROM student");
   st.executeUpdate("insert into student values(1,'Ravi','Hyderabad')");
   st.executeUpdate("insert into student values(2,'Sita','chennai')");
   st.executeUpdate("insert into student values(3,'Kiran','Bangalore')");
   System.out.println("Initial records inserted.");
   System.out.println("\nInitial Records:");
   displayRecords(con);
   String insertsql="Insert into student (rollno,name,address) values(?,?,?)";
   PreparedStatement insertst=con.prepareStatement(insertsql);
   insertst.setInt(1,4);
   insertst.setString(2,"Meena");
   insertst.setString(3,"Pune");
   insertst.executeUpdate();
   insertst.setInt(1,5);
   insertst.setString(2,"Ramesh");
   insertst.setString(3,"Mumbai");
   insertst.executeUpdate();
   System.out.println("Two new records inserted.");
   String updatesql="UPDATE student SET address=? where rollno=?";
   PreparedStatement updatest =con.prepareStatement(updatesql);
   updatest.setString(1,"Delhi");
   updatest.setInt(2,2);
   updatest.executeUpdate();
   System.out.println("One record updated.");
   String deletesql="DELETE FROM student where rollno=?";
   PreparedStatement deletest =con.prepareStatement(deletesql);
   deletest.setInt(1,3);
   deletest.executeUpdate();
   System.out.println("One record deleted.");
   System.out.println("\nFinal Records:");
   displayRecords(con);
   con.close();
   }
   catch(Exception e)
   {
    e.printStackTrace();
   }
  }
  public static void displayRecords(Connection con) throws SQLException{
  String selectsql ="Select * from student";
  PreparedStatement selectst =con.prepareStatement(selectsql);
  ResultSet rs=selectst.executeQuery();
  System.out.println("Rollno\tName\tAddress");
  while(rs.next())
  {
   int roll=rs.getInt("rollNo");
   String name=rs.getString("name");
   String address=rs.getString("address");
   System.out.println(roll+"\t"+ name +"\t"+ address);
  }
 }
} 



Output:
Table created successfully.
Initial records inserted.

Initial Records:
Rollno	Name	Address
1	Ravi	Hyderabad
2	Sita	chennai
3	Kiran	Bangalore
Two new records inserted.
One record updated.
One record deleted.

Final Records:
Rollno	Name	Address
1	Ravi	Hyderabad
2	Sita	Delhi
4	Meena	Pune
5	Ramesh	Mumbai


   
   
