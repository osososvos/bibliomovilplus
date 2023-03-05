import java.io.FileNotFoundException;

public class Presentacion {
    public static void main (String[] args) {
        try {
            Menu.displayMenu();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
