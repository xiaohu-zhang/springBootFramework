package com.cmcc.mgr.controller.model;

import java.io.Serializable;

import org.apache.ibatis.reflection.SystemMetaObject;

import com.cmcc.mgr.annotation.JsonTimeDeserializer;
import com.cmcc.mgr.annotation.JsonTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author silver
 *
 */
@SuppressWarnings("unused")
public class BaseOutputModel {
    private String RETURN_CODE;
    private String RETURN_MSG;
    private String USER_MSG;
    private String DETAIL_MSG;
    private String PROMPT_MSG;
    private String RUN_IP;
    private Object OUT_DATA;
    private String TRACEID;

    public static class Builder {
        private String RETURN_CODE = "";
        private String RETURN_MSG = "";
        private String USER_MSG = "";
        private String DETAIL_MSG = "";
        private String PROMPT_MSG = "";
        private String RUN_IP = "";
        private Object OUT_DATA = new NullObject();
        private String TRACEID = "";

        public Builder RETURN_CODE(String val) {
            RETURN_CODE = val;
            return this;
        }

        public Builder RETURN_MSG(String val) {
            RETURN_MSG = val;
            return this;
        }

        public Builder USER_MSG(String val) {
            USER_MSG = val;
            return this;
        }

        public Builder DETAIL_MSG(String val) {
            DETAIL_MSG = val;
            return this;
        }

        public Builder PROMPT_MSG(String val) {
            PROMPT_MSG = val;
            return this;
        }

        public Builder RUN_IP(String val) {
            RUN_IP = val;
            return this;
        }

        public Builder OUT_DATA(Object val) {
            OUT_DATA = val;
            return this;
        }
        
        public Builder TRACEID(String val) {
            TRACEID = val;
            return this;
        }

        public BaseOutputModel build() {
            return new BaseOutputModel(this);
        }
    }
    
    private static class NullObject{
        
    }

    private BaseOutputModel(Builder builder) {
        RETURN_CODE = builder.RETURN_CODE;
        RETURN_MSG = builder.RETURN_MSG;
        USER_MSG = builder.USER_MSG;
        DETAIL_MSG = builder.DETAIL_MSG;
        PROMPT_MSG = builder.PROMPT_MSG;
        RUN_IP = builder.RUN_IP;
        OUT_DATA = builder.OUT_DATA;
        TRACEID = builder.TRACEID;
    }

    @JsonProperty("RETURN_CODE")
    public String getRETURN_CODE() {
        return RETURN_CODE;
    }
    @JsonProperty("RETURN_MSG")
    public String getRETURN_MSG() {
        return RETURN_MSG;
    }

    @JsonProperty("USER_MSG")
    public String getUSER_MSG() {
        return USER_MSG;
    }
    @JsonProperty("DETAIL_MSG")
    public String getDETAIL_MSG() {
        return DETAIL_MSG;
    }
    @JsonProperty("PROMPT_MSG")
    public String getPROMPT_MSG() {
        return PROMPT_MSG;
    }
    @JsonProperty("RUN_IP")
    public String getRUN_IP() {
        return RUN_IP;
    }
    @JsonProperty("OUT_DATA")
    public Object getOUT_DATA() {
        return OUT_DATA;
    }

    public void setRETURN_CODE(String rETURN_CODE) {
        RETURN_CODE = rETURN_CODE;
    }

    public void setRETURN_MSG(String rETURN_MSG) {
        RETURN_MSG = rETURN_MSG;
    }

    public void setUSER_MSG(String uSER_MSG) {
        USER_MSG = uSER_MSG;
    }

    public void setDETAIL_MSG(String dETAIL_MSG) {
        DETAIL_MSG = dETAIL_MSG;
    }

    public void setPROMPT_MSG(String pROMPT_MSG) {
        PROMPT_MSG = pROMPT_MSG;
    }

    public void setRUN_IP(String rUN_IP) {
        RUN_IP = rUN_IP;
    }

    public void setOUT_DATA(Object oUT_DATA) {
        OUT_DATA = oUT_DATA;
    }
    @JsonProperty("TRACEID")
    public String getTRACEID() {
        return TRACEID;
    }

    public void setTRACEID(String tRACEID) {
        TRACEID = tRACEID;
    }

}
