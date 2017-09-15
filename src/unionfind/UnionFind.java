/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionfind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author renecsc
 */
public class UnionFind {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        File file = new File("largeUF.txt");
        
        UnionFind uf = new UnionFind();
        
        uf.ejecutarQuickFind(file);
        uf.ejecutarQuickUnion(file);
    }
    
    public UnionFind(){
        
    }
    
    public void ejecutarQuickUnion(File file) throws FileNotFoundException{
        
        int n = 1;
        while(n <= Math.pow(2, 20)){
            long totalTime = 0;
            long startTime = System.currentTimeMillis();
            
            Scanner sc = new Scanner(file);
            
            int size = sc.nextInt();
            QuickUnion qu = new QuickUnion(size);
            
            int i = 0;
            while(i < n){
                int p = sc.nextInt();
                int q = sc.nextInt();
                
                if(!qu.connected(p, q)){
                    qu.union(p, q);
                    System.out.println(p + " " + q);
                }
                i+=2;
            }
            totalTime = System.currentTimeMillis()-startTime;
            System.out.println("Tiempo con N = " + n + ": " + totalTime);
            n = n*2;
        }
    }
    
    public void ejecutarQuickFind(File file) throws FileNotFoundException{
        int n = 1;
        while(n <= Math.pow(2, 20)){
            long totalTime = 0;
            long startTime = System.currentTimeMillis();
            
            Scanner sc = new Scanner(file);
            
            int size = sc.nextInt();
            QuickFind qf = new QuickFind(size);
            
            int i = 0;
            while(i < n){
                int p = sc.nextInt();
                int q = sc.nextInt();
                
                if(!qf.connected(p, q)){
                    qf.union(p, q);
                    System.out.println(p + " " + q);
                }
                i+=2;
            }
            totalTime = System.currentTimeMillis()-startTime;
            System.out.println("Tiempo con N = " + n + ": " + totalTime);
            n = n*2;
        }
    }
}
