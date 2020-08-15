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
public class Snake {
    
    private int snakeHead;
    private int snakeTail;

    public Snake() {
        this.snakeHead=-1;
        this.snakeTail=-1;
    }

    public Snake(int snakeHead, int snakeTail) {
        this.snakeHead = snakeHead;
        this.snakeTail = snakeTail;
    }

    public int getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(int snakeHead) {
        this.snakeHead = snakeHead;
    }

    public int getSnakeTail() {
        return snakeTail;
    }

    public void setSnakeTail(int snakeTail) {
        this.snakeTail = snakeTail;
    }
    
    
}
