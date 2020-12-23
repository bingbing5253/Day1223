package cn.zb.day1223.constant;

import java.util.Random;

/**
 * @author zb
 */
public class MyConstant {
    public static int sleep(){
        int num = new Random().nextInt(4000) + 1000;  // random number between 1000 and 5000
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return num/1000;
    }
}
