import java.sql.*;
import java.util.Calendar;

public class DataBaseHelper {

    static final String myDriver = "com.mysql.jdbc.Driver";
    static final String myUrl = "jdbc:mysql://mysql48.1gb.ru/gb_cleangames";

    static final String User = "gb_cleangames";
    static final String Pass = "a5a23237psg";



    public static void main(String[] args) {
        DataBaseHelper connect = new DataBaseHelper();

        String TeamName = "Команда";
        connect.CreateTeam(TeamName);

        /* String ProjectName = "jaja";
        String Desc = "blabla";
        connect.CreateProject(ProjectName, Desc); */

        /* int PrijectID = 1;
        String GarbageParametr = "Plastic";
        double Price = 2.5;
        connect.CreateGarbageParametr(PrijectID, GarbageParametr, Price); */

        /*String GarbageParametr1 = "Пластик";
        double Price1 = 3.5;
        connect.UpdateGarbageParametr(GarbageParametr1, Price1); */

        /*String email = "jhksd@gmail.com";
        String password = "jkjkjsd";
        String name = "ab";
        String surname = "gkh";
        boolean isAdm = false;
        connect.SignUpUser(email, password, name, surname, isAdm); */

        /*int id = 2;
        int teamID = 1;
        int maxCount = 5;
        connect.JoinUserToTeam(id, teamID, maxCount); */

        /* connect.LeaveTeam(4); */

        /* connect.CreateLocation(1, 0.4555, 9.368, 1, "оыипамл"); */

        /*connect.TestSelect(1); */


        /* InsertIntoTeam iit = new InsertIntoTeam();
        String TeamName = "Веселые бурундучки";
        iit.InsertIntoTeam(TeamName); */

        /*UpdateTeamName utn = new UpdateTeamName();
        String NewTeamName = "123";
        String OldTeamName = "Веселые бурундучки вперед!";
        utn.UpdateTeamName(OldTeamName, NewTeamName); */

        /* DeleteTeam dt = new DeleteTeam();
        String DeteleTeamName = "234";
        dt.DeleteTeam(DeteleTeamName); */

        /* CreateGarbageParametr cgp = new CreateGarbageParametr();
        int ProjectID = 1;
        String GarbageParametr = "Батарейка";
        double Price = 5;
        cgp.CreateGarbageParametr(ProjectID, GarbageParametr, Price); */



        System.out.println("Goodbye!");
    }

        Connection conn = null;
        Statement stmt = null;

    public void CreateTeam(String teamName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sqlQuery = "select count(*) from Team where Name = '" + teamName + "'";
            ResultSet rs = st.executeQuery(sqlQuery);
            int count = 0;
            rs.next();
            count = rs.getInt(1);
            rs.close();

            if (count == 0) {
                String query = "insert into Team (Name, CreatedTime)" + " values (?, ?)";
                Calendar calendar = Calendar.getInstance();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                PreparedStatement pS = conn.prepareStatement(query);
                pS.setString(1, teamName);
                pS.setDate(2, startDate);

                pS.execute();
            } else {
                System.out.println("Команда с таким названием уже существует!");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public void UpdateTeamName(String oldTeamName, String newTeamName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "update Team" + " set Name = ? where Name = '" + oldTeamName + "'";

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setString(1, newTeamName);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void DeleteTeam(String teamName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "delete from Team" + " where Name = '" + teamName + "'";

            PreparedStatement pS = conn.prepareStatement(query);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


   /* private void CreateProject(String projectName, String description) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "insert into Projects (ProjectDate, Name, Description)"
                    + " values (?, ?, ?)";

            Date date = new Date();

            java.sql.Date projectDate = new java.sql.Date();

            PreparedStatement pS = conn.prepareStatement(query);

            pS.setString(1, projectDate);
            pS.setString(2, projectName);
            pS.setString(3, description);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    } */


    private void CreateGarbageParametr(int projectID, String parameterName, double price) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "insert into Parameters (ProjectID, Name, Price)" + " values (?, ?, ?)";

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setInt(1, projectID);
            pS.setString(2, parameterName);
            pS.setDouble(3, price);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }



    private void UpdateGarbageParametr(String garbageParametr, double newPrice) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            String query = "update Parameters" + " set Price = ? where Name = '" + garbageParametr + "'";

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setDouble(1, newPrice);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void DeleteParameter(String parameterName) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");
            /*Statement stat = null;
            stat.execute("set character set utf8");
            stat.execute("set names utf8"); */


            String query = "delete from Parameters" + " where Name = '" + parameterName + "'";

            PreparedStatement pS = conn.prepareStatement(query);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void SignUpUser(String email, String password, String userName, String userSurname, boolean isAdmin) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "insert into User (Email, Password, Name, Surname, IsAdmin, CreatedTime)" + " values (?, ?, ?, ?, ?, ?)";
            Calendar calendar = Calendar.getInstance();
            java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setString(1, email);
            pS.setString(2, password);
            pS.setString(3, userName);
            pS.setString(4, userSurname);
            pS.setBoolean(5, isAdmin);
            pS.setDate(6, startDate);


            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    /*private void SignInUser(String email, String password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "select Email, Password from User";

            PreparedStatement pS = conn.prepareStatement(query);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    } */

    private void JoinUserToTeam(int id, int teamID, int maxCount) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sqlQuery = "select count(*) from User where TeamID = " + teamID;
            ResultSet rs = st.executeQuery(sqlQuery);
            int count = 0;
            rs.next();
            count = rs.getInt(1);
            rs.close();

            if (count <= maxCount) {
                String query = "update User set TeamID = ?" + " where ID = " + id;
                PreparedStatement pS = conn.prepareStatement(query);
                pS.setInt(1, teamID);

                pS.execute();
            }
            else {
                System.out.println("Вы не можете присоединиться к команде, так как количество игроков не должно превышать "
                        + maxCount + " человек");
            }




        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void LeaveTeam(int id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "update User set TeamID = NULL" + " where ID = " + id;

            PreparedStatement pS = conn.prepareStatement(query);

            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private void CreateLocation(int type, double placeX, double placeY, int projectID, String comment) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "insert into Locations (Type, PlaceX, PlaceY, ProjectID, Comment)" + " values (?, ?, ?, ?, ?)";

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setInt(1, type);
            pS.setDouble(2, placeX);
            pS.setDouble(3, placeY);
            pS.setInt(4, projectID);
            pS.setString(5, comment);


            pS.execute();

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    private void TestSelect(int teamID) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");


            String query = "select Name from Team where ID = " + teamID;

            PreparedStatement pS = conn.prepareStatement(query);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            pS.execute();

            while (rs.next()) {
                String name = rs.getString("Name");
                System.out.println(name + "\n");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }




}