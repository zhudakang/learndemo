package com.dk.learndemo.java8;

import lombok.Data;

/**
 * @Author : zhudakang
 * @Description : God
 * @Date : 2019/6/14
 */
@Data
public class God {
    private String godnessName;

    public God(String godnessName) {
        this.godnessName = godnessName;
    }
}
