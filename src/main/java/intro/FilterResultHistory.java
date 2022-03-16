package intro;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class FilterResultHistory {
    
    public Set<String> filterResults (Integer month, Integer year){

        String redisKeyCommand = "result:*-%02d-%04d:megasena";

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("123");

        return jedis.keys(String.format(redisKeyCommand,month, year));

    }
    public static void main(String[] args) {

        Integer month = 10;
        Integer year=2013;
        System.out.println("======================================== KEYS (FILTER) =================================================");
        Set<String> keysResult = new FilterResultHistory().filterResults(month, year);

        System.out.println(keysResult);
        System.out.println("======================================== END =================================================");

        System.out.println("======================================== MGET =================================================");
        //EXERCISES
        Jedis jedis = new Jedis("localhost",6379);
        jedis.auth("123");

        List<String> lsResult = jedis.mget("result:04-09-2013:megasena","result:07-09-2013:megasena");
        System.out.println(lsResult);
        System.out.println("======================================== END =================================================");

    }


}
