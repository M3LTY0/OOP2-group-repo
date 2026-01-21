package packages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    // Creates a list for all the movies.
    ArrayList<Movie> movies = new ArrayList<>();

    // Loads the movies.txt file and adds each movie in the file to a list.
    public void loadMovieList() {
        try (BufferedReader br = new BufferedReader(new FileReader("packages/res/movies.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                //Splits the text recieved from the file into 3 parts and calls the constructor with those parts
                String[]parts = line.split(",");
               
                int duration = Integer.parseInt(parts[0]);
                String name = parts[1];
                int year = Integer.parseInt(parts[2]);
               
                Movie movie = new Movie(duration,name,year);
                movies.add(movie);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    // Displays a menu for the user and returns the option that the user selected.
    public int displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            System.out.println("Movie Management System");
            System.out.println("1     Add New Movie and Save");
            System.out.println("2     Generate List of Movies Released in a Year");
            System.out.println("3     Generate List of Random Movies");
            System.out.println("4     Exit");
            System.out.println();
            System.out.print("Enter an option: ");
            option = scanner.nextInt();
            if(option<1||option>4)
                System.out.println("Invalid Option");
            
                
        }while(option>=1||option<=4);
        scanner.close();
        return option;
    }





}
