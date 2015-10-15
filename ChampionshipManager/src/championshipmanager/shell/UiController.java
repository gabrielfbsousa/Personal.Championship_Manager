/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.shell;

import DefaultQuarterFinals.DefaultQuarterFinalsManager;
import QuarterFinalsWithSecondsBest.QuarterFinalsWithBestSecondsManager;
import SemiFinals.SemiFinalsManager;
import groupstageplugin.NewGroupStageManager;
import windowPlugin.MainWindow;

import interfaces.IMainWindow;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author GabrielFerreira
 */
public class UiController implements IUiController {

    private MainWindow mainWindow;

    public UiController() {
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setSize(1000, 1000);
        mainWindow.getJToolBar3().setVisible(false);
    }

    @Override
    public JButton addToolBar1Item(String iconName) { //Toolbar 1
        javax.swing.JButton newButton = new javax.swing.JButton();

        newButton.setIcon(new javax.swing.ImageIcon(iconName));
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainWindow.getJToolBar1().add(newButton);
        return newButton;
    }

    @Override
    public JButton addToolBar2Item(String iconName) { //Toolbar 2
        javax.swing.JButton newButton = new javax.swing.JButton();

        newButton.setIcon(new javax.swing.ImageIcon(iconName));
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainWindow.getJToolBar2().add(newButton);
        return newButton;
    }
    
    @Override
    public JButton addToolBar3Item(String iconName) { //Toolbar 2
        javax.swing.JButton newButton = new javax.swing.JButton();

        newButton.setIcon(new javax.swing.ImageIcon(iconName));
        newButton.setFocusable(false);
        newButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        newButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        mainWindow.getJToolBar3().add(newButton);
        return newButton;
    }

    public void switchOptionsBar() {
        javax.swing.JToolBar topToolBar = mainWindow.getJToolBar1();
        if (topToolBar.isEnabled()) {
            topToolBar.setEnabled(false);
            topToolBar.setVisible(false);
            int aux = 0;
            while (aux < topToolBar.getComponents().length) {
                topToolBar.getComponent(aux).setVisible(false);
                topToolBar.getComponent(aux).setEnabled(false);
                aux++;
            }
        } else {
            topToolBar.setEnabled(true);
            topToolBar.setVisible(true);
        }
        mainWindow.revalidate();
        mainWindow.repaint();
    }
    
    @Override
    public void clearPanel(){
        mainWindow.getjPanel2().removeAll();
    }

    @Override
    public MainWindow getMainWindow() {
        return mainWindow;
    }
    
    public javax.swing.JToolBar getToolBar3(){
        return mainWindow.getJToolBar3();
    }

    @Override
    public boolean addMenu(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JMenuItem addMenuItem(String string, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
