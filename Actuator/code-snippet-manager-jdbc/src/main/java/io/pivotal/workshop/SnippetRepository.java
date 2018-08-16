package io.pivotal.workshop;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

import static java.util.UUID.randomUUID;

@Repository
public class SnippetRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<SnippetRecord> rowMapper = (ResultSet rs, int row) -> new
            SnippetRecord(
                    rs.getString("id"),
                    rs.getString("id"),
                    rs.getString("id"),
                    rs.getDate("created").toLocalDate(),
                    rs.getDate("modified").toLocalDate()
            );

    public SnippetRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final String SQL_INSERT = "INSERT INTO snippet (id, title, code, created, modified)" + " values(?, ?, ?, now(), now())";

    public SnippetRecord save(NewSnippetFields newSnippetFields) {
        String newId = randomUUID().toString();

        jdbcTemplate.update(SQL_INSERT, newId, newSnippetFields.title, newSnippetFields.code);

        return findOne(newId);
    }

    private final String SQL_QUERY_ALL = "SELECT * FROM snippet";

    public List<SnippetRecord> findAll() {
        return (List<SnippetRecord>) jdbcTemplate.query(SQL_QUERY_ALL, rowMapper);
    }

    private final String SQL_QUERY_BY_ID = "SELECT * FROM snippet WHERE id=?";

    public SnippetRecord findOne(String id) {
        return jdbcTemplate.queryForObject(SQL_QUERY_BY_ID, new Object[]{id}, rowMapper);
    }

    private final String SQL_QUERY_BY_CREATION_DATE = "SELECT * FROM snippet WHERE created BETWEEN ? AND ?";

    public List<SnippetRecord> findByCreationDateRange(String startDate, String endDate) {
        return jdbcTemplate.query(SQL_QUERY_BY_CREATION_DATE, new Object[] {startDate, endDate}, rowMapper);
    }

}