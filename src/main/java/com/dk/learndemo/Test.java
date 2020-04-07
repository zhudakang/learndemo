package com.dk.learndemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author :zhudakang
 * @description : Test
 * @create : 2020/04/07
 */
public class Test {

    public static void main(String[] args) {
        List<OrderSpeechLittlePhaseTtsVO> phaseList = new ArrayList<>();
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("111"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("111"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("111"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("111"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("111"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("222"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("222"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("222"));
        phaseList.add(new OrderSpeechLittlePhaseTtsVO("333"));
        List<String> productCodeList = phaseList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>
                (Comparator.comparing(OrderSpeechLittlePhaseTtsVO :: getProductCode))), ArrayList::new))
                .stream().map(OrderSpeechLittlePhaseTtsVO::getProductCode).collect(Collectors.toList());

        System.out.println();
    }
}
