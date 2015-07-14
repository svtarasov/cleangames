import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;


@WebServlet("/api")
public class MyServlet extends HttpServlet {

    @Resource(name = "jdbc/StudentsDS")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
//Validation parameters
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String firstName = "";
        try {
            String SQL = "INSERT INTO Team (NAME) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(SQL);
            String NAMES = "Firstname";
            ps.setString(1, NAMES);
            st.executeUpdate(SQL);

        }
        catch (SQLException fd){
            fd.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (st != null) st.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Hello World");
    }
}