package com.upane.plearn.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Description: 第六章 用流收集数据
 *
 * @Author:pan
 * @Date:2022/5/18
 */
public class ChapterSix {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 无限流  需要加 limit
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .forEach(t -> System.out.println(t[0] + "===" + t[1]));

        // 差点以为 groupingBy 不存在这个方法
        Map<Integer, List<Transaction>> collect = transactions.stream()
                .collect(groupingBy(Transaction::getYear));

        System.out.println(collect);

        // 汇总
        Integer summingIntTemp = transactions.stream()
                .collect(summingInt(Transaction::getYear));
        // 汇总 获取max sum 等
        IntSummaryStatistics intSummaryStatistics = transactions.stream().collect(summarizingInt(Transaction::getYear));
        intSummaryStatistics.getSum();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getAverage();
        System.out.printf(intSummaryStatistics.toString());

    }


}
