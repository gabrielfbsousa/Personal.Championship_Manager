/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DefaultQuarterFinals;

import SemiFinals.SemiFinalsManager;
import championshipmanager.DaoInsert;
import groupstageplugin.IGroupsManager;
import ThreeParticipantsGroup.ThreeParticipantsManager;
import createplayerplugin.Player;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tableandmatches.Match;
import tableandmatches.PlayerPerformance;

/**
 *
 * @author gabrielferreira
 */
public class DefaultQuarterFinalsManager {

    DefaultQuarterFinalsPanel panel;
    ArrayList<PlayerPerformance> players;
    int championshipID;
    private DaoInsert dao;
    boolean hadPreviousPhase;
    private PlayerPerformance winnerA;
    private PlayerPerformance winnerB;
    private PlayerPerformance winnerC;
    private PlayerPerformance winnerD;
    private PlayerPerformance finalistOne;
    private PlayerPerformance finalistTwo;

    String photoTeamPathOne;
    String photoTeamPathTwo;
    String photoTeamPathThree;
    String photoTeamPathFour;
    String photoTeamPathFive;
    String photoTeamPathSix;
    String photoTeamPathSeven;
    String photoTeamPathEight;

    public DefaultQuarterFinalsManager() { //Apenas pra Mata-mata

        dao = new DaoInsert();
        panel = new DefaultQuarterFinalsPanel();
        panel.setVisible(true);

        configureAllCheckBoxes();
        createButtonQuarterOne();
        createButtonQuarterTwo();
        createButtonSemiTwo();
        createButtonSemiOne();
        createButtonChampion();
    }

    public DefaultQuarterFinalsPanel getPanel() {
        return panel;
    }

    public void fillBoxWithAllPlayers(JComboBox comboBox, PlayerPerformance player) {
        comboBox.addItem(player.getPlayerName());
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

    private void createButtonQuarterOne() {
        javax.swing.JButton button = panel.getjButton1();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------Match A
                PlayerPerformance homeMatchA = new PlayerPerformance(panel.getjComboBox1().getSelectedItem() + "", championshipID);
                PlayerPerformance awayMatchA = new PlayerPerformance(panel.getjComboBox2().getSelectedItem() + "", championshipID);

                Match matchA = new Match(championshipID, homeMatchA, awayMatchA);
                matchA.setHomeScore(Integer.parseInt(panel.getjTextField1().getText()));
                matchA.setAwayScore(Integer.parseInt(panel.getjTextField2().getText()));
                if (panel.getjCheckBox1().isSelected()) {
                    matchA.setHomePenalties(Integer.parseInt(panel.getjTextField15().getText()));
                    matchA.setAwayPenalties(Integer.parseInt(panel.getjTextField16().getText()));
                } else {
                    matchA.setHomePenalties(0);
                    matchA.setAwayPenalties(0);
                }
                matchA.getResultOfTheMatch();
                dao.insertMatch(matchA);
                if (homeMatchA.isEliminated()) {
                    giveRankingPoints(5, homeMatchA);
                    winnerA = awayMatchA;
                    panel.getjComboBox9().addItem(winnerA.getPlayerName());
                } else {
                    giveRankingPoints(5, awayMatchA);
                    winnerA = homeMatchA;
                    panel.getjComboBox9().addItem(winnerA.getPlayerName());
                }

                //------------------------------Match B
                PlayerPerformance homeMatchB = new PlayerPerformance(panel.getjComboBox3().getSelectedItem() + "", championshipID);
                PlayerPerformance awayMatchB = new PlayerPerformance(panel.getjComboBox4().getSelectedItem() + "", championshipID);

                Match matchB = new Match(championshipID, homeMatchB, awayMatchB);
                matchB.setHomeScore(Integer.parseInt(panel.getjTextField3().getText()));
                matchB.setAwayScore(Integer.parseInt(panel.getjTextField4().getText()));
                if (panel.getjCheckBox2().isSelected()) {
                    matchB.setHomePenalties(Integer.parseInt(panel.getjTextField17().getText()));
                    matchB.setAwayPenalties(Integer.parseInt(panel.getjTextField18().getText()));
                } else {
                    matchB.setHomePenalties(0);
                    matchB.setAwayPenalties(0);
                }
                matchB.getResultOfTheMatch();
                dao.insertMatch(matchB);
                if (homeMatchB.isEliminated()) {
                    giveRankingPoints(5, homeMatchB);
                    winnerB = awayMatchB;
                    panel.getjComboBox10().addItem(winnerB.getPlayerName());
                } else {
                    giveRankingPoints(5, awayMatchB);
                    winnerB = homeMatchB;
                    panel.getjComboBox10().addItem(winnerB.getPlayerName());
                }
            }
        });
    }

    private void createButtonQuarterTwo() {
        javax.swing.JButton button = panel.getjButton2();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //-------------------------------Match C
                PlayerPerformance homeMatchC = new PlayerPerformance(panel.getjComboBox5().getSelectedItem() + "", championshipID);
                PlayerPerformance awayMatchC = new PlayerPerformance(panel.getjComboBox6().getSelectedItem() + "", championshipID);

                Match matchC = new Match(championshipID, homeMatchC, awayMatchC);
                matchC.setHomeScore(Integer.parseInt(panel.getjTextField5().getText()));
                matchC.setAwayScore(Integer.parseInt(panel.getjTextField6().getText()));
                if (panel.getjCheckBox3().isSelected()) {
                    matchC.setHomePenalties(Integer.parseInt(panel.getjTextField19().getText()));
                    matchC.setAwayPenalties(Integer.parseInt(panel.getjTextField20().getText()));
                } else {
                    matchC.setHomePenalties(0);
                    matchC.setAwayPenalties(0);
                }
                matchC.getResultOfTheMatch();
                dao.insertMatch(matchC);
                if (homeMatchC.isEliminated()) {
                    giveRankingPoints(5, homeMatchC);
                    winnerC = awayMatchC;
                    panel.getjComboBox11().addItem(winnerC.getPlayerName());
                } else {
                    giveRankingPoints(5, awayMatchC);
                    winnerC = homeMatchC;
                    panel.getjComboBox11().addItem(winnerC.getPlayerName());
                }

                //------------------------------Match D
                PlayerPerformance homeMatchD = new PlayerPerformance(panel.getjComboBox7().getSelectedItem() + "", championshipID);
                PlayerPerformance awayMatchD = new PlayerPerformance(panel.getjComboBox8().getSelectedItem() + "", championshipID);

                Match matchD = new Match(championshipID, homeMatchD, awayMatchD);
                matchD.setHomeScore(Integer.parseInt(panel.getjTextField7().getText()));
                matchD.setAwayScore(Integer.parseInt(panel.getjTextField8().getText()));
                if (panel.getjCheckBox4().isSelected()) {
                    matchD.setHomePenalties(Integer.parseInt(panel.getjTextField21().getText()));
                    matchD.setAwayPenalties(Integer.parseInt(panel.getjTextField22().getText()));
                } else {
                    matchD.setHomePenalties(0);
                    matchD.setAwayPenalties(0);
                }

                matchD.getResultOfTheMatch();
                dao.insertMatch(matchD);
                if (homeMatchD.isEliminated()) {
                    giveRankingPoints(5, homeMatchD);
                    winnerD = awayMatchD;
                    panel.getjComboBox12().addItem(winnerD.getPlayerName());
                } else {
                    giveRankingPoints(5, awayMatchD);
                    winnerD = homeMatchD;
                    panel.getjComboBox12().addItem(winnerD.getPlayerName());
                }
            }
        });
    }

    public void createButtonSemiOne() {
        javax.swing.JButton button = panel.getjButton3();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Match match = new Match(championshipID, winnerA, winnerB);
                match.setHomeScore(Integer.parseInt(panel.getjTextField9().getText()));
                match.setAwayScore(Integer.parseInt(panel.getjTextField10().getText()));
                if (panel.getjCheckBox5().isSelected()) {
                    match.setHomePenalties(Integer.parseInt(panel.getjTextField23().getText()));
                    match.setAwayPenalties(Integer.parseInt(panel.getjTextField24().getText()));
                } else {
                    match.setHomePenalties(0);
                    match.setAwayPenalties(0);
                }

                match.getResultOfTheMatch();
                dao.insertMatch(match);
                if (winnerA.isEliminated()) {
                    giveRankingPoints(10, winnerA);
                    finalistOne = winnerB;
                    panel.getjComboBox13().addItem(finalistOne.getPlayerName());
                } else {
                    giveRankingPoints(10, winnerB);
                    finalistOne = winnerA;
                    panel.getjComboBox13().addItem(finalistOne.getPlayerName());
                }
            }
        });
    }

    public void createButtonSemiTwo() {
        javax.swing.JButton button = panel.getjButton4();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Match match = new Match(championshipID, winnerC, winnerD);
                match.setHomeScore(Integer.parseInt(panel.getjTextField11().getText()));
                match.setAwayScore(Integer.parseInt(panel.getjTextField12().getText()));
                if (panel.getjCheckBox6().isSelected()) {
                    match.setHomePenalties(Integer.parseInt(panel.getjTextField25().getText()));
                    match.setAwayPenalties(Integer.parseInt(panel.getjTextField26().getText()));
                } else {
                    match.setHomePenalties(0);
                    match.setAwayPenalties(0);
                }
                match.getResultOfTheMatch();
                dao.insertMatch(match);
                if (winnerC.isEliminated()) {
                    giveRankingPoints(10, winnerC);
                    finalistTwo = winnerD;
                    panel.getjComboBox14().addItem(finalistTwo.getPlayerName());
                } else {
                    giveRankingPoints(10, winnerD);
                    finalistTwo = winnerC;
                    panel.getjComboBox14().addItem(finalistTwo.getPlayerName());
                }
            }
        });
    }

    public void createButtonChampion() {
        javax.swing.JButton button = panel.getjButton5();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Match match = new Match(championshipID, finalistOne, finalistTwo);
                match.setHomeScore(Integer.parseInt(panel.getjTextField13().getText()));
                match.setAwayScore(Integer.parseInt(panel.getjTextField14().getText()));
                if (panel.getjCheckBox7().isSelected()) {
                    match.setHomePenalties(Integer.parseInt(panel.getjTextField27().getText()));
                    match.setAwayPenalties(Integer.parseInt(panel.getjTextField28().getText()));
                } else {
                    match.setHomePenalties(0);
                    match.setAwayPenalties(0);
                }
                match.getResultOfTheMatch();
                dao.insertMatch(match);
                if (finalistOne.isEliminated()) {
                    giveRankingPoints(20, finalistOne);
                    giveRankingPoints(25, finalistTwo);
                    panel.getjTextField29().setText(finalistTwo.getPlayerName());
                } else {
                    giveRankingPoints(20, finalistTwo);
                    giveRankingPoints(25, finalistOne);
                    panel.getjTextField29().setText(finalistOne.getPlayerName());
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
            dao.createPlayoffsChampionship(championshipID, player, 7);
        } catch (SQLException ex) {
            Logger.getLogger(DefaultQuarterFinalsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void givePointsToPlayer(int pointsEarnedFromChampionship, PlayerPerformance player) {

        try {
            dao.updateRankingPoints(pointsEarnedFromChampionship, player);
        } catch (SQLException ex) {
            Logger.getLogger(SemiFinalsManager.class.getName()).log(Level.SEVERE, null, ex);
        }

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

    public void configureAllCheckBoxes() {
        JCheckBox checkBox = panel.getjCheckBox1();
        checkBox.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox.isSelected()) {
                    panel.getjTextField15().setEditable(true);
                    panel.getjTextField16().setEditable(true);
                } else {
                    panel.getjTextField15().setEditable(false);
                    panel.getjTextField16().setEditable(false);
                }

            }
        });

        JCheckBox checkBox2 = panel.getjCheckBox2();
        checkBox2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox2.isSelected()) {
                    panel.getjTextField17().setEditable(true);
                    panel.getjTextField18().setEditable(true);
                } else {
                    panel.getjTextField17().setEditable(false);
                    panel.getjTextField18().setEditable(false);
                }

            }
        });

        JCheckBox checkBox3 = panel.getjCheckBox3();
        checkBox3.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox3.isSelected()) {
                    panel.getjTextField19().setEditable(true);
                    panel.getjTextField20().setEditable(true);
                } else {
                    panel.getjTextField19().setEditable(false);
                    panel.getjTextField20().setEditable(false);
                }

            }
        });

        JCheckBox checkBox4 = panel.getjCheckBox4();
        checkBox4.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox4.isSelected()) {
                    panel.getjTextField21().setEditable(true);
                    panel.getjTextField22().setEditable(true);
                } else {
                    panel.getjTextField21().setEditable(false);
                    panel.getjTextField22().setEditable(false);
                }

            }
        });

        JCheckBox checkBox5 = panel.getjCheckBox5();
        checkBox5.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox5.isSelected()) {
                    panel.getjTextField23().setEditable(true);
                    panel.getjTextField24().setEditable(true);
                } else {
                    panel.getjTextField23().setEditable(false);
                    panel.getjTextField24().setEditable(false);
                }

            }
        });

        JCheckBox checkBox6 = panel.getjCheckBox6();
        checkBox6.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox6.isSelected()) {
                    panel.getjTextField25().setEditable(true);
                    panel.getjTextField26().setEditable(true);
                } else {
                    panel.getjTextField25().setEditable(false);
                    panel.getjTextField26().setEditable(false);
                }

            }
        });

        JCheckBox checkBox7 = panel.getjCheckBox7();
        checkBox7.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (checkBox7.isSelected()) {
                    panel.getjTextField27().setEditable(true);
                    panel.getjTextField28().setEditable(true);
                } else {
                    panel.getjTextField27().setEditable(false);
                    panel.getjTextField28().setEditable(false);
                }

            }
        });
    }
}
