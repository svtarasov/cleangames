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
import java.util.Calendar;

@WebServlet("/api")
public class MyServlet extends HttpServlet {

    static final String myDriver = "com.mysql.jdbc.Driver";
    static final String myUrl = "jdbc:mysql://mysql48.1gb.ru/gb_cleangames";

    static final String User = "gb_cleangames";
    static final String Pass = "a5a23237psg";


    @Resource(name = "jdbc/StudentsDS")
    private DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        InsertTeam(out);
//Validation parameters
      /*  Connection conn = null;
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
        } */
    }

    private static void InsertTeam(PrintWriter out){
    Connection conn = null;
    Statement stmt = null;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");

        out.println("Connecting to database...");
        conn = DriverManager.getConnection(myUrl, User, Pass);
        out.println("Connected to database succesfully...");

        String query = "insert into Team (Name, CreatedTime)" + " values (?, ?)";

        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        PreparedStatement pS = conn.prepareStatement(query);
        String name = "¡Î‡";
        pS.setString(1, name);
        pS.setDate(2, startDate);

        pS.execute();

    }catch(SQLException se){
        se.printStackTrace();
        out.println(se);
    }catch(Exception e){
        e.printStackTrace();
        out.println(e);
    }finally{
        try{
            if(stmt!=null)
                conn.close();
        }catch(SQLException se){
        }
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se) {
            se.printStackTrace();
        }
    }
    out.println("Goodbye!");
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Hello World");
    }
}