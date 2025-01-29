package academy.devdojo.maratonajava.javacore.Hheranca.test;

import academy.devdojo.maratonajava.javacore.Hheranca.dominio.Funcionario;

public class HerancaTest02 {
    // ************************************************************************************************
    // 0 - Bloco de inicialização estático de superClasse é execultado quando a JVM carrega classe pai;
    // 1 - Bloco de inicialização estático da subclasse é execultado quando a JVM carrega classe filha;
    // 2 - Alocado espaço em memória pro objeto da superclasse;
    // 3 - Cada atributo de susuperclasse é execultado na ordem em que aparece;
    // 4 - Bloco de inicialização de superclasse é execultado na ordem que aparec;
    // 5 - Cunstrutor é execultado da superclasse;
    // 6 - Alocado espaço em mémoria pro objeto da subclasse;
    // 7 - Cada atributo de subclasse é criado e inicializado com valores default ou o que for passado;
    // 8 - Bloco de inicialização da subclasse é execultado na ordem em que aparece;
    // 9 - Construtor é execultado da subclasse.
    // ************************************************************************************************

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Jiraya");
    }
}
