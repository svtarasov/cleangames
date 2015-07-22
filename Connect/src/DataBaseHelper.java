import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DataBaseHelper {

    static final String myDriver = "com.mysql.jdbc.Driver";
    static final String myUrl = "jdbc:mysql://mysql48.1gb.ru/gb_cleangames";

    static final String User = "gb_cleangames";
    static final String Pass = "a5a23237psg";



    public static void main(String[] args) throws ParseException {
        DataBaseHelper connect = new DataBaseHelper();

       /* if (request.getParameter("ActionType").equals("CreateTeam")) {
            connect.CreateTeam(request.getParameter("Name"));
        } */

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

        String email = "jhkfgsd@gmail.com";
        String password = "jkjkjsd";
        String name = "ab";
        String surname = "gkh";
        int answ;
        answ = connect.SignUpUser(email, password, name, surname);
        if (answ == 0) {
            System.out.println("Регистрация прошла успешно! Приятной игры :)");
        }
        if (answ == 1) {
            System.out.println("Этот email уже зарегестрирован!");
        }
        if (answ == 2) {
            System.out.println("Упс, непредвиленная ошибка!");
        }





        /*String email = "qw@mail.ru";
        String password = "qwkety";
        int Answer = 0;
        Answer = connect.SignInUser(email, password);
        //connect.SignInUser(email, password);
        if (Answer == 0) {
            System.out.println("Все ок");
        }
        if (Answer == 1) {
            System.out.println("Такого пользователя не существует!");
        }
        if (Answer == 2) {
            System.out.println("Неверный пароль");
        }
        if (Answer == 3) {
            System.out.println("Упс, непредвиденная ошибка");
        } */
        //connect.TestSelect(5);







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

        /*DateFormat dateFormat = DateFormat.getDateInstance();
        Date ourDate = dateFormat.parse("01.01.2000");
        System.out.println(ourDate);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format1.format(ourDate)); */
        List<String> teamParticipants = new ArrayList<>();
        teamParticipants = connect.GetTeamParticipants(1);
        for (int i = 0; i < teamParticipants.size(); i++) {
            System.out.println(teamParticipants.get(i));
        }
        List<String> teamlist = new ArrayList<>();
        teamlist = connect.GetTeamList();
        for (int i = 0; i < teamlist.size(); i++) {
            System.out.println(teamlist.get(i));
        }
        List<String> parameterslist = new ArrayList<>();
        parameterslist = connect.GetParametersList();
        for (int i = 0; i < parameterslist.size(); i++) {
            System.out.println(parameterslist.get(i));
        }








        System.out.println("Goodbye!");
    }

        Connection conn = null;
        Statement stmt = null;




    private List<String>  GetCheckinList() {
        List<String> checkinList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQLquery = "select Name from Parameters";
            PreparedStatement ps1 = conn.prepareStatement(SQLquery);
            ResultSet rs1 = st1.executeQuery(SQLquery);
            ps1.execute();
            while (rs1.next()) {
                String teamName = rs1.getString("Name");
                checkinList.add(teamName);
            }
            rs1.close();

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
        return checkinList;
    }

    private void CreateTransferItem(int transferID, int parameterID, double value) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            String query = "insert into TransferItem (GarbageTransferID, ParametersID, Value)" + " values (?, ?, ?)";

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setInt(1, transferID);
            pS.setInt(2, parameterID);
            pS.setDouble(3, value);

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


    private int CreateTransfer(String teamName, int locationID) {
        int id = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String sqlQuery = "select ID from Team where Name = '" + teamName + "'";
            ResultSet rs = st.executeQuery(sqlQuery);
            rs.next();
            int teamID = rs.getInt("ID");


            String query = "insert into Transfer (TeamID, LocationID, CreatedTime)" + " values (?, ?, ?)";
            long timeNow = Calendar.getInstance().getTimeInMillis();
            java.sql.Timestamp startDate = new java.sql.Timestamp(timeNow);

            PreparedStatement pS = conn.prepareStatement(query);
            pS.setInt(1, teamID);
            pS.setInt(2, locationID);
            pS.setTimestamp(3, startDate);
            sqlQuery = "select ID from Transfer where Name = '" + teamName + "'";
            rs = st.executeQuery(sqlQuery);
            rs.next();
            id = rs.getInt("ID");
            rs.close();

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
        return id;
    }

    //Получить список параметров мусора
    private List<String> GetParametersList() {
        List<String> parametersList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQLquery = "select Name from Parameters";
            PreparedStatement ps1 = conn.prepareStatement(SQLquery);
            ResultSet rs1 = st1.executeQuery(SQLquery);
            ps1.execute();
            while (rs1.next()) {
                String teamName = rs1.getString("Name");
                parametersList.add(teamName);
            }
            rs1.close();

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
        return parametersList;
    }

    //Получить список всех команд
    private List<String> GetTeamList() {
        List<String> teamList = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQLquery = "select Name from Team";
            PreparedStatement ps1 = conn.prepareStatement(SQLquery);
            ResultSet rs1 = st1.executeQuery(SQLquery);
            ps1.execute();
            while (rs1.next()) {
                String teamName = rs1.getString("Name");
                teamList.add(teamName);
            }
            rs1.close();

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
        return teamList;
    }

    //Получить список участников команды
    private List<String> GetTeamParticipants(int teamID) {
        List<String> teamParticipants = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQLquery = "select Name, Surname from User where TeamID = " + teamID;
            PreparedStatement ps1 = conn.prepareStatement(SQLquery);
            ResultSet rs1 = st1.executeQuery(SQLquery);
            ps1.execute();
            while (rs1.next()) {
                String name = rs1.getString("Name");
                String surname = rs1.getString("Surname");
                teamParticipants.add(name + " " + surname);
            }


            rs1.close();

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
        return teamParticipants;
    }

    //Создать команду
    private void CreateTeam(String teamName) {

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
                //startDate = calendar.getTime().getTime();
                //long curTime = System.currentTimeMillis();
                //Date curDate = new Date(curTime);
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

    //Изменить название команды
    private void UpdateTeamName(String oldTeamName, String newTeamName) {

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

    //Удалить команду
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


    private void CreateGarbageParameter(int projectID, String parameterName, double price) {

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

    private void UpdateGarbageParameter(String garbageParametr, double newPrice) {

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

    //Регистрация пользователя
    private int SignUpUser(String email, String password, String userName, String userSurname) {
        int answ = 2;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            /*Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQLquery = "select count(*) from User where Email = '" + email + "'";
            PreparedStatement ps1 = conn.prepareStatement(SQLquery);
            ResultSet rs1 = st1.executeQuery(SQLquery);
            ps1.execute();
            rs1.next();
            int count = rs1.getInt(1);

            if (count == 1) {
                String query = "insert into User (Email, Password, Name, Surname, IsAdmin, CreatedTime)" + " values (?, ?, ?, ?, ?, ?)";
                Calendar calendar = Calendar.getInstance();
                java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                PreparedStatement pS = conn.prepareStatement(query);
                pS.setString(1, email);
                pS.setString(2, password);
                pS.setString(3, userName);
                pS.setString(4, userSurname);
                pS.setBoolean(5, true);
                pS.setDate(6, startDate);
                pS.execute();

            } else {*/

            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQLquery = "select count(*) from User where Email = '" + email + "'";
            PreparedStatement ps1 = conn.prepareStatement(SQLquery);
            ResultSet rs1 = st1.executeQuery(SQLquery);
            ps1.execute();
            rs1.next();
            int count = rs1.getInt(1);

            if (count == 0) {
                answ = 0;
                String query = "insert into User (Email, Password, Name, Surname, IsAdmin, CreatedTime)" + " values (?, ?, ?, ?, ?, ?)";

                long timeNow = Calendar.getInstance().getTimeInMillis();
                java.sql.Timestamp startDate = new java.sql.Timestamp(timeNow);
                //Calendar calendar = Calendar.getInstance();
                //java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

                PreparedStatement pS = conn.prepareStatement(query);
                pS.setString(1, email);
                pS.setString(2, password);
                pS.setString(3, userName);
                pS.setString(4, userSurname);
                pS.setBoolean(5, false);
                pS.setTimestamp(6, startDate);
                pS.execute();
            } else {
                answ = 1;
            }
            //}

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
        return answ;
    }

    //Авторизация пользователя
    private int SignInUser(String email, String password) {

        int answ = 3;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(myUrl, User, Pass);
            System.out.println("Connected to database succesfully...");

            Statement st1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            String SQLquery = "select count(*) from User where Email = '" + email + "'";
            PreparedStatement ps1 = conn.prepareStatement(SQLquery);
            ResultSet rs1 = st1.executeQuery(SQLquery);
            ps1.execute();
            rs1.next();
            int count = rs1.getInt(1);

            if (count == 1) {
                String query = "select Password from User where Email = '" + email + "'";
                PreparedStatement pS = conn.prepareStatement(query);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                pS.execute();
                rs.next();
                String pass = rs.getString("Password");
                if (pass.equals(password)) {
                    answ = 0;
                } else {
                    answ = 2;
                }
            } else {
                answ = 1;
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
        return answ;
    }

    //Добавить пользователя к команде
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

    //Исключить пользователя из команды
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