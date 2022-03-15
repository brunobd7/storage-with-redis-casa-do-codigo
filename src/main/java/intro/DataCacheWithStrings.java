package intro;

import redis.clients.jedis.Jedis;

public class DataCacheWithStrings {

    public static void main(String[] args) {

        /*JSON EXAMPLE
         {
         "data": "21-09-2013",
         "numeros": [2, 13, 24, 41, 42, 44],
         "ganhadores": 2
         }
         */

        String  key = "result:megasena";
        String lastNumbersDraw = "2, 13, 24, 41, 42, 44";

        Jedis jedis = new Jedis("localhost");
        jedis.auth("123");

        String result = jedis.set(key, lastNumbersDraw);
        System.out.println(result);

    }
}
