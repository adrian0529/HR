package com.data.hr.dto;


public class Region {
    private Integer region_id;
    private String region_name;

    public Region(){

    }

    public Region(Integer region_id, String region_name) {
        this.region_id = region_id;
        this.region_name = region_name;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }
}
