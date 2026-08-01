import java.sql.*;
class lab5
{
 public static void main(String args[]) throws Exception
 {
  String url="jdbc:mysql://localhost:3306/testdb?";
  String user="testuser";
  String password="testpass";
  try
  {
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con=DriverManager.getConnection(url,user,password);
   Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
   ResultSet rs=st.executeQuery("SELECT * FROM student");
   rs.last();
   rs.deleteRow();
   System.out.println("Last Student record deleted successfully.");
   rs.moveToInsertRow();
   rs.updateInt("RollNo",105);
   rs.updateString("Name","John Doe");
   rs.updateString("Address","Hyderabad");
   rs.insertRow();
   System.out.println("new Student record inserted successfully.");
   con.close();
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
 }
}

Output:
Last Student record deleted successfully.
new Student record inserted successfully.
