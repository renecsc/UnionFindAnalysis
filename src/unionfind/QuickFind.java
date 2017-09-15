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
public class QuickFind extends UF{

    public QuickFind(int N) {
        super(N);
    }    

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        
        for(int i = 0; i < this.id.length; i++){
            if(this.id[i] == pid){
                id[i] = qid;
            }
        }
    }
    

}
