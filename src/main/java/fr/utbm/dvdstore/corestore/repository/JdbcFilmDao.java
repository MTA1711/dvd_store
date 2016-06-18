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

/**
 *
 * @author java
 */
public class JdbcFilmDao implements FilmDaoInterface{

    private Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/DVD_STORE", "java", "java");
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
}
