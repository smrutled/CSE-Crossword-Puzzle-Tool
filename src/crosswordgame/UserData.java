package crosswordgame;

import java.util.ArrayList;


public class UserData implements java.io.Serializable{

public UserData(){
savedGames=new ArrayList<crossGame>();
stats=new ArrayList<StatisticsData>();
}    
    
public String userName;
public char[] password;
public ArrayList<crossGame> savedGames;
public ArrayList<StatisticsData> stats;
}
