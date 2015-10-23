/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemiFinals;

import championshipmanager.DaoInsert;
import groupstageplugin.IGroupsManager;
import ThreeParticipantsGroup.ThreeParticipantsManager;
import createplayerplugin.Player;
import interfaces.ICore;
import interfaces.IUiController;
import java.awt.BorderLayout;
import java.awt.Color;
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
public class PlayoffsOnlySemiFinals extends SemiFinalsManager {

    public IUiController uiController;

    public PlayoffsOnlySemiFinals(IUiController uiController) {
        super();
        this.uiController = uiController;
        hadPreviousPhase = false;
        championshipID = 1 + (int) (Math.random() * 5000);
        players = new ArrayList();
        
        
        panel.getjPanel1().setVisible(false);
        panel.getjPanel2().setVisible(false);
        panel.getjPanel4().setVisible(false);
        panel.getjPanel5().setVisible(false);
        
        fillBoxWithAllPlayers(panel.getjComboBox7());
        fillBoxWithAllPlayers(panel.getjComboBox8());
        fillBoxWithAllPlayers(panel.getjComboBox9());
        fillBoxWithAllPlayers(panel.getjComboBox10());
        configureSelectPhotoButtons();
        configureConfirmationButton();
    }

    private void configureSelectPhotoButtons() {
        javax.swing.JButton button4 = panel.getjButton4();
        button4.addActionListener(new java.awt.event.ActionListener() {

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

        javax.swing.JButton button5 = panel.getjButton5();
        button5.addActionListener(new java.awt.event.ActionListener() {

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

        javax.swing.JButton button6 = panel.getjButton6();
        button6.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    panel.getjPanel4().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathThree = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel4(), photoTeamPathThree);
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
                    panel.getjPanel5().setVisible(true);
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathFour = documentFile.getAbsolutePath();
                    addIcon(panel.getjPanel5(), photoTeamPathFour);
                    panel.revalidate();
                    panel.repaint();
                }
            }
        });
    }

    public void configureConfirmationButton() {
        javax.swing.JButton button = panel.getjButton8();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                uiController.getMainWindow().getjPanel2().removeAll();
                uiController.getMainWindow().getjPanel2().setLayout(new BorderLayout());

                String selectedOne = panel.getjComboBox7().getSelectedItem() + "";
                String selectedTwo = panel.getjComboBox8().getSelectedItem() + "";
                String selectedThree = panel.getjComboBox9().getSelectedItem() + "";
                String selectedFour = panel.getjComboBox10().getSelectedItem() + "";

                PlayerPerformance playerOne = new PlayerPerformance(selectedOne, championshipID, photoTeamPathOne);
                PlayerPerformance playerTwo = new PlayerPerformance(selectedTwo, championshipID, photoTeamPathTwo);
                PlayerPerformance playerThree = new PlayerPerformance(selectedThree, championshipID, photoTeamPathThree);
                PlayerPerformance playerFour = new PlayerPerformance(selectedFour, championshipID, photoTeamPathFour);

                players.add(playerOne);
                players.add(playerTwo);
                players.add(playerThree);
                players.add(playerFour);

                fillBoxWithAllPlayers(panel.getjComboBox1(), playerOne);
                fillBoxWithAllPlayers(panel.getjComboBox2(), playerTwo);
                fillBoxWithAllPlayers(panel.getjComboBox3(), playerThree);
                fillBoxWithAllPlayers(panel.getjComboBox4(), playerFour);
                
                getPanel().getjPanel6().setBackground(new Color(0, 0, 0, 64));
                uiController.getMainWindow().getjPanel2().add(getPanel().getjPanel6(), BorderLayout.CENTER);
                uiController.getMainWindow().revalidate();
                uiController.getMainWindow().repaint();
                uiController.getMainWindow().pack();

            }
        });
    }

}
