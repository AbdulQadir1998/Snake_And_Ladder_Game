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
public class Board {
    
    private  Cell[][] cells;
    int size;

    public Board(int s) {
        this.size=s;
        this.cells=new Cell[this.size][];
        for(int i=0;i<this.size;i++)
        {
            this.cells[i]=new Cell[this.size];
            for(int j=0;j<this.size;j++)
            {
                this.cells[i][j]=new Cell();
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void generateObjects(){
        int len=(this.size+this.size)-2;
        int per;
        int count=0,pos,index1,index2;
        //Sword
        while(count!=1)
        {
            pos=(int) (Math.random() * ((this.size*this.size)-2))+1;
            index1=pos/this.size;
            index2=pos%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().setSword(true);
                this.cells[index1][index2].setCh('/');
                count++;
            } 
        }
        //Sheild
        count=0;
        while(count!=1)
        {
            pos=(int) (Math.random() * ((this.size*this.size)-2))+1;
            index1=pos/this.size;
            index2=pos%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().setSheild(true);
                this.cells[index1][index2].setCh('X');
                count++;
            } 
        }
        per=(len*10)/100;
        //Diamonds
        count=0;
        while(count<per)
        {
            pos=(int) (Math.random() * ((this.size*this.size)-2))+1;
            index1=pos/this.size;
            index2=pos%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().setDiamonds(true);
                this.cells[index1][index2].setCh('D');
                count++;
            } 
        }
        //Prisoncells
        count=0;
        while(count<per)
        {
            pos=(int) (Math.random() * ((this.size*this.size)-2))+1;
            index1=pos/this.size;
            index2=pos%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().setPrisonCell(true);
                this.cells[index1][index2].setCh('P');
                count++;
            } 
        }
        per=(len*20)/100;
        //Goldcoins
        count=0;
        while(count<per)
        {
            pos=(int) (Math.random() * ((this.size*this.size)-2))+1;
            index1=pos/this.size;
            index2=pos%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().setGoldCoins(true);
                this.cells[index1][index2].setCh('G');
                count++;
            } 
        }
        //Silvercoins
        count=0;
        while(count<per)
        {
            pos=(int) (Math.random() * ((this.size*this.size)-2))+1;
            index1=pos/this.size;
            index2=pos%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().setSilverCoins(true);
                this.cells[index1][index2].setCh('S');
                count++;
            }
        }
        //Snake
        count=0;
        int index3,index4,pos1;
        while(count<per)
        {
            pos=(int) (Math.random() * (((this.size*this.size)/2)-2))+(((this.size*this.size)/2)+1);
            index1=pos/this.size;
            index2=pos%this.size;
            pos1=(int) (Math.random() * ((this.size*this.size)/2))+1;
            index3=pos1/this.size;
            index4=pos1%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true 
                    && this.cells[index3][index4].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().getSnake().setSnakeHead(pos);
                this.cells[index1][index2].getObjects().getSnake().setSnakeTail(pos1);
                this.cells[index1][index2].setCh('@');
                this.cells[index3][index4].setCh('~');
                count++;
            } 
        }
        //Ladder
        count=0;
        while(count<per)
        {
            pos=(int) (Math.random() * ((this.size*this.size)/2))+1;
            index1=pos/this.size;
            index2=pos%this.size;
            pos1=(int) (Math.random() * (((this.size*this.size)/2)-2))+(((this.size*this.size)/2)+1);
            index3=pos1/this.size;
            index4=pos1%this.size;
            if(this.cells[index1][index2].getObjects().checkAvailaibility_ofObjects()==true 
                    && this.cells[index3][index4].getObjects().checkAvailaibility_ofObjects()==true)
            {
                this.cells[index1][index2].getObjects().getLadder().setLadderHead(pos);
                this.cells[index1][index2].getObjects().getLadder().setLadderTail(pos1);
                this.cells[index1][index2].setCh('H');
                this.cells[index3][index4].setCh('L');
                count++;
            } 
        }
    }
}
