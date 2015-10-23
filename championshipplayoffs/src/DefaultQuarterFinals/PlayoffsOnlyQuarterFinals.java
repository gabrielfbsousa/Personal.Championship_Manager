/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DefaultQuarterFinals;

import championshipmanager.DaoInsert;
import groupstageplugin.IGroupsManager;
import ThreeParticipantsGroup.ThreeParticipantsManager;
import createplayerplugin.Player;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import tableandmatches.Match;
import tableandmatches.PlayerPerformance;

/**
 *
 * @author gabriel
 */
public class PlayoffsOnlyQuarterFinals extends DefaultQuarterFinalsManager{
    
    public IUiController uiController;

    public PlayoffsOnlyQuarterFinals(IUiController uiController) {
        hadPreviousPhase = false;
        this.uiController = uiController;
        this.championshipID = 1 + (int) (Math.random() * 5000);
        players = new ArrayList();
        
        panel.getjPanel1().setVisible(false);
        panel.getjPanel2().setVisible(false);
        panel.getjPanel3().setVisible(false);
        panel.getjPanel4().setVisible(false);
        panel.getjPanel5().setVisible(false);
        panel.getjPanel6().setVisible(false);
        panel.getjPanel7().setVisible(false);
        panel.getjPanel8().setVisible(false);
        
        fillBoxWithAllPlayers(panel.getjComboBox15());
        fillBoxWithAllPlayers(panel.getjComboBox16());
        fillBoxWithAllPlayers(panel.getjComboBox17());
        fillBoxWithAllPlayers(panel.getjComboBox18());
        fillBoxWithAllPlayers(panel.getjComboBox19());
        fillBoxWithAllPlayers(panel.getjComboBox20());
        fillBoxWithAllPlayers(panel.getjComboBox21());
        fillBoxWithAllPlayers(panel.getjComboBox22());
        
        configureSelectPhotoButtons();
        configureConfirmationButton();
    }

    
    private void configureSelectPhotoButtons() {
        javax.swing.JButton button6 = panel.getjButton6();
        button6.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel1().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathOne = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel1(), photoTeamPathOne);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });

        javax.swing.JButton button7 = panel.getjButton7();
        button7.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel2().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathTwo = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel2(), photoTeamPathTwo);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });

        javax.swing.JButton button8 = panel.getjButton8();
        button8.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel3().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathThree = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel3(), photoTeamPathThree);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });

        javax.swing.JButton button9 = panel.getjButton9();
        button9.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel4().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathFour = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel4(), photoTeamPathFour);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
        
        javax.swing.JButton button10 = panel.getjButton10();
        button10.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel5().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathFive = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel5(), photoTeamPathFive);
                    uiController.getMainWindow().pack();
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
        
        javax.swing.JButton button11 = panel.getjButton11();
        button11.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel6().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathSix = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel6(), photoTeamPathSix);
                    uiController.getMainWindow().pack();
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
        
        javax.swing.JButton button12 = panel.getjButton12();
        button12.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel7().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathSeven = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel7(), photoTeamPathSeven);
                    uiController.getMainWindow().pack();
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
        
        javax.swing.JButton button13 = panel.getjButton13();
        button13.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel8().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathEight = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel8(), photoTeamPathEight);
                    uiController.getMainWindow().pack();
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
        
    }
    
    private void configureConfirmationButton(){
        javax.swing.JButton button = panel.getjButton14();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                uiController.getMainWindow().getjPanel2().removeAll();
                uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());
                
                String selectedOne = panel.getjComboBox15().getSelectedItem() + "";
                String selectedTwo = panel.getjComboBox16().getSelectedItem() + "";
                String selectedThree = panel.getjComboBox17().getSelectedItem() + "";
                String selectedFour = panel.getjComboBox18().getSelectedItem() + "";
                String selectedFive = panel.getjComboBox19().getSelectedItem() + "";
                String selectedSix = panel.getjComboBox20().getSelectedItem() + "";
                String selectedSeven = panel.getjComboBox21().getSelectedItem() + "";
                String selectedEight = panel.getjComboBox22().getSelectedItem() + "";
                
                PlayerPerformance playerOne = new PlayerPerformance(selectedOne, championshipID,photoTeamPathOne);
                PlayerPerformance playerTwo = new PlayerPerformance(selectedTwo, championshipID,photoTeamPathTwo);
                PlayerPerformance playerThree = new PlayerPerformance(selectedThree, championshipID,photoTeamPathThree);
                PlayerPerformance playerFour = new PlayerPerformance(selectedFour, championshipID, photoTeamPathFour);
                PlayerPerformance playerFive = new PlayerPerformance(selectedFive, championshipID,photoTeamPathFive);
                PlayerPerformance playerSix = new PlayerPerformance(selectedSix, championshipID, photoTeamPathSix);
                PlayerPerformance playerSeven = new PlayerPerformance(selectedSeven, championshipID, photoTeamPathSix);
                PlayerPerformance playerEight = new PlayerPerformance(selectedEight, championshipID, photoTeamPathSix);

                players.add(playerOne);
                players.add(playerTwo);
                players.add(playerThree);
                players.add(playerFour);
                players.add(playerFive);
                players.add(playerSix);
                players.add(playerSeven);
                players.add(playerEight);

                fillBoxWithAllPlayers(panel.getjComboBox1(), playerOne);
                fillBoxWithAllPlayers(panel.getjComboBox2(), playerTwo);
                fillBoxWithAllPlayers(panel.getjComboBox3(), playerThree);
                fillBoxWithAllPlayers(panel.getjComboBox4(), playerFour);
                fillBoxWithAllPlayers(panel.getjComboBox5(), playerFive);
                fillBoxWithAllPlayers(panel.getjComboBox6(), playerSix);
                fillBoxWithAllPlayers(panel.getjComboBox7(), playerSeven);
                fillBoxWithAllPlayers(panel.getjComboBox8(), playerEight);
                
                getPanel().getjPanel10().setBackground(new Color(0,0,0,64));
                uiController.getMainWindow().getjPanel2().add(getPanel().getjPanel10(), BorderLayout.CENTER);
                uiController.getMainWindow().revalidate();
                uiController.getMainWindow().repaint();
                uiController.getMainWindow().pack();
            }
        });
    }
    
}
