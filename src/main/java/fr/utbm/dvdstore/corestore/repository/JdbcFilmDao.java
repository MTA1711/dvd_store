package fr.utbm.dvdstore.corestore.repository;


import com.mysql.jdbc.Connection;
import fr.utbm.dvdstore.corestore.dto.FilmLightDto;
import fr.utbm.dvdstore.corestore.entity.Film;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 *
 * @author java
 */
@Repository
public class JdbcFilmDao implements FilmDaoInterface{
    @Value ("${jdbc.driverClassName}")
    private String driverClassName;
    
    @Value ("${jdbc.url}")
    private String url;
    
    @Value ("${jdbc.username}")
    private String user;
    
    @Value ("${jdbc.password}")
    private String pwd;
    
    public JdbcFilmDao(){
        System.out.println("--> constructoc JdbcFilmDao call");
    }
    
    public JdbcFilmDao(String driverName){
        driverClassName = driverName;
        System.out.println("--> constructoc JdbcFilmDao(String driverName) call");
    }
    
    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driverClassName).newInstance();
            con = (Connection) DriverManager.getConnection(url, user, pwd);
            System.out.println("CONNEXION OK");
        } catch (Throwable e) {
            System.out.println("CONNECTION KO! "+ e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
    
    @Override
    public void save(Film f) {
        Connection con = this.getConnection();
        if ( con != null){
            String query = "INSERT INTO MOVIE(TITLE,COPIES, MOVIE_TYPE) VALUES(?,?,?)";
            try {
                PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, f.getTitre());
                stmt.setInt(2, f.getNbExemplaires());
                stmt.setString(3, f.getGenre());
                stmt.executeUpdate();      
            } catch (SQLException ex) {
                Logger.getLogger(JdbcFilmDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Impossible de se connecter à la BD ");
        }
    }

    @Override
    public Film find(int id) {
        Film f = null;
        return f;
    }

    @Override
    public List<FilmLightDto> findAll() {
        List<FilmLightDto> listFilmL = null;
        return listFilmL;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
}
