package com.seventeenkouer.common.dto;

import com.seventeenkouer.common.mapper.BeanMapper;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;


/**
 * 通用dto对象，有公共的toString,equals,hashCode等方法
 * Created by kaiqiang.wu on 2015/12/9.
 */
public class BaseDto implements java.io.Serializable {

    public static Integer userLoginMinTime=50;
    public static Integer userLoginDateTime=7;
    protected Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * serialVersionUID
     */
    protected static final long serialVersionUID = -3402487359191190114L;


    protected String userId;//用户Id


    protected String userName;//用户名称

    protected String userImg;//用户头像

    protected String deviceId;// 设备ID
    protected String timestamp;//

    protected String currentPage = "1";// 当前页 从1开始 默认1

    protected String pageSize = "20";// 默认20

    protected String isGetTotalPage;//是否查总页数  1是0或者空否

    protected String city;// 传入中文或者key值，

    protected Long curVersion;//当前调用接口版本号,已废除，手机端记录的版本都是String类型的

    protected String  versionNum;//当前手机版本号，只有数字和小数点，不可传其他，只有手机端才需要传入；比如：4.0.2

    protected String sid; // sessionid

    protected String companyId;//公司ID

    protected String companyName;//公司名

    private String companyImg;//公司logo

    private String deptId;//部门ID

    private String deptName;//部门名称

    private String dutyId;//岗位ID

    private String dutyName;//岗位名称

    private String projectId;//项目id

    private String groupId;//圈子id

    protected String keyWord;//用于搜索传入名称

    protected String mobile;//手机号码，请求传入用

    protected String rtnMsg;//返回成功提示，用于返回成功有不同提示信息时

    //判断是否是后台管理调用
    private Integer consoleFlag; //0前台传 1后台管理传


    private String triggerCompanyId;//触发公司ID，例如 公司A发文流程触发了公司B的收文流程，则表示A公司Id

    private String reqCompanyId;//请求公司id

    private String reqDutyId;//请求岗位id

    private String reqDeptId;//请求 部门id

    private String reqUserId;//请求用户id

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getCurVersion() {
        return curVersion;
    }

    public void setCurVersion(Long curVersion) {
        this.curVersion = curVersion;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDutyId() {
        return dutyId;
    }

    public void setDutyId(String dutyId) {
        this.dutyId = dutyId;
    }

    public String getDutyName() {
        return dutyName;
    }

    public void setDutyName(String dutyName) {
        this.dutyName = dutyName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getIsGetTotalPage() {
        return isGetTotalPage;
    }

    public void setIsGetTotalPage(String isGetTotalPage) {
        this.isGetTotalPage = isGetTotalPage;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public Integer getConsoleFlag() {
        return consoleFlag;
    }

    public void setConsoleFlag(Integer consoleFlag) {
        this.consoleFlag = consoleFlag;
    }


    public String getTriggerCompanyId() {
        return triggerCompanyId;
    }

    public void setTriggerCompanyId(String triggerCompanyId) {
        this.triggerCompanyId = triggerCompanyId;
    }

    public String getCompanyImg() {
        return companyImg;
    }

    public void setCompanyImg(String companyImg) {
        this.companyImg = companyImg;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getReqCompanyId() {
        return reqCompanyId;
    }

    public void setReqCompanyId(String reqCompanyId) {
        this.reqCompanyId = reqCompanyId;
    }

    public String getReqDutyId() {
        return reqDutyId;
    }

    public void setReqDutyId(String reqDutyId) {
        this.reqDutyId = reqDutyId;
    }

    public String getReqUserId() {
        return reqUserId;
    }

    public void setReqUserId(String reqUserId) {
        this.reqUserId = reqUserId;
    }

    public String getReqDeptId() {
        return reqDeptId;
    }

    public void setReqDeptId(String reqDeptId) {
        this.reqDeptId = reqDeptId;
    }

    protected <T> T toDBEntity(Class<T> clazz) {
        return BeanMapper.map(this,clazz);
    }

    protected <T> List<T> toDBEntityList(Collection list,Class<T> clazz) {
        return BeanMapper.mapList(list,clazz);
    }
}
