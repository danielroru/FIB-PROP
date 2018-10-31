/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interficie;
import Dominio.ControladoraDominio;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 1183942
 */
public class ControladoraInterficie {
    private ControladoraDominio CD = new ControladoraDominio();
    
    public void addCancion(String Titulo, String Autor, String Album, int Anyo,Set<String> Estilos){
        CD.addCancion(Titulo, Autor, Album, Anyo, Estilos);
    }
    

   
    
    public void modCancion2(String Tit1, String Aut1, String Tit2, String Aut2, String Alb, int Anyo, Set<String> es){
        CD.modCancion2(Tit1, Aut1, Tit2, Aut2, Alb, Anyo, es);
    }
    /**
     * Si existe la cancion con id que se le pasa por parametro
     * @param idC
     * @return 
     */
    public boolean existsCancion(int idC) {
        return CD.existsCancion(idC);
    };
    
    /**
     * Indica si existe la cancion con Titulo Title y Autor Author
     * @param Title
     * @param Author
     * @return 
     */
    public boolean existsCancion(String Title, String Author) {
        return CD.existsCancion(Title, Author);
    };
    
    

    
    
    /**
     * Elimina una cancion del sistema con el id del parametro
     * @param Id 
     */
    public void delCancionEscuchas(String Titulo, String Autor){
        CD.delCancionEscuchas(Titulo, Autor);
    }
    
    /**
     * Elimina todas las canciones escuchadas por los usuarios.
     * @param Id 
     */
    public void delCancionEscuchas(){
        CD.delCancionEscuchas();
    }
    
    public void delCancion(String Tit, String Aut){
        CD.delCancion(Tit, Aut);
        
    }
    
    public int getIdCancion(String Tit, String Aut){
        return CD.getIdCancion(Tit, Aut);
    }
    
    /**
     * Elimina todas las canciones del sistema
     */
    public void delAllCanciones(){
        CD.delAllCanciones();
    }
    
    /**
     * Anyade un usuario al sistema
     * @param nombre
     * @param Escuchas 
     */
    public void addUsuario(String nombre, Set<Integer> Escuchas){
        CD.addUsuario(nombre, Escuchas);
    }
    
    /**
     * Devuelve el nombre de todos los Usuarios del sistema
     * @return 
     */
    public ArrayList<String> getNombreUsuarios(){
        return CD.getNombreUsuarios();
    }
    /**
     * Devuelve si existe o no el usuario en el sistema.
     * @param user
     * @return 
     */
    public boolean isUsuario(String user){
        return CD.isUsuario(user);
    }
    
    /**
     * Devuelve las Escuchas del Usuario que se indica en el parametro
     * @param nombre
     * @return 
     */
    public ArrayList<Integer> getEscuchaUsuario(String nombre){
        return CD.getEscuchaUsuario(nombre);
    }
    
    /**
     * Elimina el Usuario que se indica en el parametro y todas sus Escuchas 
     * @param nombre 
     */
    public void delUsuario(String nombre){
        CD.delUsuario(nombre);
    }
    
    /**
     * Elimina todos los Usuarios y todas sus Escuchas
     */
    public void delAllUsuarios(){
        CD.delAllUsuarios();
    }
    
    /**
     * Modifica un Usuario del sistema
     * @param old
     * @param nombre
     * @param Escuchas 
     */
    public void modUsuario(String old, String nombre, Set<Integer> Escuchas){
        CD.modUsuario(old, nombre, Escuchas);
    }
    
    public void vaciarEscuchasUsuario(String usuario){
        CD.vaciarEscuchasUsuario(usuario);
    }
    
    /**
     * Elimina todas las canciones con la id del parametro de las escuchas
     * del sistema.
     * @param id 
     */
    public void delCancionEscuchas(int id){
        CD.delCancionEscuchas(id);
    }
    
    
    /**
     * Elimina la cancion con los atributos titulo y autor pasados por 
     * parametro de la escucha del usuario.
     * @param usuario
     * @param titulo
     * @param autor 
     */
    public void delCancionUsusario(String usuario, String titulo, String autor){
        CD.delCancionUsusario(usuario, titulo, autor);
    }
    /**
     * Anyadimos una Comunidad en el sistema
     * @param n
     * @param s 
     */
    public void newCjtoComunidad(String n, ArrayList<ArrayList<String>> s){
        CD.newCjtoComunidad(n, s);
    }
  
    /**
     * Devuelve los ctirerios con los que se han generado la Comunidades
     * @return 
     */
    public ArrayList<ArrayList<String>> getCriterios(){
        return CD.getCriterios();
    }
    
    /**
     * Anyade un criterio al conjunto de Comunidades
     * @param n
     * @param value 
     */
    public void addCri(String n, String value){
        CD.addCri(n, value);
    }
    
    public void genGraph(){		
	CD.genGraph();
    }
    
    /**
     * Elimina un criterio del conjunto de Comunidades
     * @param n
     * @param value 
     */
    public void delCri(String n, String value){
        CD.delCri(n, value);
    }
    
    /**
     * Devuelve el nombre de todas las Comunidades
     * @return 
     */
    public String getNomComunidades(){
        return CD.getNomComunidades();
    }
    

    
    /**
     * Anyade un elemento a una Comunidad
     * @param nCom
     * @param id 
     */
    public void addComunidad(int nCom, int id){
        CD.addComunidad(nCom, id);
    }
    
    /**
     * Elimina un elemento de una Comunidad
     * @param nCom
     * @param id 
     */
    public void delComunidad(int nCom, int id){
        CD.delComunidad(nCom, id);
    }
    
    /**
     * Devuelve todas las Comunidades para Print
     * @return 
     */
    public String getPrintComunidades(){
        return CD.getPrintComunidades();
    }
    
    /**
     * Calcula las comunidades del grafo mediante el algoritmo Clique Percolation 
     * de la Comunidad que se indica por el parametro con una p que tambien se indica
     * @param n
     * @param p
     * @return 
     */
    public void calcClique(Integer p) {
        CD.calcClique(p);
    }
    
    public void calcLouvain(Integer p) {
        CD.calcLouvain(p);
    }
    
    public void calcGirvan(Integer p) {
        CD.calcGirvan(p);
    }
    
    /**
     * Devuelve el resultado del calculo del algoritmo
     * @return 
     */
    public ArrayList<ArrayList<Integer>> getRes() {
        return CD.getRes();
    }
   
    
    /** COSAS INTERFICIE **/
    
    
    public boolean JaEstaTaula(String Titulo, String Autor, DefaultTableModel model){
        return CD.JaEstaTaula(Titulo, Autor, model);
    }
    
    public ArrayList<Object> CargarCanTab(DefaultTableModel model, String Filename, boolean b){
        
       return CD.CargarCanTab(model, Filename, b);
    }
    
    
    public void GuardarCanTab(String Filename){
        CD.GuardarCanTab(Filename);
    }
    
    public void guardarUserFichero(String Filename){
        CD.guardarUserFichero(Filename);
    }
    
    public void cargarCancionesUsuarioFichero(String Filename){
        CD.cargarCancionesUsuarioFichero(Filename);
    }
    
    public void cargarCancionesUsuarioFicherov2(String Filename){
        CD.cargarCancionesUsuarioFicherov2(Filename);
    }
    public ArrayList<Object> cargarCancionesUsuarios(String usuario){
        return CD.cargarCancionesUsuarios(usuario);
    }

    public ArrayList<Object> CargarCanTab2(){
        
        return CD.CargarCanTab2();
    }
    
    public ArrayList<Object> cargarCancionBuscador(String tit, String aut){
        return CD.cargarCancionBuscador(tit, aut);
    
    }
    
    public ArrayList<Object> cargarCancionBuscador2(String type, String value){
        return CD.cargarCancionBuscador2(type, value);
    
    }
    
    public boolean JaEstaTaulaConj(String conj, String Titulo, String Autor, DefaultTableModel model){
        return CD.JaEstaTaulaConj(conj, Titulo, Autor, model);
    }
    
    public void eliminarConjuntosVacios() {
        CD.eliminarConjuntosVacios();
    }
    
    public ArrayList<Object> ConvertirConjTab(){
        return CD.ConvertirConjTab();
    }
    
    public void CargarConjTab(String path){
        CD.CargarConjTab(path);
    }
    
    public void GuardarConjTab(String path){
        CD.GuardarConjTab(path);
    }
    
    public void eliminarCancionDelConjunto(String conj, String titulo, String autor) {
        CD.eliminarCancionDelConjunto(conj, titulo, autor);
    }
    
    public void moverCancionDeConjunto(String conj_orig, String conj_dest, String titulo, String autor) {
        CD.moverCancionDeConjunto(conj_orig, conj_dest, titulo, autor);
    }
    
    public void copiarCancionAConjunto(String conj_dest, String titulo, String autor) {
        CD.copiarCancionAConjunto(conj_dest, titulo, autor);
    }
    
}
