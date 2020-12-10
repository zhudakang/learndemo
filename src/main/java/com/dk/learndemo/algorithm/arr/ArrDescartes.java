package com.dk.learndemo.algorithm.arr;


import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : zhudakang
 * @Description :
 * @Date : 2020/12/10
 */
public class ArrDescartes {

    /**
     * 多List（集合）列表获取笛卡尔积（多数组中所有的排列组合）
     *
     * 笛卡尔乘积
     * 两个集合X和Y的笛卡尓积（Cartesian product），又称直积，表示为X×Y，第一个对象是X的成员而第二个对象是Y的所有可能有序对的其中一个成员。
     * 举例
     * 假设集合A={a, b}，集合B={0, 1, 2}，则两个集合的笛卡尔积为{(a, 0), (a, 1), (a, 2), (b, 0), (b, 1), (b, 2)}
     * 使用递归法解法; 因为为空的集合都已经去除掉了，所以不需要任何判空
     */
    public static void recursion(List<List<Integer>> inputList, List<List<Integer>> resultList,
            int curIndex, List<Integer> currentList) {
        //比如abc三个集合，都不为空，那么前两个都要走上面的if判断，到了最后一个集合的时候要走下面else，
        // currentList已等于了inputList的size大小，就可以输出了，
        // 添加到resultList里面
        if (curIndex < inputList.size() - 1) {
            //如果是三个集合的话，那么递归的顺序是1,4然后进到了下面的else 添加 6 7 去。
            //然后递归1 5 然后去下面else添加6 7去
            //然后到第二个集合搞完了 ，回到第一个集合，第一个集合该搞第二个元素了
            //然后就是递归 2 4 然后添加67去
            //然后是递归 2 5 添加67 去
            //以此类推 直到所有的元素都递归完成 那么resultList就是需要的结果了
            for (int i = 0; i < inputList.get(curIndex).size(); i++) {
                List<Integer> list = new ArrayList<>(currentList);
                list.add(inputList.get(curIndex).get(i));
                //只有这边有递归，因为下面的else里面就已经添加到结果集了 相当于一次递归的结束
                recursion(inputList, resultList, curIndex + 1, list);
            }
        } else {
            //这边如果是三个集合的话，相当于这一步把c中的6加入到currentList，然后加入到结果集里面
            //然后把c中的7加入到currentList里面，然后加入到结果里面.
            //所以最后一个元素不是6就是7
            for (int i = 0; i < inputList.get(curIndex).size(); i++) {
                List<Integer> list = new ArrayList<>(currentList);
                list.add(inputList.get(curIndex).get(i));
                //这边相当于一次递归的结束
                resultList.add(list);
            }
        }
    }

    public static List<List<Integer>> solution(List<List<Integer>> inputList) {
        //过滤掉为空的List,使用筛选后的入参，这样就没有为空的集合了
        List<List<Integer>> filterList = inputList.stream()
                .filter(item -> CollectionUtils.isNotEmpty(item)).collect(Collectors.toList());
        List<List<Integer>> resultList = new ArrayList<>();
        recursion(filterList, resultList, 0, new ArrayList<>());
        return resultList;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        List<Integer> b = new ArrayList<>();
        b.add(4);
        b.add(5);
        List<Integer> c = new ArrayList<>();
        c.add(6);
        c.add(7);
        //为空的集合
        List<Integer> d = new ArrayList<>();
        //为空的集合
        List<Integer> e = null;
        List<List<Integer>> inputList = new ArrayList<>();
        inputList.add(a);
        inputList.add(b);
        inputList.add(c);
        inputList.add(d);
        inputList.add(e);
        List<List<Integer>> result = solution(inputList);
        //打印结果
        System.out.println(result);
    }
}


