package test;

import com.alibaba.fastjson.JSON;
import com.forte.util.Mock;
import com.forte.util.mockbean.MockObject;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author ForteScarlet <[email]ForteScarlet@163.com>
 * @since JDK1.8
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        // Mock.set(User.class);
        // MockObject<User> userMockObject = Mock.get(User.class);
        // userMockObject.getStream(20).forEach(System.out::println);
        /*String s = "{\n" +
                "  \"string|1-2\": \"@string\",\n" +
                "  \"integer\": \"@integer(10,30)\",\n" +
                "  \"float\": \"@float(60,100,2,2)\",\n" +
                "  \"boolean\": \"@bool\",\n" +
                "  \"date\": \"@toDateStr\",\n" +
                "  \"datetime\": \"@time\",\n" +
                "  \"now\": \"@toDateTime\",\n" +
                "  \"url\": \"@url\",\n" +
                "  \"email\": \"@email\",\n" +
                "  \"region\": \"@region\",\n" +
                "  \"city\": \"@city\",\n" +
                "  \"province\": \"@province\",\n" +
                "  \"county\": \"@county\",\n" +
                "  \"upper\": \"@upper(@title)\",\n" +
                "  \"guid\": \"@guid\",\n" +
                "  \"id\": \"@UUNUM\",\n" +
                "  \"image\":  {\n" +
                "    \"330000\": \"@province\",\n" +
                "    \"340000\": \"@province\"\n" +
                "  },\n" +
                "  \"title\": \"@title\",\n" +
                "  \"cparagraph\": \"@cparagraph\",\n" +
                "  \"csentence\": \"@csentence\",\n" +
                "  \"range\": \"@range(2, 10)\",\n" +
                "  \"address\": \"@address\"\n" +
                "}";*/
        ThreadFactory factory = (r) -> {
            Thread thread = new Thread(r);
            thread.setName("demo-pool-%d");
            return thread;
        };
        ExecutorService executorService = new ThreadPoolExecutor(30, 50, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(20), factory);

        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                String s = "{\"a|1-3\":\"@title\"}";
                Map<String, Object> map1 = JSON.parseObject(s);
                Mock.reset("userMap1", map1);
                MockObject map12 = Mock.get("userMap1");
                System.out.println(map12.getOne());
                String json = JSON.toJSONString(map12.getOne());
                System.out.println(json);
            });
        }
        executorService.shutdown();
    }

}
