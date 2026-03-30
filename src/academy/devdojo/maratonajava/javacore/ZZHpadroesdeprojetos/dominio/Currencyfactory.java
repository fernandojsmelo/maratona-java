package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojetos.dominio;

public class Currencyfactory {
    public static Currency newCurrency(Country country) {
        switch (country) {
            case USA:
                return new UsDolar();
            case BRASIL:
                return new Real();
            default:
                throw new IllegalArgumentException("No currency found for this country");
        }
    }
}
