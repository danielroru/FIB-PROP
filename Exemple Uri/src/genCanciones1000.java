import java.util.*;

/**
 * @author Carlos Piris
 */

public class genCanciones1000 {
	    
	public static void main(String [] args){
		for(int i = 1000; i > 0; --i){
			int titulo = randInt(1,700);
			int autor = randInt(1,40000);
			int album = randInt(1,550);
			int anyo = randInt(1000,2015);
			int numEstilos = randInt(1,2);
			String estilos = Integer.toString(numEstilos) + ":" + "estilo" + Integer.toString(randInt(0,150));
			if(numEstilos == 2){
				estilos += ":" + "estilo" + Integer.toString(randInt(0,150));
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