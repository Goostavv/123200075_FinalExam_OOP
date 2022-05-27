/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;
import Movie.Movie;
/**
 *
 * @author Gustav
 */
public class Controller {
    Movie movies;
    Object[][] Films = new Object[150][4];
   
    private Object[][] movie;
    public Controller(Movie movies){
       this.movies = movies;
    }
    
    public Object[][] index(){
       movie = movies.getMovie();
       return movie;
   } 
    
    public void simpan(String title, double plot, double character, double acting){
        boolean found = false;
        for (int i = 0; movie[i][0] != null; i++) {
            if (movie[i][0].toString().equals(title)){
                found = true;
                break;
            }
        }
        if (found){
            JOptionPane.showMessageDialog(null, "The movie already been listed in the database");
        } else {
            if (plot > 5.0 || character > 5.0 || acting > 5.0){
               JOptionPane.showMessageDialog(null, "Max Rating is 5.0"); 
            } else if(plot < 0 || character < 0 || acting < 0){
                JOptionPane.showMessageDialog(null, "Min Rating is 0");
            } else {
                movies.insert(title, plot, character, acting);
                JOptionPane.showMessageDialog(null, "The movie data successfully added");
            }
        }
    }
    
    public void update(String title, double plot, double character, double acting){
        boolean found = false;
        int num = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(title)){
                num = i;
                found = true;
                break;
            }
        }
        
        if (found){
            if(plot > 5.0 || character > 5.0 || acting > 5.0){
               JOptionPane.showMessageDialog(null,"Max Rating is 5.0"); 
            } else if(plot < 0 || character < 0 || acting < 0){
                JOptionPane.showMessageDialog(null,"Min Rating is 0");
            } else{
                movies.update(movie[num][0].toString(), plot, character, acting);
                JOptionPane.showMessageDialog(null,"The movie data successfully Updated");
            }
        } else {
           JOptionPane.showMessageDialog(null,"Sowwy we cant find your movie uwu try another tittle"); 
        }
    }
    
    public void delete(String title){
        boolean found = false;
        int num = -1;
        for (int i = 0; movie[i][0] != null; i++) {
            if(movie[i][0].toString().equals(title)){
                num = i;
                found = true;
                break;
            }
        }
        
        if (found){
            movies.delete(movie[num][0].toString());
            JOptionPane.showMessageDialog(null,"The movie data successfully Deleted");
        }else{
           JOptionPane.showMessageDialog(null,"Sowwy we cant find your movie uwu try another tittle"); 
        }
    }
}
