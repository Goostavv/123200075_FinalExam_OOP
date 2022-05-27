/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalexam;
import Conn.Connector;
import View.MovieView;
/**
 *
 * @author Gustav
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connector DB = new Connector();
        
        MovieView Mview = new MovieView(DB);
        Mview.setVisible(true);
        
    }
    
}
