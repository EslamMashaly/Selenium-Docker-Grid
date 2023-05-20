package utils.dataReaders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class JsonDataReader {
   public String firstName, lastName, email, phone, password, loginEmail, loginPassword;

    public void jsonReader() throws IOException, ParseException {
        String filepath= PropertiesReader.pathsData.getProperty("RegistrationDataJson");
        File srcFile= new File (filepath);

        JSONParser parser= new JSONParser();  //to parse the json file
        JSONArray ja = (JSONArray)parser.parse(new FileReader(srcFile));     //to read the json data

        for(Object jsonObject : ja){
            JSONObject user = (JSONObject) jsonObject;
            firstName = (String) user.get("firstName");
            System.out.println(firstName);

            lastName = (String) user.get("lastName");
            System.out.println(lastName);

            email = (String) user.get("email");
            System.out.println(email);

            phone = (String) user.get("phone");
            System.out.println(phone);

            password = (String) user.get("password");
            System.out.println(password);
        }
    }

    public void loginJsonReader() throws IOException, ParseException {
        String filepath= PropertiesReader.pathsData.getProperty("LoginDataJson");
        File srcFile= new File (filepath);

        JSONParser parser= new JSONParser();  //to parse the json file
        JSONArray ja = (JSONArray)parser.parse(new FileReader(srcFile));     //to read the json data

        for(Object jsonObject : ja){
            JSONObject user = (JSONObject) jsonObject;
            loginEmail = (String) user.get("email");
            System.out.println(loginEmail);

            loginPassword = (String) user.get("password");
            System.out.println(loginPassword);

        }
    }
}
