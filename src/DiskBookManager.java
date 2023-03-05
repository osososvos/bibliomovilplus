import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DiskBookManager {
	
	

	 public static Set<String> loadBooks(String path) {
	        Set<String> books=new TreeSet<>();
	        String line;
	        try(BufferedReader br=new BufferedReader(new BufferedReader(new FileReader(path)))) {
	            while ((line = br.readLine())!=null) {
	            	//Recortar los diferentes datos de la linea:
	            	int initCursor = line.indexOf("{") + 1;
	                int fiCursor = line.indexOf("}");
	                String lhs = line.substring(initCursor, fiCursor);
	                initCursor = line.indexOf( "{", fiCursor) +1;
	                fiCursor = line.indexOf("}", initCursor);
	                String rhs = line.substring(initCursor, fiCursor);
	
	                //Guardar los lhs:
	                String[] lhs_arr=lhs.split(",");
	                for(String lhsi : lhs_arr)books.add(lhsi);
	
	                //Guadamos los rhs:
	                books.add(rhs);
	            }
	            
	            
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return books;
	   }
	 
	 public static void printBooks(Set<String> books) {
		 System.out.println("Lista de libros:");
		 for(String book : books) {
			 System.out.println(book);
		 }
	 }
}
