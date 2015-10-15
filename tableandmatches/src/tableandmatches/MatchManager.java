/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableandmatches;

import FourParticipantsGroup.FourParticipantsPanel;
import ThreeParticipantsGroup.ThreeParticipantsPanel;
import championshipmanager.DaoInsert;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author gabrielferreira
 */
public class MatchManager {

    private ThreeParticipantsPanel panelThree;
    private FourParticipantsPanel panelFour;
    private ArrayList<PlayerPerformance> participants;
    private int championshipID;
    private int groupID;
    private int tourn;
    private boolean willHaveNextTourn;
    private DaoInsert dao;

    public MatchManager(JPanel panel, ArrayList<PlayerPerformance> participants,int championshipID, int groupID, int tourn, boolean nextTourn) {
        this.participants = participants;
        this.willHaveNextTourn = nextTourn;
        this.tourn = tourn;
        this.groupID = groupID;
        this.championshipID = championshipID;
        this.dao = new DaoInsert();
        
        if (panel instanceof ThreeParticipantsPanel) {
            this.panelThree = (ThreeParticipantsPanel) panel;
            initializeThreeTable();
        }
        
        if (panel instanceof FourParticipantsPanel) {
            this.panelFour = (FourParticipantsPanel) panel;
            initializeFourTable();
        }
    }

    public void initializeThreeTable() {
        //--------------------------Primeira rodada
        int roundOneHome = Integer.parseInt(panelThree.getjTextField1().getText());
        int roundOneAway = Integer.parseInt(panelThree.getjTextField2().getText());
        Match match = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelThree.getjComboBox4().getSelectedItem() + "")){
                match.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelThree.getjComboBox5().getSelectedItem() + "")){
                match.setAwayPlayer(participants.get(i));
            }
        }
        match.setHomeScore(roundOneHome);
        match.setAwayScore(roundOneAway);
        match.getResultOfTheMatch();
        dao.insertMatch(match);
        
        //---------------------------------------Segunda rodada
        
        int roundTwoHome = Integer.parseInt(panelThree.getjTextField3().getText());
        int roundTwoAway = Integer.parseInt(panelThree.getjTextField4().getText());
        Match matchTwo = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelThree.getjComboBox6().getSelectedItem() + "")){
                matchTwo.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelThree.getjComboBox7().getSelectedItem() + "")){
                matchTwo.setAwayPlayer(participants.get(i));
            }
        }
        matchTwo.setHomeScore(roundTwoHome);
        matchTwo.setAwayScore(roundTwoAway);
        matchTwo.getResultOfTheMatch();
        dao.insertMatch(matchTwo);
        
        //------------------------------------Terceira rodada
        
        int roundThreeHome = Integer.parseInt(panelThree.getjTextField5().getText());
        int roundThreeAway = Integer.parseInt(panelThree.getjTextField6().getText());
        Match matchThree = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelThree.getjComboBox8().getSelectedItem() + "")){
                matchThree.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelThree.getjComboBox9().getSelectedItem() + "")){
                matchThree.setAwayPlayer(participants.get(i));
            }
        }
        matchThree.setHomeScore(roundThreeHome);
        matchThree.setAwayScore(roundThreeAway);
        matchThree.getResultOfTheMatch();
        dao.insertMatch(matchThree);
        
        //-----------------------------------Fim da fase de grupos. Gerar resultado do grupo
        
        if(!willHaveNextTourn){
        TableManager completedTable = new TableManager(championshipID, groupID, participants, panelThree);
        completedTable.orderGroupByPoints();
        completedTable.finishTable();
        }
    }
    
    public void initializeFourTable() {
        //--------------------------Primeira rodada - Jogo 1
        int roundOneGameOneHome = Integer.parseInt(panelFour.getjTextField1().getText());
        int roundOneGameOneAway = Integer.parseInt(panelFour.getjTextField2().getText());
        Match matchOne = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox5().getSelectedItem() + "")){
                matchOne.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox6().getSelectedItem() + "")){
                matchOne.setAwayPlayer(participants.get(i));
            }
        }
        matchOne.setHomeScore(roundOneGameOneHome);
        matchOne.setAwayScore(roundOneGameOneAway);
        matchOne.getResultOfTheMatch();
        dao.insertMatch(matchOne);
        
        //--------------------------Primeira rodada - Jogo 2
        
        int roundOneGameTwoHome = Integer.parseInt(panelFour.getjTextField3().getText());
        int roundOneGameTwoAway = Integer.parseInt(panelFour.getjTextField4().getText());
        Match matchTwo = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox7().getSelectedItem() + "")){
                matchTwo.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox8().getSelectedItem() + "")){
                matchTwo.setAwayPlayer(participants.get(i));
            }
        }
        matchTwo.setHomeScore(roundOneGameTwoHome);
        matchTwo.setAwayScore(roundOneGameTwoAway);
        matchTwo.getResultOfTheMatch();
        dao.insertMatch(matchTwo);
        
        //---------------------------Segunda rodada - Jogo 1
        
        int roundTwoGameOneHome = Integer.parseInt(panelFour.getjTextField5().getText());
        int roundTwoGameOneAway = Integer.parseInt(panelFour.getjTextField6().getText());
        Match matchThree = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox9().getSelectedItem() + "")){
                matchThree.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox10().getSelectedItem() + "")){
                matchThree.setAwayPlayer(participants.get(i));
            }
        }
        matchThree.setHomeScore(roundTwoGameOneHome);
        matchThree.setAwayScore(roundTwoGameOneAway);
        matchThree.getResultOfTheMatch();
        dao.insertMatch(matchThree);
        
        //---------------------------Segunda rodada - Jogo 2
        
        int roundTwoGameTwoHome = Integer.parseInt(panelFour.getjTextField7().getText());
        int roundTwoGameTwoAway = Integer.parseInt(panelFour.getjTextField8().getText());
        Match matchFour = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox11().getSelectedItem() + "")){
                matchFour.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox12().getSelectedItem() + "")){
                matchFour.setAwayPlayer(participants.get(i));
            }
        }
        matchFour.setHomeScore(roundTwoGameTwoHome);
        matchFour.setAwayScore(roundTwoGameTwoAway);
        matchFour.getResultOfTheMatch();
        dao.insertMatch(matchFour);
        
        //---------------------------Terceira rodada - Jogo 1
        
        int roundThreeGameOneHome = Integer.parseInt(panelFour.getjTextField9().getText());
        int roundThreeGameOneAway = Integer.parseInt(panelFour.getjTextField10().getText());
        Match matchFive = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox13().getSelectedItem() + "")){
                matchFive.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox14().getSelectedItem() + "")){
                matchFive.setAwayPlayer(participants.get(i));
            }
        }
        matchFive.setHomeScore(roundThreeGameOneHome);
        matchFive.setAwayScore(roundThreeGameOneAway);
        matchFive.getResultOfTheMatch();
        dao.insertMatch(matchFive);
        
        //---------------------------Terceira rodada - Jogo 2
        
        int roundThreeGameTwoHome = Integer.parseInt(panelFour.getjTextField11().getText());
        int roundThreeGameTwoAway = Integer.parseInt(panelFour.getjTextField12().getText());
        Match matchSix = new Match(championshipID, groupID, tourn);
        
        for(int i=0; i<participants.size();i++){
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox15().getSelectedItem() + "")){
                matchSix.setHomePlayer(participants.get(i));
            }
            
            if(participants.get(i).getPlayerName().equals(panelFour.getjComboBox16().getSelectedItem() + "")){
                matchSix.setAwayPlayer(participants.get(i));
            }
        }
        matchSix.setHomeScore(roundThreeGameTwoHome);
        matchSix.setAwayScore(roundThreeGameTwoAway);
        matchSix.getResultOfTheMatch();
        dao.insertMatch(matchSix);
        
        //-----------------------------------Fim da fase de grupos. Gerar resultado do grupo
        
        if(!willHaveNextTourn){
        TableManager completedTable = new TableManager(championshipID, groupID, participants, panelFour);
        completedTable.orderGroupByPoints();
        completedTable.finishTable();
        }
    }
        
    public void saveMatchOnDatabase(){
        
    }
}
