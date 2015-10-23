/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createplayerplugin;

import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author GabrielFerreira
 */
public class PlayerPlugin implements IPlugin {
    //private PlayersPanel panel;

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(0, 2);
        panel.setLayout(layout);
        panel.setBackground(new Color(0, 0, 0, 64));
        
        JButton newButton = new JButton();
        newButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplayer/newplayer/newplayer.png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    uiController.getMainWindow().getjPanel2().removeAll();
                    NewPlayerManager newPlayerManager = new NewPlayerManager();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    uiController.getMainWindow().getjPanel2().add(newPlayerManager.getNewPlayerPanel(), BorderLayout.CENTER);
                    uiController.getMainWindow().revalidate();
                    uiController.getMainWindow().repaint();
                }
            });
        }
        panel.add(newButton);

        newButton = new JButton();
        newButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplayer/searchinpreviouschampionship/performance.png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //Ainda não implementado
                }
            });
        }
        panel.add(newButton);

        newButton = new JButton();
        newButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplayer/edit/edit.png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                }
            });
        }
        panel.add(newButton);

        newButton = new JButton();
        newButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplayer/deleteplayer/delete.png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {

                }
            });
        }
        panel.add(newButton);
        
        

        uiController.getMainWindow().getjPanel2().add(panel, BorderLayout.CENTER);

    }
    
    

}
