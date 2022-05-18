package com.upane.plearn.stream;

/**
 * Description:
 *
 * @Author:pan
 * @Date:2022/5/18
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String tostring() {
        return "{" + this.trader + "," +
                "year:" + this.year + "," +
                "value:" + this.value + "}";
    }

}
