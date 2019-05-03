package com.veizp.training.controller;

import com.veizp.training.util.HttpReqUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author weizhipeng
 */
public class BaseController {

    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    protected String parse2Str(HttpServletRequest request, String name, String defaultVal) {
        return HttpReqUtils.parse2Str(request, name, defaultVal);
    }

    protected int parse2Int(HttpServletRequest request, String name, int defaultVal) {
        return HttpReqUtils.parse2Int(request, name, defaultVal);
    }

    protected long parse2Long(HttpServletRequest request, String name, long defaultVal) {
        return HttpReqUtils.parse2Long(request, name, defaultVal);
    }

    protected float parse2Float(HttpServletRequest request, String name, float defaultVal) {
        return HttpReqUtils.parse2Float(request, name, defaultVal);
    }

    protected double parse2Double(HttpServletRequest request, String name, double defaultVal) {
        return HttpReqUtils.parse2Double(request, name, defaultVal);
    }

}
