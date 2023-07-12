package com.yedhu.JobPortalApplication.entity;


import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "JobPost")
public class JobPost {

    private String profile;
    private int exp;
    private String desc;
    private String techs[];

    public JobPost(String profile, int exp, String desc, String[] techs) {
        this.profile = profile;
        this.exp = exp;
        this.desc = desc;
        this.techs = techs;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "JobPost{" +
                "profile='" + profile + '\'' +
                ", exp=" + exp +
                ", desc='" + desc + '\'' +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
