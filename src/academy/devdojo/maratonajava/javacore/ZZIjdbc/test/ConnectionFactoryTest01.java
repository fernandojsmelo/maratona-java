package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repository.ProducerRepository;

public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        ConnectFactory.getConnection();
        Producer producer = Producer.ProducerBuilder.builder()
                .name("MHK")
                .build();
        ProducerRepository.save(producer);
    }
}
