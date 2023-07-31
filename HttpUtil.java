package cn.wsdy.aojiang.util.http;


import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * http工具类
 *
 * @author  Tukeke
 * */
public class HttpUtil {

    /**
     * 生成word
     * @author Tukeke
     * @param jsonObject   入参数据
     * @param url          url地址
     * @param prefix       前缀名称
     * @param clazz        bean类
     * @return resultList  数据列表
     */

    public static <T> List<T> getRomoteData(JSONObject jsonObject,String url, String prefix,Class<T> clazz){
        String resultString = HttpRequest.post(url).body(jsonObject.toString(), ContentType.JSON.getValue())
                .execute().body();
        JSONObject resultObject = JSONObject.parseObject(resultString);
        List<T> resultList = JSONUtil.toList(resultObject.get(prefix).toString(), clazz);
        return resultList;
    }
}
