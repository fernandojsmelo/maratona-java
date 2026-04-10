package academy.devdojo.maratonajava.javacore.ZZJcrud.repository;

import academy.devdojo.maratonajava.javacore.ZZJcrud.conn.ConnectFactory;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZJcrud.dominio.Producer;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class AnimeRepository {
    public static List<Anime> findByName(String name) {
        log.error("Finding Anime by name '{}'", name);

        List<Anime> animes = new ArrayList<>();
        try (Connection conn = ConnectFactory.getConnection();
             PreparedStatement ps = createPreparedStatementFindByName(conn, name);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Producer producer = Producer.builder()
                        .name(rs.getString("producer_name"))
                        .id(rs.getInt("producer_id"))
                        .build();
                Anime anime = Anime
                        .builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .episodes(rs.getInt("episodes"))
                        .producer(producer)
                        .build();
                animes.add(anime);
            }
        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }

        return animes;
    }

    private static PreparedStatement createPreparedStatementFindByName(
            Connection conn, String name) throws SQLException {
        String sql = """
                SELECT a.id, a.name, a.episodes, a.producer_id, p.name as 'producer_name' FROM
                anime_store.anime a inner join anime_store.producer p on a.producer_id = p.id
                where a.name like ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", name));
        return ps;
    }

    public static Optional<Anime> findById(Integer id) {
        log.error("Finding Anime by id '{}'", id);

        try (Connection conn = ConnectFactory.getConnection();
             PreparedStatement ps = createPreparedStatementFindById(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) return Optional.empty();
            Producer producer = Producer.builder()
                    .name(rs.getString("producer_name"))
                    .id(rs.getInt("producer_id"))
                    .build();
            Anime anime = Anime
                    .builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .episodes(rs.getInt("episodes"))
                    .producer(producer)
                    .build();
            return Optional.of(anime);
        } catch (Exception e) {
            log.error("Error while trying to find all produce", e);
        }
        return Optional.empty();
    }

    private static PreparedStatement createPreparedStatementFindById(
            Connection conn, Integer id) throws SQLException {
        String sql = """
                SELECT a.id, a.name, a.episodes, a.producer_id, p.name as 'producer_name' FROM
                anime_store.anime a inner join anime_store.producer p on a.producer_id = p.id
                where a.id = ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void delete(int id) {

        try (Connection conn = ConnectFactory.getConnection();
             PreparedStatement ps = createPreparedStatementDelete(conn, id)) {
            ps.execute();

            log.error("Deleted anime '{}' fom the dataBase", id);

        } catch (Exception e) {
            log.error("Error while trying to deleted produce '{}'", id, e);
        }
    }

    private static PreparedStatement createPreparedStatementDelete(Connection conn, Integer id)
            throws SQLException {
        String sql = "DELETE FROM `anime_store`.`anime` WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void save(Anime anime) {
        log.error("Saving Anime '{}'", anime);
        try (Connection conn = ConnectFactory.getConnection();
             PreparedStatement ps = createPrepareStatementSave(conn, anime)) {
            ps.execute();

        } catch (Exception e) {
            log.error("Error while trying to Update produce '{}'",
                    anime.getName(),
                    e)
            ;
        }

    }

    private static PreparedStatement createPrepareStatementSave(
            Connection conn, Anime anime) throws SQLException {
        String sql =
                "INSERT INTO `anime_store`.`anime` (`name`, `episodes`, `producer_id`) VALUES (?,?,?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getProducer().getId());
        return ps;
    }

    public static void update(Anime anime) {
        log.error("Update anime '{}'", anime);
        try (Connection conn = ConnectFactory.getConnection();
             PreparedStatement ps = createPreparedStatementUpdate(conn, anime)) {
            ps.execute();

        } catch (Exception e) {
            log.error("Error while trying to Update produce '{}'",
                    anime.getId(), e)
            ;
        }

    }

    private static PreparedStatement createPreparedStatementUpdate(
            Connection conn, Anime anime) throws SQLException {
        String sql =
                "UPDATE `anime_store`.`anime` SET `name` = ?, `episodes` = ? WHERE (`id` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getName());
        ps.setInt(2, anime.getEpisodes());
        ps.setInt(3, anime.getId());
        return ps;
    }
}
