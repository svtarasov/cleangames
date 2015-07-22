import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet extends HttpServlet {

    DataBaseHelper dbs = new DataBaseHelper();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain; charset=UTF-8");
       // request.setAttribute("messages", messages);
        String actionType = request.getParameter("ActionType");

        if (actionType.equals("CreateTeam")) {
            String teamName = request.getParameter("TeamName");
            String userID = request.getParameter("UserID");
            dbs.CreateTeam(teamName);
            //PrintWriter out = response.getWriter();
            //out.println(str);

        } else
        {
            PrintWriter out = response.getWriter();
            out.println("Error");
        }
    }
}