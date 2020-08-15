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
public class Bag {
    
    private int DC;
    private int GC;
    private int SC;
    private boolean sword;
    private boolean shield;

    public Bag() {
        this.DC=0;
        this.GC=0;
        this.SC=0;
        this.shield=false;
        this.sword=false;
    }

    public Bag(int DC, int GC, int SC, boolean sword, boolean shield) {
        this.DC = DC;
        this.GC = GC;
        this.SC = SC;
        this.sword = sword;
        this.shield = shield;
    }

    public int getDC() {
        return DC;
    }

    public void setDC(int DC) {
        this.DC = DC;
    }

    public int getGC() {
        return GC;
    }

    public void setGC(int GC) {
        this.GC = GC;
    }

    public int getSC() {
        return SC;
    }

    public void setSC(int SC) {
        this.SC = SC;
    }

    public boolean isSword() {
        return sword;
    }

    public void setSword(boolean sword) {
        this.sword = sword;
    }

    public boolean isShield() {
        return shield;
    }

    public void setShield(boolean shield) {
        this.shield = shield;
    }
    
    public void addDiamonds(int dc){
        this.DC=this.DC+dc;
    }
    public void subDiamonds(int dc){
        this.DC=this.DC-dc;
    }
    public void addGoldcoins(int gc){
        this.GC=this.GC+gc;
    }
    public void subGoldcoins(int gc){
        this.GC=this.GC-gc;
    }
    public void addSilvercoins(int gc){
        this.SC=this.SC+gc;
    }
    public void subSilvercoins(int gc){
        this.SC=this.SC-gc;
    }
}
