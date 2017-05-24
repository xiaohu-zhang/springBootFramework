package com.cmcc.mgr.controller.model.ipresent;

import java.util.Date;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import com.cmcc.mgr.annotation.JsonTimeDeserializer;
import com.cmcc.mgr.annotation.TimePattern;
import com.fasterxml.jackson.annotation.JsonFormat;

@Component
public class PresentInputMoneyModel {
    @NotBlank
    @Size(max=10)
    @Pattern(regexp="^\\d*$")
    private String companyId;
    @NotBlank
    @Pattern(regexp="^[1-9]\\d{0,13}$")
    private String migusum;
    
    private Date effectiveTimeBegin;

    private Date effectiveTimeEnd;
    
    @NotBlank
    private String activityCode;
    
    
    
   
    public String getCompanyId() {
        return companyId;
    }
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
    public String getMigusum() {
        return migusum;
    }
    public void setMigusum(String migusum) {
        this.migusum = migusum;
    }

    public Date getEffectiveTimeBegin() {
        return effectiveTimeBegin;
    }
    @JsonTimeDeserializer(pattern="yyyyMMdd")
    public void setEffectiveTimeBegin(Date effectiveTimeBegin) {
        this.effectiveTimeBegin = effectiveTimeBegin;
    }
   
    public Date getEffectiveTimeEnd() {
        return effectiveTimeEnd;
    }
    @JsonTimeDeserializer(pattern="yyyyMMdd")
    public void setEffectiveTimeEnd(Date effectiveTimeEnd) {
        this.effectiveTimeEnd = effectiveTimeEnd;
    }
    public String getActivityCode() {
        return activityCode;
    }
    public void setActivityCode(String activityCode) {
        this.activityCode = activityCode;
    }
    
    
}
