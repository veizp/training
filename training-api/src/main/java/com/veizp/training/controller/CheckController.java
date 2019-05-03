package com.veizp.training.controller;

import com.veizp.training.dao.CheckDao;
import com.veizp.training.vo.HealthCheckVO;
import com.veizp.training.vo.common.IResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author weizhipeng
 */
@Controller
@RequestMapping("/check")
public class CheckController extends BaseController {

    @Autowired
    private CheckDao checkDao;

    @RequestMapping(value = "/health")
    @ResponseBody
    public IResult<HealthCheckVO> healthCheck() {
        int result = checkDao.checkDB();
        return IResult.buildOK(HealthCheckVO.newBuilder().system(true).db(1 == result).build());
    }

    @RequestMapping(value = "/proxy")
    @ResponseBody
    public IResult<HealthCheckVO> proxyCheck() {
        return IResult.buildOK(HealthCheckVO.newBuilder().system(true).build());
    }

}
