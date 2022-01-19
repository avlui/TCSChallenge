/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ultimatehorseracing;

import java.util.Random;

/**
 *
 * @author avlui
 */
public class HorseRacing {
    
    private Random random;
    
    //Tipos de pista para la carrera.
    private String[] tracks = {"Hard", "Soft","God to Soft","Firm"};
    
    //Tipos de carrera.
    private String[] types = {"FLAT","JUMP"};
    
    //Distancias a rrecorrer en la carrera.
    private String[] distances = {"5 Furlongs","6 Furlongs","7 Furlongs","1 Mi", "2 Mi","3 Mi"};
    
    //Caballos que participan en la carrera.
    public Horse[] horsesInRacing;
    
    //Tipo de pista seleccionada alaeatoriamente.
    public String trackType;
    
    //Tipo de carrera seleccionada aleatoriamente.
    public String racingType;
    
    //Tipo de distacía para la carrera seleccionada aleatoriamente.
    public String raceDistance;
    

    public Random getRandom() {
        return random;
    }
    public void setRandom(Random random) {
        this.random = random;
    }
    
    public String[] getTracks() {
        return tracks;
    }
    public void setTracks(String[] tracks) {
        this.tracks = tracks;
    }
    

    public String[] getTypes() {
        return types;
    }
    public void setType(String[] type) {
        this.types = type;
    }
    

    public String[] getDistances() {
        return distances;
    }
    public void setDistancce(String[] distancce) {
        this.distances = distancce;
    }

    public Horse[] getHorsesInRacing() {
        return horsesInRacing;
    }
    public void setHorsesInRacing(Horse[] horsesInRacing) {
        this.horsesInRacing = horsesInRacing;
    }
   
    
    public String getTrackType() {
        return this.trackType;
    }
    public void setTrackType(Random random) {
        this.trackType = this.getTracks()[random.nextInt(this.getTracks().length)];
    }
    

    public String getRacingType() {
        return this.racingType;
    }
    public void setRacingType(Random random) {
        this.racingType = this.getTypes()[random.nextInt(this.getTypes().length)];
    }
    

    public String getRaceDistance() {
        return this.raceDistance;
    }
    public void setRaceDistance(Random random) {
        this.raceDistance = this.getDistances()[random.nextInt(this.getDistances().length)];
    }


    /*Este método crea un nuevo objeto de la clase HorseBet */
    public HorseRacing(Horse[] horses) {
        
        this.setRandom(new Random());
        
        this.setTrackType(this.getRandom());
        this.setRaceDistance(this.getRandom());
        this.setRacingType(this.getRandom());
        
        this.setHorsesInRacing(horses);
        
        System.out.println(this.getTrackType() + this.getRacingType() + this.getRaceDistance());
        
    }

    
    public Horse showResults(){
        Horse winner = this.getHorsesInRacing()[this.getRandom().nextInt(this.getHorsesInRacing().length)];
        System.out.println("The winner was: " + winner.getName());
        return winner;
    }
    
    public void giveRewards(){}
}
