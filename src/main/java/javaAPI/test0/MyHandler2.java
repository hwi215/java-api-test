package javaAPI.test0;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.simple.JSONArray;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;


/**
 * 이미 있는  JSON 파일  파싱하기
 */
public class MyHandler2 implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("MyHandler2 call..");

        Gson gson = new Gson();


        // FileReader 생성

        String path = MyHandler2.class.getResource("").getPath();
        System.out.println("path :" + path);



/*
        // json파일 읽어서, User 객체로 변환

        System.out.println("성공?");
        Gson gson = new Gson();
        User user = gson.fromJson(fileReader, User.class);

        // User 객체 출력 및 post_count의 총합 구하기
        System.out.println(user);

 */

        //
        String filePath = "/Users/gimhwigyeong/Desktop/hwi/project/javaAPI/src/main/java/javaAPI/test0/user.json";
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(filePath));
            JsonObject object = gson.fromJson(jsonReader, JsonObject.class);
            System.out.println("\"user_id\" : " + object.get("user_id"));
            //System.out.println(object.toString());

            System.out.println("중간 ===");

            Set<Map.Entry<String, JsonElement>> element = object.entrySet();

            for(Map.Entry<String, JsonElement> entry : element){
                System.out.println("key: " + entry.getKey());
                System.out.println("val: " + entry.getValue());
                System.out.println("==========================");
            }




            /*

            FileReader fileReader = new FileReader("/javaAPI/test0/user.json");
            String jsonData = "{\"user_id\":\"1\", \"username\":\"hwi\"}";
            System.out.println("filereader: " + fileReader);
            JsonObject jsonObject = (JsonObject) JsonParser.parseString(String.valueOf(fileReader));

            fileReader.close();
            System.out.println(jsonObject);
            */
        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
   /*
        int user_id = jsonObject.get("user_id").getAsInt();
        String username = jsonObject.get("username").getAsString();
        System.out.println("user_id: " + user_id + ", username: " + username);

         */










    }
}
