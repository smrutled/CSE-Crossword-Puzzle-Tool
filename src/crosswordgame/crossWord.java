package crosswordgame;


class crossWord implements java.io.Serializable{
//crossLetter[] word;
public char[] letter;
public int startX;
public int startY;
public char dir;
public int num;
public String clue;
public crossWord(String w, int sX, int sY, char d, String c){
startX=sX;
startY=sY;
dir=d;
clue=c;
num=0;
letter= new char[w.length()];
for (int i = 0; i < w.length(); i++) {
	 letter[i]=w.charAt(i);
}
}

}
