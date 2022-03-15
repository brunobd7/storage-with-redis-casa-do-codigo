package intro;

import redis.clients.jedis.Jedis;

public class HelloRedis {

    public static void main(String[] args) {


        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("123");

        System.out.println("======================================== ECHO =================================================");
        String result = jedis.echo("Hello Redis");

        System.out.println(result.toUpperCase());

        System.out.println("======================================== SET =================================================");

        result = jedis.set("last_logged_user", "Tony Stark");
        System.out.println("RESULT -> "+result.toUpperCase());

        System.out.println("========================================= GET ================================================");
        System.out.println("VALUE CHANGED -> "+jedis.get("last_logged_user"));

        System.out.println("========================================= DEL ================================================");
        Long nrResult = jedis.del("last_logged_user");
        System.out.println("RESULT OP DELETE (TOTAL OF DEL KEYS)-> "+nrResult);
        System.out.println("=========================================================================================");

    }


}
