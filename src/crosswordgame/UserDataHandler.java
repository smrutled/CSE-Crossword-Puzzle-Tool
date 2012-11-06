package crosswordgame;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class UserDataHandler {

public static UserData GetUserData(String userName, char[] password)
{
	UserData data = null;
        try{
	FileInputStream fileIn =
                          new FileInputStream("userdata/"+userName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            data = (UserData) in.readObject();
            fileIn.close();
            in.close();
        }
        catch(IOException | ClassNotFoundException i){
            
         return null;
        }
        if(Arrays.equals(password, data.password))
	return data;
        else
            return null;
}

public static UserData GetUserData(String userName)
{
	UserData data = null;
        try{
	FileInputStream fileIn =
                          new FileInputStream("userdata/"+userName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            data = (UserData) in.readObject();
            fileIn.close();
            in.close();
        }
        catch(IOException | ClassNotFoundException i){
            
         return null;
        }
        return data;
  
}

public static UserData[] GetUserDataList()
{
    ArrayList<UserData> userList=new ArrayList();
    
            File directory = new File("./userdata");  
            File[] files = directory.listFiles();    
            for (int index = 0; index < files.length; index++)  
            {  
                UserData user=GetUserData(files[index].getName());
                if(user!=null)
                userList.add(user);  
            }
	
	
	return (UserData[])userList.toArray(new UserData[userList.size()]);
}

public static UserData CreateUser(String userName, char[] password)
{
	UserData user =null;
	if(CheckUserName(userName))
	{
	user = new UserData();
	user.userName=userName;
	user.password=password;
        SaveUserData(user);
	}
	return user;
}

public static boolean DeleteUserDataFile(String userName){
    File userFile = new File("./userdata/"+userName);
    return userFile.delete();
}

public static Boolean CheckUserName(String userName)
{
	File directory = new File("./userdata");  
        File[] files = directory.listFiles();    
        for (int index = 0; index < files.length; index++)  
        {  
                if((userName).equals(files[index].getName()))
                    return false;
        }
	return true;
}

public static Boolean SaveUserData(UserData data)
{
	try
      {
         FileOutputStream fileOut =
         new FileOutputStream("userdata/"+data.userName);
         ObjectOutputStream out =
                            new ObjectOutputStream(fileOut);
         out.writeObject(data);
         
         out.flush();
         out.close();
         fileOut.close();
      }catch(IOException i)
      {
         return false;
      }

	return true;
}

public static Boolean SaveCrossGame(UserData user, crossGame game){
    
    for (int i =0; i<user.savedGames.size(); i++){
        if(game.name.equals(user.savedGames.get(i).name)){
            user.savedGames.remove(i);
            break;
        }
            
    }
    user.savedGames.add(game);
    return true;
}

public static crossGame GetCrossGame(UserData user, String name){
    
    for (int i =0; i<user.savedGames.size(); i++){
        if(name.equals(user.savedGames.get(i).name)){
            return user.savedGames.get(i);
        }      
    }
    return null;
}

public static void RemoveCrossGame(UserData user, String name){
     for (int i =0; i<user.savedGames.size(); i++){
        if(name.equals(user.savedGames.get(i).name)){
            user.savedGames.remove(i);
        }      
    }
}

public static void SaveGameStatistics(UserData user, crossGame game){
     user.stats.add(game.stats);
}


public static StatisticsData GetSpecificGameStats(UserData user, String gameName){
    for (int i =0; i<user.stats.size(); i++){
         if(gameName.equals(user.stats.get(i).gamename))
             return user.stats.get(i);
    }
    return null;
    
}

public static StatisticsData[] GetSpecificGameStatsList(String gameName){
    UserData[] userList=GetUserDataList();
    ArrayList<StatisticsData> statsList= new ArrayList();
    
    for (int i =0; i<userList.length; i++){
        StatisticsData stats=GetSpecificGameStats(userList[i],gameName);
        if(stats!=null)
            statsList.add(stats);
    }
    Collections.sort(statsList,new StatsScoreComparator());
    return (StatisticsData[])statsList.toArray(new StatisticsData[statsList.size()]);
    
}
public static void RemoveSpecificGameStats(UserData user, String gameName){
    for (int i =0; i<user.stats.size(); i++){
         if(gameName.equals(user.stats.get(i).gamename))
             user.stats.remove(i);
    }
}


}
