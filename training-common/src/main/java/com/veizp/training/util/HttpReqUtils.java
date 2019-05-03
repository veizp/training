package com.veizp.training.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;

/**
 * @author weizhipeng
 */
public class HttpReqUtils {

    private static final Logger logger = LoggerFactory.getLogger(HttpReqUtils.class);

    public static String parse(HttpServletRequest request, String name) {
        return request.getParameter(name);
    }

    public static String parse2Str(HttpServletRequest request, String name, String defaultVal) {
        String value = request.getParameter(name);
        if (StringUtils.isBlank(value)) {
            value = defaultVal;
        }
        return value;
    }

    public static int parse2Int(HttpServletRequest request, String name, int defaultVal) {
        String value = request.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                logger.error("", e);
            }
        }
        return defaultVal;
    }

    public static long parse2Long(HttpServletRequest request, String name, long defaultVal) {
        String value = request.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException e) {
                logger.error("", e);
            }
        }
        return defaultVal;
    }

    public static float parse2Float(HttpServletRequest request, String name, float defaultVal) {
        String value = request.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException e) {
                logger.error("", e);
            }
        }
        return defaultVal;
    }

    public static double parse2Double(HttpServletRequest request, String name, double defaultVal) {
        String value = request.getParameter(name);
        if (StringUtils.isNotBlank(value)) {
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                logger.error("", e);
            }
        }
        return defaultVal;
    }

    protected static <T> T parse2Obj(HttpServletRequest request, String name, Class<T> cls) {
        String value = request.getParameter(name);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return JsonUtil.toObj(value, cls);
    }

    protected static <T> T parse2Obj(HttpServletRequest request, String name, Type cls) {
        String value = request.getParameter(name);
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return JsonUtil.toObj(value, cls);
    }

}
