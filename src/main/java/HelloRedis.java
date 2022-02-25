import redis.clients.jedis.Jedis;

public class HelloRedis {

    public static void main(String[] args) {


        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("123");

        String result = jedis.echo("Hello Redis");

        System.out.println(result.toUpperCase());

    }


}
