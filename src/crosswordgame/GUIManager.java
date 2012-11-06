/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crosswordgame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sean
 */
public class GUIManager extends JFrame {
    JPanel currentPanel;
    UserData[] currentUser;
    crossGame currentGame;
    
    private GUIManager(){
        currentPanel=new LoginPanel();
        currentUser=new UserData[2];
        add(currentPanel);
        setTitle("Crossword Puzzle Manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(true);
        
        //Saves any user data on window close
        addWindowListener(new WindowAdapter() {
  public void windowClosing(WindowEvent e) {
      
      if(currentGame!=null && currentGame.isAlive && currentUser[0]!=null)
      {
          UserDataHandler.SaveCrossGame(currentUser[0], currentGame);
          if(currentGame.twoPlayers)
             UserDataHandler.SaveCrossGame(currentUser[1], currentGame); 
      }
      if(currentUser[0]!=null){
          UserDataHandler.SaveUserData(currentUser[0]);
          currentUser[0]=null;
      }
      if(currentUser[1]!=null){
          UserDataHandler.SaveUserData(currentUser[1]);
          currentUser[1]=null;
      }
          
  }
});

        
    }
    
    public static GUIManager getGUIManager()
    {
    if (ref == null)
        ref = new GUIManager();		
    return ref;
    }

    public void ReplacePanel(JPanel panel, int width, int height)
    {
        this.setSize(width, height);
        this.getContentPane().removeAll();
        this.getContentPane().invalidate();
        add(panel);
        currentPanel=panel;
        this.getContentPane().revalidate();
        this.setLocationRelativeTo(null);

    }
    
    private static GUIManager ref;

}
