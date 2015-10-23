/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.shell;

import DefaultQuarterFinals.DefaultQuarterFinalsManager;
import QuarterFinalsWithSecondsBest.QuarterFinalsWithBestSecondsManager;
import SemiFinals.SemiFinalsManager;
import createplayerplugin.NewPlayerManager;
import createplayerplugin.NewPlayerPanel;
import createplayerplugin.PlayerPlugin;

import groupstageplugin.NewGroupStageManager;
import windowPlugin.MainWindow;

import interfaces.IMainWindow;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 *
 * @author GabrielFerreira
 */
public class UiController implements IUiController {

    private MainWindow mainWindow;

    public UiController() {
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setSize(1000, 2000);

        addBackgroundPhoto(mainWindow.getjPanel5(), "/home/gabriel/Downloads/fifabackground.png");
        mainWindow.getjPanel5().setSize(856, 1000);
        addBackgroundPhoto(mainWindow.getjPanel1(), "/home/gabriel/Downloads/barra.png");
        //addBackgroundPhoto(mainWindow.getjPanel2(), "/home/gabriel/Downloads/menu.png");
        //mainWindow.setContentPane(new JLabel(new ImageIcon("/home/gabriel/Downloads/fifabackground.png")));
        
        //mainWindow.getjPanel3().add(new NewPlayerPanel());
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void addBackgroundPhoto(JPanel panel, String address) {
        javax.swing.ImageIcon img = new javax.swing.ImageIcon(address);

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);
        
        panel.revalidate();
        panel.repaint();
    }

    @Override
    public void clearPanel() {
        mainWindow.getjPanel2().removeAll();
    }

    @Override
    public MainWindow getMainWindow() {
        return mainWindow;
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
