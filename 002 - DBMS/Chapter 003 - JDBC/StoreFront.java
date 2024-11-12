import java.sql.*;

public class StoreFront {
    public static void main(String[] args) {
        try {
            String driverClassName = "oracle.jdbc.driver.OracleDriver";
            String url = "jdbc:odbc:XE";
            String username = "scott";
            String password = "tiger";
            String query = "insert into students values(109, 'bhatt')";

            Class.forName(driverClassName);
            Connection con=DriverManager.getConnection(
                "jdbc:oracle:root:@localhost:3306:xe","root","root"
            );  

            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();


            int count = st.executeUpdate(query);
            System.out.println(
                    "number of rows affected by this query= "
                            + count);

            con.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
