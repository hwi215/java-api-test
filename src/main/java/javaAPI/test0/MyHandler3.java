package javaAPI.test0;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


/**
 * 요구사항3
 * 이미 있는  JSON 파일  파싱하기2
 * - 모든 user의 post_count의 합
 */
public class MyHandler3 implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("MyHandler2 call..");

        Gson gson = new Gson();


        // FileReader 생성

        String path = MyHandler3.class.getResource("").getPath();
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
        String filePath = "/Users/gimhwigyeong/Desktop/hwi/project/javaAPI/src/main/java/javaAPI/test0/user2.json";
        try {

            JsonReader jsonReader = new JsonReader(new FileReader(filePath));

            JSONArray jsonArray = gson.fromJson(jsonReader, JSONArray.class);

            System.out.println(jsonArray.toString());
            System.out.println("size: " + jsonArray.size());
            System.out.println("get0: " + jsonArray.get(0));


            int sum = 0;
            for(int i = 0; i < jsonArray.size(); i++){
                JsonObject object = gson.fromJson(jsonArray.get(i).toString(), JsonObject.class);
                String user_id = object.get("user_id").getAsString();
                String username = object.get("username").getAsString();
                String count = object.get("post_count").getAsString();
                /*
                System.out.println("user_id: " + user_id);
                System.out.println("username: " + username);
                System.out.println("post_count: " + count);

                 */

                int post_count = object.get("post_count").getAsInt();
                sum += post_count;
            }

            System.out.println("모든 user의 post_count의 합: " + sum);

        }catch (Exception e){
            System.out.println("error");
            e.printStackTrace();
        }










    }
}
