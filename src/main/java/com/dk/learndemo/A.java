package com.dk.learndemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author :zhudakang
 * @description : A
 * @create : 2020/08/11
 */
public class A {

    static {
        System.out.println("A");
        System.out.println();
    }

    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(8L);
        list.add(7L);
        list.add(0L);

        List<Long> list2 = new ArrayList<>();
        list2.add(1L);
        list2.add(8L);
        list2.add(7L);
        list2.add(0L);
        List<List<Long>> test = new ArrayList<>();
        test.add(list);
        test.add(list2);
        List<Long> a = retainElementList(test);

    }

    public static List<Long> retainElementList(List<List<Long>> elementLists) {

        Optional<List<Long>> result = elementLists.parallelStream()
                .filter(elementList -> elementList != null && ((List) elementList).size() != 0)
                .reduce((a, b) -> {
                    a.retainAll(b);
                    return a;
                });
        return result.orElse(new ArrayList<>());
    }

}
