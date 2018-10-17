package GeneradorHoraris;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		Centre c;
		c = new Centre();
		
		System.out.println("Indica el valor de la operación:");
		System.out.println("1] Crear Aula");
		System.out.println("2] Crear Nivel");
		System.out.println("3] Eliminar Aula");
		System.out.println("4] Eliminar Nivell");
		System.out.println("5] Aules");
		System.out.println("6] Nivells");
		
		while (true) {
			
			// ---------------- Entrar Datos---------------- 
			String texto = "";
			InputStreamReader in = new InputStreamReader(System.in);
			BufferedReader buffer = new BufferedReader(in);
			try {
				texto = buffer.readLine();
			}catch(IOException e) {};
			// ---------------------------------------------
			
			int x  = Integer.parseInt(texto);
			
			if (x == 1) {
				c.crearAula();
			}
			else if (x == 2) {
				c.crearNivell();
			}
			else if (x == 3) {
				c.eliminarAula();
			}
			else if (x == 4) {
				c.eliminarNivell();
			}
			else if (x == 5) {
				System.out.println(c.getNAula());
			}
			else {
				System.out.println(c.getNNivell());
			}
		}
	}

}
