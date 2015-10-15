/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DefaultQuarterFinals;

import groupstageplugin.IGroupsManager;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class GroupstageQuarterFinals extends DefaultQuarterFinalsManager {

    public GroupstageQuarterFinals(int championshipID, ArrayList<IGroupsManager> groups) {
        super();
        hadPreviousPhase = true;
        super.championshipID = championshipID;
        fillBoxWithAllPlayers(panel.getjComboBox1());
        fillBoxWithAllPlayers(panel.getjComboBox2());
        fillBoxWithAllPlayers(panel.getjComboBox3());
        fillBoxWithAllPlayers(panel.getjComboBox4());
        fillBoxWithAllPlayers(panel.getjComboBox5());
        fillBoxWithAllPlayers(panel.getjComboBox6());
        fillBoxWithAllPlayers(panel.getjComboBox7());
        fillBoxWithAllPlayers(panel.getjComboBox8());
        
        disableOnlyPlayoffsOptions();
    }

    private void disableOnlyPlayoffsOptions() {
       panel.getjComboBox15().setEnabled(false);
        panel.getjComboBox15().setVisible(false);
        panel.getjComboBox16().setEnabled(false);
        panel.getjComboBox16().setVisible(false);
        panel.getjComboBox17().setEnabled(false);
        panel.getjComboBox17().setVisible(false);
        panel.getjComboBox18().setEnabled(false);
        panel.getjComboBox18().setVisible(false);
        panel.getjComboBox19().setEnabled(false);
        panel.getjComboBox19().setVisible(false);
        panel.getjComboBox20().setEnabled(false);
        panel.getjComboBox20().setVisible(false);
        panel.getjComboBox21().setEnabled(false);
        panel.getjComboBox21().setVisible(false);
        panel.getjComboBox22().setEnabled(false);
        panel.getjComboBox22().setVisible(false);
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
        panel.getjButton13().setEnabled(false);
        panel.getjButton13().setVisible(false);
        panel.getjButton14().setEnabled(false);
        panel.getjButton14().setVisible(false);
    }
}
