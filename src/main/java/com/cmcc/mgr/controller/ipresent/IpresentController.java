package com.cmcc.mgr.controller.ipresent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cmcc.mgr.annotation.Cmodel;
import com.cmcc.mgr.controller.model.BaseOutputModel;
import com.cmcc.mgr.controller.model.ipresent.PresentInputMoneyModel;
import com.cmcc.mgr.dao.AcComcontractInfoMapper;
import com.cmcc.mgr.util.HttpUtil;


@RestController
public class IpresentController {
    @Autowired
    private AcComcontractInfoMapper acComcontractInfoMapper;
    
    
    
    @RequestMapping(value="/MiGuMgr/rs/service/com_sitech_acctmgr_inter_IPresentIssSvc_cfm")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) 
    @ResponseBody
    public String PresentMoney(@Cmodel  @Validated PresentInputMoneyModel presentMoneyInputModel/*,BindingResult result*/) throws Exception {
        return  String.valueOf(acComcontractInfoMapper.select1());
    }
    
    @RequestMapping(value="/MiGuMgr/rs/service/com_sitech_acctmgr_inter_IPresentIssSvc3_cfm")
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED) 
    @ResponseBody
    public String PresentMoney1(@Cmodel  @Validated PresentInputMoneyModel presentMoneyInputModel/*,BindingResult result*/) throws Exception {
        return  HttpUtil.synSend("http://www.baidu.com", new HashMap<String,String>(), "");
    }
    
    private Logger logger = LoggerFactory.getLogger(IpresentController.class);
}
