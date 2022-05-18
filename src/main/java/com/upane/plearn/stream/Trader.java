package com.upane.plearn.stream;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Description: java8 lambda
 *
 * @Author:pan
 * @Date:2022/5/18
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getcity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + "in" + this.city;
    }

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

//        (1)找出2011年发生的所有交易，并按交易额排序（从低到高）。
        List<Transaction> collect = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(toList());
        System.out.println(collect);


//        (2)交易员都在哪些不同的城市工作过？
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getcity())
                .distinct()
                .collect(toList());
        System.out.println(cities);

//        (3)查找所有来自于剑桥的交易员，并按姓名排序。
        Stream<String> names = transactions.stream().filter(a -> a.getTrader().getcity().equals("Cambridge"))
                .map(a -> a.getTrader().getName())
                .sorted();
        // 答案
        List<Trader> traders = transactions.stream().map(Transaction::getTrader)
                .filter(trader -> trader.getcity().equals("Cambridge"))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        // 也就是可以用map先取出所有子集 ---> 去重 ---> 排序 ---> 终端操作集合

//        (4)返回所有交易员的姓名字符串，按字母顺序排序。
        System.out.println("-------4-----------");
        String s = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .collect(toList()).stream().iterator().toString();
        // 打印为 对象地址  java.util.Spliterators$1Adapter@179d3b25
        // 答案
        String tradesNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(joining());
        System.out.println(tradesNames);

//        (5)有没有交易员是在米兰工作的？
        Optional<Transaction> milan1 = transactions.stream()
                .filter(a -> a.getTrader().getcity().equals("Milan"))
                .findAny();
        // 答案
        boolean milan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getcity().equals("Milan"));
        // 我的是找人，答案是判断boolean

//        (6)打印生活在剑桥的交易员的所有交易额。
        transactions.stream()
                .filter(a->a.getTrader().getcity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(a-> System.out.printf("打印生活在剑桥的交易员的所有交易额。%d%n", a));

        // 答案
        transactions.stream()
                .filter(a->a.getTrader().getcity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


//        (7)所有交易中，最高的交易额是多少？
        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(reduce);

//        (8)找到交易额最小的交易。
        Optional<Transaction> first = transactions.stream()
                .sorted(comparing(Transaction::getValue))
                .findFirst();

        // 答案
        Optional<Transaction> reduce1 = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        Optional<Transaction> min = transactions.stream()
                .min(comparing(Transaction::getValue));
        System.out.println(min);
        // amazing 结果参数都相同

        // 亏贼 steam略有小成
    }

}
