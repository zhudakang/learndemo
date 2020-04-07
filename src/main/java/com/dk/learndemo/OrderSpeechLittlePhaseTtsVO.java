package com.dk.learndemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author :zhudakang
 * @description : OrderSpeechLittlePhaseTtsVO
 * @create : 2020/04/07
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSpeechLittlePhaseTtsVO {
    private long oslpId;
    private String ttsContent;
    private String ttsContentMd5;
    private String productCode;
    private int insureSelf;

    public OrderSpeechLittlePhaseTtsVO(String productCode) {
        this.productCode = productCode;
    }
}
