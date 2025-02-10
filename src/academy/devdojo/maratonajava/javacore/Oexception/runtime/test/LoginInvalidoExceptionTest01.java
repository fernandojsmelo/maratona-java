package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.util.Scanner;

public class LoginInvalidoExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        }catch (LayerInstantiationException e){
            e.printStackTrace();
        }
    }

    private static void logar() throws LayerInstantiationException{
        Scanner teclado = new Scanner(System.in);
        String usernameDB = "Goku";
        String senhaDB ="ssj";
        System.out.println("Usuário:");
        String usernameDijitado = teclado.nextLine();
        System.out.println("Senha:");
        String senhaDijitada = teclado.nextLine();

        if(!usernameDB.equals(usernameDijitado) || !senhaDB.equals(senhaDijitada)){
            throw new LayerInstantiationException("Usuário ou Senha inválidos!");
        }
        System.out.println("Usuário logado com sucesso");
    }
}
