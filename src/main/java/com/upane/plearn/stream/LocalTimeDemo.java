package com.upane.plearn.stream;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

/**
 * Description:
 *
 * @Author:pan
 * @Date:2022/6/1
 */
public class LocalTimeDemo {
    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2014, 3, 18);
        date = date.with(ChronoField.MONTH_OF_YEAR, 9);
        date = date.plusYears(2).minusDays(10);
        date.withYear(2011);
    }
}
