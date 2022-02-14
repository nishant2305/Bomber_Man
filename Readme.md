Bomberman
Bomberman is a popular game where a player is trapped in a room and is expected to get out by finding the key. In this version of the game, the room consists of breakable bricks, unbreakable walls and Villains. The player need to grab the key to win the game.
Level 1:
Create a NxN map where N is always an even number (Max Size = 26)
P - Player * - Wall
B - Brick V - Villain K - Key
-> First row and First column for location identification. -> Walls position is always fixed.
Input:
Map Size
User position
Key position
No of Villains and their position No of Bricks and their position
Sample Input:
Map size: 12 Player position: CB Key position:FD Villain count:2
V1: BH
V2: DF
Brick count:6
B1: DD
B2: ED
B3: FB
B4: FF
B5: GB
B6: HD
  
 Sample Output:
Note: An element should not be placed on top of another element.
Level 2:
The Player can move in all 8 directions.
W - Move up
S - Move down
A - Move left
D - Move right
Q - Move diagonally up left
Z - Move diagonally down left E - Move diagonally up right
C - Move diagonally down right
-> The player can not move to a position if there is a Wall or Brick
-> If there is a Villain where the player moves. The player dies
-> If there is a Key where the player moves. The player wins the game
-> The player can plant a bomb to destroy Bricks and Villains. X - Bomb
Map:
   
  Sample Input:
C
Sample Output:
   -> Player position in above image is CD. Now the player plants a bomb in CD. Then moves to BC
Sample Input:
X
1 Plant
2 Detonate 1
Sample Output:
   -> When the player moves out of the position the Bomb should display in the map. (Note: Again the player can not move on top of the Bomb)

 -> The Bomb blast only in up, down, left, right directions and has the range of 1
-> If a Player plant a Bomb, then the player can not plant another Bomb until the first one detonates
Sample Input:
X
1 Plant
2 Detonate 2
  Note: -> If the player is inside the Bomb blast range. Then the player dies -> Print the map each and every time after an input
Level 3:
-> In this Level the map will contain 3 Powers. 1 - Bomb Blast Range + 1
2 - Bomb can blast in diagonal direction 3 - Bomb count + 1
-> Get the position of powers 1,2 while creating the map.
Sample Output:
   -> The Player moves to BD and gets the power 1

  -> The Player moves to CD and gets the power 2
-> Then the Player moves to DE and plants a Bomb
-> Then the Player moves to CD and to BD
  
  -> Now the Player detonates the Bomb
Power 3 :
-> If the player gets this power, the Bomb count increases by 1 (ie: The player can plant another Bomb while another Bomb already planted in the map)
-> If the Player got Power 3.
-> Ask whether to plant or detonate always.
-> As you can see the Player planted two bombs one in DB and another in DC
-> Now to detonate bomb Press 'X' and press '2' which blasts every bomb in the map.
-> If no bomb is planted and if the input is 2(Detonate) then print "No bomb is planted to detonate"
Level 4:
-> In this level, there will be a Dynamite which also denotes when it is triggered only by
    
 other blast
-> Dynamite always has the range of 1. And blasts in all directions -> Get the position of Dynamite while creating the map
M - Dynamite
Sample Output:
-> Now Player P has power 1 and 2
-> Now the Player detonates the Bomb - 'X'
Level 5:
-> The player can plant a Timer Bomb.
T - Timer Bomb Time = 3
    
 -> Player moves to DB and places a bomb return back to CB
-> The Bomb detonates when the player moves 3 positions in any direction.
-> Timer Bomb always has the count - 1, range - 1, directions - (up, left, right, down)
Note: The player can plant both the Ordinary bombs and Timer bomb at different position.
