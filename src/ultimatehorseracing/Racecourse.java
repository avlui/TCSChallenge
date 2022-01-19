/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatehorseracing;

/**
 *
 * @author avlui
 */
public class Racecourse {
    
    
    public Horse[] horses;
    
    public HorseRacing horseRacing;
 
    /*Consructor*/
    public Racecourse() {
        this.setHorses();
    }

    public Horse[] getHorses() {
        return horses;
    }
    public void setHorses() {
        Horse mostufa = new Horse("Mostufa","APPALOSA",1);
        Horse omicron = new Horse("Omicron","American Paint",2);
        Horse paracron = new Horse("Paracron","Árabe",3);
        Horse trueno = new Horse("Trueno","Thoroughbred",4);
        
        Horse[] horsesToRacing = {mostufa, omicron, paracron,trueno};
        this.horses = horsesToRacing;
    }

    
    public HorseRacing getHorseRacing() {
        return horseRacing;
    }
    public void setHorseRacing(HorseRacing horseBet) {
        this.horseRacing = horseBet;
    }
       
    
    public void makeRacing(){
       this.setHorseRacing(new HorseRacing(this.getHorses()));
    }
}
