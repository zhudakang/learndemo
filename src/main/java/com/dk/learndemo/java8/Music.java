package com.dk.learndemo.java8;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Author : zhudakang
 * @Description : Fruit
 * @Date : 2019/6/13
 */
@Data
public class Music {
    private int type;
    private String name;
    private String releaseDate;

    public Music(int type, String name, String releaseDate) {
        this.type = type;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
