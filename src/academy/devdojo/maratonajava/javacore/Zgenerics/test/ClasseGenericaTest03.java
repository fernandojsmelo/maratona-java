package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Barco;
import academy.devdojo.maratonajava.javacore.Zgenerics.dominio.Carro;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.BarcoRentavelService;
import academy.devdojo.maratonajava.javacore.Zgenerics.service.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {
    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(List.of(new Carro("BMW"),new Carro("Fusca")));
        List<Barco> barcosDisponiveis = new ArrayList<>(List.of(new Barco("Lancha"),new Barco("Canoa")));

        RentalService<Carro> rentalServicecarro = new RentalService<>(carrosDisponiveis);
        Carro carro = rentalServicecarro.buscarObjetoDisponivel();
        System.out.println("Usando o carro por um Mês...");
        rentalServicecarro.retornarObjetoAlugado(carro);

        System.out.println("----------------------------------------------");
        RentalService<Barco> rentalServiceBarco = new RentalService<>(barcosDisponiveis);
        Barco barco = rentalServiceBarco.buscarObjetoDisponivel();
        System.out.println("Usando o Barco por um Mês...");
        rentalServiceBarco.retornarObjetoAlugado(barco);
    }
}
