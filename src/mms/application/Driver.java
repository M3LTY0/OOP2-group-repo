//Matthew, Jaeryn and Jerry - 20/1/26
//Manages the movie class through methods
package src.mms.application;

import src.mms.manager.MovieManager;

public class Driver {
    public static void main(String[] args) {
        MovieManager Manager = new MovieManager();
        Manager.loadMovieList();
        int action = Manager.displayMenu();


        while (action != 4) {
            if (action == 1) {
                Manager.addMovie();
            }

            else if (action == 2) {
                Manager.generateMovieListInYear();
            } 
                    
        
            else if (action == 3) {
                Manager.generateRandomMovieList();
            }
        
            Manager.loadMovieList();
            action = Manager.displayMenu();
         }


                
            }
            
        }
