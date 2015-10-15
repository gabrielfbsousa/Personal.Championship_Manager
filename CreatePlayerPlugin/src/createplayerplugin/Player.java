/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createplayerplugin;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Date;
import javax.swing.JFileChooser;

/**
 *
 * @author gabrielferreira
 */
public class Player {

    private String name;
    private int rankingPoints;
    private String photoPath;
    private int goals = 0;
    private int points = 0;
    private int victories = 0;
    private int draws = 0;
    private int loses = 0;
    private int goalsMade = 0;
    private int goalsConceded = 0;

    public Player() {
        rankingPoints = 0;
    }
    
    public Player(String name,int rankingPoints){
        this.name = name;
        this.rankingPoints = rankingPoints;
    }
    
    public Player(String name){
        this.name = name;
    }
    
    public void selectPhoto(){
        JFileChooser jfc = new JFileChooser();
	jfc.setDialogTitle("Open Document");
	jfc.setDialogType(JFileChooser.OPEN_DIALOG);
        if (jfc.showDialog(null, "Ok") == JFileChooser.APPROVE_OPTION)
        {
            File documentFile = jfc.getSelectedFile();
            photoPath = documentFile.getAbsolutePath();
        }
    }

    public void copyPhoto() throws FileNotFoundException {
        //Pegar o caminho de destino da foto
        String destinationPhoto = null;
        try {
            destinationPhoto = new File("../ChampionshipManagerResources/src/res/players/").getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Pega os dois arquivos, de origem e destino
        File arquivoOrigem = new File(photoPath);
        File arquivoDestino = null;
        //File arquivoDestino = new File(destinationPhoto + "/" +  name +"/profilePhoto.jpg");
        
             
         if (!new File(destinationPhoto + "/" +  name +"/").exists()) { // Verifica se o diretório existe.   
             (new File(destinationPhoto + "/" +  name +"/")).mkdir();   // Cria o diretório   
             arquivoDestino = new File(destinationPhoto + "/" +  name +"/profilePhoto.jpg");
         } else {
             arquivoDestino = new File(destinationPhoto + "/" +  name +"/profilePhoto.jpg");
         }
        
         photoPath = destinationPhoto + "/" +  name +"/profilePhoto.jpg";

        Date date = new Date();
       
        FileInputStream fisOrigem = null;
        try {
            fisOrigem = new FileInputStream(arquivoOrigem);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        FileOutputStream fisDestino = null;
        fisDestino = new FileOutputStream(arquivoDestino);
        
        FileChannel fcOrigem = fisOrigem.getChannel();
        FileChannel fcDestino = fisDestino.getChannel();
        try {
            fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            fisOrigem.close();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            fisDestino.close();
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Long time = new Date().getTime() - date.getTime();
        System.out.println("Saiu copy" + time);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getRankingPoints() {
        return rankingPoints;
    }

    public void setRankingPoints(int rankingPoints) {
        this.rankingPoints = rankingPoints;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public int getGoals() {
        return goals;
    }


    public int getPoints() {
        return points;
    }


    public int getGoalsMade() {
        return goalsMade;
    }


    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void victoryInMatch(){
        this.points += 3;
    }
    
    public void goalsScoredInMatch(int goals){
        this.goalsMade += goals;
    }
    
    public void goalsConcededInMatch(int goals){
        this.goalsConceded += goals;
    }
    
    public void setScore(int score){
        this.goals = score;
    }

    public int getVictories() {
        return victories;
    }

    public void victory() {
        this.victories++;
    }

    public int getDraws() {
        return draws;
    }

    public void draw() {
        this.draws++;
    }

    public int getLoses() {
        return loses;
    }

    public void lose() {
        this.loses++;
    }
    
    

}


