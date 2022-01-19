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
public class Horse {
    public String name;
    public String horseBreed;
    public int drawerNumber;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getHorseBreed() {
        return horseBreed;
    }
    public void setHorseBreed(String horseBreed) {
        this.horseBreed = horseBreed;
    }

    public int getDrawerNumber() {
        return drawerNumber;
    }
    public void setDrawerNumber(int drawerNumber) {
        this.drawerNumber = drawerNumber;
    }

    
    //Constructor
    public Horse(String name, String horseBreed, int drawerNumber) {
        this.setName(name);
        this.setHorseBreed(horseBreed);
        this.setDrawerNumber(drawerNumber);
    }
    
    public void run(){}
}
