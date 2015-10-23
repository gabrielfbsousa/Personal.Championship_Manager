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
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tableandmatches.Match;
import tableandmatches.MatchManager;
import tableandmatches.PlayerPerformance;

/**
 *
 * @author gabrielferreira
 */
public class SemiFinalsManager {

    SemiFinalsManagerPanel panel;
    ArrayList<PlayerPerformance> players;
    int championshipID;
    boolean hadPreviousPhase;

    private PlayerPerformance leaderOne;
    private PlayerPerformance leaderTwo;
    private PlayerPerformance secondOne;
    private PlayerPerformance secondTwo;
    private PlayerPerformance finalistOne;
    private PlayerPerformance finalistTwo;

    String photoTeamPathOne;
    String photoTeamPathTwo;
    String photoTeamPathThree;
    String photoTeamPathFour;

    private DaoInsert dao;

    public SemiFinalsManager() { 
        panel = new SemiFinalsManagerPanel();
        panel.setVisible(true);
        dao = new DaoInsert();

        createButtonSemiOne();
        createButtonSemiTwo();
        createButtonChampion();
        configureJCheckBox1();
        configureJCheckBox2();
        configureJCheckBox3();
    }

    public SemiFinalsManagerPanel getPanel() {
        return panel;
    }

    public void fillBoxWithAllPlayers(JComboBox comboBox) {
        ArrayList<Player> allPlayers = new ArrayList();

        try {
            allPlayers = dao.selectAllPlayers();
        } catch (SQLException ex) {
            Logger.getLogger(ThreeParticipantsManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < allPlayers.size(); i++) {
            comboBox.addItem(allPlayers.get(i).getName());
        }
    }

    public void fillBoxWithAllPlayers(JComboBox comboBox, PlayerPerformance player) {
        comboBox.addItem(player.getPlayerName());
    }

    public void createButtonSemiOne() {
        javax.swing.JButton button = panel.getjButton1();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                leaderOne = new PlayerPerformance(panel.getjComboBox1().getSelectedItem() + "", championshipID);
                secondTwo = new PlayerPerformance(panel.getjComboBox2().getSelectedItem() + "", championshipID);

                Match match = new Match(championshipID, leaderOne, secondTwo);
                match.setHomeScore(Integer.parseInt(panel.getjTextField1().getText()));
                match.setAwayScore(Integer.parseInt(panel.getjTextField2().getText()));
                if (panel.getjCheckBox1().isSelected()) {
                    match.setHomePenalties(Integer.parseInt(panel.getjTextField7().getText()));
                    match.setAwayPenalties(Integer.parseInt(panel.getjTextField8().getText()));
                } else {
                    match.setHomePenalties(0);
                    match.setAwayPenalties(0);
                }
                match.getResultOfTheMatch();
                dao.insertMatch(match);
                if (leaderOne.isEliminated()) {
                    giveRankingPoints(10, leaderOne);
                    finalistOne = secondTwo;
                    panel.getjComboBox5().addItem(finalistOne.getPlayerName());
                } else {
                    giveRankingPoints(10, secondTwo);
                    finalistOne = leaderOne;
                    panel.getjComboBox5().addItem(finalistOne.getPlayerName());
                }
            }
        });
    }

    public void createButtonSemiTwo() {
        javax.swing.JButton button = panel.getjButton2();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                leaderTwo = new PlayerPerformance(panel.getjComboBox3().getSelectedItem() + "", championshipID);
                secondOne = new PlayerPerformance(panel.getjComboBox4().getSelectedItem() + "", championshipID);

                Match match = new Match(championshipID, leaderTwo, secondOne);
                match.setHomeScore(Integer.parseInt(panel.getjTextField3().getText()));
                match.setAwayScore(Integer.parseInt(panel.getjTextField4().getText()));
                if (panel.getjCheckBox2().isSelected()) {
                    match.setHomePenalties(Integer.parseInt(panel.getjTextField9().getText()));
                    match.setAwayPenalties(Integer.parseInt(panel.getjTextField10().getText()));
                } else {
                    match.setHomePenalties(0);
                    match.setAwayPenalties(0);
                }
                match.getResultOfTheMatch();
                dao.insertMatch(match);
                if (leaderTwo.isEliminated()) {
                    giveRankingPoints(10, leaderTwo);
                    finalistTwo = secondOne;
                    panel.getjComboBox6().addItem(finalistTwo.getPlayerName());
                } else {
                    giveRankingPoints(10, secondOne);
                    finalistTwo = leaderTwo;
                    panel.getjComboBox6().addItem(finalistTwo.getPlayerName());
                }
            }
        });
    }

    public void createButtonChampion() {
        javax.swing.JButton button = panel.getjButton3();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Match match = new Match(championshipID, finalistOne, finalistTwo);
                match.setHomeScore(Integer.parseInt(panel.getjTextField5().getText()));
                match.setAwayScore(Integer.parseInt(panel.getjTextField6().getText()));
                if (panel.getjCheckBox3().isSelected()) {
                    match.setHomePenalties(Integer.parseInt(panel.getjTextField11().getText()));
                    match.setAwayPenalties(Integer.parseInt(panel.getjTextField12().getText()));
                } else {
                    match.setHomePenalties(0);
                    match.setAwayPenalties(0);
                }
                match.getResultOfTheMatch();
                dao.insertMatch(match);
                if (finalistOne.isEliminated()) {
                    giveRankingPoints(20, finalistOne);
                    giveRankingPoints(25, finalistTwo);
                    panel.getjTextField13().setText(finalistTwo.getPlayerName());
                } else {
                    giveRankingPoints(20, finalistTwo);
                    giveRankingPoints(25, finalistOne);
                    panel.getjTextField13().setText(finalistOne.getPlayerName());
                }
                
                JFrame frame = new JFrame(); // Frame pra fazer o relatório do campeonato, com a opção de concluir
                frame.setVisible(true);
            }
        });
    }

    public void giveRankingPoints(int pointsEarnedFromChampionship, PlayerPerformance player) {
        if (!hadPreviousPhase) {
            insertPerformanceIntoDatabase(pointsEarnedFromChampionship, player);
        } else {
            givePointsToPlayer(pointsEarnedFromChampionship, player);
        }
    }

    public void insertPerformanceIntoDatabase(int pointsEarnedFromChampionship, PlayerPerformance player) {
        try {
            dao.eliminatedFromPlayoffs(championshipID, player, pointsEarnedFromChampionship);
        } catch (SQLException ex) {
            Logger.getLogger(SemiFinalsManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            dao.createPlayoffsChampionship(championshipID, player, 6);
        } catch (SQLException ex) {
            Logger.getLogger(SemiFinalsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void givePointsToPlayer(int pointsEarnedFromChampionship, PlayerPerformance player) {

        try {
            dao.updateRankingPoints(pointsEarnedFromChampionship, player);
        } catch (SQLException ex) {
            Logger.getLogger(SemiFinalsManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void configureJCheckBox1() {
        JCheckBox checkBox = panel.getjCheckBox1();
        checkBox.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox.isSelected()) {
                    panel.getjTextField7().setEditable(true);
                    panel.getjTextField8().setEditable(true);
                } else {
                    panel.getjTextField7().setEditable(false);
                    panel.getjTextField8().setEditable(false);
                }

            }
        });
    }

    public void configureJCheckBox2() {
        JCheckBox checkBox = panel.getjCheckBox2();
        checkBox.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox.isSelected()) {
                    panel.getjTextField9().setEditable(true);
                    panel.getjTextField10().setEditable(true);
                } else {
                    panel.getjTextField9().setEditable(false);
                    panel.getjTextField10().setEditable(false);
                }

            }
        });

    }

    public void configureJCheckBox3() {
        JCheckBox checkBox = panel.getjCheckBox3();
        checkBox.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox.isSelected()) {
                    panel.getjTextField11().setEditable(true);
                    panel.getjTextField12().setEditable(true);
                } else {
                    panel.getjTextField11().setEditable(false);
                    panel.getjTextField12().setEditable(false);
                }

            }
        });

    }

    public void addIcon(JPanel panel, String address) {
        javax.swing.ImageIcon img = new javax.swing.ImageIcon(address);

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);
        panel.revalidate();
        panel.repaint();
    }

}
