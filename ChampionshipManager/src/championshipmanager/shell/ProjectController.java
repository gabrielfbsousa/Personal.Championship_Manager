/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.shell;

import championshipmanager.SearchPlugin;
import createplayerplugin.PlayerPlugin;
import windowPlugin.MainWindow;
import interfaces.ICore;
import interfaces.IProjectController;
import interfaces.IUiController;
import java.awt.Color;
import java.awt.event.ActionEvent;
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
        uiController.switchOptionsBar();

        //------------------------------------------Construir Botão Home ------------------- ToolBar 2
        javax.swing.JButton newButton = uiController.addToolBar2Item("../ChampionshipManagerResources/src/res/icons/primaries/home.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainWindow.getjPanel2().removeAll();
                    javax.swing.JToolBar topToolBar = mainWindow.getJToolBar1();
                    if (topToolBar.isEnabled()) {
                        core.getUiController().switchOptionsBar();
                    }
                    mainWindow.revalidate();
                    mainWindow.repaint();
                }

            }
            );
        }

        //------------------------------------------Construir Botão Player ------------------- ToolBar 2
        newButton = uiController.addToolBar2Item("../ChampionshipManagerResources/src/res/icons/primaries/player18.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    mainWindow.getjPanel2().removeAll();

                    PlayerPlugin plugin = new PlayerPlugin();
                    plugin.initialize(core);
                    core.getUiController().switchOptionsBar();

                }
            });
        }

        //------------------------------------------Construir Botão Search ------------------- ToolBar 2
        newButton = uiController.addToolBar2Item("../ChampionshipManagerResources/src/res/icons/primaries/search.png");
        if (newButton != null) {
            newButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    SearchPlugin plugin = new SearchPlugin();
                    plugin.initialize(core);
                    core.getUiController().switchOptionsBar();
                }
            });
        }

        //------------------------------------------Construir Botão + ------------------- 
        final javax.swing.JButton newButtonPlus = mainWindow.getjButton9();
        newButtonPlus.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/primaries/circleblue24.png")); // NOI18N
        newButtonPlus.setFocusable(false);
        newButtonPlus.setBorderPainted(false);
        newButtonPlus.setOpaque(true);
        final Indicator indicator = new Indicator();
        if (newButtonPlus != null) {
            newButtonPlus.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    if (!indicator.isIndicator()) {
                        uiController.getMainWindow().getJToolBar3().setVisible(true);

                        GroupstagePlugin groupstagePlugin = new GroupstagePlugin();
                        groupstagePlugin.initialize(core);

                        PlayoffsPlugin playoffsPlugin = new PlayoffsPlugin();
                        playoffsPlugin.initialize(core);

                        indicator.change();
                        newButtonPlus.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/primaries/circleblue24minus.png")); // NOI18N
                        mainWindow.revalidate();
                        mainWindow.repaint();
                    } else {
                        uiController.getMainWindow().getJToolBar3().removeAll();
                        uiController.getMainWindow().getJToolBar3().setVisible(false);
                        indicator.change();
                        newButtonPlus.setIcon(new javax.swing.ImageIcon("../ChampionshipManagerResources/src/res/icons/primaries/circleblue24.png")); // NOI18N
                        mainWindow.revalidate();
                        mainWindow.repaint();
                    }
                }
            });
        }

    }

}
