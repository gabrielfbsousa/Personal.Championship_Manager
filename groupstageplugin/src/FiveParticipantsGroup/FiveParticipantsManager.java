/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FiveParticipantsGroup;


import groupstageplugin.IGroupsManager;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import tableandmatches.PlayerPerformance;
import windowPlugin.MainWindow;

/**
 *
 * @author gabrielferreira
 */
public class FiveParticipantsManager implements IGroupsManager{
    private int groupID;
    private int championshipID;
    private MainWindow mainWindow;
    
    public FiveParticipantsManager(int championshipID, MainWindow mainWindow){
        this.mainWindow = mainWindow;
        this.championshipID = championshipID;
        this.groupID = 1 + (int) (Math.random()*5000); 
    }

    @Override
    public JTabbedPane getGroupPanel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillBoxWithAllPlayers(JComboBox comboBox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void configureConfirmationButton() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fillMatchesWithSpecificPlayers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<PlayerPerformance> getPlayersPerformance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
