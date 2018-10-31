package GestionDatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex Cuello
 */
public class FileManager
{
    private File file = null;
    private boolean canRead = false;
    private boolean canWrite = false;
    private boolean isFile = false;
    
    public FileManager(){}
    /**
     * Comprovamos que se pueda leer o escribir de un fichero con la ruta del parametro
     * @param path 
     */
    public FileManager(String path)
    {
        file = new File(path);
        this.canRead = file.canRead();
        this.canWrite = file.canWrite();
        this.isFile = file.isFile();
    }
    
    /**
     * Escribimos en un fichero un array de strings
     * @param data
     * @return 
     */
    public boolean writeFile(ArrayList<String> data)
    {
        boolean result = false;
        if(file != null && this.isFile && this.canWrite)
        {
            try
            {
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.flush();
                for(String s : data)
                {
                    bw.write(s);
                    bw.newLine();
                }
                bw.close();
                fw.close();
                result = true;
            }
            catch(IOException ex)
            {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;
    }
    
    /**
     * Leemos de un fichero
     * @return devolvemos un array de strings con el contenido del fichero
     */
    public ArrayList<String> readFile()
    {
        ArrayList<String> listString = new ArrayList<>();
        if(file != null && this.isFile && this.canRead)
        {
            try
            {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line = br.readLine()) != null)
                {
                    listString.add(line);
                }
                br.close();
                fr.close();
            }
            catch(IOException ex)
            {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listString;
    }
    
    /**
     * Configuramos la disponiblidad de lectura o escritura del fichero del parametro
     * @param path 
     */
    public void setPath(String path)
    {
        file = new File(path);
        this.canRead = file.canRead();
        this.canWrite = file.canWrite();
        this.isFile = file.isFile();
    }
    
    
    public String getPath()
    {
        return null;
    }
}
