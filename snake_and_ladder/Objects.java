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
public class Objects {
    
    private boolean goldCoins;
    private boolean silverCoins;
    private boolean diamonds;
    private boolean prisonCell;
    private boolean sword;
    private boolean sheild;
    private Snake snake;
    private Ladder ladder;

    public Objects() {
        this.diamonds=false;
        this.goldCoins=false;
        this.prisonCell=false;
        this.sheild=false;
        this.sword=false;
        this.silverCoins=false;
        this.snake=new Snake();
        this.ladder=new Ladder();
    }

    public boolean isGoldCoins() {
        return goldCoins;
    }

    public void setGoldCoins(boolean goldCoins) {
        this.goldCoins = goldCoins;
    }

    public boolean isSilverCoins() {
        return silverCoins;
    }

    public void setSilverCoins(boolean silverCoins) {
        this.silverCoins = silverCoins;
    }

    public boolean isDiamonds() {
        return diamonds;
    }

    public void setDiamonds(boolean diamonds) {
        this.diamonds = diamonds;
    }

    public boolean isPrisonCell() {
        return prisonCell;
    }

    public void setPrisonCell(boolean prisonCell) {
        this.prisonCell = prisonCell;
    }

    public boolean isSword() {
        return sword;
    }

    public void setSword(boolean sword) {
        this.sword = sword;
    }

    public boolean isSheild() {
        return sheild;
    }

    public void setSheild(boolean sheild) {
        this.sheild = sheild;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }
    
    public boolean checkAvailaibility_ofObjects(){
        
        return diamonds==false && goldCoins==false 
                && prisonCell==false && silverCoins==false
                && sheild==false && sword==false 
                && snake.getSnakeHead()==-1 && snake.getSnakeTail()==-1
                && ladder.getLadderHead()==-1 && ladder.getLadderTail()==-1;
    }
    
}
