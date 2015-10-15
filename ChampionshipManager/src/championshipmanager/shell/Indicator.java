/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package championshipmanager.shell;

/**
 *
 * @author gabrielferreira
 */
public class Indicator {
    private boolean indicator;
    
    public Indicator(){
        indicator = false;
    }

    public boolean isIndicator() {
        return indicator;
    }
    
    public void setIndicator(boolean b){
        this.indicator = b;
    }
    
    public void change(){
        if(indicator == true){
            indicator = false;
        } else {
            indicator = true;
        }
    }
    
    
}
