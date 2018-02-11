package com.seventeenkouer.da.model;

public class Attachment {
    /**
     * 
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 原名
     */
    private String originalName;

    /**
     * 类型
     */
    private Byte type;

    /**
     * 介绍
     */
    private String description;

    /**
     * 大小
     */
    private Long size;

    /**
     * 1：审核通过 ：0 ：不通过  ，默认不通过
     */
    private Byte approvalStatus;

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
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 原名
     * @return original_name 原名
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * 原名
     * @param originalName 原名
     */
    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
    }

    /**
     * 类型
     * @return type 类型
     */
    public Byte getType() {
        return type;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 介绍
     * @return description 介绍
     */
    public String getDescription() {
        return description;
    }

    /**
     * 介绍
     * @param description 介绍
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 大小
     * @return size 大小
     */
    public Long getSize() {
        return size;
    }

    /**
     * 大小
     * @param size 大小
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 1：审核通过 ：0 ：不通过  ，默认不通过
     * @return approval_status 1：审核通过 ：0 ：不通过  ，默认不通过
     */
    public Byte getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 1：审核通过 ：0 ：不通过  ，默认不通过
     * @param approvalStatus 1：审核通过 ：0 ：不通过  ，默认不通过
     */
    public void setApprovalStatus(Byte approvalStatus) {
        this.approvalStatus = approvalStatus;
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