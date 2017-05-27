package connection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by andres on 27/05/17.
 * DrApp
 * connection
 */
public class SpecialNetClientPost {

    public static JSONArray NetClientPost(String url, String output) {

        JSONArray jsonArray = new JSONArray();

        try {

            URL realURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realURL.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "Application/json");

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(output.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode());
            }

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input = bufferedReader.readLine();

            try {

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(input);
                //noinspection unchecked
                jsonArray.add(jsonObject);

            } catch (Exception e) {
                try {
                    return NetClientPutArray(connection, input);
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }
            }

            connection.disconnect();
            return jsonArray;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonArray;

    }

    private static JSONArray NetClientPutArray(HttpURLConnection connection ,String jsonString) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(jsonString);
        connection.disconnect();
        return jsonArray;
    }
}