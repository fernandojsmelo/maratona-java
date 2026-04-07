package academy.devdojo.maratonajava.javacore.ZZIjdbc.repository;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
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

    public static List<Producer> findByNamePreparedStatement(String name) {
        log.error("Finding by name Producers");

        String sql = "select * from anime_store.producer where name like ?;";
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectFactory.getConnection();
             PreparedStatement ps = createdPreparedStatement(conn, sql, name);
             ResultSet rs = ps.executeQuery()) {

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

    private static PreparedStatement createdPreparedStatement(Connection conn, String sql, String name) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "%" + name + "%");
        return ps;
    }

    public static void showProducerMetadata() {
        log.info("Showing Producer MetaData");
        log.error("Showing Producer MetaData");

        String sql = "select * from anime_store.producer;";

        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            ResultSetMetaData rsMetaData = rs.getMetaData();
            int columnCount = rsMetaData.getColumnCount();
            log.error("Columns count '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.error("Table name '{}'", rsMetaData.getTableName(i));
                log.error("Column name '{}'", rsMetaData.getColumnName(i));
                log.error("Column size '{}'", rsMetaData.getColumnDisplaySize(i));
                log.error("Column type '{}'", rsMetaData.getColumnTypeName(i));
            }
        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }
    }

    public static void showDriverMetaData() {
        log.info("Showing Driver MetaData");
        log.error("Showing Driver MetaData");

        try (Connection conn = ConnectFactory.getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.error("Supports TYPE_FORWARD_ONLY");
                if (dbMetaData.supportsResultSetConcurrency(
                        ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)) {
                    log.error("And Supports CONCUR_UPDATABLE");
                }
            }

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.error("Supports TYPE_SCROLL_INSENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.error("And Supports CONCUR_UPDATABLE");
                }
            }

            if (dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.error("Supports TYPE_SCROLL_SENSITIVE");
                if (dbMetaData.supportsResultSetConcurrency(
                        ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                    log.error("And Supports CONCUR_UPDATABLE");
                }
            }
        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }
    }

    public static void showTypeScrollWoring() {
        String sql = "select * from anime_store.producer ;";

        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            log.error("Last row? '{}'", rs.last());
            log.error("Row number? '{}'", rs.getRow());
            log.error(Producer
                    .builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build()
            );

            log.error("===================================================");

            log.error("First row? '{}'", rs.first());
            log.error("Row number? '{}'", rs.getRow());
            log.error(Producer
                    .builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build()
            );

            log.error("===================================================");

            log.error("Row Absolute? '{}'", rs.absolute(2));
            log.error("Row number? '{}'", rs.getRow());
            log.error(Producer
                    .builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build()
            );

            log.error("===================================================");

            log.error("Row Relative? '{}'", rs.relative(-1));
            log.error("Row number? '{}'", rs.getRow());
            log.error(Producer
                    .builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .build()
            );

            log.error("===================================================");

            log.error("Is Last? '{}'", rs.isLast());
            log.error("Row number? '{}'", rs.getRow());

            log.error("======Last Row 2===================================");

            log.error("Last Row? '{}'", rs.last());

            log.error("===================================================");
            rs.next();
            log.error("After last Row? '{}'", rs.isAfterLast());
            while (rs.previous()) {
                log.error(Producer
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .build()
                );
            }
        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }

    }

    public static List<Producer> findByNameAndUpdateToUpperCase(String name) {
        log.error("Finding by name Producers");

        String sql = "select * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
             );
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                rs.updateString(
                        "name", rs.getString("name").toUpperCase());
//                rs.cancelRowUpdates(); // Quando tiver que cancelar uma alteração
                // Só é usado antes do UpdateRow
                rs.updateRow();
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

    public static List<Producer> findByNameAndInsertWhenNotFound(String name) {
        log.error("Finding by name Producers");

        String sql = "select * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        List<Producer> producers = new ArrayList<>();
        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
             );
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) return producers;

            insertNewProducer(name, rs);
            producers.add(getProducer(rs));

        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }

        return producers;
    }

    public static void findByNameAndDelete(String name) {
        log.error("Finding by name Producers");

        String sql = "select * from anime_store.producer where name like '%%%s%%';"
                .formatted(name);
        try (Connection conn = ConnectFactory.getConnection();
             Statement stmt = conn.createStatement(
                     ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE
             );
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                log.error("Deleting '{}'", rs.getString("name"));
                rs.deleteRow();
            }

        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }

    }

    private static void insertNewProducer(String name, ResultSet rs) throws SQLException {
        rs.moveToInsertRow();
        rs.updateString("name", name);
        rs.insertRow();
    }

    private static Producer getProducer(ResultSet rs) throws SQLException {
        rs.beforeFirst();
        rs.next();
        return Producer
                .builder()
                .id(rs.getInt("id"))
                .name(rs.getString("name"))
                .build();

    }
}
