import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DBConnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking", "root", "");
            st = con.createStatement();


        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void getData() {
        try {

            String query = "select * from persons";
            rs = st.executeQuery(query);
            System.out.println("records from Database");
            while (rs.next()) {
                String name = rs.getString("name");
                String id = rs.getString("id");
                System.out.println("Name: " + name +"; " + " Id: " + id);
            }

        } catch (Exception ex) {
            System.out.println(ex);

        }
    }
}
