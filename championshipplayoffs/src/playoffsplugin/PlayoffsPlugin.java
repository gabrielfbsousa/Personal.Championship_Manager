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
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author GabrielFerreira
 */
public class PlayoffsPlugin implements IPlugin {

    @Override
    public void initialize(ICore core) {
        IUiController uiController = core.getUiController();

        javax.swing.JButton newButton = uiController.addToolBar3Item("../ChampionshipManagerResources/src/res/icons/menuplus/semis/semifinals.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PlayoffsOnlySemiFinals semis = new PlayoffsOnlySemiFinals(uiController);
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    //JScrollPane scroll = new JScrollPane();
                    //scroll.add(semis.getPanel());
                    uiController.getMainWindow().getjPanel2().add(semis.getPanel().getjPanel3(), BorderLayout.CENTER);
                    uiController.getMainWindow().revalidate();
                    uiController.getMainWindow().repaint();
                    uiController.getMainWindow().setSize(1200, 1000);
                }
            });
        }

        newButton = uiController.addToolBar3Item("../ChampionshipManagerResources/src/res/icons/menuplus/quarters/quarters.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PlayoffsOnlyQuarterFinals quarter = new PlayoffsOnlyQuarterFinals(uiController);
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    //JScrollPane scroll = new JScrollPane(quarter.getPanel());
                    //uiController.getMainWindow().getjPanel2().add(scroll, BorderLayout.CENTER);
                    uiController.getMainWindow().getjPanel2().add(quarter.getPanel().getjPanel9(), BorderLayout.CENTER);
                    uiController.getMainWindow().revalidate();
                    uiController.getMainWindow().repaint();
                    uiController.getMainWindow().setSize(1300, 1000);
                }
            });
        }

        newButton = uiController.addToolBar3Item("../ChampionshipManagerResources/src/res/icons/menuplus/quarterswithbests/quarterswithbests.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    PlayoffsOnlyQuarterFinalsWithSecondsBest quarterWithBest = new PlayoffsOnlyQuarterFinalsWithSecondsBest(uiController);
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    //JScrollPane scroll = new JScrollPane(quarterWithBest.getPanel());
                    //uiController.getMainWindow().getjPanel2().add(scroll, BorderLayout.CENTER);
                    uiController.getMainWindow().getjPanel2().add(quarterWithBest.getPanel().getjPanel7(), BorderLayout.CENTER);
                    uiController.getMainWindow().revalidate();
                    uiController.getMainWindow().repaint();
                    uiController.getMainWindow().setSize(1400, 1000);
                }
            });
        }
    }
}
