package levels;

import models.Board;

import java.util.Scanner;

public class Level1
{
    public Board board;

    public void getInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the board size : ");
        int size = scanner.nextInt();
        scanner.nextLine();
        board = new Board(size);
        System.out.print("Enter Player Position : ");
        board.setPlayerPos(scanner.nextLine().toUpperCase());
        System.out.print("Enter Key Position : ");
        board.setKeyPos(scanner.nextLine().toUpperCase());
        System.out.print("Enter Villain size : ");
        board.setvSize(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter Villain position : ");
        String[] vPosition = new String[board.getvSize()];
        for(int i =0; i< vPosition.length; i++)
        {
            vPosition[i] = scanner.nextLine().toUpperCase();
        }
        board.setVillains(vPosition);
        System.out.print("Enter Number of Bricks : ");
        board.setbSize(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Enter Brick position : ");
        String[] bPosition = new String[board.getbSize()];
        for(int i =0; i< bPosition.length; i++)
        {
            bPosition[i] = scanner.nextLine().toUpperCase();
        }
        board.setBricks(bPosition);
    }

    public void createBoard()
    {
        int i,j;
        int boardSize = board.getSize();
        String[][] localBoard = new String[boardSize][boardSize];
        for(i =0; i< boardSize; i++)
        {
            for(j =0 ; j< boardSize; j++)
            {
                String curPos =""+(char)(64+i)+(char)(64+j);
                if((i == 0 && j!=0))
                {
                    localBoard[i][j] = ""+(char)(64+j);
                }
                else if(j == 0 && i!=0)
                {
                    localBoard[i][j] = ""+(char)(64+i);
                }
                else if((i==1 || j==1 || j==boardSize-1 || i == boardSize-1) || (i%2 != 0 && j%2 != 0))
                {
                    localBoard[i][j] = "*";
                }
                else if(curPos.equals(this.board.getPlayerPos()))
                {
                    localBoard[i][j] = "P";
                }
                else if(curPos.equals(this.board.getKeyPos()))
                {
                    localBoard[i][j] = "K";
                }
                else if(checkElement(curPos, this.board.getVillains()))
                {
                    localBoard[i][j] = "V";
                }
                else if(checkElement(curPos, this.board.getBricks()))
                {
                    localBoard[i][j] = "B";
                }
                else
                {
                    localBoard[i][j] = " ";
                }
            }
        }
        this.board.setBoard(localBoard);
    }

    public boolean checkElement(String curPos, String[] list)
    {
        boolean result = false;

        for(String v : list)
        {
            if(curPos.equals(v))
            {
                result = true;
                break;
            }
        }
        return result;
    }

    public void displayBoard()
    {
        board.displayBoard();
    }
}
