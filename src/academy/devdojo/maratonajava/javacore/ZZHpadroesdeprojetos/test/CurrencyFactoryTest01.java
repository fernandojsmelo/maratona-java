package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio.Country;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio.Currency;
import academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio.Currencyfactory;

public class CurrencyFactoryTest01 {
    static void main(String[] args) {
        Currency currency = Currencyfactory.newCurrency(Country.BRASIL);
        System.out.printf(currency.getSymbol());
    }
}
