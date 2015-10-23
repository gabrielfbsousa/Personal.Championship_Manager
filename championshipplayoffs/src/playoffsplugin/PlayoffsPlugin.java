/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playoffsplugin;

import DefaultQuarterFinals.DefaultQuarterFinalsManager;
import DefaultQuarterFinals.PlayoffsOnlyQuarterFinals;
import QuarterFinalsWithSecondsBest.PlayoffsOnlyQuarterFinalsWithSecondsBest;
import QuarterFinalsWithSecondsBest.QuarterFinalsWithBestSecondsManager;
import SemiFinals.PlayoffsOnlySemiFinals;
import SemiFinals.SemiFinalsManager;
import groupstageplugin.NewGroupStageManager;
import interfaces.ICore;
import interfaces.IPlugin;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author GabrielFerreira
 */
public class PlayoffsPlugin implements IPlugin {
    
    private JButton semiFinalButton;
    private JButton quarterButton;
    private JButton quarterWithBestButton;

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();

        semiFinalButton = new JButton();
        semiFinalButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplus/semis/semifinals.png")); // NOI18N
        semiFinalButton.setFocusable(false);
        semiFinalButton.setBorderPainted(false);

        if (semiFinalButton != null) {
            semiFinalButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PlayoffsOnlySemiFinals semis = new PlayoffsOnlySemiFinals(uiController);
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    semis.getPanel().getjPanel3().setBackground(new Color(0, 0, 0, 64));
                    JScrollPane scroll = new JScrollPane();

                    uiController.getMainWindow().getjPanel2().add(semis.getPanel().getjPanel3(), BorderLayout.CENTER);
                    uiController.getMainWindow().revalidate();
                    uiController.getMainWindow().repaint();
                    uiController.getMainWindow().pack();
                }
            });
        }
        
        quarterButton = new JButton();
        quarterButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplus/quarters/quarters.png")); // NOI18N
        quarterButton.setFocusable(false);
        quarterButton.setBorderPainted(false);
        if (quarterButton != null) {
            quarterButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PlayoffsOnlyQuarterFinals quarter = new PlayoffsOnlyQuarterFinals(uiController);
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    
                    quarter.getPanel().getjPanel9().setBackground(new Color(0, 0, 0, 64));
                    uiController.getMainWindow().getjPanel2().add(quarter.getPanel().getjPanel9(), BorderLayout.CENTER);
                    uiController.getMainWindow().revalidate();
                    uiController.getMainWindow().repaint();
                    uiController.getMainWindow().pack();
                }
            });
        }
        
        quarterWithBestButton = new JButton();
        quarterWithBestButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/menuplus/quarterswithbests/quarterswithbests.png")); // NOI18N
        quarterWithBestButton.setFocusable(false);
        quarterWithBestButton.setBorderPainted(false);
        if (quarterWithBestButton != null) {
            quarterWithBestButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PlayoffsOnlyQuarterFinalsWithSecondsBest quarterWithBest = new PlayoffsOnlyQuarterFinalsWithSecondsBest(uiController);
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    
                    quarterWithBest.getPanel().getjPanel7().setBackground(new Color(0, 0, 0, 64));
                    uiController.getMainWindow().getjPanel2().add(quarterWithBest.getPanel().getjPanel7(), BorderLayout.CENTER);
                    uiController.getMainWindow().revalidate();
                    uiController.getMainWindow().repaint();
                    uiController.getMainWindow().pack();
                }
            });
        }
    }
    
    public JButton getSemiFinalsButton(){
        return semiFinalButton;
    }
    
    public JButton getQuarterButton(){
        return quarterButton;
    }
    
    public JButton getQuarterWithBestButton(){
        return quarterWithBestButton;
    }
}
