import java.util.*;

/**
 * @author Carlos Piris
 */

public class genUsuarios1000 {

	static ArrayList<String> canciones = new ArrayList<>();
	    
	public static void main(String [] args){
	
		Scanner in = new Scanner(System.in);
		int cont = 0;
		
		while(in.hasNext()){
			++cont;
			String input = in.next();
			String[] dataline = input.split(":");
			canciones.add(dataline[0]+":"+dataline[1]);
		}
	
		for(int i = 15; i > 0; --i){
			int numEscuchas = randInt(1,10);
			String escuchas = Integer.toString(numEscuchas) + ":" + canciones.get(randInt(0, cont-1));
			for(; numEscuchas > 1; --numEscuchas){
				escuchas +=  ":" + canciones.get(randInt(0, cont-1));
			}
			System.out.println("Usuario" + i + ":" + escuchas);
			
		}
	}
	
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
}