package cn.zb.day1223.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.*;

/**
 * @author zb
 */
@RestController
public class Service1 {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @GetMapping(path = "/getAll")
    public String getAll() throws ExecutionException, InterruptedException {
        String Result2 = "", Result3 = "", Result4 = "";
        ExecutorService es = Executors.newFixedThreadPool(3);
        Callable<String> task2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return getResult("http://localhost:8092/Service2/getTwo");
            }
        };
        Callable<String> task3 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return getResult("http://localhost:8093/Service3/getThree");
            }
        };
        Callable<String> task4 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return getResult("http://localhost:8094/Service4/getFour");
            }
        };
        Future<String> future2 = es.submit(task2);
        Future<String> future3 = es.submit(task3);
        Future<String> future4 = es.submit(task4);

        return String.format("ResultList,<br>%s;<br>%s;<br>%s", future2.get(), future3.get(), future4.get());
      /*  Result2 = getResult("http://localhost:8092/Service2/getTwo");
        Result3 = getResult("http://localhost:8093/Service3/getThree");
        Result4 = getResult("http://localhost:8094/Service4/getFour");
        return String.format("ResultList, <br>%s;<br>%s;<br>%s", Result2, Result3, Result4);*/
    }

    public String getResult(String url) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
        return responseEntity.getBody();
    }
}
