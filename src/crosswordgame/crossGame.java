package crosswordgame;

//Basic Idea for the crossword data structure and how to read in from file
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class crossGame implements java.io.Serializable{
String name;
Boolean twoPlayers;
Boolean playerTurn;
Boolean isAlive;
crossWord[] wordList;
StatisticsData stats;
char[][] board;
char [][] inputboard;
int sizeX;
int sizeY;
crossGame(String s, Boolean p2){
    name=s;
    twoPlayers=p2;
    playerTurn=true;
    isAlive=true;
    createFromFile(name);
    stats= new StatisticsData();
    stats.gamename=name;
    stats.wordCount=wordList.length;
    sizeX=findBoardSizeX();
    sizeY=findBoardSizeY();
    createGUIBoard();
    createClueNumbers();
    inputboard=new char[sizeX][sizeY];
}

void createFromFile( String file){
	ArrayList<crossWord> wl= new ArrayList<crossWord>(); 
	try{
        FileReader fin = new FileReader("puzzles/"+file);
    Scanner src = new Scanner(fin);
    while ( src.hasNextLine() ){
        wl.add(processLine( src.nextLine() ));
      }
	wordList=(crossWord[]) wl.toArray(new crossWord[wl.size()]);
	
        }
        catch(FileNotFoundException e)
        {
            
        }
   
}

protected crossWord processLine(String aLine){ 
    Scanner scanner = new Scanner(aLine);
    scanner.useDelimiter(":");
    String word = scanner.next();
    int startX = scanner.nextInt();
    int startY = scanner.nextInt();
    String dir =scanner.next();
    String clue = scanner.next();
    crossWord aWord = new crossWord(word,startX,startY,dir.charAt(0), clue);
    return aWord;
  }

void createGUIBoard()
{
    board= new char[sizeX][sizeY];
    for (int i = 0; i < sizeX; i +=1){
      for (int j = 0; j < sizeY; j+=1){
          board[i][j]=getLetter(i,j);
      }}
}
char getLetter(int x, int y)
{
    for (int i = 0; i < wordList.length; i +=1){
       if(wordList[i].dir=='a'){
           for (int j = 0; j < wordList[i].letter.length; j +=1){
               if(x==wordList[i].startX+j && y==wordList[i].startY)
                   return wordList[i].letter[j];
           }
       }
       else
       {
           for (int j = 0; j < wordList[i].letter.length; j +=1){
               if(y==wordList[i].startY+j && x==wordList[i].startX)
                   return wordList[i].letter[j];
           }
       }
    }
    return '$';
}

void createClueNumbers(){
    int num=1;
    ArrayList<crossWord> list=new ArrayList<crossWord>(Arrays.asList(wordList));
    
    for(int i =0; i<wordList.length; i+=1){
        if(wordList[i].num!=0)
            continue;
        for(crossWord w1 : list){
               
           if(w1.startX==wordList[i].startX && w1.startY==wordList[i].startY){
               w1.num=num;
           }
              
         }
        
      num+=1;    
    }

}

String getClueList(){
    String across="", down="";
    across+="Across\n";
    down+="Down\n";
        for(int i =0; i<wordList.length; i+=1){
               if(wordList[i].dir =='a')
                   across+=Integer.toString(wordList[i].num)+"."+wordList[i].clue+"\n";
               else
                   down+=Integer.toString(wordList[i].num)+"."+wordList[i].clue+"\n"; 
              
         }
        

    if(!twoPlayers)
    return across+"\n"+down;
    else{
        if(playerTurn)
            return across;
        else
            return down;
    }
}

int findBoardSizeX() {
    int x=1;
    int j=999;
    for(int i =0; i<wordList.length; i+=1){
        if(wordList[i].dir=='a'){
            if(wordList[i].startX+wordList[i].letter.length-1>x)
                x=wordList[i].startX+wordList[i].letter.length-1;
        }
        else
            if(wordList[i].startX>x)
                x=wordList[i].startX;
        if(wordList[i].startX<j)
                j=wordList[i].startX;
    }
    
    for(int i =0; i<wordList.length; i+=1){
       wordList[i].startX=wordList[i].startX-j;
    }
    
    return x+1-j;
}
int findBoardSizeY() {
    int y=1;
    int j=999;
    for(int i =0; i<wordList.length; i+=1){
        if(wordList[i].dir=='d'){
            if(wordList[i].startY+wordList[i].letter.length-1>y)
                y=wordList[i].startY+wordList[i].letter.length-1;
        }
        else
            if(wordList[i].startY>y)
                y=wordList[i].startY;
        
        if(wordList[i].startY<j)
                j=wordList[i].startY;
    }
    
    for(int i =0; i<wordList.length; i+=1){
       wordList[i].startY=wordList[i].startY-j;
    }
    
    return y+1-j;
}

void UpdatePercentCompelete()
{
    int correct=0;
    for (int i = 0; i < wordList.length; i +=1){
       correct+=1;
       if(wordList[i].dir=='a'){
           for (int j = 0; j < wordList[i].letter.length; j +=1){
               if(inputboard[wordList[i].startX+j][wordList[i].startY]!=wordList[i].letter[j]){
                   correct-=1;
                   break; 
               }
                  
           }
       }
       else
       {
           for (int j = 0; j < wordList[i].letter.length; j +=1){
               if(inputboard[wordList[i].startX][wordList[i].startY+j]!=wordList[i].letter[j]){
                   correct-=1;
                   break;
           }
           }
       }
    }
    stats.wordComp=correct;
}

}
