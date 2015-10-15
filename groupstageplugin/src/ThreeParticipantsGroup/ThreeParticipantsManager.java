/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreeParticipantsGroup;




import FourParticipantsGroup.FourParticipantsManager;
import championshipmanager.DaoInsert;
import createplayerplugin.Player;
import groupstageplugin.IGroupsManager;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import tableandmatches.MatchManager;
import tableandmatches.PlayerPerformance;

/**
 *
 * @author gabrielferreira
 */
public class ThreeParticipantsManager implements IGroupsManager {

    private ThreeParticipantsPanel groupPanel;
    private ArrayList<PlayerPerformance> participants;
    private int groupID;
    private int championshipID;
    private String photoTeamPathOne;
    private String photoTeamPathTwo;
    private String photoTeamPathThree;
    private DaoInsert dao;
    private int tourns;

    public ThreeParticipantsManager(int championshipID) {
        groupPanel = new ThreeParticipantsPanel();
        participants = new ArrayList();
        this.tourns = 0;
        this.championshipID = championshipID;
        dao = new DaoInsert();
        this.groupID = 1 + (int) (Math.random()*5000); 
        
        try {
            dao.createGroup(groupID, 3);
       } catch (SQLException ex) {
            Logger.getLogger(FourParticipantsManager.class.getName()).log(Level.SEVERE, null, ex);
       }
        fillBoxWithAllPlayers(groupPanel.getjComboBox1());
        fillBoxWithAllPlayers(groupPanel.getjComboBox2());
        fillBoxWithAllPlayers(groupPanel.getjComboBox3());
        configureSelectPhotoButtons();
        configureConfirmationButton();
        configureCreateTable();
    }

    public ThreeParticipantsPanel getGroupPanel() {
        return groupPanel;
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

    public void configureConfirmationButton() {
        javax.swing.JButton button = groupPanel.getjButton4();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOne = groupPanel.getjComboBox1().getSelectedItem() + "";
                String selectedTwo = groupPanel.getjComboBox2().getSelectedItem() + "";
                String selectedThree = groupPanel.getjComboBox3().getSelectedItem() + "";

                participants.add(new PlayerPerformance(selectedOne, championshipID, groupID, photoTeamPathOne));
                participants.add(new PlayerPerformance(selectedTwo, championshipID, groupID, photoTeamPathTwo));
                participants.add(new PlayerPerformance(selectedThree, championshipID, groupID, photoTeamPathThree));

                fillMatchesWithSpecificPlayers();
            }
        });
    }

    public void fillMatchesWithSpecificPlayers() {
        for (int i = 0; i < 3; i++) {
            groupPanel.getjComboBox4().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 3; i++) {
            groupPanel.getjComboBox5().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 3; i++) {
            groupPanel.getjComboBox6().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 3; i++) {
            groupPanel.getjComboBox7().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 3; i++) {
            groupPanel.getjComboBox8().addItem(participants.get(i).getPlayerName());
        }
        for (int i = 0; i < 3; i++) {
            groupPanel.getjComboBox9().addItem(participants.get(i).getPlayerName());
        }
    }

    public void configureCreateTable() {
        javax.swing.JButton button = groupPanel.getjButton5();
        button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Termina fase de grupos. Aqui, a ideia é calcular partida por partida, mandar elas pro banco, 
                //criar uma tabela temporária, e por fim, gerar a tabela final, que será mandada ao banco
                tourns++;
                if(groupPanel.getjCheckBox1().isSelected()){ // Tem mais um turno
                    MatchManager create = new MatchManager(groupPanel, participants, championshipID, groupID, tourns, true);
                    groupPanel.getjTextField1().setText("");
                    groupPanel.getjTextField2().setText("");
                    groupPanel.getjTextField3().setText("");
                    groupPanel.getjTextField4().setText("");
                    groupPanel.getjTextField5().setText("");
                    groupPanel.getjTextField6().setText("");
                } else { // Não tem outro turno
                    MatchManager create = new MatchManager(groupPanel, participants, championshipID, groupID, tourns, false);
                }

            }
        });
    }

    public ArrayList<PlayerPerformance> getPlayersPerformance() {
        return participants;
    }

    private void configureSelectPhotoButtons() {
        javax.swing.JButton button1 = groupPanel.getjButton1();
        button1.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathOne = documentFile.getAbsolutePath();
                    addIcon(groupPanel.getjPanel1(), photoTeamPathOne);
                    groupPanel.revalidate();
                    groupPanel.repaint();
                }   
            }
        });
        
        javax.swing.JButton button2 = groupPanel.getjButton2();
        button2.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathTwo = documentFile.getAbsolutePath();
                    addIcon(groupPanel.getjPanel2(), photoTeamPathTwo);
                    groupPanel.revalidate();
                    groupPanel.repaint();
                }   
            }
        });
        
        javax.swing.JButton button3 = groupPanel.getjButton3();
        button3.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.setDialogTitle("Open Document");
                jfc.setDialogType(JFileChooser.OPEN_DIALOG);
                if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION) {
                    File documentFile = jfc.getSelectedFile();
                    photoTeamPathThree = documentFile.getAbsolutePath();
                    addIcon(groupPanel.getjPanel3(), photoTeamPathThree);
                    groupPanel.revalidate();
                    groupPanel.repaint();
                }   
            }
        });
    }
    
    public void addIcon(JPanel panel, String address){
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
