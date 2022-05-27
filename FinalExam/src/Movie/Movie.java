    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Movie;
import Conn.Connector;
import java.sql.ResultSet;
/**
 *
 * @author Gustav
 */
public class Movie {
    public Connector DB;
    public Movie(Connector DB){
        this.DB = DB;
    }
    
    public Object[][] getMovie(){
        Object[][] movie = new Object[100][5];
        try{
            DB.statement = DB.connection.createStatement();
            ResultSet result = DB.statement.executeQuery("SELECT * FROM `movie`");
            
            int i = 0;
            while(result.next()){
                movie[i][0] = result.getString("title");
                movie[i][1] = result.getString("plot");
                movie[i][2] = result.getString("character");
                movie[i][3] = result.getString("acting");
                movie[i][4] = result.getString("score");
                i++;
            }
            DB.statement.close();
        } catch(Exception err){
            System.out.println(err);
        }
        return movie;
    }
    
    public void insert(String title, double plot, double character, double acting){
        try {
            double rating = (plot+character+acting)/3.0;
            DB.statement = DB.connection.createStatement(); 
            String query = "INSERT INTO `movie` (`title`, `plot`, `character`, `acting`, `score`) VALUES ('"+title+"', '"+plot+"', '"+character+"', '"+acting+"', '"+rating+"')";
            DB.statement.execute(query);
        } catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void update(String title, double plot, double character, double acting){
        try {
            double rating = (plot+character+acting)/3.0;
            DB.statement = DB.connection.createStatement(); 
            String query = "UPDATE `movie` SET `plot` = '"+plot+"', `character` = '"+character+"', `acting` = '"+acting+"', `score` = '" +rating+ "' WHERE `movie`.`title` = '" +title+ "'";
            DB.statement.execute(query);
            
        }  catch(Exception err){
            System.out.println(err);
        }
    }
    
    public void delete(String title){
        try {
            DB.statement = DB.connection.createStatement(); 
            String query = "DELETE FROM `movie` WHERE `movie`.`title` = '"+title+"'";
            DB.statement.execute(query);
            
        } catch(Exception err){
            System.out.println(err);
        }
    }
}
