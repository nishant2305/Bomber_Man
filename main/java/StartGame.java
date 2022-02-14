import levels.*;

import java.util.Scanner;

public class StartGame
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please select the level : ");
        int level = sc.nextInt();
        switch (level){
            case 1:
                Level1 level1 = new Level1();
                level1.getInput();
                level1.createBoard();
                level1.displayBoard();
                break;
            case 2:
                Level2 level2 = new Level2();
                level2.startGame();
                level2.action();
                break;
            case 3:
                Level3 level3 = new Level3();
                level3.startGame();
                level3.play();
                break;
            case 4:
                Level4 level4 = new Level4();
                level4.startGame();
                level4.play();
                break;
            case 5:
                Level5 level5 = new Level5();
                level5.startGame();
                level5.play();
                break;
            default:
                System.out.println("Please select the correct level.");
                break;
        }
    }
}
