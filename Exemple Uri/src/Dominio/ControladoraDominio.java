/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import static Dominio.Main.printCancion;
import GestionDatos.FileManager;
import java.util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alexcuello/Carlos Piris
 */
public class ControladoraDominio {
    private final Cjto_Canciones CjtoCanciones = new Cjto_Canciones();
    private final Cjto_Usuarios CjtoUsuarios = new Cjto_Usuarios();
    private final Cjto_Comunidades CjtoComunidades = new Cjto_Comunidades();
    private final Cjto_Escuchas CjtoEscuchas = new Cjto_Escuchas();
    private Boolean louvain_active = new Boolean(Boolean.FALSE);
    private Boolean girvan_active = new Boolean(Boolean.FALSE);
    int Id = 0; // Id canciones
    private Integer id_escuchas = 0;
    
    /**
     * Creador por defecto
     */
    public ControladoraDominio() {
    }
    
    /**
     * Anyade una cancion al sistema
     * @param Id
     * @param Titulo
     * @param Autor
     * @param Album
     * @param Anyo
     * @param Estilos 
     */
    public void addCancion(String Titulo, String Autor, String Album, int Anyo,Set<String> Estilos){
        Cancion c = new Cancion();
        c = new Cancion(Id,Titulo,Autor,Album,Anyo,Estilos);
        CjtoCanciones.addCancion(c);
        ++Id;
    }
    

    
    public void modCancion(Cancion c_old, Cancion c_new){
        CjtoCanciones.modCancion(c_old,c_new);
    }
    
    public void modCancion2(String Tit1, String Aut1, String Tit2, String Aut2, String Alb, int Anyo, Set<String> es){
        Cancion c_old = null;
        Cancion c_new = null;
        c_old = CjtoCanciones.retCancion(Tit1, Aut1);
        c_new = c_old;
        c_new.setTitulo(Tit2);
        c_new.setAutor(Aut2);
        c_new.setAlbum(Alb);
        c_new.setAnyo(Anyo);
        c_new.setEstilo(es);
        CjtoCanciones.modCancion(c_old,c_new);
    }
    /**
     * Si existe la cancion con id que se le pasa por parametro
     * @param idC
     * @return 
     */
    public boolean existsCancion(int idC) {
        return CjtoCanciones.existsCancion(idC);
    };
    
    /**
     * Indica si existe la cancion con Titulo Title y Autor Author
     * @param Title
     * @param Author
     * @return 
     */
    public boolean existsCancion(String Title, String Author) {
        return CjtoCanciones.existsCancion(Title, Author);
    };
    
    
    /**
     * Devuelve todas las canciones del sistema
     * @return 
     */
    public ArrayList<Cancion> getAll() {
        return CjtoCanciones.getAll();
    }
    
    
    /**
     * Elimina una cancion del sistema con el id del parametro
     * @param Id 
     */
    public void delCancionEscuchas(String Titulo, String Autor){
        CjtoEscuchas.delCancion(CjtoCanciones.retCancion(Titulo, Autor).getId());
    }
    
    /**
     * Elimina todas las canciones escuchadas por los usuarios.
     * @param Id 
     */
    public void delCancionEscuchas(){
        CjtoEscuchas.vaciar();
    }
    
    public void delCancion(String Tit, String Aut){
        if(CjtoCanciones.existsCancion(Tit, Aut)){
            Cancion c = CjtoCanciones.retCancion(Tit, Aut);
            CjtoCanciones.delCancion(c.getId());
        }
        
    }
    
    public int getIdCancion(String Tit, String Aut){
        Cancion c = CjtoCanciones.retCancion(Tit, Aut);
        return c.getId();

    }
    
    /**
     * Elimina todas las canciones del sistema
     */
    public void delAllCanciones(){
        CjtoCanciones.delAllCanciones();
    }
    
    /**
     * Anyade un usuario al sistema
     * @param nombre
     * @param Escuchas 
     */
    public void addUsuario(String nombre, Set<Integer> Escuchas){
        Escucha e = new Escucha(id_escuchas, Escuchas);
        Usuario u = new Usuario(nombre, id_escuchas);
        ++id_escuchas;
        CjtoEscuchas.addEscucha(e);
        CjtoUsuarios.addUsuario(u);
    }
    
    /**
     * Devuelve el nombre de todos los Usuarios del sistema
     * @return 
     */
    public ArrayList<String> getNombreUsuarios(){
        ArrayList<String> as = new ArrayList<>();
        for(Usuario u : CjtoUsuarios.getAllUsuarios()){
            as.add(u.getNombre());
        }
        return as;
    }
    /**
     * Devuelve si existe o no el usuario en el sistema.
     * @param user
     * @return 
     */
    public boolean isUsuario(String user){
        return CjtoUsuarios.isUsuario(user);
    }
    
    /**
     * Devuelve las Escuchas del Usuario que se indica en el parametro
     * @param nombre
     * @return 
     */
    public ArrayList<Integer> getEscuchaUsuario(String nombre){
        return (ArrayList<Integer>) CjtoEscuchas.getEscucha(CjtoUsuarios.getUsuario(nombre).getIdEscuchas()).getListCanciones();
    }
    
    /**
     * Elimina el Usuario que se indica en el parametro y todas sus Escuchas 
     * @param nombre 
     */
    public void delUsuario(String nombre){
        CjtoEscuchas.delEscucha(CjtoUsuarios.getUsuario(nombre).getIdEscuchas());
        CjtoUsuarios.delUsuario(CjtoUsuarios.getUsuario(nombre));
    }
    
    /**
     * Elimina todos los Usuarios y todas sus Escuchas
     */
    public void delAllUsuarios(){
        CjtoUsuarios.delAllUsuarios();
        CjtoEscuchas.delAllEscuchas();
    }
    
    /**
     * Modifica un Usuario del sistema
     * @param old
     * @param nombre
     * @param Escuchas 
     */
    public void modUsuario(String old, String nombre, Set<Integer> Escuchas){
        this.delUsuario(old);
        this.addUsuario(nombre, Escuchas);
    }
    
    public void vaciarEscuchasUsuario(String usuario){
        Usuario user = CjtoUsuarios.getUsuario(usuario);
        int idEsc = user.getIdEscuchas();
        Escucha esc = CjtoEscuchas.getEscucha(idEsc);
        esc.removeAll();
    }
    
    /**
     * Elimina todas las canciones con la id del parametro de las escuchas
     * del sistema.
     * @param id 
     */
    public void delCancionEscuchas(int id){
        CjtoEscuchas.delCancion(id);
    }
    
    /**
     * Elimina la cancion con los atributos titulo y autor pasados por 
     * parametro de la escucha del usuario.
     * @param usuario
     * @param titulo
     * @param autor 
     */
    public void delCancionUsusario(String usuario, String titulo, String autor){
        Cancion c = CjtoCanciones.retCancion(titulo, autor);
        int id = c.getId();
        Usuario user = CjtoUsuarios.getUsuario(usuario);
        int idEsc = user.getIdEscuchas();
        Escucha e = CjtoEscuchas.getEscucha(idEsc);
        e.remove(id);
    }
    /**
     * Anyadimos una Comunidad en el sistema
     * @param n
     * @param s 
     */
    public void newCjtoComunidad(String n, ArrayList<ArrayList<String>> s){
        CjtoComunidades.setId(n);
        CjtoComunidades.setCriterios(s);
        //CjtoComunidades.genGraph(CjtoCanciones, CjtoEscuchas);
    }
  
    /**
     * Devuelve los ctirerios con los que se han generado la Comunidades
     * @return 
     */
    public ArrayList<ArrayList<String>> getCriterios(){
        return CjtoComunidades.getCriterios();
    }
    
    /**
     * Anyade un criterio al conjunto de Comunidades
     * @param n
     * @param value 
     */
    public void addCri(String n, String value){
        CjtoComunidades.addCriterio(n, value);
    }
    
    public void genGraph(){		
	this.CjtoComunidades.genGraph(CjtoCanciones, CjtoEscuchas, CjtoUsuarios.getAllUsuarios().size());		
    }
    
    /**
     * Elimina un criterio del conjunto de Comunidades
     * @param n
     * @param value 
     */
    public void delCri(String n, String value){
        CjtoComunidades.delCriterio(n, value);
    }
    
    /**
     * Devuelve el nombre de todas las Comunidades
     * @return 
     */
    public String getNomComunidades(){
        return CjtoComunidades.getId();
    }
    

    /**
     * Devuelve el grafo del Conjunto de Comunidades
     * @return 
     */
    public Graph<Integer,Double> getGraphComunidad(){
        return CjtoComunidades.getGraph();
    }
    
    /**
     * Anyade un elemento a una Comunidad
     * @param nCom
     * @param id 
     */
    public void addComunidad(int nCom, int id){
        CjtoComunidades.addResult(nCom, id);
    }
    
    /**
     * Elimina un elemento de una Comunidad
     * @param nCom
     * @param id 
     */
    public void delComunidad(int nCom, int id){
        CjtoComunidades.delResult(nCom, id);
    }
    
    /**
     * Devuelve todas las Comunidades para Print
     * @return 
     */
    public String getPrintComunidades(){
        String allCom = CjtoComunidades.getId() + ":" + Integer.toString(CjtoComunidades.getCriterios().size());
        for(ArrayList<String> s : CjtoComunidades.getCriterios()){
            allCom += ":"+s.get(0)+":"+s.get(1);
        }
        return allCom;
    }
    
    /**
     * Calcula las comunidades del grafo mediante el algoritmo Clique Percolation 
     * de la Comunidad que se indica por el parametro con una p que tambien se indica
     * @param n
     * @param p
     * @return 
     */
    public void calcClique(Integer p) {
        CliquePercolation cp = new CliquePercolation();
        cp.setP(p);
        CjtoComunidades.genGraph(CjtoCanciones, CjtoEscuchas, CjtoUsuarios.getAllUsuarios().size());
        cp.calc(CjtoComunidades.getGraph());
        CjtoComunidades.setResult(cp.obtain());
    }
    
    public void calcLouvain(Integer p) {
        Louvain lou = new Louvain();
        lou.setP(p);
        CjtoComunidades.genGraph(CjtoCanciones, CjtoEscuchas, CjtoUsuarios.getAllUsuarios().size());
        lou.calc(CjtoComunidades.getGraph());
        CjtoComunidades.setResult(lou.obtain());
    }
    
    public void calcGirvan(Integer p) {
        GirvanNewman gnew = new GirvanNewman();
        gnew.setP(p);
        CjtoComunidades.genGraph(CjtoCanciones, CjtoEscuchas, CjtoUsuarios.getAllUsuarios().size());
        gnew.calc(CjtoComunidades.getGraph());
        CjtoComunidades.setResult(gnew.obtain());
    }
    
    /**
     * Devuelve el resultado del calculo del algoritmo
     * @return 
     */
    public ArrayList<ArrayList<Integer>> getRes() {
        return CjtoComunidades.getResult();
    }
   
    
    /** COSAS INTERFICIE **/
    
    
    public boolean JaEstaTaula(String Titulo, String Autor, DefaultTableModel model){
        int rowSize = model.getRowCount();
        for (int i = 0; i < rowSize; ++i){
            String Titulo1 = model.getValueAt(i,0).toString();
            String Autor1 = model.getValueAt(i,1).toString();
            if(Titulo1.equals(Titulo) && Autor1.equals(Autor)) return true;
        }
        return false;
    }
    
    public ArrayList<Object> CargarCanTab(DefaultTableModel model, String Filename, boolean b){
        
        FileManager fm = new FileManager(Filename);
        ArrayList<String> l = fm.readFile();
        ArrayList<Object> v = new ArrayList<>();
        b = true;
        for (String line : l){
            String dataLine[] = line.split(":");
            if(CjtoCanciones.existsCancion(dataLine[0], dataLine[1]));
            else {
                int nEstilos = Integer.parseInt(dataLine[4]);
                String Estilos1 = "";
                Set<String> Estilos = new HashSet<>();
                for(int i = 1; i < nEstilos; ++i){
                    Estilos1 += dataLine[4+i] +", ";
                    Estilos.add(dataLine[4+i]);
                }
                Estilos1 += dataLine[4+nEstilos];
                Estilos.add(dataLine[4+nEstilos]);
                
                Cancion c = new Cancion(Id, dataLine[0],dataLine[1],dataLine[2],Integer.parseInt(dataLine[3]),Estilos);
                CjtoCanciones.addCancion(c);
                ++Id;
                Object o[] = {dataLine[0],dataLine[1],dataLine[2],dataLine[3],Estilos1, b};
                v.add(o);
            }
        }
        return v;
    }
    
    
    public void GuardarCanTab(String Filename){
        FileManager fm2 = new FileManager(Filename);
        ArrayList<String> l2 = new ArrayList<>();
        ArrayList<Cancion> lc2 = CjtoCanciones.getAll();
        String linia;
        for(Cancion c: lc2){
            Set<String> Estilos = c.getEstilo();
            linia = c.getTitulo()+":"+c.getAutor()+":"+c.getAlbum()+":"+c.getAnyo()+":"+c.getEstilo().size();
            for(String s : Estilos){
                linia += ":"+s;
            }
            l2.add(linia);
            linia = new String();
        }
        fm2.writeFile(l2);
    }
    
    public void guardarUserFichero(String Filename){
        FileManager fm = new FileManager(Filename);
        ArrayList<String> l = new ArrayList<>();
        ArrayList<Usuario> listUser = CjtoUsuarios.getAllUsuarios();
        String linia = new String();
        for(Usuario user: listUser){
            int idEsc = user.getIdEscuchas();
            Escucha e = CjtoEscuchas.getEscucha(idEsc);
            Set<Integer> S = e.getS();
            linia = user.getNombre() + ":" + S.size();
            for(int id: S){
                Cancion c = CjtoCanciones.getCancion(id);
                linia += ":" + c.getTitulo() + ":" + c.getAutor();
            }
            l.add(linia);
        }
        fm.writeFile(l);
    }
    
    public void cargarCancionesUsuarioFichero(String Filename){
        FileManager fm = new FileManager(Filename);
        ArrayList<String> l = fm.readFile();
        for (String line : l){
            String dataLine[] = line.split(":");
            String usuario = dataLine[0];
            if(CjtoUsuarios.isUsuario(usuario)){
                Usuario user = CjtoUsuarios.getUsuario(dataLine[0]);
                int idEsc = user.getIdEscuchas();
                Escucha esc = CjtoEscuchas.getEscucha(idEsc);
                Set<Integer> S = new HashSet<>(esc.getS());
                int numCan = Integer.parseInt(dataLine[1]);
                for(int i = 0; i < numCan; ++i){
                    int idCan = Integer.parseInt(dataLine[2+i]);
                    if(CjtoCanciones.existsCancion(idCan)) S.add(idCan); 
                }
                esc.setS(S);
            }
            else {
                Set<Integer> S = new HashSet<>();
                int numCan = Integer.parseInt(dataLine[1]);
                for(int i = 0; i < numCan; ++i){
                    int idCan = Integer.parseInt(dataLine[2+i]);
                    if(CjtoCanciones.existsCancion(idCan)) S.add(idCan); 
                }
                Escucha e = new Escucha(id_escuchas, S);
                Usuario u = new Usuario(usuario, id_escuchas);
                ++id_escuchas;
                CjtoEscuchas.addEscucha(e);
                CjtoUsuarios.addUsuario(u);
            }
        }
    }
    
    public void cargarCancionesUsuarioFicherov2(String Filename){
        FileManager fm = new FileManager(Filename);
        ArrayList<String> l = fm.readFile();
        for (String line : l){
            String dataLine[] = line.split(":");
            String usuario = dataLine[0];
            if(CjtoUsuarios.isUsuario(usuario)){
                Usuario user = CjtoUsuarios.getUsuario(dataLine[0]);
                int idEsc = user.getIdEscuchas();
                Escucha esc = CjtoEscuchas.getEscucha(idEsc);
                Set<Integer> S = new HashSet<>(esc.getS());
                int numCan = Integer.parseInt(dataLine[1]);
                for(int i = 0; i < 2*numCan; i+=2){
                    String tit = dataLine[2+i];
                    String aut = dataLine[3+i];
                    if(CjtoCanciones.existsCancion(tit, aut)) {
                        int idCan = CjtoCanciones.retCancion(tit, aut).getId();
                        S.add(idCan);
                    } 
                }
                esc.setS(S);
            }
            else {
                Set<Integer> S = new HashSet<>();
                int numCan = Integer.parseInt(dataLine[1]);
                for(int i = 0; i < 2*numCan; i+=2){
                    String tit = dataLine[2+i];
                    String aut = dataLine[3+i];
                    if(CjtoCanciones.existsCancion(tit, aut)) {
                        int idCan = CjtoCanciones.retCancion(tit, aut).getId();
                        S.add(idCan);
                    } 
                }
                Escucha e = new Escucha(id_escuchas, S);
                Usuario u = new Usuario(usuario, id_escuchas);
                ++id_escuchas;
                CjtoEscuchas.addEscucha(e);
                CjtoUsuarios.addUsuario(u);
            }
        }
    }
    public ArrayList<Object> cargarCancionesUsuarios(String usuario){
        Usuario user = CjtoUsuarios.getUsuario(usuario);
        int id = user.getIdEscuchas();
        Escucha e = CjtoEscuchas.getEscucha(id);
        ArrayList<Integer> ids = (ArrayList) e.getListCanciones();
        ArrayList<Object> res = new ArrayList<>();
        for(int can: ids){
            if(CjtoCanciones.existsCancion(can)){
                Cancion c = CjtoCanciones.getCancion(can);
                String Estilos1 = "";
                Set<String> Estilos = c.getEstilo();
                Iterator iter = Estilos.iterator();
                ArrayList<String> es = new ArrayList<>();
                while (iter.hasNext()) {
                    es.add((String) iter.next());
                }
                for (int i = 0; i < es.size()-1; ++i){
                    Estilos1 += es.get(i) + ",";
                }
                Estilos1 += es.get(es.size()-1);
                Object obj[] = {c.getTitulo(), c.getAutor(), c.getAlbum(), c.getAnyo(), Estilos1};
                res.add(obj);
            }
        }
        return res;
    }

    public ArrayList<Object> CargarCanTab2(){
        
        ArrayList<Cancion> songs = CjtoCanciones.getAll();
        ArrayList<Object> res = new ArrayList<>();
        for(Cancion c: songs){
            String Estilos1 = "";
            Set<String> Estilos = c.getEstilo();
            Iterator iter = Estilos.iterator();
            //int cont = 0;
            ArrayList<String> es = new ArrayList<>();
            while (iter.hasNext()) {
                es.add((String) iter.next());
            }
            for (int i = 0; i < es.size()-1; ++i){
                Estilos1 += es.get(i) + ",";
            }
            Estilos1 += es.get(es.size()-1);
            Object obj[] = {c.getTitulo(), c.getAutor(), c.getAlbum(), c.getAnyo(), Estilos1};
            res.add(obj);
        }
        return res;
    }
    
    public ArrayList<Object> cargarCancionBuscador(String tit, String aut){
        ArrayList<Cancion> songs = CjtoCanciones.getAll();
        ArrayList<Object> res = new ArrayList<>();
        for(Cancion c: songs){
            String titulo = c.getTitulo();
            String autor = c.getAutor();
            if(titulo.toLowerCase().contains(tit.toLowerCase()) && autor.toLowerCase().contains(aut.toLowerCase())){
                String Estilos1 = "";
                Set<String> Estilos = c.getEstilo();
                Iterator iter = Estilos.iterator();
                ArrayList<String> es = new ArrayList<>();
                while (iter.hasNext()) {
                    es.add((String) iter.next());
                }
                for (int i = 0; i < es.size()-1; ++i){
                    Estilos1 += es.get(i) + ",";
                }
                Estilos1 += es.get(es.size()-1);
                Object obj[] = {titulo, autor, c.getAlbum(), c.getAnyo(), Estilos1};
                res.add(obj);
            }
        }
        return res;
    
    }
    
    public ArrayList<Object> cargarCancionBuscador2(String type, String value){
        ArrayList<Cancion> songs = CjtoCanciones.getAll();
        ArrayList<Object> res = new ArrayList<>();
        switch(type){
            case "Titulo":
                for(Cancion c: songs){
                    if(c.getTitulo().toLowerCase().contains(value.toLowerCase())){
                        String Estilos1 = "";
                        Set<String> Estilos = c.getEstilo();
                        Iterator iter = Estilos.iterator();
                        ArrayList<String> es = new ArrayList<>();
                        while (iter.hasNext()) {
                            es.add((String) iter.next());
                        }
                        for (int i = 0; i < es.size()-1; ++i){
                            Estilos1 += es.get(i) + ",";
                        }
                        Estilos1 += es.get(es.size()-1);
                        Object obj[] = {c.getTitulo(), c.getAutor(), c.getAlbum(), c.getAnyo(), Estilos1};
                        res.add(obj);
                    }
                }
                break; 
            case "Autor":
                for(Cancion c: songs){
                    if(c.getAutor().toLowerCase().contains(value.toLowerCase())){
                        String Estilos1 = "";
                        Set<String> Estilos = c.getEstilo();
                        Iterator iter = Estilos.iterator();
                        ArrayList<String> es = new ArrayList<>();
                        while (iter.hasNext()) {
                            es.add((String) iter.next());
                        }
                        for (int i = 0; i < es.size()-1; ++i){
                            Estilos1 += es.get(i) + ",";
                        }
                        Estilos1 += es.get(es.size()-1);
                        Object obj[] = {c.getTitulo(), c.getAutor(), c.getAlbum(), c.getAnyo(), Estilos1};
                        res.add(obj);
                    }
                }
                break;
            case "Album":
                for(Cancion c: songs){
                    if(c.getAlbum().toLowerCase().contains(value.toLowerCase())){
                        String Estilos1 = "";
                        Set<String> Estilos = c.getEstilo();
                        Iterator iter = Estilos.iterator();
                        ArrayList<String> es = new ArrayList<>();
                        while (iter.hasNext()) {
                            es.add((String) iter.next());
                        }
                        for (int i = 0; i < es.size()-1; ++i){
                            Estilos1 += es.get(i) + ",";
                        }
                        Estilos1 += es.get(es.size()-1);
                        Object obj[] = {c.getTitulo(), c.getAutor(), c.getAlbum(), c.getAnyo(), Estilos1};
                        res.add(obj);
                    }
                }
                break;
            case "Año":
                for(Cancion c: songs){
                    if(Integer.toString(c.getAnyo()).toLowerCase().contains(value.toLowerCase())){
                        String Estilos1 = "";
                        Set<String> Estilos = c.getEstilo();
                        Iterator iter = Estilos.iterator();
                        ArrayList<String> es = new ArrayList<>();
                        while (iter.hasNext()) {
                            es.add((String) iter.next());
                        }
                        for (int i = 0; i < es.size()-1; ++i){
                            Estilos1 += es.get(i) + ",";
                        }
                        Estilos1 += es.get(es.size()-1);
                        Object obj[] = {c.getTitulo(), c.getAutor(), c.getAlbum(), c.getAnyo(), Estilos1};
                        res.add(obj);
                    }
                }
                break;
            default:
                for(Cancion c: songs){
                        String Estilos1 = "";
                        Set<String> Estilos = c.getEstilo();
                        Iterator iter = Estilos.iterator();
                        ArrayList<String> es = new ArrayList<>();
                        while (iter.hasNext()) {
                            es.add((String) iter.next());
                        }
                        for (int i = 0; i < es.size()-1; ++i){
                            Estilos1 += es.get(i) + ",";
                        }
                        Estilos1 += es.get(es.size()-1);
                        Object obj[] = {c.getTitulo(), c.getAutor(), c.getAlbum(), c.getAnyo(), Estilos1};
                        res.add(obj);
                }
                break;
                        
        }
                
        for(Cancion c: songs){
         
        }
        return res;
    
    }
    
    public boolean JaEstaTaulaConj(String conj, String Titulo, String Autor, DefaultTableModel model){
        int rowSize = model.getRowCount();
        for (int i = 0; i < rowSize; ++i){
            String conj1 = model.getValueAt(i,0).toString();
            if (conj1.equals(conj)) {
                String Titulo1 = model.getValueAt(i,1).toString();
                String Autor1 = model.getValueAt(i,2).toString();
                if(Titulo1.equals(Titulo) && Autor1.equals(Autor)) return true;
            }
        }
        return false;
    }
    
    public void eliminarConjuntosVacios() {
        ArrayList<ArrayList<Integer>> v = CjtoComunidades.getResult(); //Recogemos los conjuntos calculados
        for (int i = 0; i < v.size(); i++) {    //Eliminamos conjuntos vacios
            if (v.get(i).isEmpty()) {
                v.remove(i);
                i--;
            }
        }
        CjtoComunidades.setResult(v); //Actualizamos los cambios
    }
    
    public ArrayList<Object> ConvertirConjTab(){
        eliminarConjuntosVacios();
        ArrayList<ArrayList<Integer>> v = CjtoComunidades.getResult(); //Recogemos los conjuntos a mostrar
        ArrayList<Object> res = new ArrayList<>();   // Ahora toca transformar cada idCancion a sus atributos
        res.add(v.size());
        for (int i = 0; i < v.size(); i++)  {  // Conjunto i..
            for (int j = 0; j < v.get(i).size(); j++) { // Cancion i.j i.j+1 i.j+2...
                if (CjtoCanciones.existsCancion(v.get(i).get(j))) {
                    Cancion c = new Cancion();
                    c = CjtoCanciones.getCancion(v.get(i).get(j));
                    //Set<String> est = new HashSet<>();
                    //est.add("Estilo1");
                    //est.add("Estilo2");
                    //Cancion c = new Cancion(99, "Titulo", "Autor", "Album", 1900, est);

                    String titulo = c.getTitulo();
                    String autor = c.getAutor();
                    String album = c.getAlbum();
                    String ano = Integer.toString(c.getAnyo());
                    Set<String> estilos = c.getEstilo();
                    String estilo = "";
                    Boolean first = true;
                    for (String s : estilos) {
                        if (first) {
                            first = false;
                            estilo = s;
                        }
                        else {
                            estilo = estilo + "," + s;
                        }
                    }
                    //Object o[] = {Integer.toString(i),Integer.toString(v.get(i).get(j)),titulo,autor,album,ano,estilo};
                    Object o[] = {Integer.toString(i),titulo,autor,album,ano,estilo};
                    res.add(o);
                }
            }
        }
        return res;
    }
    
    public void CargarConjTab(String path){
        FileManager fm = new FileManager(path); //Se abre el archivo "path"
        ArrayList<String> l = fm.readFile();    //Se guarda el contenido en "l"
        ArrayList<ArrayList<Integer>> v = new ArrayList<>();
        for (String line : l){  //Por cada linea de "l"...
            String dataLine[] = line.split(":");    //Convertimos la linea en un Array
            ArrayList<Integer> aux = new ArrayList<>();
            
            for (int i = 1; i < (dataLine.length)-1; i += 2)
                if (CjtoCanciones.existsCancion(dataLine[i], dataLine[i+1]))
                    aux.add(CjtoCanciones.retCancion(dataLine[i], dataLine[i+1]).getId()); //Metemos cada posicion del Array en "aux"
            
            v.add(aux); //Tenemos los idCancion del conjunto "line", lo metemos en el conjunto "v"
        }
        CjtoComunidades.setResult(v);   //Actualizamos la solucion del grafo por la que acabamos de leer
    }
    
    public void GuardarConjTab(String path){
        eliminarConjuntosVacios();
        FileManager fm2 = new FileManager(path);
        ArrayList<String> l2 = new ArrayList<>();
        String linia = new String();
        ArrayList< ArrayList<Integer> > res = CjtoComunidades.getResult();
        for (int c = 0; c < res.size(); c++) {
            linia = "Conjunto " + c;
            for (Integer idCancion: res.get(c)) {
                linia += ":" + CjtoCanciones.getCancion(idCancion).getTitulo();
                linia += ":" + CjtoCanciones.getCancion(idCancion).getAutor();
            }
            l2.add(linia);
            linia = new String();
        }
        fm2.writeFile(l2);
    }
    
    public void eliminarCancionDelConjunto(String conj, String titulo, String autor) {
        if (CjtoCanciones.existsCancion(titulo, autor)) {
            int c = Integer.parseInt(conj);
            Integer id = CjtoCanciones.retCancion(titulo, autor).getId();
            ArrayList<ArrayList<Integer>> res = CjtoComunidades.getResult();
            res.get(c).remove(id);
            CjtoComunidades.setResult(res);
        }
    }
    
    public void moverCancionDeConjunto(String conj_orig, String conj_dest, String titulo, String autor) {
        if (CjtoCanciones.existsCancion(titulo, autor)) {
            int co = Integer.parseInt(conj_orig);
            int cd = Integer.parseInt(conj_dest);
            Integer id = CjtoCanciones.retCancion(titulo, autor).getId();
            ArrayList<ArrayList<Integer>> res = CjtoComunidades.getResult();
            res.get(co).remove(id);
            res.get(cd).add(id);
            CjtoComunidades.setResult(res);
        }
    }
    
    public void copiarCancionAConjunto(String conj_dest, String titulo, String autor) {
        if (CjtoCanciones.existsCancion(titulo, autor)) {
            int cd = Integer.parseInt(conj_dest);
            Integer id = CjtoCanciones.retCancion(titulo, autor).getId();
            ArrayList<ArrayList<Integer>> res = CjtoComunidades.getResult();
            res.get(cd).add(id);
            CjtoComunidades.setResult(res);
        }
    }
}
