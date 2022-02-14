package models;

public class Board
{
    private final int size;
    private String[][] board;
    private String playerPos;
    private String keyPos;
    private int vSize;
    private String[] villains;
    private int bSize;
    private String[] bricks;
    private String bombPos;
    private int power1Count;
    private String[] power1;
    private int power2Count;
    private String[] power2;
    private int power3Count;
    private String[] power3;
    private int dynamiteCount;
    private String[] dynamitePos;
    private String timeBombpos;

    public String getTimeBombpos() {
        return timeBombpos;
    }

    public void setTimeBombpos(String timeBombpos) {
        this.timeBombpos = timeBombpos;
    }

    public int getDynamiteCount() {
        return dynamiteCount;
    }

    public void setDynamiteCount(int dynamiteCount) {
        this.dynamiteCount = dynamiteCount;
    }

    public String[] getDynamitePos() {
        return dynamitePos;
    }

    public void setDynamitePos(String[] dynamitePos) {
        this.dynamitePos = dynamitePos;
    }

    public Board(int size) {
        this.size = size;
        board = new String[size][size];
    }

    public int getPower1Count() {
        return power1Count;
    }

    public void setPower1Count(int power1Count) {
        this.power1Count = power1Count;
    }

    public String[] getPower1() {
        return power1;
    }

    public void setPower1(String[] power1) {
        this.power1 = power1;
    }

    public int getPower2Count() {
        return power2Count;
    }

    public void setPower2Count(int power2Count) {
        this.power2Count = power2Count;
    }

    public String[] getPower2() {
        return power2;
    }

    public void setPower2(String[] power2) {
        this.power2 = power2;
    }

    public int getPower3Count() {
        return power3Count;
    }

    public void setPower3Count(int power3Count) {
        this.power3Count = power3Count;
    }

    public String[] getPower3() {
        return power3;
    }

    public void setPower3(String[] power3) {
        this.power3 = power3;
    }

    public int getSize() {
        return size;
    }

    public String getBombPos() {
        return bombPos;
    }

    public void setBombPos(String bombPos) {
        this.bombPos = bombPos;
    }

    public String[][] getBoard() {
        return board;
    }

    public String getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(String playerPos) {
        this.playerPos = playerPos;
    }

    public String getKeyPos() {
        return keyPos;
    }

    public void setKeyPos(String keyPos) {
        this.keyPos = keyPos;
    }

    public int getvSize() {
        return vSize;
    }

    public void setvSize(int vSize) {
        this.vSize = vSize;
    }

    public String[] getVillains() {
        return villains;
    }

    public int getbSize() {
        return bSize;
    }

    public void setbSize(int bSize) {
        this.bSize = bSize;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void setVillains(String[] villains) {
        this.villains = villains;
    }

    public void setBricks(String[] bricks) {
        this.bricks = bricks;
    }

    public String[] getBricks() {
        return bricks;
    }

    public void displayBoard()
    {
        for(int i =0 ; i< size ; i++)
        {
            for(int j=0; j< size ; j++)
            {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }


}
