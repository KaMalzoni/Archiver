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

    /**
     * number of bytes
     */
    protected Long size;
    protected Integer pos;
    protected Boolean status;
    protected Integer rn;
    protected Integer quantidade;

    public Head(Long size, Integer pos, Boolean status, Integer rn, Integer quantidade) {
        this.size = size;
        this.pos = pos;
        this.status = status;
        this.rn = rn;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Integer getPos() {
        return pos;
    }

    public void setPos(Integer pos) {
        this.pos = pos;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRn() {
        return rn;
    }

    public void setRn(Integer rn) {
        this.rn = rn;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    //TODO
    public static int getHeadSize(){
        return 71;
    }
    
    public byte[] getBytes(){
        return new byte[1024]; // Fazer
    }
    
}
