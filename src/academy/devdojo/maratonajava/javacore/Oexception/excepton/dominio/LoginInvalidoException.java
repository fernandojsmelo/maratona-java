package academy.devdojo.maratonajava.javacore.Oexception.excepton.dominio;

public class LoginInvalidoException extends Throwable {
    public LoginInvalidoException() {
        System.out.println("Login Inválido");
    }

    public LoginInvalidoException(String message) {
        System.out.println(message);
    }
}
