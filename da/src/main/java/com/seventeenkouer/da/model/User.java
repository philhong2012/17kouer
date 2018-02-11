package com.seventeenkouer.da.model;

public class User {
    /**
     * id
     */
    private String id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 创建人
     */
    private String createId;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改人
     */
    private String updateId;

    /**
     * 修改时间
     */
    private Long updateTime;

    /**
     * 删除标志: 1 删除 0 （默认）未删除
     */
    private Byte delFlag;

    /**
     * id
     * @return id id
     */
    public String getId() {
        return id;
    }

    /**
     * id
     * @param id id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 用户名
     * @return name 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 用户名
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 登录名
     * @return login_name 登录名
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 登录名
     * @param loginName 登录名
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 创建人
     * @return create_id 创建人
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * 创建人
     * @param createId 创建人
     */
    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改人
     * @return update_id 修改人
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * 修改人
     * @param updateId 修改人
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 删除标志: 1 删除 0 （默认）未删除
     * @return del_flag 删除标志: 1 删除 0 （默认）未删除
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标志: 1 删除 0 （默认）未删除
     * @param delFlag 删除标志: 1 删除 0 （默认）未删除
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }
}