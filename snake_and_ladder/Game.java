/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_and_ladder;

import java.util.Scanner;


/**
 *
 * @author Abdul Qadir Saifee
 */
public class Game {
    
    private Board board;
    private Player p1;
    private Player p2;

    public Game(int size) {
        this.board = new Board(size);
        this.p1=new Player();
        this.p2=new Player();
    }   
    
    public void printBoard(){
        
        System.out.print("               ");
        for(int i=0;i<this.board.size;i++)
        {
            System.out.print("______");
        }
        System.out.println("");
        for(int i=this.board.size-1;i>=0;i--)
        {
            System.out.print("              | ");
            for(int j=0;j<this.board.size;j++)
            {
                System.out.print("     |");
            }
            System.out.println("");
            if(i%2==1)
            {
                System.out.print("              | ");
                for(int j=this.board.size-1;j>=0;j--)
                {
                        System.out.print(this.board.getCells()[i][j].getCh()+"    |");
                }
                System.out.println("");
                System.out.print("              | ");
                for(int j=0;j<this.board.size;j++)
                {
                    System.out.print("_____|");
                }
            }
            else if(i%2==0)
            {
                System.out.print("              | ");
                for(int j=0;j<this.board.size;j++)
                {
                    System.out.print(this.board.getCells()[i][j].getCh()+"    |");
                }
                System.out.println("");
                System.out.print("              | ");
                for(int j=0;j<this.board.size;j++)
                {
                    System.out.print("_____|");
                }
            }
            System.out.println("");
        }
    }
    
    public void Process(){
        
        int dice=0;
        int index1,index2;
        int count;
        char ch;
        boolean flag,flag1;
        String choice; 
        Scanner obj =new Scanner(System.in);
        this.p1.setTurn(true);
        this.board.generateObjects();
        while((this.p1.getPos()+3)<=96 && (this.p2.getPos()+3)<=96)
        {
            if(this.p1.isTurn()==true && this.p1.getStuck()==3)
            {
                System.out.flush();
                this.printBoard();
                dice=6;
                count=0;
                flag=false;
                flag1=true;
                if(this.p2.getStuck()<3)
                {
                    this.p2.removeStuck();
                }
                System.out.println("Saifee's turns");
                if(this.p1.getPos()!=-1)
                {
                    index1=this.p1.getPos()/this.board.size;
                    index2=this.p1.getPos()%this.board.size;
                    this.board.getCells()[index1][index2].setCh(' ');
                } 
                while(dice==6)
                {
                    dice=(int) (Math.random() * (6))+1;
                    this.p1.updatePos(dice);
                }
                System.out.println("dice "+dice);
                System.out.println(this.p1.getPos());
                index1=this.p1.getPos()/this.board.size;
                index2=this.p1.getPos()%this.board.size;
                System.out.println(index1);
                System.out.println(index2);
                if(this.board.getCells()[index1][index2].getObjects().checkAvailaibility_ofObjects()==false)
                {
                    ch=this.board.getCells()[index1][index2].getCh();
                    if(this.p2.getStuck()==3)
                    {
                        this.p1.setTurn(false);
                        this.p2.setTurn(true);
                    }                   
                    switch (ch) {
                        case '/':
                            this.p1.getBag().setSword(true);
                            this.p1.addPoints(0);
                            this.board.getCells()[index1][index2].getObjects().setSword(false);
                            this.board.getCells()[index1][index2].setCh('A');
                            System.out.println("Saifee gets a sword");
                            
                            break;
                        case 'X':
                            this.p1.getBag().setShield(true);
                            this.p1.addPoints(0);
                            this.board.getCells()[index1][index2].getObjects().setSheild(false);
                            this.board.getCells()[index1][index2].setCh('A');
                            System.out.println("Saifee gets a shield");
                            
                            break;
                        case 'D':
                            this.p1.getBag().addDiamonds(1);
                            this.p1.addPoints(50);
                            this.board.getCells()[index1][index2].getObjects().setDiamonds(false);
                            this.board.getCells()[index1][index2].setCh('A');
                            System.out.println("Saifee gets a diamond");
                            
                            break;
                        case 'G':
                            this.p1.getBag().addGoldcoins(1);
                            this.p1.addPoints(10);
                            this.board.getCells()[index1][index2].getObjects().setGoldCoins(false);
                            this.board.getCells()[index1][index2].setCh('A');
                            System.out.println("Saifee gets a gold coin");
                            
                            break;
                        case 'S':
                            this.p1.getBag().addSilvercoins(2);
                            this.p1.addPoints(10);
                            this.board.getCells()[index1][index2].getObjects().setSilverCoins(false);
                            this.board.getCells()[index1][index2].setCh('A');
                            System.out.println("Saifee gets a silver coin");
                           
                            break;
                            //ladder
                        case 'H':
                            this.p1.setPos(this.board.getCells()[index1][index2].getObjects().getLadder().getLadderTail());
                            System.out.println("saifee reaches through ladder");
                            break;
                        case '@':
                            System.out.println("Snake appears");
                            while(count<3)
                            {
                                if(this.p1.getBag().getGC()>=3 && count==0)
                                {
                                    System.out.println("You can use gold coins to avoid from snake");
                                    flag=true;
                                }
                                else if(this.p1.getBag().getSC()>=6 && count==1)
                                {
                                    System.out.println("You can use silver coins to avoide from snake");
                                    flag=true;
                                }
                                else if(this.p1.getBag().isSword()==true && count==2)
                                {
                                    System.out.println("You can use sword to kill the snake");
                                    flag=true;
                                }
                                count++;
                            }
                            if(flag==true)
                            {
                                while(flag1==true)
                                {
                                   System.out.println("Enetr choice '/' 'S' 'G'");
                                   choice=obj.next();
                                    if(choice.compareTo("/")==0)
                                    {
                                        if(this.p1.getBag().isSword()==true)
                                        {
                                            System.out.println("you have used sword");
                                            this.board.getCells()[index1][index2].getObjects().setSnake(null);
                                            this.p1.getBag().setSword(false);
                                            this.board.getCells()[index1][index2].setCh('A');
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have Sword");
                                        }
                                    }
                                    else if(choice.compareTo("G")==0)
                                    {
                                        if(this.p1.getBag().getGC()>=3)
                                        {
                                            System.out.println("you used gold coins");
                                            this.p1.getBag().subGoldcoins(3);
                                            this.p1.subPoints(30);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have enough Gold coins");
                                        }
                                    }
                                    else if(choice.compareTo("S")==0)
                                    {
                                        if(this.p1.getBag().getSC()>=6)
                                        {
                                            System.out.println("you used silver coins");
                                            this.p1.getBag().subSilvercoins(6);
                                            this.p1.subPoints(30);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have enough silver coins");
                                        }
                                    }
                                    else{
                                        System.out.println("Enter valid choice...");
                                    }
                                }
                            }
                            else if(flag==false)
                            {
                                this.p1.setPos(this.board.getCells()[index1][index2].getObjects().getSnake().getSnakeTail());
                                System.out.println("you reaches through snake");
                            }
                            break;
                        case 'P':
                            
                            System.out.println("Prison cell appears");
                            while(count<2)
                            {
                                if(this.p1.getBag().getDC()>=1 && count==0)
                                {
                                    System.out.println("You can use diamond coin to avoid from snake");
                                    flag=true;
                                }
                                else if(this.p1.getBag().isShield()==true && count==1)
                                {
                                    System.out.println("You can use shield to avoid from prison");
                                    flag=true;
                                }
                                count++;
                            }
                            if(flag==true)
                            {
                                while(flag1==true)
                                {
                                    System.out.println("Enetr choice 'X' 'D' ");
                                    choice=obj.next();
                                    if(choice.compareTo("X")==0)
                                    {
                                        if(this.p1.getBag().isShield()==true)
                                        {
                                            System.out.println("you have used shield");
                                            this.p1.getBag().setShield(false);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have Shield");
                                        }
                                    }
                                    else if(choice.compareTo("D")==0)
                                    {
                                        if(this.p1.getBag().getDC()>=1)
                                        {
                                            System.out.println("you used a diamond");
                                            this.p1.getBag().subDiamonds(1);
                                            this.p1.subPoints(50);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have enough diamonds");
                                        }
                                    }
                                }
                            }
                            else if(flag==false)
                            {
                                this.p1.setStuck(0);
                            }
                            break;
                        default:
                            break;   
                    }
                }
                else
                {
                    this.board.getCells()[index1][index2].setCh('A');
                    if(this.p2.getStuck()==3)
                    {
                        this.p1.setTurn(false);
                        this.p2.setTurn(true);
                    } 
                }
            }
            else if(this.p2.isTurn()==true && this.p2.getStuck()==3)
            {
                System.out.flush();
                this.printBoard();
                dice=6;
                count=0;
                flag=false;
                flag1=true;
                if(this.p1.getStuck()<3)
                {
                    this.p1.removeStuck();
                }
                System.out.println("wajaht turns");
                if(this.p2.getPos()!=-1)
                {
                    index1=this.p2.getPos()/this.board.size;
                    index2=this.p2.getPos()%this.board.size;
                    this.board.getCells()[index1][index2].setCh(' ');
                } 
                while(dice==6)
                {
                   
                    dice=(int) (Math.random() * (6))+1;
                    this.p2.updatePos(dice);
                }
                System.out.println("dice "+dice);
                System.out.println(this.p2.getPos());
                index1=this.p2.getPos()/this.board.size;
                index2=this.p2.getPos()%this.board.size;
                System.out.println(index1);
                System.out.println(index2);
                if(this.board.getCells()[index1][index2].getObjects().checkAvailaibility_ofObjects()==false)
                {
                    ch=this.board.getCells()[index1][index2].getCh();
                    if(this.p1.getStuck()==3)
                    {
                         this.p2.setTurn(false);
                         this.p1.setTurn(true);
                    }
                    switch (ch) {
                        case '/':
                            this.p2.getBag().setSword(true);
                            this.p2.addPoints(0);
                            this.board.getCells()[index1][index2].getObjects().setSword(false);
                            this.board.getCells()[index1][index2].setCh('W');
                            System.out.println("wajaht gets a sword");
                            break;
                        case 'X':
                            this.p2.getBag().setShield(true);
                            this.p2.addPoints(0);
                            this.board.getCells()[index1][index2].getObjects().setSheild(false);
                            this.board.getCells()[index1][index2].setCh('W');
                            System.out.println("wajaht gets a shiled");
                            break;
                        case 'D':
                            this.p2.getBag().addDiamonds(1);
                            this.p2.addPoints(50);
                            this.board.getCells()[index1][index2].getObjects().setDiamonds(false);
                            this.board.getCells()[index1][index2].setCh('W');
                            System.out.println("wajaht gets a diamond");
                            break;
                        case 'G':
                            this.p2.getBag().addGoldcoins(1);
                            this.p2.addPoints(10);
                            this.board.getCells()[index1][index2].getObjects().setGoldCoins(false);
                            this.board.getCells()[index1][index2].setCh('W');
                            System.out.println("wajaht gets a gold coin ");
                            break;
                        case 'S':
                            this.p2.getBag().addSilvercoins(1);
                            this.p2.addPoints(5);
                            this.board.getCells()[index1][index2].getObjects().setSilverCoins(false);
                            this.board.getCells()[index1][index2].setCh('W');
                            System.out.println("wajaht gets a silver coin");
                            break;
                            //ladder
                        case 'H':
                            this.p2.setPos(this.board.getCells()[index1][index2].getObjects().getLadder().getLadderTail());
                            System.out.println("wajaht reaches through ladder");
                            break;
                        case '@':
                            System.out.println("Snake appears");
                            while(count<3)
                            {
                                if(this.p2.getBag().getGC()>=3 && count==0)
                                {
                                    System.out.println("You can use gold coins to avoid from snake");
                                    flag=true;
                                }
                                else if(this.p2.getBag().getSC()>=6 && count==1)
                                {
                                    System.out.println("You can use silver coins to avoide from snake");
                                    flag=true;
                                }
                                else if(this.p2.getBag().isSword()==true && count==2)
                                {
                                    System.out.println("You can use sword to kill the snake");
                                    flag=true;
                                }
                                count++;
                            }
                            if(flag==true)
                            {
                                while(flag1==true)
                                {
                                   System.out.println("Enetr choice '/' 'S' 'G'");
                                   choice=obj.next();
                                    if(choice.compareTo("/")==0)
                                    {
                                        if(this.p2.getBag().isSword()==true)
                                        {
                                            System.out.println("you have used a sword");
                                            this.board.getCells()[index1][index2].getObjects().setSnake(null);
                                            this.p2.getBag().setSword(false);
                                            this.board.getCells()[index1][index2].setCh('A');
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have Sword");
                                        }
                                    }
                                    else if(choice.compareTo("G")==0)
                                    {
                                        if(this.p2.getBag().getGC()>=3)
                                        {
                                            System.out.println("you used gold coins");
                                            this.p2.getBag().subGoldcoins(3);
                                            this.p2.subPoints(30);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have enough Gold coins");
                                        }
                                    }
                                    else if(choice.compareTo("S")==0)
                                    {
                                        if(this.p2.getBag().getSC()>=6)
                                        {
                                            System.out.println("you used silver coins");
                                            this.p2.getBag().subSilvercoins(6);
                                            this.p2.subPoints(30);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have enough silver coins");
                                        }
                                    }
                                    else{
                                        System.out.println("Enter valid choice...");
                                    }
                                }
                            }
                            else if(flag==false)
                            {
                                this.p2.setPos(this.board.getCells()[index1][index2].getObjects().getSnake().getSnakeTail());
                                System.out.println("you reaches through snake");
                            }
                            break; 
                            case 'P':
                            System.out.println("Prison cell appears");
                            while(count<2)
                            {
                                if(this.p2.getBag().getDC()>=1 && count==0)
                                {
                                    System.out.println("You can use diamond coin to avoid from snake");
                                    flag=true;
                                }
                                else if(this.p2.getBag().isShield()==true && count==1)
                                {
                                    System.out.println("You can use shield to avoid from prison");
                                    flag=true;
                                }
                                count++;
                            }
                            if(flag==true)
                            {
                                while(flag1==true)
                                {
                                    System.out.println("Enetr choice 'X' 'D' ");
                                    choice=obj.next();
                                    if(choice.compareTo("X")==0)
                                    {
                                        if(this.p2.getBag().isShield()==true)
                                        {
                                            System.out.println("you have used shield");
                                            this.p2.getBag().setShield(false);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have Shield");
                                        }
                                    }
                                    else if(choice.compareTo("D")==0)
                                    {
                                        if(this.p2.getBag().getDC()>=1)
                                        {
                                            System.out.println("you used a diamond");
                                            this.p2.getBag().subDiamonds(1);
                                            this.p2.subPoints(50);
                                            flag1=false;
                                        }
                                        else
                                        {
                                            System.out.println("you dont have enough diamonds");
                                        }
                                    }
                                }
                            }
                            else if(flag==false)
                            {
                                this.p2.setStuck(0);
                            }
                            break;
                        default:
                            break;   
                    }
                }
                else
                {
                    this.board.getCells()[index1][index2].setCh('w');
                    if(this.p1.getStuck()==3)
                    {
                         this.p2.setTurn(false);
                         this.p1.setTurn(true);
                    }
                }
            }
        }
        System.out.println("Game over");
        if(this.p1.isTurn()==true)
        {
            System.out.println("wajaht wins");
        }
        else
        {
            System.out.println("saifee wins");
        }
    }
}
