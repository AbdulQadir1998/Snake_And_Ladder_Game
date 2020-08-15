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
public class Player {
    
    private int no_of_points;
    int pos;
    private boolean turn;
    private Bag bag;
    int stuck;

    public Player() {
        this.no_of_points=0;
        this.pos=-1;
        this.turn=false;
        this.bag=new Bag();
        this.stuck=3;
    }
    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getStuck() {
        return stuck;
    }

    public void setStuck(int stuck) {
        this.stuck = stuck;
    }
    
    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos =pos;
    }

    public Player(int no_of_points, Bag bag) {
        this.no_of_points = no_of_points;
        this.bag = bag;
    }

    public int getNo_of_points() {
        return no_of_points;
    }

    public void setNo_of_points(int no_of_points) {
        this.no_of_points = no_of_points;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
     public void updatePos(int pos){
         this.pos=this.pos+pos;
     }
    public void addPoints(int points){
        
        this.no_of_points=this.no_of_points+points;
    }
    public void subPoints(int points){
        this.no_of_points=this.no_of_points-points;
    }
    public void removeStuck(){
        this.stuck++;
    }
}
