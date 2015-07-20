import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException{

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        final String myDriver = "com.mysql.jdbc.Driver";
        final String myUrl = "jdbc:mysql://mysql48.1gb.ru/gb_cleangames?useUnicode=true&characterEncoding=utf8";

        final String User = "gb_cleangames";
        final String Pass = "a5a23237psg";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(myUrl, User, Pass);

            String query = "insert into Team (ID, Name, CreatedTime)" + " values (?, ?, ?)";

            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setInt(1, 94);
            pS.setString(2, "onlieureurhuerse");
            pS.setDate(3, startDate);

            pS.execute();

            conn.close();
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


        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Team added</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}