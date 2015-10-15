package createplayerplugin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import championshipmanager.DaoInsert;
import championshipmanager.DaoInsert;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabrielferreira
 */
public class NewPlayerManager {

    public NewPlayerPanel newPlayerPanel;
    private Player newPlayer;

    public NewPlayerManager() {
        newPlayerPanel = new NewPlayerPanel();
        newPlayerPanel.setVisible(true);
        newPlayer = new Player();
        initialize();
    }

    public NewPlayerPanel getNewPlayerPanel() {
        return newPlayerPanel;
    }
    
    

    public void initialize() {
        javax.swing.JButton selectPhoto = newPlayerPanel.getjButton1();
        selectPhoto.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                newPlayer.selectPhoto();
            }
        });

        javax.swing.JButton createPlayer = newPlayerPanel.getjButton2();
        createPlayer.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                javax.swing.JTextField nameField = newPlayerPanel.getjTextField1();
                String name = nameField.getText();
                newPlayer.setName(name);
                
                try {
                    newPlayer.copyPhoto();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(NewPlayerManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                DaoInsert dao = new DaoInsert();

                try {
                    dao.createPlayer(newPlayer);
                } catch (SQLException ex) {
                    Logger.getLogger(NewPlayerManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });

    }
    
}
