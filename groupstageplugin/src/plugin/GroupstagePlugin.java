/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plugin;

import createplayerplugin.NewPlayerManager;
import groupstageplugin.NewGroupStageManager;
import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author GabrielFerreira
 */
public class GroupstagePlugin implements IPlugin{
    
    private JButton button;

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();
        
        button = new JButton();
        button.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplus/groupstage/groupstage.png")); // NOI18N
        button.setFocusable(false);
        button.setBorderPainted(false);
        if (button != null) {
            button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewGroupStageManager newChampionship = new NewGroupStageManager(uiController.getMainWindow());
                uiController.getMainWindow().getjPanel2().removeAll();
                uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                newChampionship.getPontosPanel().setBackground(new Color(0, 0, 0, 64));
                uiController.getMainWindow().getjPanel2().add(newChampionship.getPontosPanel(), BorderLayout.CENTER);
                uiController.getMainWindow().revalidate();
                uiController.getMainWindow().repaint();
                uiController.getMainWindow().pack();
                }
            });
        }        
    }
    
    public JButton getButton(){
        return button;
    }
   
    
}
