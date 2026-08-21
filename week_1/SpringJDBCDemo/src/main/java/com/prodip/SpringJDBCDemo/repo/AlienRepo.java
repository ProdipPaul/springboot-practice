package com.prodip.SpringJDBCDemo.repo;

import com.prodip.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

@Repository
public class AlienRepo {

    private JdbcTemplate template ;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien){

        String sql = "insert into alien (id, name, tech) values (?,?,?)";

       int rows = template.update(sql,  alien.getId(), alien.getName(), alien.getTech());
       System.out.println(rows + " rows/s affected");

    }

    public List<Alien> findAll(){

        String sql = "select * from alien";

        RowMapper<Alien> mapper = new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));

                return a;
            }
        };

        List<Alien> aliens = template.query(sql,mapper);

        return aliens;
    }


}


/*
 * NOTE: RowMapper একটি Functional Interface (১টিমাত্র abstract method mapRow আছে)।
 * তাই Anonymous Inner Class-এর বয়লারপ্লেট কোড বাদ দিয়ে Lambda (rs, row) -> { ... }
 * ব্যবহার করা হয়েছে, যা কোড ছোট করার পাশাপাশি Functional Programming সাপোর্ট দেয়।
 */
/*
RowMapper<Alien> mapper = (rs, row) -> {
    Alien a = new Alien();
    a.setId(rs.getInt(1));
    a.setName(rs.getString(2));
    a.setTech(rs.getString(3));
    return a;
};
*/