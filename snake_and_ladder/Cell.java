/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_and_ladder;

/**
 *
 * @author Abdul Qadir Saifee
 */
public class Cell {
    
    private char ch;
    private Objects objects;

    public Cell() {
        ch=' ';
        this.objects=new Objects();
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }
    
    public Objects getObjects() {
        return objects;
    }

    public void setObjects(Objects objects) {
        this.objects = objects;
    }
    
    
}
