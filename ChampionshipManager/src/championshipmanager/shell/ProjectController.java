/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.shell;

import championshipmanager.SearchPlugin;
import createplayerplugin.NewPlayerManager;
import createplayerplugin.NewPlayerPanel;
import createplayerplugin.PlayerPlugin;
import windowPlugin.MainWindow;
import interfaces.ICore;
import interfaces.IProjectController;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import playoffsplugin.PlayoffsPlugin;
import plugin.GroupstagePlugin;

/**
 *
 * @author GabrielFerreira O Project Controller monta a tela inicial do
 * programa. Usa, pra isso, elementos do UiController
 */
public class ProjectController implements IProjectController {

    @Override
    public void initialize(final ICore core) {
        final IUiController uiController = core.getUiController();
        final MainWindow mainWindow = (MainWindow) uiController.getMainWindow();

        //------------------------------------------Construir Botão Home -------------------
        javax.swing.JButton newButton = uiController.getMainWindow().getjButton1();
        newButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/primaries/home.png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);

        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainWindow.getjPanel2().removeAll();
                    mainWindow.revalidate();
                    mainWindow.repaint();
                }

            }
            );
        }

        //------------------------------------------Construir Botão Player -------------------
        newButton = uiController.getMainWindow().getjButton2();
        newButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/primaries/player18.png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());

                    PlayerPlugin plugin = new PlayerPlugin();
                    plugin.initialize(core);

                    mainWindow.pack();
                    mainWindow.revalidate();
                    mainWindow.repaint();

                }
            });
        }

        //------------------------------------------Construir Botão Search -------------------
        newButton = uiController.getMainWindow().getjButton3();
        newButton.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/primaries/search.png")); // NOI18N
        newButton.setFocusable(false);
        newButton.setBorderPainted(false);
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SearchPlugin plugin = new SearchPlugin();
                    plugin.initialize(core);
                }
            });
        }

        //------------------------------------------Construir Botão Torneios ------------------- 
        final javax.swing.JButton newButtonPlus = mainWindow.getjButton4();
        newButtonPlus.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/primaries/tournment.png")); // NOI18N
        newButtonPlus.setFocusable(false);
        newButtonPlus.setBorderPainted(false);
        if (newButtonPlus != null) {
            newButtonPlus.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    uiController.getMainWindow().getjPanel2().removeAll();
                    uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                    
                    JPanel panel = new JPanel();
                    GridLayout layout = new GridLayout(0, 2);
                    panel.setLayout(layout);
                    panel.setBackground(new Color(0, 0, 0, 64));
                    

                    GroupstagePlugin groupstagePlugin = new GroupstagePlugin();
                    groupstagePlugin.initialize(core);
                    panel.add(groupstagePlugin.getButton());

                    PlayoffsPlugin playoffsPlugin = new PlayoffsPlugin();
                    playoffsPlugin.initialize(core);
                    panel.add(playoffsPlugin.getQuarterButton());
                    panel.add(playoffsPlugin.getQuarterWithBestButton());
                    panel.add(playoffsPlugin.getSemiFinalsButton());

                    uiController.getMainWindow().getjPanel2().add(panel, BorderLayout.CENTER);
                    mainWindow.pack();
                    mainWindow.revalidate();
                    mainWindow.repaint();

                }
            });
        }

    }

}
