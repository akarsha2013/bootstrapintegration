package in.akarsh.jdbcapidemo.repository;

import in.akarsh.jdbcapidemo.model.User;
import jakarta.persistence.EntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final EntityManager entityManager;


    //accept the parameter
    public UserRepository(JdbcTemplate jdbcTemplate,EntityManager entityManager){
        this.jdbcTemplate=jdbcTemplate;
        this.entityManager=entityManager;

    }
    //CREATE
  //  @Transactional
    public void createUser(User user) {
  //  String sql = "INSERT INTO tbl_users(name,email) VALUES(?,?)";
   //     jdbcTemplate.update(sql,user.getName(),user.getEmail());
        entityManager.persist(user);
    }

    //READ//list of employees name we have to add that's why we create List
    public List<User> findAll(){
   //  return    jdbcTemplate.query("select *from tbl_users",userRowMapper);
       return entityManager.createQuery("FROM User",User.class).getResultList();
    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
       //     return null;
            //row mapper help to map the database value directly into  java object
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            return user;

        }
    };

    //UPDATE
    public User findUserByID(Long id) {

      //  String sql=  "SELECT *from tbl_users WHERE id=?";
      //  return jdbcTemplate.queryForObject(sql,userRowMapper,id);
        return entityManager.find(User.class,id);
    }
//@Transactional
    public void update(User user) {
      //  String sql="UPDATE tbl_users SET name=?,email=? WHERE id =?";
        //jdbcTemplate.update(sql,user.getName(),user.getEmail(),user.getId());
    entityManager.merge(user);
    }

    //DELETE
    public void deleteUser(Long id) {
      //  String sql="DELETE FROM tbl_users WHERE id=?";
      //  jdbcTemplate.update(sql,id);
        User existingUser = entityManager.find(User.class,id);
        entityManager.remove(existingUser);

    }


}
