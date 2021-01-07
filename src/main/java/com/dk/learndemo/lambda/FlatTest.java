package com.dk.learndemo.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :zhudakang
 * @description : Test
 * @create : 2020/04/07
 */
public class FlatTest {

    /**
     * stream 是必须要有终止条件的
     * */
    public static void main(String[] args) {

        List<ContainerIdVO> containerIdVOList = new ArrayList<>();
        containerIdVOList.add(new ContainerIdVO("JOBMANAGER", Arrays.asList("aaa", "bbb")));
        containerIdVOList.add(new ContainerIdVO("TASKMANAGER", Arrays.asList("cccc", "dddd")));
        List<String> containerIds = new ArrayList<>();
        containerIds = containerIdVOList.stream().filter(o -> o.getNodeType().equalsIgnoreCase("JOBMANAGER"))
                .map(ContainerIdVO::getContainerIds).flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(containerIds);
        System.out.println();



//        containerIdVOList.forEach(o -> containerIds.addAll(o.getContainerIds()));
//        System.out.println();

    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static
    class ContainerIdVO {

        private String nodeType;

        private List<String> containerIds;
    }
}
