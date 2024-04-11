package dlub.icoders.icourse.common.utils.http;

import com.alibaba.cloud.commons.lang.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.lionsoul.ip2region.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;

/**
 * @ClassName AddressUtils.java
 * @Description 根据IP获取地址
 * @Author panda
 * @Date 2023/4/22 15:32
 * @Version 1.0
 */
public class AddressUtils {
    private static final Logger log = LoggerFactory.getLogger(AddressUtils.class);

    static String dbPath;
    static DbConfig config;
    static DbSearcher searcher;

    private AddressUtils() {
    }

    static {
        dbPath = createFtlFileByFtlArray() + "ip2region.db";
        try {
            config = new DbConfig();
        } catch (DbMakerConfigException e) {
            e.printStackTrace();
        }
        try {
            searcher = new DbSearcher(config, dbPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建ip2region文件
     *
     * @return
     */
    private static String createFtlFileByFtlArray() {
        String ftlPath = "city/";
        return createFtlFile(ftlPath, "ip2region.db");
    }

    /**
     * 创建文件
     *
     * @param ftlPath
     * @param ftlName
     * @return
     */
    private static String createFtlFile(String ftlPath, String ftlName) {
        InputStream certStream = null;
        try {
            //获取当前项目所在的绝对路径
            String proFilePath = System.getProperty("user.dir");

            //获取模板下的路径，然后存放在temp目录下　
            String newFilePath = proFilePath + File.separator + "temp" + File.separator + ftlPath;
            newFilePath = newFilePath.replace("/", File.separator);
            //检查项目运行时的src下的对应路径
            File newFile = new File(newFilePath + ftlName);
            if (newFile.isFile() && newFile.exists()) {
                return newFilePath;
            }
            //当项目打成jar包会运行下面的代码，并且复制一份到src路径下（具体结构看下面图片）
            certStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(ftlPath + ftlName);
            assert certStream != null;
            byte[] certData = IOUtils.toByteArray(certStream);
            FileUtils.writeByteArrayToFile(newFile, certData);
            return newFilePath;
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                assert certStream != null;
                certStream.close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    /**
     * 根据IP获取城市地址
     *
     * @param ip
     * @return
     */
    public static String getCityInfo(String ip) {

        if (StringUtils.isEmpty(dbPath)) {
            log.error("Error: Invalid ip2region.db file");
            return null;
        }
        if (config == null || searcher == null) {
            log.error("Error: DbSearcher or DbConfig is null");
            return null;
        }

        /**
         * 查询算法
         * B-tree, B树搜索（更快）
         * DbSearcher.BTREE_ALGORITHM
         *
         * Binary,使用二分搜索
         * DbSearcher.BINARY_ALGORITHM
         * method = searcher.getClass().getMethod("binarySearch", String.class);
         * Memory,加载内存（最快）
         * DbSearcher.MEMORY_ALGORITYM
         * method = searcher.getClass().getMethod("memorySearch", String.class);
         */
        try {
            // 使用静态代码块，减少文件读取操作
            //define the method
            Method method;
            method = searcher.getClass().getMethod("btreeSearch", String.class);

            DataBlock dataBlock;
            if (!Util.isIpAddress(ip)) {
                log.error("Error: Invalid ip address");
            }

            dataBlock = (DataBlock) method.invoke(searcher, ip);
            String ipInfo = dataBlock.getRegion();
            if (!StringUtils.isEmpty(ipInfo)) {
                ipInfo = ipInfo.replace("|0", "");
                ipInfo = ipInfo.replace("0|", "");
            }
            return ipInfo;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
