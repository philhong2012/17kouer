package com.seventeenkouer.da.model;

public class DrugNumb {
    /**
     * null
     */
    private Integer id;

    /**
     * null
     */
    private String drugBcode;

    /**
     * null
     */
    private String provinceName;

    /**
     * null
     */
    private String drugNumb;

    /**
     * null
     * @return id null
     */
    public Integer getId() {
        return id;
    }

    /**
     * null
     * @param id null
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * null
     * @return drug_bcode null
     */
    public String getDrugBcode() {
        return drugBcode;
    }

    /**
     * null
     * @param drugBcode null
     */
    public void setDrugBcode(String drugBcode) {
        this.drugBcode = drugBcode == null ? null : drugBcode.trim();
    }

    /**
     * null
     * @return province_name null
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * null
     * @param provinceName null
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    /**
     * null
     * @return drug_numb null
     */
    public String getDrugNumb() {
        return drugNumb;
    }

    /**
     * null
     * @param drugNumb null
     */
    public void setDrugNumb(String drugNumb) {
        this.drugNumb = drugNumb == null ? null : drugNumb.trim();
    }
}