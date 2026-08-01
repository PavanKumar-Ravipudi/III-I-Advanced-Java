import java.sql.*;

public class lab3 {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/employee_db";
        String user = "testuser";
        String password = "testpass";
        try(Connection con = DriverManager.getConnection(url, user, password);) {
            System.out.println("Database Connected.");
            CallableStatement insertst=con.prepareCall("{call insert_employee(?,?,?)}");
            insertst.setInt(1,101);
            insertst.setString(2,"John Doe");
            insertst.setDouble(3,55000.00);
            insertst.execute();
            System.out.println("Record inserted successfully.");
            CallableStatement getsalary=con.prepareCall("{call get_salary_by_id(?,?)}");
            getsalary.setInt(1,101);
            getsalary.registerOutParameter(2,Types.DECIMAL);
            getsalary.execute();
            double salary=getsalary.getDouble(2);
            System.out.println("Salary for Employee ID 101 is:"+salary);
            insertst.close();
           }
           catch(SQLException e)
          {
           e.printStackTrace();
          }
        }
    }
       

