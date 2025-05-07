package org.example.currencyconverterfinalprojectsdev200carsonbeckmann;

public abstract class AbstractCurrency {
    private final String code;
    private final String name;
    private final double exchangeRate;

    public AbstractCurrency(String code, String name, double exchangeRate) {
        this.code = code;
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }
}