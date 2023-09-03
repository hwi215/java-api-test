package javaAPI.test0;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.simple.JSONArray;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 요구사항4
 * 이미 있는  JSON 파일  파싱하기
 * - User 객체로 변환한 후, 모든 user의 post_count의 합 구하기
 */
public class MyHandler4 implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        System.out.println("MyHandler4 call..");

        Gson gson = new Gson();


/*
        // json파일 읽어서, User 객체로 변환

        System.out.println("성공?");
        Gson gson = new Gson();
        User user = gson.fromJson(fileReader, User.class);

        // User 객체 출력 및 post_count의 총합 구하기
        System.out.println(user);

 */

        //
        String filePath = "/Users/gimhwigyeong/Desktop/hwi/project/javaAPI/src/main/java/javaAPI/data/user2.json";

        String jsonStr = "";
        try {

            JsonReader jsonReader = new JsonReader(new FileReader(filePath));

            JSONArray jsonArray = gson.fromJson(jsonReader, JSONArray.class);

            System.out.println(jsonArray.toString());
            System.out.println("size: " + jsonArray.size());
            System.out.println("get0: " + jsonArray.get(0));


            int sum = 0;
            List<User> userList = new ArrayList<>();
            for(int i = 0; i < jsonArray.size(); i++){
                //JsonObject object = gson.fromJson(jsonArray.get(i).toString(), JsonObject.class);
                User users = gson.fromJson(jsonArray.get(i).toString(), User.class);


                int user_id = users.getUser_id();
                String username = users.getUsername();
                int count = users.getPost_count();
                System.out.println("user_id: " + user_id + ", username: " + username);

                userList.add(new User(user_id, username, count));


            }

            for(User user : userList){
                sum += user.getPost_count();
            }

            System.out.println("모든 user의 post_count의 합: " + sum);

            JsonObject resultObject = new JsonObject();
            resultObject.addProperty("sum", sum);
            jsonStr = gson.toJson(resultObject);

            exchange.getResponseHeaders().add("Content-Type", "application/json"); // 응답 헤더 설정
            exchange.sendResponseHeaders(200, jsonStr.getBytes().length); // 응답 코드와 길이 설정

        }catch (Exception e){
            System.out.println("error");
            exchange.getResponseHeaders().add("Content-Type", "application/json"); // 응답 헤더 설정
            exchange.sendResponseHeaders(500, jsonStr.getBytes().length); // 응답 코드와 길이 설정
            e.printStackTrace();
        }finally {
            OutputStream os = exchange.getResponseBody();
            os.write(jsonStr.getBytes());
            os.close();

        }



    }
}
