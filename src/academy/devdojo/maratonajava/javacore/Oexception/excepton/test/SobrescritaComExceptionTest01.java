package academy.devdojo.maratonajava.javacore.Oexception.excepton.test;

import academy.devdojo.maratonajava.javacore.Oexception.excepton.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Oexception.excepton.dominio.LoginInvalidoException;
import academy.devdojo.maratonajava.javacore.Oexception.excepton.dominio.Pessoa;

public class SobrescritaComExceptionTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();

        try {
            funcionario.salvar();
        } catch (LoginInvalidoException e) {
            throw new RuntimeException(e);
        }
    }
}
