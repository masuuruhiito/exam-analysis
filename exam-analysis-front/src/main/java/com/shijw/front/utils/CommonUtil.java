package com.shijw.front.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zgy
 * @version 1.0
 * @date 2021/1/28
 */
@Slf4j
public class CommonUtil {

    /**
     * 函数功能：将一些链接中的http改为https
     *
     * @param
     * @return void
     */
    public static String replaceHttpToHttps(String oldUrl) {
        //如果是http的就改为https,前端https不能访问http接口
        if (oldUrl != null && oldUrl.contains("http://ydschool-online.nos.netease.com")) {
            oldUrl = oldUrl.replace("http://ydschool-online.nos.netease.com",
                                    "https://nos.netease.com/ydschool-online");
        } else if (oldUrl != null && oldUrl.contains("http://")) {
            oldUrl = oldUrl.replace("http://", "https://");
        }
        return oldUrl;
    }

    /**
     * <p>Replaces all continuous occurrences of a String within another String.</p>
     *
     *
     * <pre>
     * CommonUtil.replace("aaanyaa", "aa", "a")    = "anya"
     * CommonUtil.replace("aba", "a", "")    = "b"
     * CommonUtil.replace("aba", "a", "z")   = "zbz"
     * CommonUtil.replace("a  b a", "  ", " ")   = "a b a"
     * </pre>
     */
    public static String replaceContinuous(String word, String target, String replacement) {
        if (StringUtils.isBlank(word)) {
            return word;
        }
        String wordTemp;
        do {
            wordTemp = word;
            word = word.replace(target, replacement);
        } while (!wordTemp.equals(word));
        return word;
    }

    /**
     * 去掉所有html，比较定制化了
     *
     * @param html
     * @return
     */
    public static String removeAllHtmlTag(String html) {
        if (StringUtils.isBlank(html)) {
            return "";
        }
        String htmlStr = html;
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
        String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        htmlStr = trim(htmlStr);
        htmlStr = htmlStr.trim();

        String[] arr = htmlStr.split("\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (StringUtils.isEmpty(s)) {
                continue;
            }
            sb.append(s.trim());
            if (i != arr.length - 1) {
                sb.append("\n");
            }
        }
        //将 &amp; 等 转义的换成& 未转义的
        return StringEscapeUtils.unescapeHtml4(sb.toString());
    }

    public static String trim(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (c == 160 || c == 12288) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }
        return servletRequestAttributes.getRequest();
    }

    public static HttpServletResponse getResponse() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (servletRequestAttributes == null) {
            return null;
        }
        return servletRequestAttributes.getResponse();
    }

    public static boolean noCache() {
        HttpServletRequest request = getRequest();
        if (request != null && StringUtils.isNotEmpty(request.getParameter("noCache")) &&
            request.getParameter("noCache").equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加span包裹标签
     * 例:输入hello, 输出<span>hello</span>,为null时输出<span></span>
     *
     * @param str 被包裹的字符串
     * @return 添加标签后的字符串
     */
    public static String addSpan(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("<span>");
        if (str != null) {
            sb.append(str);
        }
        sb.append("</span>");
        return sb.toString();
    }

    /**
     * 把map<Object,Object>转化为map<String,String>当Object为=null时，String="null"
     *
     * @param map
     * @return
     */
    public static Map<String, String> convertMap(Map<Object, Object> map) {
        if (map != null) {
            Map<String, String> res = new HashMap<>(map.size());
            Iterator<Map.Entry<Object, Object>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Object, Object> next = iterator.next();
                Object key = next.getKey();
                Object value = next.getValue();
                String keyStr = String.valueOf(key);
                String valueStr = String.valueOf(value);
                res.put(keyStr, valueStr);
            }
            return res;
        }
        return new HashMap<>(0);
    }

    /**
     * 会根据levels进行分段进行平均分段如果需要needZero或needFull，则对needZero 或needFull单独分一档，中间段评分分档
     *
     * @param fullScore
     * @param levels
     * @param scores
     * @return
     * @needFull 是否需要满分档
     */
    public static String getAverageLevelStringByScore(boolean needZero, boolean needFull, double fullScore,
                                                      String[] levels, double... scores) {
        if (levels == null || levels.length == 0) {
            return "";
        }
        double sc = 0.0;
        if (scores != null) {
            for (double score : scores) {
                sc += score;
            }
        }
        // 切换为百分制
        sc = sc / fullScore * 100;
        if (sc == 0) {
            return levels[0];
        }
        // 平分为几档
        int count = levels.length;
        // 平均分档的最低档
        int level = 0;
        if (needZero) {
            level++;
            count--;
        }
        if (needFull) {
            count--;
        }
        // 如果是零分则直接返回最低档
        if (sc <= 0) {
            return levels[0];
        }
        // 如果满分档直接返回最高档
        if (sc >= 100) {
            return levels[levels.length - 1];
        }
        // 每一档的分数
        double per = 100.0 / count;
        int d = 1;
        while (d <= count) {
            if (sc < per * d) {
                return levels[level];
            }
            level++;
            d++;
        }
        return levels[levels.length - 1];
    }

    /**
     * Map排序
     *
     * @param map
     * @param <T>
     * @return
     */
    public static <T> HashMap<String, T> sortMapByValues(HashMap<String, T> map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o2)).getValue())
                    .compareTo(((Map.Entry) (o1)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
