
package Dominio;

import java.util.*;

/**
 *
 * @author Alex Cuello
 */
public class Cancion {
    private int Id;
    private String Titulo;
    private String Album;
    private String Autor;
    private int Anyo;
    private Set <String> Estilo;

           
    public Cancion(){};
    /**
     * Constructora de Cancion
     * @param Id
     * @param Titulo
     * @param Album
     * @param Autor
     * @param Anyo 
     * @param Estilo1 
     */
    public Cancion(int Id, String Titulo, String Autor, String Album, int Anyo, Set<String> Estilo1) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Album = Album;
        this.Autor = Autor;
        this.Anyo = Anyo;
        this.Estilo = Estilo1;
    }
    
    /**
     * Post: Copia la cancion del parametro al parametro implicito
     * @param c 
     */
    public void Cancion (Cancion c){
        this.Id = c.getId();
        this.Titulo = c.getTitulo();
        this.Album = c.getAlbum();
        this.Autor = c.getAutor();
        this.Anyo = c.getAnyo();
        this.Estilo = c.getEstilo();
        
    }
   
    /**
     * Post: Devuelve el Id de una cancion
     * @return 
     */
    public int getId() {
        return Id;
    } 
    
    
    /**
     * Post: Modifica el Id de una cancion
     * @param Id 
     */
    public void setId(int Id) {
        this.Id = Id;
    }
    
    /**
     * Post: Devuelve el titulo de una cancion
     * @return Titulo de la cancion
     */
    public String getTitulo() {
        return Titulo;
    }
    
    /**
     * Post: Modifica el título de una cancion
     * @param Titulo 
     */
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    
    /**
     * Post: Devuelve el album de una cancion
     * @return 
     */
    public String getAlbum() {
        return Album;
    }
    
    /**
     * Post: Modifica el Album de una cancion
     * @param Album 
     */
    public void setAlbum(String Album) {
        this.Album = Album;
    }
    
    /**
     * Post: Devuelve el Autor de una cancion
     * @return 
     */
    public String getAutor() {
        return Autor;
    }
    
    /**
     * Post: Modifica el Autor de una cancion
     * @param Autor 
     */
    public void setAutor(String Autor) {
        this.Autor = Autor;
    }
    
    /**
     * Post: Devuelve el Anyo de una cancion
     * @return 
     */
    public int getAnyo() {
        return Anyo;
    }
    /**
     * Post: Modifica el Anyo de una cancion
     * @param Anyo 
     */
    public void setAnyo(int Anyo) {
        this.Anyo = Anyo;
    }
    
    
    
    /**
     * Post: Devuelve el conjunto de estilos de una cancion
     * @return 
     */
    public Set<String> getEstilo() {
        return Estilo;
    }
    /**
     * Post: Modifica el conjunto de estilos de una cancion
     * @param Estilo 
     */
    public void setEstilo(Set<String> Estilo) {    
        this.Estilo = new HashSet<>(Estilo);
        
    
    }
   
    
    /**
     * Post: Determina si la cancion del parametro es igual que la del parametro implicito
     * @param c
     * @return 
     */
    public boolean iguales(Cancion c){
        return this.Id == c.getId();
    }
}


