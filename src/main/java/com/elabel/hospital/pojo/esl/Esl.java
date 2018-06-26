package com.elabel.hospital.pojo.esl;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Timestamp;

public class Esl {
    public Integer hospitalId;
    public Integer batInfo;
    public Integer batPercent;
    public Integer apRssi;
    public Integer eslRssi;
    public Integer aToken;
    public Integer loginCount;
    public Integer updateCount;
    public Integer channel;
    public Integer channelB;
    public String barcode;
    public Integer sysMapId;
    public Integer eslMapId;
    public Integer price;
    public Integer newPrice;
    public Integer cmd;
    public Integer updateState;

    @JSONField(name = "goodsBarcode")
    public String patientId;
    public String tinyIp;
    public String tagType;
    public String tagVer;
    public String patternId;
    public Boolean stopped;
    public Timestamp batch;
    public Timestamp loginTime;
    public Timestamp updateTime;
    public Timestamp updatedTime;
    public Timestamp cloudUpdateTime;


    @Override
    public String toString() {
        return "Esl{" +
                "hospitalId=" + hospitalId +
                ", batInfo=" + batInfo +
                ", batPercent=" + batPercent +
                ", apRssi=" + apRssi +
                ", eslRssi=" + eslRssi +
                ", aToken=" + aToken +
                ", loginCount=" + loginCount +
                ", updateCount=" + updateCount +
                ", channel=" + channel +
                ", channelB=" + channelB +
                ", code=" + barcode +
                ", sysMapId=" + sysMapId +
                ", eslMapId=" + eslMapId +
                ", price=" + price +
                ", newPrice=" + newPrice +
                ", cmd=" + cmd +
                ", updateState=" + updateState +
                ", patientId=" + patientId +
                ", tinyIp='" + tinyIp + '\'' +
                ", tagType='" + tagType + '\'' +
                ", tagVer='" + tagVer + '\'' +
                ", patternId='" + patternId + '\'' +
                ", stopped=" + stopped +
                ", batch=" + batch +
                ", loginTime=" + loginTime +
                ", updateTime=" + updateTime +
                ", updatedTime=" + updatedTime +
                ", cloudUpdateTime=" + cloudUpdateTime +
                '}';
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getBatInfo() {
        return batInfo;
    }

    public void setBatInfo(Integer batInfo) {
        this.batInfo = batInfo;
    }

    public Integer getBatPercent() {
        return batPercent;
    }

    public void setBatPercent(Integer batPercent) {
        this.batPercent = batPercent;
    }

    public Integer getApRssi() {
        return apRssi;
    }

    public void setApRssi(Integer apRssi) {
        this.apRssi = apRssi;
    }

    public Integer getEslRssi() {
        return eslRssi;
    }

    public void setEslRssi(Integer eslRssi) {
        this.eslRssi = eslRssi;
    }

    public Integer getaToken() {
        return aToken;
    }

    public void setaToken(Integer aToken) {
        this.aToken = aToken;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(Integer updateCount) {
        this.updateCount = updateCount;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getChannelB() {
        return channelB;
    }

    public void setChannelB(Integer channelB) {
        this.channelB = channelB;
    }

    public Integer getSysMapId() {
        return sysMapId;
    }

    public void setSysMapId(Integer sysMapId) {
        this.sysMapId = sysMapId;
    }

    public Integer getEslMapId() {
        return eslMapId;
    }

    public void setEslMapId(Integer eslMapId) {
        this.eslMapId = eslMapId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public Integer getCmd() {
        return cmd;
    }

    public void setCmd(Integer cmd) {
        this.cmd = cmd;
    }

    public Integer getUpdateState() {
        return updateState;
    }

    public void setUpdateState(Integer updateState) {
        this.updateState = updateState;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getTinyIp() {
        return tinyIp;
    }

    public void setTinyIp(String tinyIp) {
        this.tinyIp = tinyIp;
    }

    public String getTagType() {
        return tagType;
    }

    public void setTagType(String tagType) {
        this.tagType = tagType;
    }

    public String getTagVer() {
        return tagVer;
    }

    public void setTagVer(String tagVer) {
        this.tagVer = tagVer;
    }

    public String getPatternId() {
        return patternId;
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public Boolean getStopped() {
        return stopped;
    }

    public void setStopped(Boolean stopped) {
        this.stopped = stopped;
    }

    public Timestamp getBatch() {
        return batch;
    }

    public void setBatch(Timestamp batch) {
        this.batch = batch;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Timestamp getCloudUpdateTime() {
        return cloudUpdateTime;
    }

    public void setCloudUpdateTime(Timestamp cloudUpdateTime) {
        this.cloudUpdateTime = cloudUpdateTime;
    }
}
