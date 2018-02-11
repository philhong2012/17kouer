package com.seventeenkouer.facade.dto;

/**
 * ${DESCRIPTION}
 *
 * @author hongxubing
 * @create 2018-02-11 15:35
 **/
public class UserDto {
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
    private String login_name;

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
    private String create_id;

    /**
     * 创建时间
     */
    private Long create_time;

    /**
     * 修改人
     */
    private String update_id;

    /**
     * 修改时间
     */
    private Long update_time;

    /**
     * 删除标志: 1 删除 0 （默认）未删除
     */
    private Byte del_flag;

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
    public String getLogin_name() {
        return login_name;
    }

    /**
     * 登录名
     * @param login_name 登录名
     */
    public void setLogin_name(String login_name) {
        this.login_name = login_name == null ? null : login_name.trim();
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
    public String getCreate_id() {
        return create_id;
    }

    /**
     * 创建人
     * @param create_id 创建人
     */
    public void setCreate_id(String create_id) {
        this.create_id = create_id == null ? null : create_id.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Long getCreate_time() {
        return create_time;
    }

    /**
     * 创建时间
     * @param create_time 创建时间
     */
    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    /**
     * 修改人
     * @return update_id 修改人
     */
    public String getUpdate_id() {
        return update_id;
    }

    /**
     * 修改人
     * @param update_id 修改人
     */
    public void setUpdate_id(String update_id) {
        this.update_id = update_id == null ? null : update_id.trim();
    }

    /**
     * 修改时间
     * @return update_time 修改时间
     */
    public Long getUpdate_time() {
        return update_time;
    }

    /**
     * 修改时间
     * @param update_time 修改时间
     */
    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    /**
     * 删除标志: 1 删除 0 （默认）未删除
     * @return del_flag 删除标志: 1 删除 0 （默认）未删除
     */
    public Byte getDel_flag() {
        return del_flag;
    }

    /**
     * 删除标志: 1 删除 0 （默认）未删除
     * @param del_flag 删除标志: 1 删除 0 （默认）未删除
     */
    public void setDel_flag(Byte del_flag) {
        this.del_flag = del_flag;
    }
}
