package com.veizp.training.dao;

import com.veizp.training.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author weizhipeng
 * @Date: 2019/5/3 17:51
 */
public class CheckDaoTest extends BaseTest {

    @Autowired
    private CheckDao checkDao;

    @Test
    public void test() {
        print(checkDao.checkDB());
    }
}
