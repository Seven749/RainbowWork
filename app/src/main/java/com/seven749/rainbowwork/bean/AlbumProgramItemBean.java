package com.seven749.rainbowwork.bean;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class AlbumProgramItemBean {
    private String id;
    private String name;
    private String picUrl;

    public AlbumProgramItemBean(String id, String name, String picUrl) {
        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicUrl() {
        return picUrl;
    }
}
