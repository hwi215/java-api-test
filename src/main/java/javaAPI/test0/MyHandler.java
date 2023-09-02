package javaAPI.test0;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import org.json.simple.JSONObject;


/**
 * 요구사항 1.
 * 클라이언트가  "/" , "content-type, json " 요청을 보낼때
 * API 서버를 하나 5678포트로 생성해서
 * json 형태로  "message" : "server check" 를 담아주는 요구사항
 */
public class MyHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        Gson gson = new Gson();
        String response = "";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "server check");
        exchange.getResponseHeaders().add("Content-Type", "application/json"); // 응답 헤더 설정
        exchange.sendResponseHeaders(200, response.getBytes().length); // 응답 코드와 길이 설정

        // jsonObject을 json 문자열로 변환
        String jsonStr = gson.toJson(jsonObject);

        // 생성된 json 문자열 출력
        System.out.println(jsonStr);

        OutputStream os = exchange.getResponseBody();
        os.write(jsonStr.getBytes());
        os.close();



    }
}
