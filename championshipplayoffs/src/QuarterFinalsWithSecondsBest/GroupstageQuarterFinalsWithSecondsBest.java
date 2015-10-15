/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuarterFinalsWithSecondsBest;

import groupstageplugin.IGroupsManager;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class GroupstageQuarterFinalsWithSecondsBest extends QuarterFinalsWithBestSecondsManager {

    public GroupstageQuarterFinalsWithSecondsBest(int championshipID, ArrayList<IGroupsManager> groups) {
        super();
        hadPreviousPhase = true;
        this.championshipID = championshipID;

        fillBoxWithAllPlayers(panel.getjComboBox1(), groups.get(1).getPlayersPerformance().get(1));
        fillBoxWithAllPlayers(panel.getjComboBox2(), groups.get(0).getPlayersPerformance().get(2));
        fillBoxWithAllPlayers(panel.getjComboBox3(), groups.get(0).getPlayersPerformance().get(0));
        fillBoxWithAllPlayers(panel.getjComboBox5(), groups.get(0).getPlayersPerformance().get(1));
        fillBoxWithAllPlayers(panel.getjComboBox6(), groups.get(1).getPlayersPerformance().get(2));
        fillBoxWithAllPlayers(panel.getjComboBox7(), groups.get(1).getPlayersPerformance().get(0));
        
        disableOnlyPlayoffsOptions();
    }

    private void disableOnlyPlayoffsOptions() {
        panel.getjComboBox4().setEnabled(false);
        panel.getjComboBox4().setVisible(false);
        panel.getjComboBox8().setEnabled(false);
        panel.getjComboBox8().setVisible(false);
        panel.getjComboBox15().setEnabled(false);
        panel.getjComboBox15().setVisible(false);
        panel.getjComboBox16().setEnabled(false);
        panel.getjComboBox16().setVisible(false);
        panel.getjComboBox17().setEnabled(false);
        panel.getjComboBox17().setVisible(false);
        panel.getjComboBox18().setEnabled(false);
        panel.getjComboBox18().setVisible(false);
        panel.getjButton6().setEnabled(false);
        panel.getjButton6().setVisible(false);
        panel.getjButton7().setEnabled(false);
        panel.getjButton7().setVisible(false);
        panel.getjButton8().setEnabled(false);
        panel.getjButton8().setVisible(false);
        panel.getjButton9().setEnabled(false);
        panel.getjButton9().setVisible(false);
        panel.getjButton10().setEnabled(false);
        panel.getjButton10().setVisible(false);
        panel.getjButton11().setEnabled(false);
        panel.getjButton11().setVisible(false);
        panel.getjButton12().setEnabled(false);
        panel.getjButton12().setVisible(false);
    }
}
