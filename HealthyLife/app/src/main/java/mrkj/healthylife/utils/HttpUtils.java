package mrkj.healthylife.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 下载数据的工具类
 * 
 * @author Administrator
 *
 */
public class HttpUtils {
    private static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    private static final int DEF_CONN_TIMEOUT = 30000;
    private static final int DEF_READ_TIMEOUT = 30000;
    private static final String DEF_CHATSET = "UTF-8";
    public static final String HUMIDITY = "%rh";// 湿度单位
    public static final String TEMPERATURE = "°C";// 温度单位

    /**
     * HttpUrl
     */
    public static String getJsonStr(String dataUrl) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuffer sb = new StringBuffer();
            URL url = new URL(dataUrl);
            connection = (HttpURLConnection) url.openConnection();// 引用这个url
            connection.setRequestProperty("User-agent", userAgent);
            connection.setUseCaches(false);
            connection.setConnectTimeout(DEF_CONN_TIMEOUT);
            connection.setReadTimeout(DEF_READ_TIMEOUT);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.connect();// 打开连接
            if (connection.getResponseCode() == 200) {// code为200位连接服务器成功
                InputStream is = connection.getInputStream();// 获取输入流
                reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
                String strRead = null;
                while ((strRead = reader.readLine()) != null) {
                    sb.append(strRead);
                }
                rs = sb.toString();
                return rs;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();// 关闭流
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                connection.disconnect();// 断开连接
            }
        }

        return null;

    }
}
