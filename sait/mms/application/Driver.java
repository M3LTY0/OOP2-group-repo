//Matthew, Jaeryn and Jerry - 20/1/26
//Manages the movie class through methods
package sait.mms.application;

import sait.mms.manager.MovieManager;

public class Driver {
    public static void main(String[] args) {
        MovieManager Manager = new MovieManager();
        Manager.loadMovieList();
        int action = Manager.displayMenu();

        if(action==1){Manager.addMovie();}
        else if(action==2){Manager.generateMovieListInYear();}
        else if(action==3){Manager.generateRandomMovieList();}




        
    }
    
}
