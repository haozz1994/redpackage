package com.example.redpackage.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抢红包
 * 二倍均值法
 * 每次随机金额的上限为剩余人均金额的2倍
 */
public class RedPackageDemo {

    public static void main(String[] args) {

        for(int term = 1 ; term <= 100; term++){
            System.out.println("================");
            System.out.println("第"+term+"轮开始");
            List<Integer> amountList = divideRedPackage(10000, 10);
            for (int i = 0; i < amountList.size(); i++) {
                System.out.println("第" + (i + 1) + "个人抢到" + new BigDecimal(amountList.get(i)).divide(new BigDecimal(100)));
            }
            System.out.println("第"+term+"轮结束");
        }

    }

    /**
     * 拆分红包
     *
     * @param totalAmount    总金额（单位：分）
     * @param totalPeopleNum 总人数
     * @return
     */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        //剩余金额
        Integer restAmount = totalAmount;
        //剩余人数
        Integer restPeopleNum = totalPeopleNum;

        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            //随机范围:[1,剩余人均金额的2倍-1]分
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;

            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        //最后一个人不用计算，直接取剩余金额即可
        amountList.add(restAmount);
        return amountList;
    }
}
