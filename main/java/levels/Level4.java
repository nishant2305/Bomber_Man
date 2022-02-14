package levels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Level4 extends Level3{

    public void startGame(){
        try {
            File file = new File("/Users/_nishant_kumar/eclipse-workspace/Bomerman/src/main/resources/Instructions/level4.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getInput();
        updateInput();
        System.out.print("Dynamite count : ");
        board.setDynamiteCount(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter Dynamite position : ");
        String[] dyPosition = new String[board.getDynamiteCount()];
        for(int i =0; i< dyPosition.length; i++)
        {
            dyPosition[i] = sc.nextLine().toUpperCase();
        }
        board.setDynamitePos(dyPosition);
        createBoard();
        updateBoardWithDynamite();
        updateBoardWithPower();
    }
    public void updateBoardWithDynamite(){
        int i,j;
        int boardSize = board.getSize();
        String[][] localBoard = board.getBoard();
        for(i =0; i< boardSize; i++)
        {
            for(j =0 ; j< boardSize; j++) {
                String curPos = "" + (char) (64 + i) + (char) (64 + j);
                if (checkElement(curPos, this.board.getDynamitePos())) {
                    localBoard[i][j] = "M";
                }
            }
        }
        board.setBoard(localBoard);
    }
    public void play(){
        action();
    }
}
