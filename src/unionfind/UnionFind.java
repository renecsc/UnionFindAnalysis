/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionfind;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author renecsc
 */
public class UnionFind extends JFrame{
    private File file;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        UnionFind uf = new UnionFind();
        
        System.out.println("Ejecución de QuickFind: ");
        uf.ejecutarQuickFind();
        System.out.println("Ejecución de QuickUnion: ");
        uf.ejecutarQuickUnion();
    }
    /**
     * Constructor
     * inicia una ventana de dialogo para seleccionar el archivo a leer.
     */
    public UnionFind(){
        JFileChooser chooser = new JFileChooser();
        
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setMultiSelectionEnabled(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de uniones txt", "txt");
        
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            this.file = chooser.getSelectedFile();
        }
    }
    /**
     * metodo para ejecutar el algoritmo de QuickUnion
     * @throws FileNotFoundException 
     */
    public void ejecutarQuickUnion() throws FileNotFoundException{
        
        int n = 1;
        while(n <= Math.pow(2, 20)){
            long totalTime = 0;
            long startTime = System.currentTimeMillis();
            
            Scanner sc = new Scanner(this.file);
            
            int size = sc.nextInt();
            QuickUnion qu = new QuickUnion(size);
            
            int i = 0;
            while(i < n){
                int p = sc.nextInt();
                int q = sc.nextInt();
                
                if(!qu.connected(p, q)){
                    qu.union(p, q);
                    //System.out.println(p + " " + q);
                }
                i+=2;
            }
            totalTime = System.currentTimeMillis()-startTime;
            //totalTime = totalTime/1000;
            System.out.println("Tiempo con N = " + n + ": " + totalTime + " milisegundos");
            n = n*2;
        }
    }
    /**
     * metodo para ejecutar el algoritmo de QuickFind
     * @throws FileNotFoundException 
     */
    public void ejecutarQuickFind() throws FileNotFoundException{
        int n = 1;
        while(n <= Math.pow(2, 20)){
            long totalTime = 0;
            long startTime = System.currentTimeMillis();
            
            Scanner sc = new Scanner(this.file);
            
            int size = sc.nextInt();
            QuickFind qf = new QuickFind(size);
            
            int i = 0;
            while(i < n){
                int p = sc.nextInt();
                int q = sc.nextInt();
                
                if(!qf.connected(p, q)){
                    qf.union(p, q);
                    //System.out.println(p + " " + q);
                }
                i+=2;
            }
            totalTime = System.currentTimeMillis()-startTime;
            //totalTime = totalTime/1000;
            System.out.println("Tiempo con N = " + n + ": " + totalTime + " milisegundos");
            n = n*2;
        }
    }
}
