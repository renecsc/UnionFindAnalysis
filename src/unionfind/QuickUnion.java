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
public class QuickUnion extends UF{

    public QuickUnion(int N) {
        super(N);
    }

    @Override
    public int find(int p) {
        while (p != this.id[p]){
            p = this.id[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        this.id[i] = j;
    }


    
}
