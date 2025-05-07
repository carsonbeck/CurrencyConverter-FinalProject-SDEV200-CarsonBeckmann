package org.example.currencyconverterfinalprojectsdev200carsonbeckmann;

public class CurrencyConverter {
    public static double convert(double amount, AbstractCurrency source, AbstractCurrency target) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        double usdEquivalent = amount / source.getExchangeRate();
        return usdEquivalent * target.getExchangeRate();
    }
}