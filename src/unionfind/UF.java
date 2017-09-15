/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unionfind;

/**
 *
 * @author renecsc
 */
public abstract class UF {
    protected int[] id;
    
    public UF(int N){
        this.id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    abstract public int find(int p); 
    
    abstract public void union(int p, int q);    
    
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
}
