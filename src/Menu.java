import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.FileNotFoundException;
public class Menu {

	private static final String pathRule = "src/libros_3.txt";
	private static final String pathBook = "src/libros_3.txt";
	
	public static void displayMenu() throws FileNotFoundException {
		RuleSet rs = new RuleSet();
        rs.loadFromDisk(pathRule);
		Scanner sc=new Scanner(System.in);
		int r=-1;
		do {
			System.out.println("Bienvenido a nuestra BiblioMóvil Plus");
			System.out.println("Si eres usuario pulsa 1 y si eres el administrador pulsa 2");
			r=sc.nextInt();
			sc.nextLine();
			if(r!=1&&r!=2) continue;
			if(r==1) {
				System.out.println("Cómo te llamas");
				String nombre=sc.nextLine();
				System.out.println("Hola " +nombre);
				System.out.println("Nuestra Biblioteca dispone de estos ejemplares: \n");

				File listado = new File("src/libros_listado.txt");
				Scanner scan = new Scanner(listado);
				while(scan.hasNextLine()) {
					System.out.println(scan.nextLine());
				}

				System.out.println("Ahora te mostraremos la lista de libros que más éxitos han tenido:\n Pulsa cualquier tecla para continuar");
				String mostrar=sc.nextLine();
				if(mostrar.equals("Y")) DiskBookManager.printBooks(DiskBookManager.loadBooks(pathBook));



			DiskBookManager.printBooks(DiskBookManager.loadBooks(pathBook));

				System.out.println("¿Qué libros que hayas leído de la lista o de las recomendaciones te han gustado?  (max.3) \n");
				List<String> libros=new ArrayList<>();
				int i=0;
				do {
					System.out.println("Introduce tu libro favorito o si no ENTER para salir: \n Te recomendamos que uses copia/pega del listado");
					String libro=sc.nextLine();
					if(libro=="")break;
					else libros.add(libro);
					i++;
				}while(i<3);
				String[] librosArr=new String[libros.size()];
				for(i=0;i<libros.size();i++) librosArr[i]=libros.get(i);
		        Set<String> productosRecomendados = rs.recommendedElements(librosArr);
		        String productos="";
		        for(String s:librosArr)productos+=" "+s;
		        System.out.println("Como te ha gustado el/los libro/s" + productos + " te recomenendamos  el/los siguientes: ");
		        for (String p : productosRecomendados) System.out.println(p);
			}else {
				System.out.println("Este es el menu de administrador\nPara dar de alta o dar de baja un libro te recomendamos hacerlo manualmente en el archivo libros_listado.txt hasta la próxima actualización, Gracias!");
				//System.out.println("¿Quieres ver el listado de los ejemplares actuales? (Y/N)\n");
				//File listado = new File("/Users/miguelroman/Downloads/untitled1-2/src/libros_listado.txt");
				//Scanner scan = new Scanner(listado);
				//if(mostrar.equals("Y"))System.out.println(scan.nextLine());
				/*while(scan.hasNextLine()) {
					System.out.println(scan.nextLine());
				}*/
				//String mostrar=sc.nextLine();
				//if(mostrar.equals("Y"))DiskBookManager.printBooks(DiskBookManager.loadBooks(pathBook));
			}
			System.out.println("Quieres salir? (Y/N)");
	        String salir=sc.nextLine();
	        if(!salir.equals("Y"))r=-1;
		}while(r==-1);
	}
}
