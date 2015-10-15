/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableandmatches;

import FourParticipantsGroup.FourParticipantsPanel;
import ThreeParticipantsGroup.ThreeParticipantsPanel;
import championshipmanager.DaoInsert;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author gabrielferreira
 */
public class TableManager {

    private ArrayList<PlayerPerformance> playersOnGroup;// não inicializado
    private int championshipID;
    private int groupID;
    private ThreeParticipantsPanel panelThree;
    private FourParticipantsPanel panelFour;
    private DaoInsert dao;
    //cada grupo terá que conter vários jogadores, de modo que cada um deles tem que ter suas estatísticas.Melhor manter isso numa classe

    public TableManager(int championshipID, int groupID, ArrayList<PlayerPerformance> playersOnGroup, JPanel panel) {
        this.championshipID = championshipID;
        this.groupID = groupID;
        this.playersOnGroup = playersOnGroup;
        this.dao = new DaoInsert();
          
        if (panel instanceof ThreeParticipantsPanel) {
            this.panelThree = (ThreeParticipantsPanel) panel;
        }

        if (panel instanceof FourParticipantsPanel) {
            this.panelFour = (FourParticipantsPanel) panel;
        }

    }

    public ArrayList<PlayerPerformance> orderGroupByPoints() {
        Collections.sort(playersOnGroup, new PlayerPerformanceComparator());
        return playersOnGroup;
    }

    public void finishTable() {
        
        if (panelFour == null) { //ou seja, se o que existir for o PanelThree, iremos povoar a panelThree
            panelThree.getjTextField7().setText(playersOnGroup.get(0).getPlayerName());
            panelThree.getjTextField8().setText(playersOnGroup.get(0).getPoints() + "");
            panelThree.getjTextField9().setText(playersOnGroup.get(0).getWins() + "");
            panelThree.getjTextField10().setText(playersOnGroup.get(0).getDraws() + "");
            panelThree.getjTextField11().setText(playersOnGroup.get(0).getLoses() + "");
            panelThree.getjTextField12().setText(playersOnGroup.get(0).getGoalsMade() + "");
            panelThree.getjTextField13().setText(playersOnGroup.get(0).getGoalsConceded() + "");
            panelThree.getjTextField14().setText(playersOnGroup.get(0).getGoalDifference() + "");
            addIcon(panelThree.getjPanel4(), playersOnGroup.get(0).getTeamIconPath());
            insertPerformanceIntoDatabase(1, playersOnGroup.get(0), 3);
            panelThree.getjTextField15().setText(playersOnGroup.get(1).getPlayerName());
            panelThree.getjTextField16().setText(playersOnGroup.get(1).getPoints() + "");
            panelThree.getjTextField17().setText(playersOnGroup.get(1).getWins() + "");
            panelThree.getjTextField18().setText(playersOnGroup.get(1).getDraws() + "");
            panelThree.getjTextField19().setText(playersOnGroup.get(1).getLoses() + "");
            panelThree.getjTextField20().setText(playersOnGroup.get(1).getGoalsMade() + "");
            panelThree.getjTextField21().setText(playersOnGroup.get(1).getGoalsConceded() + "");
            panelThree.getjTextField22().setText(playersOnGroup.get(1).getGoalDifference() + "");
            addIcon(panelThree.getjPanel5(), playersOnGroup.get(1).getTeamIconPath());
            insertPerformanceIntoDatabase(2, playersOnGroup.get(1), 3);
            panelThree.getjTextField23().setText(playersOnGroup.get(2).getPlayerName());
            panelThree.getjTextField24().setText(playersOnGroup.get(2).getPoints() + "");
            panelThree.getjTextField30().setText(playersOnGroup.get(2).getWins() + "");
            panelThree.getjTextField29().setText(playersOnGroup.get(2).getDraws() + "");
            panelThree.getjTextField28().setText(playersOnGroup.get(2).getLoses() + "");
            panelThree.getjTextField27().setText(playersOnGroup.get(2).getGoalsMade() + "");
            panelThree.getjTextField26().setText(playersOnGroup.get(2).getGoalsConceded() + "");
            panelThree.getjTextField25().setText(playersOnGroup.get(2).getGoalDifference() + "");
            addIcon(panelThree.getjPanel6(), playersOnGroup.get(2).getTeamIconPath());
            insertPerformanceIntoDatabase(3, playersOnGroup.get(2), 3);
            givePointsToPlayer(5, playersOnGroup.get(2));
            panelThree.revalidate();
            panelThree.repaint();
        }
        if (panelThree == null) {
            panelFour.getjTextField13().setText(playersOnGroup.get(0).getPlayerName());
            panelFour.getjTextField14().setText(playersOnGroup.get(0).getPoints() + "");
            panelFour.getjTextField15().setText(playersOnGroup.get(0).getWins() + "");
            panelFour.getjTextField16().setText(playersOnGroup.get(0).getDraws() + "");
            panelFour.getjTextField17().setText(playersOnGroup.get(0).getLoses() + "");
            panelFour.getjTextField18().setText(playersOnGroup.get(0).getGoalsMade() + "");
            panelFour.getjTextField19().setText(playersOnGroup.get(0).getGoalsConceded() + "");
            panelFour.getjTextField20().setText(playersOnGroup.get(0).getGoalDifference() + "");
            addIcon(panelFour.getjPanel5(), playersOnGroup.get(0).getTeamIconPath());
            insertPerformanceIntoDatabase(1, playersOnGroup.get(0), 4);
            panelFour.getjTextField21().setText(playersOnGroup.get(1).getPlayerName());
            panelFour.getjTextField22().setText(playersOnGroup.get(1).getPoints() + "");
            panelFour.getjTextField23().setText(playersOnGroup.get(1).getWins() + "");
            panelFour.getjTextField24().setText(playersOnGroup.get(1).getDraws() + "");
            panelFour.getjTextField25().setText(playersOnGroup.get(1).getLoses() + "");
            panelFour.getjTextField26().setText(playersOnGroup.get(1).getGoalsMade() + "");
            panelFour.getjTextField27().setText(playersOnGroup.get(1).getGoalsConceded() + "");
            panelFour.getjTextField28().setText(playersOnGroup.get(1).getGoalDifference() + "");
            addIcon(panelFour.getjPanel6(), playersOnGroup.get(1).getTeamIconPath());
            insertPerformanceIntoDatabase(2, playersOnGroup.get(1), 4);
            panelFour.getjTextField29().setText(playersOnGroup.get(2).getPlayerName());
            panelFour.getjTextField30().setText(playersOnGroup.get(2).getPoints() + "");
            panelFour.getjTextField31().setText(playersOnGroup.get(2).getWins() + "");
            panelFour.getjTextField32().setText(playersOnGroup.get(2).getDraws() + "");
            panelFour.getjTextField33().setText(playersOnGroup.get(2).getLoses() + "");
            panelFour.getjTextField34().setText(playersOnGroup.get(2).getGoalsMade() + "");
            panelFour.getjTextField35().setText(playersOnGroup.get(2).getGoalsConceded() + "");
            panelFour.getjTextField36().setText(playersOnGroup.get(2).getGoalDifference() + "");
            addIcon(panelFour.getjPanel7(), playersOnGroup.get(2).getTeamIconPath());
            insertPerformanceIntoDatabase(3, playersOnGroup.get(2), 4);
            givePointsToPlayer(5, playersOnGroup.get(2));
            panelFour.getjTextField37().setText(playersOnGroup.get(3).getPlayerName());
            panelFour.getjTextField38().setText(playersOnGroup.get(3).getPoints() + "");
            panelFour.getjTextField39().setText(playersOnGroup.get(3).getWins() + "");
            panelFour.getjTextField40().setText(playersOnGroup.get(3).getDraws() + "");
            panelFour.getjTextField41().setText(playersOnGroup.get(3).getLoses() + "");
            panelFour.getjTextField42().setText(playersOnGroup.get(3).getGoalsMade() + "");
            panelFour.getjTextField43().setText(playersOnGroup.get(3).getGoalsConceded() + "");
            panelFour.getjTextField44().setText(playersOnGroup.get(3).getGoalDifference() + "");
            addIcon(panelFour.getjPanel8(), playersOnGroup.get(3).getTeamIconPath());
            insertPerformanceIntoDatabase(4, playersOnGroup.get(3), 4);
            givePointsToPlayer(0, playersOnGroup.get(3));
            panelThree.revalidate();
            panelThree.repaint();
        } 
    }
    
    public void addIcon(JPanel panel, String address){
        javax.swing.ImageIcon img = new javax.swing.ImageIcon(address);

        int largura = img.getIconWidth();
        int altura = img.getIconHeight();

        javax.swing.JLabel labelimg = new javax.swing.JLabel(img);
        labelimg.setSize(largura, altura);

        panel.add(labelimg);
    }
    
    
    public void insertPerformanceIntoDatabase(int positionOnGroup, PlayerPerformance player, int kind_of_group){
        try {
            dao.finishGroup(positionOnGroup, player, groupID, championshipID, kind_of_group);
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void givePointsToPlayer(int pointsEarned, PlayerPerformance player){
        try {
            dao.updateRankingPoints(pointsEarned, player);
        } catch (SQLException ex) {
            Logger.getLogger(TableManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
