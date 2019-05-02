package za.co.bbd.gradprogram.jigsaw.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TargetImageJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class TargetImageRowMapper implements RowMapper<TargetImage> {

        @Override
        public TargetImage mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new TargetImage(rs.getLong("id"), rs.getBytes("image"));
        }
    }

    public List<TargetImage> findAll() {
        return jdbcTemplate.query("select * from targetImage", new TargetImageRowMapper());
    }

    public TargetImage findById(long id) {
        return jdbcTemplate.queryForObject("select * from targetImage where id=?", new Object[]{id},
                new BeanPropertyRowMapper<TargetImage>(TargetImage.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from targetImage where id=?", new Object[]{id});
    }

    public long insert(TargetImage targetImage) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement("insert into targetImage (image) " + "values(?)", new String[] {"id"});
            ps.setBytes(1, new byte[] {});
            return ps;
        }, keyHolder);
        return (long) keyHolder.getKey();
    }

    public int update(TargetImage targetImage) {
        return jdbcTemplate.update("update targetImage " + " set image = ? " + " where id = ?",
                new Object[]{targetImage.getImage(), targetImage.getId()});
    }

}
