package archivos;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.io.*;
import javax.swing.JFileChooser;

public class archi {
    File doc=new File("si.txt");
    Scanner tec=new Scanner(System.in);
    int opcion=0, i=0;
    String respuesta="", palabra="";
    
    public void menu(){
        do{
            System.out.println("1. Crear archivo");
            System.out.println("2. Guardar en archivo");
            System.out.println("3. Buscar en el archivo");
            System.out.println("4. Leer el archivo");
            System.out.println("5. Actualizar el archivo");
            System.out.println("6. Eliminar archivo");
            System.out.println("7. Eliminar en el archivo");
            System.out.println("8. Salir");
            opcion=tec.nextInt();
            switch(opcion){
                case 1:
                    creararchivo();
                    break;
                case 2:
                    guardarenarchivo();
                    break;
                case 3:
                    buscarenarchivo();
                    break;
                case 4:
                    leerarchivo();
                    menu();
                    break;
                case 5:
                    actualizarenelarchivo();
                    break;
                case 6:
                    eliminararchivo();
                    menu();
                    break;
                case 7:
                    eliminarenarchivo();
                    break;
                case 8:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            
        }while(opcion!=8);
    }
    
    private void creararchivo(){
        if(doc.exists()==true){
            System.out.println("El archivo sí existe");
        }else{
            System.out.println("El archivo de creará");
            try{
                doc.createNewFile();
            }catch(IOException e){
                System.out.println(e);
            }
        }
        
        menu();
        
    }

    private void guardarenarchivo() {
        try {
            FileWriter escribir=new FileWriter(doc, true);
            PrintWriter linea=new PrintWriter(escribir);
            linea.println(tec.next());
            linea.println("Hola");
            linea.println("Hola 3");
            linea.close();
            escribir.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        menu();
    }

    private void buscarenarchivo() {
        Scanner entrada=null;
        String linea;
        int nodelinea=1;
        boolean contiene=false;
        String matriz[][];
        int j=0;
        
        
        System.out.println("Ingrese su busqueda: ");
        String texto=tec.next();
        
        try{
            entrada=new Scanner(doc);
            while(entrada.hasNext()){
                j++;
            }
            matriz=new String[j][0];
            
            while(entrada.hasNext()){
                i++;
                linea=entrada.next();
                if(linea.contains(texto)){
                    
                    contiene=true;
                }
                nodelinea++;
                
                if(!contiene){
                matriz[i][0]=linea;
            }
            }
            eliminararchivo();
            creararchivo();
            
            FileWriter escribir=new FileWriter(doc,true);
            PrintWriter lineaw=new PrintWriter(escribir);
            
            for(int y=0;y<i;y++){
                lineaw.println(matriz[y][0]);
            }
            escribir.close();
            
            
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }catch(NullPointerException e){
            System.out.println(e.toString()+"No se ha seleccionado ningun archivo");
        }catch(Exception e){
            System.out.println(e.toString());
        } finally{
            if(entrada!=null){
                entrada.close();
            }
        
        }
        
        
        
        menu();
    }

    private void leerarchivo() {
        String cadena="";
        try {
            FileReader leer=new FileReader(doc);
            BufferedReader almacena=new BufferedReader(leer);
            while(cadena!=null){
                cadena=almacena.readLine();
                System.out.println(cadena);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }

    private void actualizarenelarchivo() {
        menu();
    }

    private void eliminararchivo() {
        if(doc.exists()){
            System.out.println("El archivo se ha borrado");
            try{
                doc.delete();
            }catch(Exception e){
                System.out.println(e);
            }
        
        }else{
            System.out.println("El archivo no existe");
        }       
       
        
    }
    
    private void eliminarenarchivo(){
        leerarchivo();
        String matriz[][];
        int j=0;
        
        System.out.println("Escribe la línea que deseas eliminar");
        String eliminar="";
             eliminar=tec.next();
        
        try{
            BufferedReader br=new BufferedReader (new FileReader("hola.txt"));
            while((br.readLine())!=null){
                j++;
            }
            matriz=new String[j][1];
            
            while((respuesta=br.readLine())!=null){
                i++;
                if(respuesta==eliminar){
                    System.out.println("a");
                }else{
                    matriz[i][0]=respuesta;
                }          
                  
                 
                    
                
            }
            eliminararchivo();
                    creararchivo();
                     try {
            FileWriter escribir=new FileWriter(doc, true);
            PrintWriter linea=new PrintWriter(escribir);
            for(int y=0; y<i;y++){
                linea.println(matriz[y][0]);
            }
           
            escribir.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
            
        }catch(Exception e){
            System.out.println(""+e);
        }
        menu();        
    }
    
    private void elim(){
        Scanner entrada=null;
        String linea;
        leerarchivo();
        String matriz[][];
        boolean contiene=false;
        int j=0;
        
        System.out.println("Escribe la linea que quieres eliminar");
        String eliminar=tec.next();
        
        try{
            entrada=new Scanner(doc);
            while(entrada.hasNext()){
                j++;
            }
            
            matriz=new String[j][0];
            while(entrada.hasNext()){
                i++;
                linea=entrada.nextLine();
                if(linea.contains(eliminar)){
                    
                }else{
                    matriz[i][0]=linea;
                }
               
            }
            
            
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }catch(NullPointerException e){
            System.out.println(e.toString()+"No se ha seleccionado ningun archivo");
        }catch(Exception e){
            System.out.println(e.toString());
        } finally{
            if(entrada!=null){
                entrada.close();
            }
        
        }
        eliminararchivo();
            creararchivo();
             try {
                 matriz=new String[i][0];
            FileWriter escribir=new FileWriter(doc, true);
            PrintWriter lineaw=new PrintWriter(escribir);
            for(int y=0; y<i;y++){
                lineaw.println(matriz[y][0]);
            }
           
            lineaw.close();
            escribir.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        menu();
    }
    
    public void eea(){
        Scanner entrada=null;
        String linea;
        leerarchivo();
        String matriz[][];
        boolean contiene=false;
        int j=0;
        
        System.out.println("Escribe la linea que quieres eliminar");
        String eliminar=tec.next();
        
        try{
             try{
            entrada=new Scanner(doc);
            
            while(entrada.hasNext()){
                linea=entrada.nextLine();
                if(linea.contains(eliminar)){
                    System.out.println("siu");
                    contiene=true;
                }else{
                    
                }
                
            }
            if(!contiene){
                
            }
            
        }catch (FileNotFoundException e){
            System.out.println(e.toString());
        }catch(NullPointerException e){
            System.out.println(e.toString()+"No se ha seleccionado ningun archivo");
        }catch(Exception e){
            System.out.println(e.toString());
        } finally{
            if(entrada!=null){
                entrada.close();
            }
        
        }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
}
