package packages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    // Creates a list for all the movies.
    ArrayList<String> movies = new ArrayList<>();

    // Loads the movies.txt file and adds each movie in the file to a list.
    public void loadMovieList() {
        try (BufferedReader br = new BufferedReader(new FileReader("packages/res/movies.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                movies.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }

    // Displays a menu for the user and returns the option that the user selected.
    public int displayMenu() {
        System.out.println("Movie Management System");
        System.out.println("1     Add New Movie and Save");
        System.out.println("2     Generate List of Movies Released in a Year");
        System.out.println("3     Generate List of Random Movies");
        System.out.println("4     Exit");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an option: ");
        int option = scanner.nextInt();
        scanner.close();
        return option;
    }
}
