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

/**
 *
 * @author GabrielFerreira
 */
public class PlayerPlugin implements IPlugin{

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        
        javax.swing.JButton newButton = uiController.addToolBar1Item("../ChampionshipManagerResources/src/res/icons/menuplayer/newplayer/newplayer.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {      
                NewPlayerManager newPlayerManager = new NewPlayerManager();
                uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                uiController.getMainWindow().getjPanel2().add(newPlayerManager.getNewPlayerPanel(), BorderLayout.CENTER);
                uiController.getMainWindow().revalidate();
                uiController.getMainWindow().repaint();
            }
        });
        }
        
        newButton = uiController.addToolBar1Item("../ChampionshipManagerResources/src/res/icons/menuplayer/searchinpreviouschampionship/performance.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        }
        
        newButton = uiController.addToolBar1Item("../ChampionshipManagerResources/src/res/icons/menuplayer/edit/edit.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        }
        
        newButton = uiController.addToolBar1Item("../ChampionshipManagerResources/src/res/icons/menuplayer/deleteplayer/delete.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

            }
        });
        }
        

        
    }
    
}
