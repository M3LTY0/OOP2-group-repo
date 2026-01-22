package sait.mms.manager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import sait.mms.problemdomain.Movie;

public class MovieManager {
    // Creates a list for all the movies aswell as a scanner.
    ArrayList<Movie> movies = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    // Loads the movies.txt file and adds each movie in the file to a list.
    public void loadMovieList() {
        try (BufferedReader br = new BufferedReader(new FileReader("res/movies.txt"))) {
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
        int option;
        do{
            System.out.println("\nMovie Management System");
            System.out.println("1     Add New Movie and Save");
            System.out.println("2     Generate List of Movies Released in a Year");
            System.out.println("3     Generate List of Random Movies");
            System.out.println("4     Exit");
            System.out.println();
            System.out.print("Enter an option: ");
            option = scanner.nextInt();
            if(option<1||option>4)
                System.out.println("Invalid Option!");
            
                
        }while(option < 1||option > 4);
        return option;
    }

    //Takes in user input for year the iterates through arraylist with a for loop to find relevant matches
    public void generateMovieListInYear(){
        int duration=0;
        System.out.print("Enter in year: ");
        int year = scanner.nextInt();
        for(Movie film: movies){
            if(year==film.getYear()){
                System.out.println(film.toString());
                duration+=film.getDuration();
            }
        }
        System.out.println("Total Duration: "+duration+" minutes");

    }

    //Takes user input for number of movies and sets that as limit for the loop. 
    // Then uses a random number generator derived from the soze of the list to generate an index for the array
    public void generateRandomMovieList(){
        int duration=0;
        System.out.print("Enter number of movies: ");
        int num = scanner.nextInt();
        for(int x=0;x<num;x++){
            int rand = (int)(Math.random()*(movies.size()));
            System.out.println(movies.get(rand).toString());
            duration+=movies.get(rand).getDuration();
        }
        System.out.println("Total Duration: "+duration+" minutes");
    }

    //Creates a refrence to the file and a writer to said file. Writes details of the film and cataches any expection that may be thrown
    public void saveMovieListToFile(){
        try {
            File films = new File("res/movies.txt");
            PrintWriter pen = new PrintWriter(films);
            for(Movie film:movies)
                pen.println(film.getDuration()+","+film.getTitle()+","+film.getYear());
            pen.close();
        } catch (IOException e){
            System.out.println("Error reading file.");
        }
        
    }

    public void addMovie() {
            // movie var
            int duration;
            String title;
            int year;
    
            // get user input
            System.out.print("Enter duration: ");
            duration = scanner.nextInt();
            scanner.nextLine(); // input scanner to consume the extra \n
                        // https://stackoverflow.com/questions/44288369/how-to-input-a-string-in-java-except-using-nextline-and-i-need-to-print-the-wh
    
            System.out.print("Enter movie title: ");
            title = scanner.nextLine(); // REMOVE no need to do nexLine again in a string, only ints etc.
    
            System.out.print("Enter year: ");
            year = scanner.nextInt();
            scanner.nextLine();
    
            // create new movie obj using user info
            Movie movie = new Movie(duration, title, year);
            // add movies to list
            movies.add(movie);
    
            // add it to file
            saveMovieListToFile();
            System.out.println("Saving movies...\n" + "Added movie to the data file.");
        }



}
