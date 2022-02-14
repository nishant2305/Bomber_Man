package levels;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Level2 extends Level1
{
    boolean plant = false;
    int blastRange = 1;
    int bombCount = 1;
    int timeBombCount = 1;
    int t=0;
    ArrayList<String> powers = new ArrayList<>();
    ArrayList<String> bombLocations = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    public void startGame()
    {
        try {
            File file = new File("/Users/_nishant_kumar/eclipse-workspace/Bomerman/src/main/resources/Instructions/level2.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine())
                System.out.println(sc.nextLine());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getInput();
        createBoard();
        displayBoard();
    }

    public void action()
    {
        boolean userWish = true;
        while(userWish)
        {
            String curPlayerPos = board.getPlayerPos();
            int curRow = curPlayerPos.charAt(0) - 64;
            int curCol = curPlayerPos.charAt(1) - 64;
            System.out.println("Your Move : ");
            Scanner sc = new Scanner(System.in);
            String action = sc.nextLine().toUpperCase();
            int won = Move(action, curRow, curCol);
            if(won == 1){
                System.out.println("Victory !!! You Won.");
                userWish = false;
            }
            else if(won == 0){
                System.out.println("Oops !!! You were killed by Villain");
                userWish = false;
            }
            else if(won == 2){
                System.out.println("Oops !!! You were in range of the Bomb | Game Over |");
                userWish = false;
            }
            displayBoard();
        }
    }

    public int Move(String move,int currRow, int currCol)
    {
        String[][] board = this.board.getBoard();
        boolean result = false;
        int won = -1;
        String cur;

        ArrayList<String> blocks = new ArrayList<>(Arrays.asList("*", "B", "X","M"));
        if(move.equals("W") && !blocks.contains(board[currRow-1][currCol]))
        {
            result = true;
            switch (board[currRow - 1][currCol]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow-1][currCol] = "P";
            cur = ""+(char)(63+currRow)+(char)(64+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("S") && !blocks.contains(board[currRow+1][currCol]))
        {
            result = true;
            switch (board[currRow + 1][currCol]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow+1][currCol] = "P";
            cur = ""+(char)(65+currRow)+(char)(64+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("A") && !blocks.contains(board[currRow][currCol-1]))
        {
            result = true;
            switch (board[currRow][currCol - 1]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow][currCol-1] = "P";
            cur = ""+(char)(64+currRow)+(char)(63+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("D") && !blocks.contains(board[currRow][currCol+1]))
        {
            result = true;
            switch (board[currRow][currCol + 1]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow][currCol+1] = "P";
            cur = ""+(char)(64+currRow)+(char)(65+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("Q") && !blocks.contains(board[currRow-1][currCol-1]))
        {
            result = true;
            switch (board[currRow - 1][currCol - 1]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow-1][currCol-1] = "P";
            cur = ""+(char)(63+currRow)+(char)(63+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("E") && !blocks.contains(board[currRow-1][currCol+1]))
        {
            result = true;
            switch (board[currRow - 1][currCol + 1]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow-1][currCol+1] = "P";
            cur = ""+(char)(63+currRow)+(char)(65+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("Z") && !blocks.contains(board[currRow+1][currCol-1]))
        {
            result = true;
            switch (board[currRow + 1][currCol - 1]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow+1][currCol-1] = "P";
            cur = ""+(char)(65+currRow)+(char)(63+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("C") && !blocks.contains(board[currRow+1][currCol+1]))
        {
            result = true;
            switch (board[currRow + 1][currCol + 1]) {
                case "K":
                    return 1;
                case "V":
                    return 0;
                case "1":
                    System.out.println("Yay !!! Power1 -> Blast Range increased by 1");
                    powers.add("1");
                    break;
                case "2":
                    System.out.println("Yay !!! Power2 -> Diagonal Blast activated");
                    powers.add("2");
                    break;
                case "3":
                    System.out.println("Yay !!! Power3 -> Blast count increased by 1");
                    bombCount++;
                    break;
            }
            board[currRow+1][currCol+1] = "P";
            cur = ""+(char)(65+currRow)+(char)(65+currCol);
            this.board.setPlayerPos(cur);
        }
        else if(move.equals("X"))
        {
            System.out.println("Bomb: 1-Plant/2-Detonate : ");
            Scanner sc = new Scanner(System.in);
            int actionOnBomb = sc.nextInt();
            won = bomb(actionOnBomb,currRow,currCol);
        }
        else if(move.equals("T")){
            timeBomb(currRow,currCol);
        }
        else{
            System.out.println("Invalid Move !!! Please try a different move.");
        }
        if(result){
            if(!plant || t>0)
                board[currRow][currCol] = " ";
            else{
                t=1;
            }
        }
        this.board.setBoard(board);
        return won;
    }

    public int bomb(int actionOnBomb, int currRow, int currCol)
    {
        String[][] board = this.board.getBoard();
        if(actionOnBomb == 1 && bombCount == 0){
            if(plant){
                System.out.println("Caution : Bomb is already planted, You can't plant another.");}
            else{
                System.out.println("Sorry !!! No bombs left.");
            }
        }
        else if(actionOnBomb == 1 && bombCount>0){
            board[currRow][currCol] = "X";
            String pos =""+(char)(currRow)+(char)(currCol);
            bombLocations.add(pos);
            this.board.setBoard(board);
            String cur = ""+(char)(64+currRow)+(char)(64+currCol);
            this.board.setPlayerPos(cur);
            this.board.setBombPos(cur);
            System.out.println("Bomb planted successfully.");
            System.out.println("You are not safe here and can't stay here, Your next move : ");
            bombCount--;
            String move = sc.nextLine().toUpperCase();
            t=0;
            plant = true;
            Move(move,currRow,currCol);
        }
        else if(actionOnBomb == 2 && !plant){
            System.out.println("There is no Bomb planted, Please plant a bomb before detonation.");
        }
        else if(actionOnBomb == 2) {
            plant = false;
            ArrayList<String> blocks = new ArrayList<>(Arrays.asList("*", "K", "1", "2", "3"));
            for (String pos : bombLocations) {
                int row = pos.charAt(0);
                int col = pos.charAt(1);
                if (powers.contains("1")) {
                        blastRange = 2;
                        powers.remove("1");
                    }

                if (!blocks.contains(board[row][col]))
                    board[row][col] = " ";
                for (int i = 1; i <= blastRange; i++) {
                        if (!blocks.contains(board[row + i][col])) {
                            if (board[row + i][col].equals("P")) {
                                return 2;
                            }
                            if(board[row + i][col].equals("M")){
                                dynamite(row+i,col);
                            }
                            board[row + i][col] = " ";
                        } else {
                            break;
                        }
                    }
                for (int i = 1; i <= blastRange; i++) {
                        if (!blocks.contains(board[row - i][col])) {
                            if (board[row - i][col].equals("P")) {
                                return 2;
                            }
                            if(board[row - i][col].equals("M")){
                                dynamite(row-i,col);
                            }
                            board[row - i][col] = " ";
                        } else {
                            break;
                        }
                    }
                for (int i = 1; i <= blastRange; i++) {
                        if (!blocks.contains(board[row][col + i])) {
                            if (board[row][col + i].equals("P")) {
                                return 2;
                            }
                            if(board[row][col+i].equals("M")){
                                dynamite(row,col+i);
                            }
                            board[row][col + i] = " ";
                        } else {
                            break;
                        }
                    }
                for (int i = 1; i <= blastRange; i++) {
                        if (!blocks.contains(board[row][col - i])) {
                            if (board[row][col - i].equals("P")) {
                                return 2;
                            }
                            if(board[row][col - i].equals("M")){
                                dynamite(row,col-i);
                            }
                            board[row][col - i] = " ";
                        } else {
                            break;
                        }
                    }
                if (powers.contains("2")) {
                    for (int i = 1; i <= blastRange; i++) {
                            if (!blocks.contains(board[row + i][col + i])) {
                                if (board[row + i][col + i].equals("P")) {
                                    return 2;
                                }
                                if(board[row + i][col+i].equals("M")){
                                    dynamite(row+i,col+i);
                                }
                                board[row + i][col + i] = " ";
                            } else {
                                break;
                            }
                        }
                    for (int i = 1; i <= blastRange; i++) {
                            if (!blocks.contains(board[row - i][col + i])) {
                                if (board[row - i][col + i].equals("P")) {
                                    return 2;
                                }
                                if(board[row - i][col + i].equals("M")){
                                    dynamite(row-i,col+i);
                                }
                                board[row - i][col + i] = " ";
                            } else {
                                break;
                            }
                        }
                    for (int i = 1; i <= blastRange; i++) {
                            if (!blocks.contains(board[row + i][col - i])) {
                                if (board[row + i][col - i].equals("P")) {
                                    return 2;
                                }
                                if(board[row + i][col - i].equals("M")){
                                    dynamite(row+i,col-i);
                                }
                                board[row + i][col - i] = " ";
                            } else {
                                break;
                            }
                        }
                    for (int i = 1; i <= blastRange; i++) {
                            if (!blocks.contains(board[row - i][col - i])) {
                                if (board[row - i][col - i].equals("P")) {
                                    return 2;
                                }
                                if(board[row - i][col - 1].equals("M")){
                                    dynamite(row-i,col-i);
                                }
                                board[row - i][col - i] = " ";
                            } else {
                                break;
                            }
                        }
                    powers.remove("2");
                }
            }
            this.board.setBoard(board);
        }
        else {
                System.out.println("Sorry !!! No bombs left.");
            }
    return -1;
    }
    public void dynamite(int row, int col){
        int dyRow = 0,dyCol = 0;
        String [][]localBoard = this.board.getBoard();
        ArrayList<String> blocks = new ArrayList<>(Arrays.asList("*", "K", "1", "2", "3"));
        if(!blocks.contains(localBoard[row+1][col])){
            if(localBoard[row+1][col].equals("M")){
                dyRow = row+1;
                dyCol = col;
            }
            localBoard[row+1][col] = " ";
        }
        if(!blocks.contains(localBoard[row-1][col])){
            if(localBoard[row-1][col].equals("M")){
                dyRow = row-1;
                dyCol = col;
            }
            localBoard[row-1][col] = " ";
        }
        if(!blocks.contains(localBoard[row][col+1])){
            if(localBoard[row][col+1].equals("M")){
                dyRow = row;
                dyCol = col+1;
            }
            localBoard[row][col+1] = " ";
        }
        if(!blocks.contains(localBoard[row][col-1])){
            if(localBoard[row][col-1].equals("M")){
                dyRow = row;
                dyCol = col-1;
            }
            localBoard[row][col-1] = " ";
        }
        if(!blocks.contains(localBoard[row+1][col+1])){
            if(localBoard[row+1][col+1].equals("M")){
                dyRow = row+1;
                dyCol = col+1;
            }
            localBoard[row+1][col+1] = " ";
        }
        if(!blocks.contains(localBoard[row+1][col-1])){
            if(localBoard[row+1][col-1].equals("M")){
                dyRow = row+1;
                dyCol = col-1;
            }
            localBoard[row+1][col-1] = " ";
        }
        if(!blocks.contains(localBoard[row-1][col+1])){
            if(localBoard[row-1][col+1].equals("M")){
                dyRow = row-1;
                dyCol = col+1;
            }
            localBoard[row-1][col+1] = " ";
        }
        if(!blocks.contains(localBoard[row-1][col-1])){
            if(localBoard[row-1][col-1].equals("M")){
                dyRow = row-1;
                dyCol = col-1;
            }
            localBoard[row-1][col-1] = " ";
        }
        if(dyRow>0 && dyCol>0){
            dynamite(dyRow,dyCol);
        }
    }
    public void timeBomb(int row, int col){
        String [][] localBoard = this.board.getBoard();
        if(timeBombCount>0){
            localBoard[row][col] = "T";
            this.board.setBoard(localBoard);
            String cur = ""+(char)(64+row)+(char)(64+col);
            this.board.setPlayerPos(cur);
            this.board.setTimeBombpos(cur);
            System.out.println("Time Bomb planted successfully.");
            System.out.println("You Have to move three steps out of range for time bomb to detonate.");
            timeBombCount--;
            plant = true;
            t=0;
            for(int i=0;i<3;i++){
                System.out.println("Next Move");
                String move = sc.nextLine().toUpperCase();
                String curPos = board.getPlayerPos();
                int Rw = curPos.charAt(0)-64;
                int Cl = curPos.charAt(1)-64;
                Move(move,Rw,Cl);
                displayBoard();}
            blast(row,col);
        }
        else{
            System.out.println("Sorry !!! No time-bombs left.");
        }
    }
    public void blast(int row, int col){
        String [][] localBoard = this.board.getBoard();
        ArrayList<String> blocks = new ArrayList<>(Arrays.asList("*", "K", "1", "2", "3"));
        if(!blocks.contains(localBoard[row][col])){
            localBoard[row][col] = " ";
        }
        if(!blocks.contains(localBoard[row+1][col])){
            localBoard[row+1][col] = " ";
        }
        if(!blocks.contains(localBoard[row-1][col])){
            localBoard[row-1][col] = " ";
        }
        if(!blocks.contains(localBoard[row][col+1])){
            localBoard[row][col+1] = " ";
        }
        if(!blocks.contains(localBoard[row][col-1])){
            localBoard[row][col-1] = " ";
        }
    }
}

