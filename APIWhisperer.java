import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class APIWhisperer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the API URL: ");
        String apiUrl = scanner.nextLine(); // user input replaces hardcoded URL

        try {
            // to create a URL object
            URL url = new URL(apiUrl);

            // to open HTTP connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // to check for successful response
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) { //means that the request was successful
                BufferedReader in = new BufferedReader( // read from input stream
                        new InputStreamReader(conn.getInputStream()));

                String inputLine;
                StringBuilder response = new StringBuilder(); // to store the response

                while ((inputLine = in.readLine()) != null) { // read each line of the response
                    response.append(inputLine).append("\n");
                }
                in.close();

                // print the raw JSON response
                System.out.println(">>> Raw JSON response:");
                System.out.println(response.toString());

                try {
                    // parse JSON response using GSON
                    Gson gson = new Gson();
                    JsonObject jsonObj = gson.fromJson(response.toString(), JsonObject.class);

                    // print selected JSON fields (if they exist)
                    System.out.println(">>> API Summary <<<");
                    if (jsonObj.has("login")) {
                        System.out.println("Login: " + jsonObj.get("login").getAsString());
                    }
                    if (jsonObj.has("id")) {
                        System.out.println("ID: " + jsonObj.get("id").getAsInt());
                    }
                    if (jsonObj.has("public_repos")) {
                        System.out.println("Public Repos: " + jsonObj.get("public_repos").getAsInt());
                    }
                    if (jsonObj.has("created_at")) {
                        System.out.println("Created At: " + jsonObj.get("created_at").getAsString());
                    }
                } catch (JsonSyntaxException e) {
                    System.out.println("The response was not valid JSON.");
                }

            } else {
                System.out.println("Failed to fetch data. HTTP status code: " + responseCode);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}