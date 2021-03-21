package mainpackage;

import java.sql.*;

public class Test
{
    public static ResultSet getData(Connection myConn) throws SQLException
    {
        Statement st1 = myConn.createStatement();

        ResultSet rs = st1.executeQuery("select * from clients");

        return rs;
    }

    public static void updateData(Connection myConn) throws SQLException
    {
        Statement st1 = myConn.createStatement();

        st1.executeUpdate("update clients set name='Arda Baylan' where id=5");
    }

    public static void insertData(Connection myConn) throws SQLException
    {
        Statement st1 = myConn.createStatement();

        String values = "('5', 'Arda Kaplan', '05552324567', '1')";
        st1.execute("insert into clients (id, name, phone_number, state) values " + values);
    }

    public static void main(String args[])
    {
        try
        {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dcm?useTimezone=true&serverTimezone=UTC","root","2367");

            //insertData(myConn);

            updateData(myConn);

            ResultSet rs = getData(myConn);

            while(rs.next())
            {
                System.out.println("id:" + rs.getString("id") + " name:" + rs.getString("name") + " phone number:" + rs.getString("phone_number"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}
