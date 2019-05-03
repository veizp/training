package com.veizp.training.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weizhipeng
 */
public class JsonUtil {
    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public static String toJson(Object obj) {
        try {
            if (obj == null) {
                return null;
            }
            if (obj instanceof String) {
                return obj.toString();
            } else if (obj instanceof JsonElement) {
                return obj.toString();
            } else {
                return new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT | Modifier.STATIC).create()
                        .toJson(obj);
            }
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    public static String toJson(Object obj, Type type) {
        try {
            if (obj == null) {
                return null;
            }
            if (obj instanceof String) {
                return obj.toString();
            } else if (obj instanceof JsonElement) {
                return obj.toString();
            } else {
                return new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT | Modifier.STATIC).create()
                        .toJson(obj, type);
            }
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    public static void writeJson(Object obj, Type type, Appendable writer) {
        try {
            if (obj != null) {
                if (type != null) {
                    new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT | Modifier.STATIC).create()
                            .toJson(obj, type, writer);
                } else {
                    new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT | Modifier.STATIC).create()
                            .toJson(obj, writer);
                }
            }
        } catch (Exception e) {
            logger.error(null, e);
        }
    }

    public static <T> T toObj(String jsonStr, Class<T> t) {
        if (jsonStr == null) {
            return null;
        }
        try {
            return new Gson().fromJson(jsonStr, t);
        } catch (Exception e) {
            logger.error(jsonStr, e);
        }
        return null;
    }

    public static <T> T toObj(String jsonStr, Type type) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            return new Gson().fromJson(jsonStr, type);
        } catch (Exception e) {
            logger.error(jsonStr, e);
        }
        return null;
    }

    public static JsonObject toJsonObj(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            return new JsonParser().parse(jsonStr).getAsJsonObject();
        } catch (Exception e) {
            logger.error(jsonStr, e);
        }
        return null;
    }

    public static JsonArray toJsonArr(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        try {
            return new JsonParser().parse(jsonStr).getAsJsonArray();
        } catch (Exception e) {
            logger.error(jsonStr, e);
        }
        return null;
    }

    public static String jsonGetStr(JsonObject jObj, String key) {
        try {
            JsonElement targetEl = jObj != null ? jObj.get(key) : null;
            return targetEl != null ? targetEl.getAsString() : null;
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    /**
     * @param jObj
     * @param key
     * @param cls  String/Integer/Long/Float/Double
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> jsonGetList(JsonObject jObj, String key, Class<T> cls) {
        try {
            JsonArray array = jObj.getAsJsonArray(key);
            if (array == null) {
                return null;
            }
            List<T> list = new ArrayList<T>();
            if (cls == String.class) {
                for (JsonElement ele : array) {
                    list.add((T) ele.getAsString());
                }
            } else if (cls == Integer.class) {
                for (JsonElement ele : array) {
                    list.add((T) new Integer(ele.getAsInt()));
                }
            } else if (cls == Long.class) {
                for (JsonElement ele : array) {
                    list.add((T) new Long(ele.getAsLong()));
                }
            } else if (cls == Float.class) {
                for (JsonElement ele : array) {
                    list.add((T) new Float(ele.getAsFloat()));
                }
            } else if (cls == Double.class) {
                for (JsonElement ele : array) {
                    list.add((T) new Double(ele.getAsDouble()));
                }
            } else {
                return null;
            }
            return list;
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    /**
     * @param jObj
     * @param key
     * @param cls  String/Integer/Long/Float/Double
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] jsonGetArray(JsonObject jObj, String key, Class<T> cls) {
        try {
            JsonArray array = jObj.getAsJsonArray(key);
            if (array == null) {
                return null;
            }
            T[] tArray = (T[]) Array.newInstance(cls, array.size());
            if (cls == String.class) {
                for (int i = 0; i < tArray.length; i++) {
                    tArray[i] = (T) array.get(i).getAsString();
                }
            } else if (cls == Integer.class) {
                for (int i = 0; i < tArray.length; i++) {
                    tArray[i] = (T) new Integer(array.get(i).getAsInt());
                }
            } else if (cls == Long.class) {
                for (int i = 0; i < tArray.length; i++) {
                    tArray[i] = (T) new Long(array.get(i).getAsLong());
                }
            } else if (cls == Float.class) {
                for (int i = 0; i < tArray.length; i++) {
                    tArray[i] = (T) new Float(array.get(i).getAsFloat());
                }
            } else if (cls == Double.class) {
                for (int i = 0; i < tArray.length; i++) {
                    tArray[i] = (T) new Double(array.get(i).getAsDouble());
                }
            } else {
                return null;
            }
            return tArray;
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    public static Integer jsonGetInt(JsonObject jObj, String key) {
        try {
            JsonElement targetEl = jObj != null ? jObj.get(key) : null;
            return targetEl != null ? targetEl.getAsInt() : null;
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    public static Long jsonGetLong(JsonObject jObj, String key) {
        try {
            JsonElement targetEl = jObj != null ? jObj.get(key) : null;
            return targetEl != null ? targetEl.getAsLong() : null;
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    public static Float jsonGetFloat(JsonObject jObj, String key) {
        try {
            JsonElement targetEl = jObj != null ? jObj.get(key) : null;
            return targetEl != null ? targetEl.getAsFloat() : null;
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    public static Double jsonGetDouble(JsonObject jObj, String key) {
        try {
            JsonElement targetEl = jObj != null ? jObj.get(key) : null;
            return targetEl != null ? targetEl.getAsDouble() : null;
        } catch (Exception e) {
            logger.error(null, e);
        }
        return null;
    }

    public static <T> Type getType() {
        return new TypeToken<T>() {
        }.getType();
    }

}
