import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class ClientApp {



    public static void main(String args[]) {

        ClientApp Exp = new ClientApp();
        Exp.CreateChekin(1, 1, 1, 1.055555, 1.9784, "Все хорошо");

    }

    public void CreateChekin(int UserID, int TeamID, int ProjectID, double PlaceX, double PlaceY, String Comments ){
        String targetURL = "http://localhost:8080/api";
        String urlParameters = "ActionType=CreateChekin&UserID=" + UserID + "&ProjectID=" + ProjectID +
                "&TeamID=" + TeamID + "&PlaceX=" + PlaceX + "&PlaceY=" + PlaceY + "&Comments=" + Comments;
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
            DataOutputStream wr = new DataOutputStream(
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
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

