package com.hbkd.hyx.tool;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Convert object to json string.
 * Convert json string to object.
 * <p>
 * Json     			java
 * string			java.lang.String
 * number			java.lang.Number
 * true|false		java.lang.Boolean
 * null				null
 * array			java.util.List
 * object			java.util.Map
 */
@SuppressWarnings({"unchecked"})
public class JsonKit {

    private static int convertDepth = 8;
    private static String timestampPattern = "yyyy-MM-dd HH:mm:ss";
    private static String datePattern = "yyyy-MM-dd";

    public static void setConvertDepth(int convertDepth) {
        if (convertDepth < 2) {
            throw new IllegalArgumentException("convert depth can not less than 2.");
        }
        JsonKit.convertDepth = convertDepth;
    }

    public static void setTimestampPattern(String timestampPattern) {
        if (timestampPattern == null || "".equals(timestampPattern.trim())) {
            throw new IllegalArgumentException("timestampPattern can not be blank.");
        }
        JsonKit.timestampPattern = timestampPattern;
    }

    public static void setDatePattern(String datePattern) {
        if (datePattern == null || "".equals(datePattern.trim())) {
            throw new IllegalArgumentException("datePattern can not be blank.");
        }
        JsonKit.datePattern = datePattern;
    }

    private static String mapToJson(Map map, int depth) {
        if (map == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        Iterator iter = map.entrySet().iterator();

        sb.append('{');
        while (iter.hasNext()) {
            if (first) {
                first = false;
            } else {
                sb.append(',');
            }

            Map.Entry entry = (Map.Entry) iter.next();
            toKeyValue(String.valueOf(entry.getKey()), entry.getValue(), sb, depth);
        }
        sb.append('}');
        return sb.toString();
    }

    private static String toKeyValue(String key, Object value, StringBuilder sb, int depth) {
        sb.append('\"');
        if (key == null) {
            sb.append("null");
        } else {
            escape(key, sb);
        }
        sb.append('\"').append(':');

        sb.append(toJson(value, depth));

        return sb.toString();
    }

    private static String listToJson(List list, int depth) {
        if (list == null) {
            return "null";
        }

        boolean first = true;
        StringBuilder sb = new StringBuilder();
        Iterator iter = list.iterator();

        sb.append('[');
        while (iter.hasNext()) {
            if (first) {
                first = false;
            } else {
                sb.append(',');
            }

            Object value = iter.next();
            if (value == null) {
                sb.append("null");
                continue;
            }
            sb.append(toJson(value, depth));
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * Escape quotes, \, /, \r, \n, \b, \f, \t and other control characters (U+0000 through U+001F).
     */
    private static String escape(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        escape(s, sb);
        return sb.toString();
    }

    private static void escape(String s, StringBuilder sb) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if ((ch >= '\u0000' && ch <= '\u001F') || (ch >= '\u007F' && ch <= '\u009F') || (ch >= '\u2000' && ch <= '\u20FF')) {
                        String str = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - str.length(); k++) {
                            sb.append('0');
                        }
                        sb.append(str.toUpperCase());
                    } else {
                        sb.append(ch);
                    }
            }
        }
    }

    public static String toJson(Object value) {
        return toJson(value, convertDepth);
    }

    public static String toJson(Object value, int depth) {
        if (value == null || (depth--) < 0) {
            return "null";
        }

        if (value instanceof String) {
            return "\"" + escape((String) value) + "\"";
        }

        if (value instanceof Double) {
            if (((Double) value).isInfinite() || ((Double) value).isNaN()) {
                return "null";
            } else {
                return value.toString();
            }
        }

        if (value instanceof Float) {
            if (((Float) value).isInfinite() || ((Float) value).isNaN()) {
                return "null";
            } else {
                return value.toString();
            }
        }

        if (value instanceof Number) {
            return value.toString();
        }

        if (value instanceof Boolean) {
            return value.toString();
        }

        if (value instanceof java.util.Date) {
            if (value instanceof java.sql.Timestamp) {
                return "\"" + new SimpleDateFormat(timestampPattern).format(value) + "\"";
            }
            if (value instanceof java.sql.Time) {
                return "\"" + value.toString() + "\"";
            }
            return "\"" + new SimpleDateFormat(datePattern).format(value) + "\"";
        }

        if (value instanceof Map) {
            return mapToJson((Map) value, depth);
        }

        if (value instanceof List) {
            return listToJson((List) value, depth);
        }

        String result = otherToJson(value, depth);
        if (result != null) {
            return result;
        }

        // 类型无法处理时当作字符串处理,否则ajax调用返回时js无法解析
        // return value.toString();
        return "\"" + escape(value.toString()) + "\"";
    }

    private static String otherToJson(Object value, int depth) {
        if (value instanceof Character) {
            return "\"" + escape(value.toString()) + "\"";
        }

        if (value instanceof Object[]) {
            Object[] arr = (Object[]) value;
            List list = new ArrayList(arr.length);
            for (int i = 0; i < arr.length; i++) {
                list.add(arr[i]);
            }
            return listToJson(list, depth);
        }
        if (value instanceof Enum) {
            return "\"" + value.toString() + "\"";
        }

        return beanToJson(value, depth);
    }

    private static String beanToJson(Object model, int depth) {
        Map map = new HashMap(16);
        Method[] methods = model.getClass().getMethods();
        for (Method m : methods) {
            String methodName = m.getName();
            int indexOfGet = methodName.indexOf("get");
            if (indexOfGet == 0 && methodName.length() > 3) {    // Only getter
                String attrName = methodName.substring(3);
                if (!"Class".equals(attrName)) {                // Ignore Object.getClass()
                    Class<?>[] types = m.getParameterTypes();
                    if (types.length == 0) {
                        try {
                            Object value = m.invoke(model);
                            map.put(StrKit.firstCharToLowerCase(attrName), value);
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage(), e);
                        }
                    }
                }
            } else {
                int indexOfIs = methodName.indexOf("is");
                if (indexOfIs == 0 && methodName.length() > 2) {
                    String attrName = methodName.substring(2);
                    Class<?>[] types = m.getParameterTypes();
                    if (types.length == 0) {
                        try {
                            Object value = m.invoke(model);
                            map.put(StrKit.firstCharToLowerCase(attrName), value);
                        } catch (Exception e) {
                            throw new RuntimeException(e.getMessage(), e);
                        }
                    }
                }
            }
        }
        return mapToJson(map, depth);
    }

    public static Map jsonToMap(String json) {
        if (json == null) {
            return null;
        }
        json = json.trim();
        Map<String, Object> map = new HashMap<>(16);
        if (json.startsWith("{") && json.endsWith("}")) {
            return parseValue(json);

        } else if (json.startsWith("[") && json.endsWith("]")) {
            throw new IllegalStateException("格式错误，请执行json数组转换");
        }
        return map;
    }

    public static List<Map> jsonToList(String json) {
        if (json == null) {
            return null;
        }
        json = json.trim();
        if (json.startsWith("{") && json.endsWith("}")) {

            throw new IllegalStateException("格式错误，请执行json数组转换");
        } else if (json.startsWith("[") && json.endsWith("]")) {
            return parseValue(json);
        }
        return null;
    }

    private static <T> T parseValue(Object obj) {
        if (!(obj instanceof String)) {
            return (T) obj;
        }
        String json = (String) obj;

        if (json.startsWith("{") && json.endsWith("}")) {
            Map<String, Object> map = new HashMap<>(16);
            json = json.substring(1, json.length() - 1);

            int jsonLen = json.length(), rankIdx = -1, preIdx = 0, closeFlag = 0;//标签结束标记
            if (jsonLen == 0) {
                return (T) map;
            }

            String key = "", value;
            while (rankIdx < jsonLen - 1) {
                rankIdx++;
                char rankChar = json.charAt(rankIdx);
                if (rankChar == '{' || rankChar == '[') {
                    closeFlag++;
                    continue;
                }
                if (rankChar == '}' || rankChar == ']') {
                    closeFlag--;
                    continue;
                }
                //key
                if (rankChar == ':' && closeFlag == 0) {
                    key = json.substring(preIdx, rankIdx).trim();
                    preIdx = rankIdx + 1;
                    continue;
                }
                //value
                if (rankChar == ',' && closeFlag == 0) {
                    value = json.substring(preIdx, rankIdx).trim();
                    map.put(handleKey(key), parseValue(handleValue(value)));
                    preIdx = rankIdx + 1;
                }
            }

            value = json.substring(preIdx).trim();
            map.put(handleKey(key), parseValue(value));

            return (T) map;
        } else if (json.startsWith("[") && json.endsWith("]")) {
            json = json.substring(1, json.length() - 1);
            int jsonLen = json.length();
            List<Map> list = new ArrayList<Map>();
            int rankIdx = 0, preIdx = 0;
            while (rankIdx < jsonLen) {
                char rankChar = json.charAt(rankIdx);
                if (rankChar == '}') {
                    list.add(parseValue(json.substring(preIdx, rankIdx + 1)));
                    preIdx = rankIdx + 1;
                    while (preIdx < jsonLen && json.charAt(preIdx) != ',') {
                        preIdx++;
                    }
                    if (preIdx < jsonLen) {
                        preIdx++;
                    }
                }
                rankIdx++;
            }
            return (T) list;
        } else {
            json = handleKey(json);
            if (json == null) {
                return null;
            }
            try {
                Integer intVal = Integer.parseInt(json);
                return (T) intVal;
            } catch (NumberFormatException e) {
            }
            try {
                Float floatVal = Float.parseFloat(json);
                if (json.equals(String.valueOf(floatVal))) {
                    return (T) floatVal;
                } else {
                    Double doubleVal = Double.parseDouble(json);
                    return (T) doubleVal;
                }
            } catch (NumberFormatException e) {
            }
            return (T) json;
        }
    }

    /**
     * 处理key
     *
     * @param key
     * @return
     */
    private static String handleKey(String key) {
        if (key == null || "".equals(key.trim())) {
            return null;
        }
        if (key.startsWith("\"") && key.endsWith("\"") && key.length() > 2) {
            key = key.substring(1, key.length() - 1);
        }
        return key;
    }

    /**
     * 处理值
     *
     * @param value
     * @return
     */
    private static Object handleValue(String value) {
        if (value == null || "".equals(value.trim())) {
            return null;
        }
        if (value.startsWith("\"") && value.endsWith("\"") && value.length() > 2) {
            value = value.substring(1, value.length() - 1);
        }
        try {
            Integer intVal = Integer.parseInt(value);
            return intVal;
        } catch (NumberFormatException e) {
        }
        return value;
    }

    public static void main(String[] args) {
        Map map = new HashMap(16);
//		map.put("sdf", "1");
//		map.put("sd2f", "a");
        System.out.println(JsonKit.toJson(map));
        System.out.println(JsonKit.jsonToMap(JsonKit.toJson(map)));
        System.out.println(JsonKit.toJson(JsonKit.jsonToMap(JsonKit.toJson(map))));
        System.out.println((char) ('^' + 1));
        String jsonStr = "{\"outputStream\":\"{\"statusCode\":\"200\",\"totalCount\":4270,\"pageNo\":1,\"pageSize\":10,\"bodyData\":[{\"birthday\":\"\",\"createTim\":\"|5102\"}]}\"}";
        System.out.println(JsonKit.jsonToMap(jsonStr).get("outputStream"));
        System.out.println(JsonKit.jsonToMap(jsonStr).get("outputStream").getClass());
    }
}
