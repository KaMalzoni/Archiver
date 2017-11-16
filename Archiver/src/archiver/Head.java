/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver;

import java.io.Serializable;

/**
 *
 * @author Karen
 */
public class Head implements Serializable {
    
    protected String nome = new String();
    protected Integer size;
    protected Integer pos;
    protected Boolean status;
    
    protected void SetNome (String n) {
        this.nome = n;
    }
    protected void SetSize (Integer i) {
        this.size = i;
    }
    protected void SetPos (Integer i) {
        this.pos = i;
    }
    protected void SetStatus (Boolean i) {
        this.status = i;
    }
}
