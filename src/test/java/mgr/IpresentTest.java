package mgr;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Matchers.anyObject;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.cmcc.mgr.Application;
import com.cmcc.mgr.dao.AcComcontractInfoMapper;
import com.cmcc.mgr.dao.AcComcontractInfoTestMapper;
import com.cmcc.mgr.util.HttpUtil;


@PrepareForTest(HttpUtil.class)
@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value=SpringRunner.class)
@SpringBootTest(classes={Application.class})
@PowerMockIgnore("javax.net.ssl.*")
@Rollback
@Transactional
@AutoConfigureMockMvc
public class IpresentTest {

    @Autowired
    private MockMvc mvc; 
    
    @Autowired
    private AcComcontractInfoTestMapper acComcontractInfoTestMapper;
    
    
 // 执行测试方法之前初始化模拟request,response  
    @Before    
    public void setUp(){     
    } 
    
    @Test  
    @Sql({"clean-up.sql"})
    public void testPresentMoney() throws Exception {   
        String content = "{\"companyId\": \"2\",\"migusum\":\"223\",\"effectiveTimeBegin\":\"20151221\",\"effectiveTimeEnd\":\"20141211\",\"activityCode\":\"001\"}";
            this.mvc.perform(post("/MiGuMgr/rs/service/com_sitech_acctmgr_inter_IPresentIssSvc_cfm?tracelog=12345")
                    .contentType(MediaType.APPLICATION_JSON_UTF8).content(content).accept(MediaType.APPLICATION_JSON_UTF8))
            .andExpect((jsonPath("$.ROOT.BODY.OUT_DATA", is("10"))));
        acComcontractInfoTestMapper.select();
    } 
    
    @Test  
    public void testPresentMoney1() throws Exception {   
        PowerMockito.mockStatic(HttpUtil.class);
        String content = "{\"companyId\": \"2\",\"migusum\":\"223\",\"effectiveTimeBegin\":\"20151221\",\"effectiveTimeEnd\":\"20141211\",\"activityCode\":\"001\"}";
        PowerMockito.when(HttpUtil.class, "synSend",anyObject(),anyObject(),anyObject()).thenReturn("10");
            this.mvc.perform(post("/MiGuMgr/rs/service/com_sitech_acctmgr_inter_IPresentIssSvc3_cfm?tracelog=12345")
                    .contentType(MediaType.APPLICATION_JSON_UTF8).content(content).accept(MediaType.APPLICATION_JSON_UTF8))
            .andExpect((jsonPath("$.ROOT.BODY.OUT_DATA", is("20"))));
    }
    
}
