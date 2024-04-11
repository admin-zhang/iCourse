package dlub.icoders.icourse.common.utils;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @ClassName StrUtils.java
 * @Description
 * @Author panda
 * @Date 2023/4/22 11:05
 * @Version 1.0
 */
public class StrUtils {
    public static boolean isUnKnown(String str) {
        return "unknown".equalsIgnoreCase(str);
    }

    /**
     * 生成随机用户名，数字和字母组成
     *
     * @return
     */
    public static String getStringRandom() {
        int length = 10;
        StringBuilder val = new StringBuilder("iShop");
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else {
                val.append(String.valueOf(random.nextInt(10)));
            }
        }
        return val.toString();
    }

    /**
     * 自动生成中文名字
     *
     * @return
     */
    public static String getRandomJianHan() {
        int len = 10;
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos; // 定义高位
            int lowPos; // 定义低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (byte) hightPos;
            b[1] = (byte) lowPos;
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret.append(str);
        }
        return ret.toString();
    }
}
