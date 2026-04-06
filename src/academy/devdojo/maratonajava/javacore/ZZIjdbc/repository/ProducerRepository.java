package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProducerRepository {
    public static void save(Producer producer) {
        String sql =
                "INSERT INTO `anime_store`.`producer` (`name`) VALUES ('%s');"
                        .formatted(producer.getName());
        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Inserted producer '{}' in the dataBase rows affected '{}'",
                    producer.getName(),
                    rowsAffected)
            ;
            log.error("Inserted producer in the dataBase rows affected '{}'",
                    rowsAffected);
            ;
//            System.out.println(rowsAffected);

        } catch (Exception e) {
            log.error("Error while trying to insert produce '{}'",
                    producer.getName(),
                    e)
            ;
        }
//        DELETE FROM `anime_store`.`producer` WHERE (`id` = '16');

    }

    public static void delete(int id) {
        String sql =
                "DELETE FROM `anime_store`.`producer` WHERE (`id` = '%d');"
                        .formatted(id);
        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Deleted producer '{}' from the dataBase rows affected '{}'",
                    id,
                    rowsAffected)
            ;
            log.error("Deleted producer '{}' fom the dataBase rows affected '{}'",
                    id,
                    rowsAffected)
            ;
//            System.out.println(rowsAffected);

        } catch (Exception e) {
            log.error("Error while trying to deleted produce '{}'",
                    id,
                    e)
            ;
        }
    }

    public static void update(Producer producer) {
        String sql =
                "UPDATE `anime_store`.`producer` SET `name` = '%s' WHERE (`id` = '%d');"
                        .formatted(producer.getName(), producer.getId());
        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int rowsAffected = stmt.executeUpdate(sql);
            log.info("Update producer '{}', in the dataBase rows affected '{}'",
                    producer.getName(),
                    rowsAffected)
            ;
            log.error("Update producer '{}', in the dataBase rows affected '{}'",
                    producer.getName(),
                    rowsAffected);
            ;
//            System.out.println(rowsAffected);

        } catch (Exception e) {
            log.error("Error while trying to Update produce '{}'",
                    producer.getName(),
                    e)
            ;
        }
//        DELETE FROM `anime_store`.`producer` WHERE (`id` = '16');

    }

    public static List<Producer> findAll() {
        log.info("Finding all Producers");
        log.error("Finding all Producers");

        return findByName("");

//        String sql = "select id, name from anime_store.producer;";
//        List<Producer> producers = new ArrayList<>();
//        try (Connection conn = ConnectFactory.getConnection();
//             Statement stmt = conn.createStatement();
//             ResultSet rs = stmt.executeQuery(sql)) {
//
//            while (rs.next()) {
//
//                Producer producer = Producer
//                        .builder()
//                        .id(rs.getInt("id"))
//                        .name(rs.getString("name"))
//                        .build();
//                producers.add(producer);
//            }
//        } catch (Exception e) {
//            log.error("Error while trying to find all produce", e);
//        }
//
//        return producers;
    }

    public static List<Producer> findByName(String name) {
        log.info("Finding by name Producers");
        log.error("Finding by name Producers");

        String sql = "select * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                Producer producer = Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build();
                producers.add(producer);
            }
        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }

        return producers;
    }
}
