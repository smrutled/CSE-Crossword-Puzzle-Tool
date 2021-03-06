/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package crosswordgame;

import java.awt.event.ItemEvent;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.ListModel;

/**
 *
 * @author Sean
 */
public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */
    private DefaultListModel list;
    
    public MenuPanel() {
        initComponents();
        GUIManager manager = GUIManager.getGUIManager();
        userWelcomeText.setText(manager.currentUser[0].userName);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newGameOpt = new javax.swing.JDialog();
        newStartGameB = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        gameList = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        playerNumToggle = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        loginPlayer2Label = new javax.swing.JLabel();
        loginPlayer2Button = new javax.swing.JButton();
        loginP2CompLabel = new javax.swing.JLabel();
        loadSavedGameDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        savedGameList = new javax.swing.JList();
        saveStartGameB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        loginLoadP2Button = new javax.swing.JButton();
        loginLoadP2CompLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        p2LoginDialog = new javax.swing.JDialog();
        loginPanel1 = new LoginPanel(1);
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        newGameB = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        logoffB = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        userWelcomeText = new javax.swing.JLabel();
        helloText = new javax.swing.JLabel();

        newGameOpt.setResizable(false);

        newStartGameB.setText("Start Game");
        newStartGameB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStartGameBActionPerformed(evt);
            }
        });

        gameList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(gameList);

        jLabel2.setText("Select Game");

        playerNumToggle.setText("One");
        playerNumToggle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                playerNumToggleItemStateChanged(evt);
            }
        });

        jLabel3.setText("Players?");

        loginPlayer2Label.setText("Player 2 Login");

        loginPlayer2Button.setText("Login");
        loginPlayer2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginPlayer2ButtonActionPerformed(evt);
            }
        });

        loginP2CompLabel.setText(" ");

        javax.swing.GroupLayout newGameOptLayout = new javax.swing.GroupLayout(newGameOpt.getContentPane());
        newGameOpt.getContentPane().setLayout(newGameOptLayout);
        newGameOptLayout.setHorizontalGroup(
            newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newGameOptLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(newStartGameB)
                .addContainerGap(154, Short.MAX_VALUE))
            .addGroup(newGameOptLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(playerNumToggle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(newGameOptLayout.createSequentialGroup()
                        .addComponent(loginPlayer2Label)
                        .addGap(64, 64, 64))
                    .addGroup(newGameOptLayout.createSequentialGroup()
                        .addComponent(loginPlayer2Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(loginP2CompLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        newGameOptLayout.setVerticalGroup(
            newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newGameOptLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(loginPlayer2Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newGameOptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playerNumToggle)
                        .addComponent(loginPlayer2Button)
                        .addComponent(loginP2CompLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(newStartGameB)
                .addContainerGap())
        );

        loginPlayer2Label.setVisible(false);
        loginPlayer2Button.setVisible(false);

        savedGameList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        savedGameList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                savedGameListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(savedGameList);

        saveStartGameB.setText("Start Game");
        saveStartGameB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStartGameBActionPerformed(evt);
            }
        });

        jLabel4.setText("Player 2 Login");
        jLabel4.setVisible(false);

        loginLoadP2Button.setText("Login");
        loginLoadP2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginLoadP2ButtonActionPerformed(evt);
            }
        });
        loginLoadP2Button.setVisible(false);

        jLabel5.setText("This is a two player game");
        jLabel5.setVisible(false);

        javax.swing.GroupLayout loadSavedGameDialogLayout = new javax.swing.GroupLayout(loadSavedGameDialog.getContentPane());
        loadSavedGameDialog.getContentPane().setLayout(loadSavedGameDialogLayout);
        loadSavedGameDialogLayout.setHorizontalGroup(
            loadSavedGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadSavedGameDialogLayout.createSequentialGroup()
                .addGroup(loadSavedGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadSavedGameDialogLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(loadSavedGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(loginLoadP2Button)
                            .addComponent(jLabel5)
                            .addComponent(loginLoadP2CompLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loadSavedGameDialogLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(saveStartGameB)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        loadSavedGameDialogLayout.setVerticalGroup(
            loadSavedGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadSavedGameDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loadSavedGameDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadSavedGameDialogLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(loginLoadP2Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginLoadP2CompLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(saveStartGameB)
                .addContainerGap())
        );

        jLabel8.setText("Player 2 login below and then click Finish");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton4.setText("Finish");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p2LoginDialogLayout = new javax.swing.GroupLayout(p2LoginDialog.getContentPane());
        p2LoginDialog.getContentPane().setLayout(p2LoginDialogLayout);
        p2LoginDialogLayout.setHorizontalGroup(
            p2LoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2LoginDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(p2LoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(loginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p2LoginDialogLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addContainerGap())))
        );
        p2LoginDialogLayout.setVerticalGroup(
            p2LoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p2LoginDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p2LoginDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(p2LoginDialogLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, p2LoginDialogLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(loginPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        newGameB.setText("New Game");
        newGameB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameBActionPerformed(evt);
            }
        });

        jButton2.setText("Load Game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Statistics");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        logoffB.setText("Log off");
        logoffB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoffBActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("Crossword Helper 2000");

        helloText.setText("Hello");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logoffB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(helloText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userWelcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(newGameB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(helloText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userWelcomeText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addComponent(newGameB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoffB)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newGameBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameBActionPerformed
            list= new DefaultListModel();
            File directory = new File("./puzzles");  
            File[] files = directory.listFiles();    
            for (int index = 0; index < files.length; index++)  
            {  
                list.addElement(files[index].getName());  
            }
         gameList.setModel(list);
        newGameOpt.pack();
        newGameOpt.setLocationRelativeTo(this);
        newGameOpt.setVisible(true);
    }//GEN-LAST:event_newGameBActionPerformed

    private void newStartGameBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStartGameBActionPerformed
      GUIManager manager = GUIManager.getGUIManager();
      if(gameList.getSelectedIndex()!=-1){
      if(playerNumToggle.isSelected() && loginP2CompLabel.getText().equals("Complete"))
      {
          manager.currentGame=new crossGame((String)list.get(gameList.getSelectedIndex()),true);
          newGameOpt.setVisible(false);
          manager.ReplacePanel(new GamePanel(),800,600);
          
      }
      else if(!playerNumToggle.isSelected()){
      manager.currentGame=new crossGame((String)list.get(gameList.getSelectedIndex()),false);
      newGameOpt.setVisible(false);
      manager.ReplacePanel(new GamePanel(),800,600);  
      }
      }
      
      
    }//GEN-LAST:event_newStartGameBActionPerformed

    private void logoffBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoffBActionPerformed
        GUIManager manager = GUIManager.getGUIManager();
        UserDataHandler.SaveUserData(manager.currentUser[0]);
        manager.currentUser[0]=null;
        manager.ReplacePanel(new LoginPanel(),400, 300);
        
    }//GEN-LAST:event_logoffBActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      GUIManager manager=GUIManager.getGUIManager();
      manager.ReplacePanel(new StatisticsPanel(), 500,270);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GUIManager manager=GUIManager.getGUIManager();
        list= new DefaultListModel();
         
        for (crossGame g : manager.currentUser[0].savedGames)  
            {  
                list.addElement(g.name);  
            }
        savedGameList.setModel(list);
        loadSavedGameDialog.pack();
        loadSavedGameDialog.setLocationRelativeTo(this);
        loadSavedGameDialog.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void saveStartGameBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStartGameBActionPerformed
           GUIManager manager = GUIManager.getGUIManager();
           if(savedGameList.getSelectedIndex()!=-1){
           if(loginLoadP2Button.isVisible() && loginLoadP2CompLabel.getText().equals("Complete")){
           manager.currentGame=UserDataHandler.GetCrossGame(manager.currentUser[0],(String)list.get(savedGameList.getSelectedIndex()));
           loadSavedGameDialog.setVisible(false);
           manager.ReplacePanel(new GamePanel(), 800, 600);
           }
           else if(!loginLoadP2Button.isVisible()){
           manager.currentGame=UserDataHandler.GetCrossGame(manager.currentUser[0],(String)list.get(savedGameList.getSelectedIndex()));
           loadSavedGameDialog.setVisible(false);
           manager.ReplacePanel(new GamePanel(), 800, 600);
               
           }
           }
    }//GEN-LAST:event_saveStartGameBActionPerformed

    private void playerNumToggleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_playerNumToggleItemStateChanged
        if(evt.getStateChange()==ItemEvent.DESELECTED){
             playerNumToggle.setText("One");
             loginPlayer2Label.setVisible(false);
             loginPlayer2Button.setVisible(false);
             
        }
         if(evt.getStateChange()==ItemEvent.SELECTED){
             playerNumToggle.setText("Two");
             loginPlayer2Label.setVisible(true);
             loginPlayer2Button.setVisible(true);
         }
             
    }//GEN-LAST:event_playerNumToggleItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(loginPanel1.login==true){
           if(newGameOpt.isVisible()){
           playerNumToggle.setEnabled(false);
           loginP2CompLabel.setText("Complete");
           loginPlayer2Button.setEnabled(false);
           }
           else if(loadSavedGameDialog.isVisible()){
           loginLoadP2CompLabel.setText("Complete");
           loginLoadP2Button.setEnabled(false);
           }
           loginPanel1.login=false;
           loginPanel1.loginClear();
           p2LoginDialog.setVisible(false);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void loginPlayer2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginPlayer2ButtonActionPerformed
        p2LoginDialog.pack();
        p2LoginDialog.setLocationRelativeTo(this);
        p2LoginDialog.setVisible(true);
    }//GEN-LAST:event_loginPlayer2ButtonActionPerformed

    private void loginLoadP2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginLoadP2ButtonActionPerformed
        p2LoginDialog.pack();
        p2LoginDialog.setLocationRelativeTo(this);
        p2LoginDialog.setVisible(true);
    }//GEN-LAST:event_loginLoadP2ButtonActionPerformed

    private void savedGameListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_savedGameListValueChanged
     GUIManager manager = GUIManager.getGUIManager();
     crossGame temp;
     temp=UserDataHandler.GetCrossGame(manager.currentUser[0],(String)list.get(savedGameList.getSelectedIndex()));
     if(temp.twoPlayers){
         loginLoadP2Button.setVisible(true);
         jLabel5.setVisible(true);
         jLabel4.setVisible(true);
     }
     else{
         loginLoadP2Button.setVisible(false);
         jLabel5.setVisible(false);
         jLabel4.setVisible(false);
         loginLoadP2Button.setEnabled(true);
         loginLoadP2CompLabel.setText("");
     }
     
    }//GEN-LAST:event_savedGameListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList gameList;
    private javax.swing.JLabel helloText;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog loadSavedGameDialog;
    private javax.swing.JButton loginLoadP2Button;
    private javax.swing.JLabel loginLoadP2CompLabel;
    private javax.swing.JLabel loginP2CompLabel;
    private crosswordgame.LoginPanel loginPanel1;
    private javax.swing.JButton loginPlayer2Button;
    private javax.swing.JLabel loginPlayer2Label;
    private javax.swing.JButton logoffB;
    private javax.swing.JButton newGameB;
    private javax.swing.JDialog newGameOpt;
    private javax.swing.JButton newStartGameB;
    private javax.swing.JDialog p2LoginDialog;
    private javax.swing.JToggleButton playerNumToggle;
    private javax.swing.JButton saveStartGameB;
    private javax.swing.JList savedGameList;
    private javax.swing.JLabel userWelcomeText;
    // End of variables declaration//GEN-END:variables
}
