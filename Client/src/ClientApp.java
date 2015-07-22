import com.sun.deploy.net.HttpResponse;
import javafx.scene.control.TextInputControl;
import sun.net.www.http.HttpClient;

import javax.swing.text.AbstractDocument;
import java.io.*;
import java.net.*;
import java.text.*;
import java.nio.charset.StandardCharsets;

public class ClientApp {



    public static void main(String args[]) {

        ClientApp Exp = new ClientApp();
        Exp.CreateTeam("time is wrong",2);

    }

    public void CreateTeam(String teamName, int userID){

        String targetURL = "http://api.cleangames.ru/ServletTest/Servlet";
        String urlParameters = "ActionType=CreateTeam&TeamName="
                + teamName +"&UserID=" + userID;


        //System.out.println(urlParameters);
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            OutputStream wr = connection.getOutputStream();
            wr.write(urlParameters.getBytes("UTF-8"));
            wr.flush();
            wr.close();

            //Get Response
            //TextInputControl.Content is = connection.getContent();
            //String is = response.getEntity;
            //System.out.println(is);
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                  System.out.println(line);
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}

