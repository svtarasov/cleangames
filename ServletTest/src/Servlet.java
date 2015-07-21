import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet extends HttpServlet {

    final String myDriver = "com.mysql.jdbc.Driver";
    final String myUrl = "jdbc:mysql://mysql48.1gb.ru/gb_cleangames?useUnicode=true&characterEncoding=utf8";

    final String User = "gb_cleangames";
    final String Pass = "a5a23237psg";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain; charset=UTF-8");

        String actionType = request.getParameter("ActionType");

        if (actionType.equals("CreateTeam"))
        {
            String teamName = request.getParameter("TeamName");
            String userID = request.getParameter("UserID");
            String str = CreateTeam(teamName,userID);

            PrintWriter out = response.getWriter();
            out.println(str);

        }
        else

        {
            PrintWriter out = response.getWriter();
            out.println("Error");
        }
    }

    public void Login() {}

    public void Register() {}

    public String CreateTeam(String teamName, String userID) {
        Connection connection = null;
        Statement statement = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(myUrl, User, Pass);

            String query = "insert into Team (Name, CreatedTime)" + " values (?, ?)";

            long timeNow = Calendar.getInstance().getTimeInMillis();
            java.sql.Timestamp startDate = new java.sql.Timestamp(timeNow);

            PreparedStatement preparedStatement = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, teamName);
            preparedStatement.setTimestamp(2, startDate);

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            int teamID=0;
            if (rs.next())
            {
                teamID = rs.getInt(1);
            }
            query = "UPDATE User SET TeamID = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, teamID);
            preparedStatement.setInt(2, new Integer(userID));
            preparedStatement.execute();

            return "Team added: " + teamName;

        }catch(SQLException se){
            se.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(statement!=null)
                    connection.close();
            }catch(SQLException se){
            }
            try{
                if(connection!=null)
                    connection.close();
            }catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return "Error";
    }

    public void JoinTeam() {}

    public void LeaveTeam() {}

    public void DeleteTeam() {}

    public void GetTeam() {}

    public void GetTeamList() {}

    public void UpdateTeam() {}

    public void GetProjectList() {}

    public void CreateParameter() {}

    public void DeleteParameter() {}

    public void UpdateParameter() {}

    public void GetParameterList() {}

    public void CreateCheckin() {}

    public void DeleteCheckin() {}

    public void UpdateCheckin() {}

    public void GetCheckinList() {}

    public void GetUserCheckinList() {}

    public void CreateTransfer() {}

    public void UpdateTransfer() {}

    public void DeleteTransfer() {}

    public void GetTransferList() {}

    public void GetLocationList() {}

}