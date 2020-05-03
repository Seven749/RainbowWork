package com.seven749.rainbowwork.bean;

/**
 * @author 行云流水
 * @date 2020/5/3
 * @description
 */
public class AlbumProgramItemBean {
    private String id;
    private String name;

    public AlbumProgramItemBean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
