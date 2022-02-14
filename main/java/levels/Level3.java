package levels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Level3 extends Level2
{
    Scanner sc = new Scanner(System.in);
    public void startGame(){
        try {
            File file = new File("/Users/_nishant_kumar/eclipse-workspace/Bomerman/src/main/resources/Instructions/level3.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getInput();
        updateInput();
        createBoard();
        updateBoardWithPower();
    }

    public void updateBoardWithPower(){
        int i,j;
        int boardSize = board.getSize();
        String[][] localBoard = board.getBoard();
        for(i =0; i< boardSize; i++)
        {
            for(j =0 ; j< boardSize; j++)
            {
                String curPos =""+(char)(64+i)+(char)(64+j);
                if(checkElement(curPos,this.board.getPower1()))
                {
                    localBoard[i][j] = "1";
                }
                else if(checkElement(curPos,this.board.getPower2())){
                    localBoard[i][j] = "2";
                }
                else if(checkElement(curPos,this.board.getPower3())){
                    localBoard[i][j] = "3";
                }
            }}
        board.setBoard(localBoard);
        displayBoard();
    }
    public void updateInput(){
        System.out.print("Power1 count : ");
        board.setPower1Count(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter power1 position : ");
        String[] pow1Position = new String[board.getPower1Count()];
        for(int i =0; i< pow1Position.length; i++)
        {
            pow1Position[i] = sc.nextLine().toUpperCase();
        }
        board.setPower1(pow1Position);

        System.out.print("Power2 count : ");
        board.setPower2Count(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter power2 position : ");
        String[] pow2Position = new String[board.getPower2Count()];
        for(int i =0; i< pow2Position.length; i++)
        {
            pow2Position[i] = sc.nextLine().toUpperCase();
        }
        board.setPower2(pow2Position);

        System.out.print("Power3 count : ");
        board.setPower3Count(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter power3 position : ");
        String[] pow3Position = new String[board.getPower3Count()];
        for(int i =0; i< pow3Position.length; i++)
        {
            pow3Position[i] = sc.nextLine().toUpperCase();
        }
        board.setPower3(pow3Position);
    }

    public void play(){
        action();
    }
}
