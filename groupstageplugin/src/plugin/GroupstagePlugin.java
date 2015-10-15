/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugin;

import groupstageplugin.NewGroupStageManager;
import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUiController;
import java.awt.BorderLayout;

/**
 *
 * @author GabrielFerreira
 */
public class GroupstagePlugin implements IPlugin{

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        javax.swing.JButton newButton = uiController.addToolBar3Item("../ChampionshipManagerResources/src/res/icons/menuplus/groupstage/groupstage.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    NewGroupStageManager newChampionship = new NewGroupStageManager(uiController.getMainWindow());
                uiController.getMainWindow().getjPanel2().removeAll();
                uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                uiController.getMainWindow().getjPanel2().add(newChampionship.getPontosPanel(), BorderLayout.CENTER);
                uiController.getMainWindow().revalidate();
                uiController.getMainWindow().repaint();
                uiController.getMainWindow().setSize(1500, 1000);
                }
            });
        }        
    }
    
}
