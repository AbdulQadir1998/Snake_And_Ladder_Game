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
public class Ladder {
    
    private int ladderHead;
    private int ladderTail;

    public Ladder() {
        this.ladderHead=-1;
        this.ladderTail=-1;
    }

    public Ladder(int ladderHead, int ladderTail) {
        this.ladderHead = ladderHead;
        this.ladderTail = ladderTail;
    }

    public int getLadderHead() {
        return ladderHead;
    }

    public void setLadderHead(int ladderHead) {
        this.ladderHead = ladderHead;
    }

    public int getLadderTail() {
        return ladderTail;
    }

    public void setLadderTail(int ladderTail) {
        this.ladderTail = ladderTail;
    }
    
    
}
