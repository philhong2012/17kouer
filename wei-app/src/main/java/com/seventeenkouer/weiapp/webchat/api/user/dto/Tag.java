package com.seventeenkouer.weiapp.webchat.api.user.dto;


/**
 * Created by wind on 17/4/14.
 */
public class Tag {
    /**
     * tag名称
     */
    private String name;
    /**
     * tag Id
     */
    private String id;
    /**
     * tag下的粉丝数
     */
    private Integer count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
