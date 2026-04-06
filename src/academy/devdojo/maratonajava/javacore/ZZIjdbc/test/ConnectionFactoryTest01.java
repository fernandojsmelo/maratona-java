package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProducerService;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        ConnectFactory.getConnection();
//        Producer producer = Producer.builder().name("Studio Deen").build();
        Producer producerToUpdate = Producer.builder()
                .id(1)
                .name("MADHOUSE")
                .build();
//        ProducerService.save(producer);
//        ProducerService.delete(6);
//        ProducerService.delete(7);
//        ProducerService.delete(8);
//        ProducerService.delete(9);
//        ProducerService.delete(10);
//        ProducerService.delete(11);
//        ProducerService.delete(12);
//        ProducerService.delete(13);
//        ProducerService.delete(14);
//        ProducerService.delete(15);
//        ProducerService.delete(16);
//        ProducerService.delete(17);
//        ProducerService.delete(18);
//        ProducerService.delete(19);
//        ProducerService.delete(20);
//        ProducerService.update(producerToUpdate);
        List<Producer> producers = ProducerService.findAll();
        log.error("Producers found '{}'",producers);
    }
}
