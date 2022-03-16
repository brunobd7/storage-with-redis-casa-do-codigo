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
        String result = "";

        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("123");

//        System.out.println("======================================== SET =================================================");
//        result = jedis.set(key, lastNumbersDraw);
//        System.out.println(result);

//        System.out.println("======================================== GET =================================================");
//        result = jedis.get(key);
//        System.out.println(result);


        String drawDate1 = "04-09-2013";
        String drawNumbers1 = "10, 11, 18, 42, 55, 56";
        String key1 = String.format("result:%s:megasena", drawDate1);

        String drawDate2 = "07-09-2013";
        String drawNumbers2 = "2, 21, 30, 35, 45, 50";
        String key2 = String.format("result:%s:megasena", drawDate2);

        String drawDate3 = "21-09-2013";
        String drawNumbers3 = "2, 13, 24, 41, 42, 44";
        String key3 = String.format("result:%s:megasena", drawDate3);

        String drawDate4 = "02-10-2013";
        String drawNumbers4 = "7, 15, 20, 23, 30, 41";
        String key4 = String.format("result:%s:megasena",drawDate4);

        result = jedis.mset(
                key1, drawDate1,
                key2, drawDate2,
                key3, drawDate3,
                key4, drawDate4
        );
        System.out.println(String.format("Return of redis -> %s ",result));


    }
}
