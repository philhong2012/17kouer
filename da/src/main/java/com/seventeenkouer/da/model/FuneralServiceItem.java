package com.seventeenkouer.da.model;

import java.math.BigDecimal;

public class FuneralServiceItem {
    /**
     * 
     */
    private String serviceItemId;

    /**
     * 订单详情Id
     */
    private String orderDetailId;

    /**
     * 订单Id
     */
    private String orderId;

    /**
     * 公司id
     */
    private String companyId;

    /**
     * 
     */
    private String serviceId;

    /**
     * 
     */
    private String itemId;

    /**
     * 1：场地、2：物资、3：车辆、4：骨灰格等
     */
    private String itemType;

    /**
     * 服务项名称
     */
    private String itemName;

    /**
     * 服务项主图片
     */
    private String itemMainPic;

    /**
     * 价格
     */
    private BigDecimal itemPrice;

    /**
     * 价格单位
     */
    private String priceUnit;

    /**
     * 数量
     */
    private Integer amount;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 创建者
     */
    private String createUserId;

    /**
     * 更新者
     */
    private String updateUserId;

    /**
     * 删除标志
     */
    private Integer delFlag;

    /**
     * 总价 (界面可以修改)
     */
    private BigDecimal totalPrice;

    /**
     * 
     * @return serviceItemId 
     */
    public String getServiceItemId() {
        return serviceItemId;
    }

    /**
     * 
     * @param serviceItemId 
     */
    public void setServiceItemId(String serviceItemId) {
        this.serviceItemId = serviceItemId == null ? null : serviceItemId.trim();
    }

    /**
     * 订单详情Id
     * @return orderDetailId 订单详情Id
     */
    public String getOrderDetailId() {
        return orderDetailId;
    }

    /**
     * 订单详情Id
     * @param orderDetailId 订单详情Id
     */
    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId == null ? null : orderDetailId.trim();
    }

    /**
     * 订单Id
     * @return orderId 订单Id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单Id
     * @param orderId 订单Id
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /**
     * 公司id
     * @return companyId 公司id
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * 公司id
     * @param companyId 公司id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /**
     * 
     * @return serviceId 
     */
    public String getServiceId() {
        return serviceId;
    }

    /**
     * 
     * @param serviceId 
     */
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    /**
     * 
     * @return itemId 
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 
     * @param itemId 
     */
    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    /**
     * 1：场地、2：物资、3：车辆、4：骨灰格等
     * @return itemType 1：场地、2：物资、3：车辆、4：骨灰格等
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * 1：场地、2：物资、3：车辆、4：骨灰格等
     * @param itemType 1：场地、2：物资、3：车辆、4：骨灰格等
     */
    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    /**
     * 服务项名称
     * @return itemName 服务项名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 服务项名称
     * @param itemName 服务项名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * 服务项主图片
     * @return itemMainPic 服务项主图片
     */
    public String getItemMainPic() {
        return itemMainPic;
    }

    /**
     * 服务项主图片
     * @param itemMainPic 服务项主图片
     */
    public void setItemMainPic(String itemMainPic) {
        this.itemMainPic = itemMainPic == null ? null : itemMainPic.trim();
    }

    /**
     * 价格
     * @return itemPrice 价格
     */
    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    /**
     * 价格
     * @param itemPrice 价格
     */
    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * 价格单位
     * @return priceUnit 价格单位
     */
    public String getPriceUnit() {
        return priceUnit;
    }

    /**
     * 价格单位
     * @param priceUnit 价格单位
     */
    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit == null ? null : priceUnit.trim();
    }

    /**
     * 数量
     * @return amount 数量
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * 数量
     * @param amount 数量
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * 创建时间
     * @return createTime 创建时间
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
     * 更新时间
     * @return updateTime 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建者
     * @return createUserId 创建者
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * 创建者
     * @param createUserId 创建者
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * 更新者
     * @return updateUserId 更新者
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 更新者
     * @param updateUserId 更新者
     */
    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId == null ? null : updateUserId.trim();
    }

    /**
     * 删除标志
     * @return delFlag 删除标志
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标志
     * @param delFlag 删除标志
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 总价 (界面可以修改)
     * @return totalPrice 总价 (界面可以修改)
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * 总价 (界面可以修改)
     * @param totalPrice 总价 (界面可以修改)
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}