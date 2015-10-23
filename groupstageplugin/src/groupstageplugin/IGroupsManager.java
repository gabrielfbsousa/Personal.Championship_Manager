/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupstageplugin;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import tableandmatches.PlayerPerformance;

/**
 *
 * @author gabrielferreira
 */
public interface IGroupsManager {

    public abstract JTabbedPane getGroupPanel();

    public abstract void fillBoxWithAllPlayers(JComboBox comboBox);

    public abstract void fillMatchesWithSpecificPlayers();
    
    public abstract void configureConfirmationButton();
    
    public abstract ArrayList<PlayerPerformance> getPlayersPerformance();
}
