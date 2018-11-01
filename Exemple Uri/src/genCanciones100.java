import java.util.*;

/**
 * @author Carlos Piris
 */

public class genCanciones100 {
	    
	public static void main(String [] args){
		for(int i = 100; i > 0; --i){
			int titulo = randInt(1,50);
			int autor = randInt(1,20);
			int album = randInt(1,15);
			int anyo = randInt(1980,2020);
			int numEstilos = randInt(1,5);
			String estilos = Integer.toString(numEstilos) + ":" + "estilo" + Integer.toString(randInt(0,30));
			for(; numEstilos > 1; --numEstilos){
				estilos += ":" + "estilo" + Integer.toString(randInt(0,10));
			}
			System.out.println("titulo" + titulo + ":" + "autor" + autor + ":" + "album" + album + ":" + anyo + ":" + estilos);
			
		}
	}
	
	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
	
}