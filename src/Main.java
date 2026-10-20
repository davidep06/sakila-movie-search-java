import java.util.Scanner;
import dao.MovieDAO;
import entity.Movie;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the title of the film you are looking for: ");
        String inputTitle = scan.nextLine();

        try {
            Movie filmGasit = MovieDAO.getMovieByName(inputTitle);
            System.out.println("Movie found: ");
            System.out.println(filmGasit);
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        scan.close();
    }
}
