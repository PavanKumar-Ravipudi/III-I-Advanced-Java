import java.sql.*;
public class lab4
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
   Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
   ResultSet rs=st.executeQuery("SELECT * FROM student");
   System.out.println("Records in Forward Direction:");
   System.out.println("RollNo\tName\tAddress");
   System.out.println("-----------------------------");
   while(rs.next())
   {
    System.out.println(rs.getInt("RollNo")+"\t"+rs.getString("Name")+"\t"+rs.getString("Address"));
   }
   System.out.println("\nRecords in Backward Direction:");
   System.out.println("RollNo\tName\tAddress");
   System.out.println("-----------------------------");
   while(rs.previous())
   {
    System.out.println(rs.getInt("RollNo")+"\t"+rs.getString("Name")+"\t"+rs.getString("Address"));
   }
   rs.first();
   System.out.println("\nFirst record:");
   System.out.println("Row"+rs.getRow()+":"+rs.getInt("RollNo")+"\t"+rs.getString("Name")+"\t"+rs.getString("Address"));
   rs.last();
   System.out.println("\nLast record:");
   System.out.println("Row"+rs.getRow()+":"+rs.getInt("RollNo")+"\t"+rs.getString("name")+"\t"+rs.getString("Address"));
   rs.relative(-1);
   System.out.println("\n2nd Record from last:");
   System.out.println("Row"+rs.getRow()+":"+rs.getInt("RollNo")+"\t"+rs.getString("Name")+"\t"+rs.getString("Address"));
   rs.absolute(2);
   System.out.println("\n2nd Record from beginning:");
   System.out.println("Row"+rs.getRow()+":"+rs.getInt("RollNo")+"\t"+rs.getString("Name")+"\t"+rs.getString("Address"));
   con.close();
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
 }
}

Output:
Records in Forward Direction:
RollNo	Name	Address
-----------------------------
1	Ravi	Hyderabad
2	Sita	Delhi
4	Meena	Pune
5	Ramesh	Mumbai

Records in Backward Direction:
RollNo	Name	Address
-----------------------------
5	Ramesh	Mumbai
4	Meena	Pune
2	Sita	Delhi
1	Ravi	Hyderabad

First record:
Row1:1	Ravi	Hyderabad

Last record:
Row4:5	Ramesh	Mumbai

2nd Record from last:
Row3:4	Meena	Pune

2nd Record from beginning:
Row2:2	Sita	Delhi

  
