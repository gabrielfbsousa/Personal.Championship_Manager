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
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import tableandmatches.Match;
import tableandmatches.PlayerPerformance;

/**
 *
 * @author gabriel
 */
public class GroupstageSemiFinals extends SemiFinalsManager {

    public GroupstageSemiFinals(int championshipID, ArrayList<IGroupsManager> groups) {
        super();
        hadPreviousPhase = true;
        this.championshipID = championshipID;

        fillBoxWithAllPlayers(panel.getjComboBox1(), groups.get(0).getPlayersPerformance().get(0));
        fillBoxWithAllPlayers(panel.getjComboBox2(), groups.get(1).getPlayersPerformance().get(1));
        fillBoxWithAllPlayers(panel.getjComboBox3(), groups.get(0).getPlayersPerformance().get(1));
        fillBoxWithAllPlayers(panel.getjComboBox4(), groups.get(1).getPlayersPerformance().get(0));

        disableOnlyPlayoffsOptions();

    }

    private void disableOnlyPlayoffsOptions() {
        panel.getjComboBox7().setEnabled(false);
        panel.getjComboBox7().setVisible(false);
        panel.getjComboBox8().setEnabled(false);
        panel.getjComboBox8().setVisible(false);
        panel.getjComboBox9().setEnabled(false);
        panel.getjComboBox9().setVisible(false);
        panel.getjComboBox10().setEnabled(false);
        panel.getjComboBox10().setVisible(false);
        panel.getjButton4().setEnabled(false);
        panel.getjButton4().setVisible(false);
        panel.getjButton5().setEnabled(false);
        panel.getjButton5().setVisible(false);
        panel.getjButton6().setEnabled(false);
        panel.getjButton6().setVisible(false);
        panel.getjButton7().setEnabled(false);
        panel.getjButton7().setVisible(false);
        panel.getjButton8().setEnabled(false);
        panel.getjButton8().setVisible(false);
    }

}
