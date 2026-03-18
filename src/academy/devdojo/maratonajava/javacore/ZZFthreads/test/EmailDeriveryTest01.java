package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Members;
import academy.devdojo.maratonajava.javacore.ZZFthreads.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeriveryTest01 {
    static void main(String[] args) {
        Members members = new Members();
        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");

        jiraya.start();
        kakashi.start();
        while (true){
            String email = JOptionPane.showInputDialog("Entre com seu email:");
            if (email == null || email.isEmpty()){
                members.closse();
                break;
            }
            members.addMemberEmail(email);
        }
    }
}
