/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import ultimatehorseracing.Bet;
import ultimatehorseracing.Gambler;
import ultimatehorseracing.Horse;
import ultimatehorseracing.Racecourse;

/**
 *
 * @author avlui
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    
    
    Racecourse racecourse;
    
    private String[] playersNames;
    private Gambler[] gamblers;
    private Horse[] horses;
    private ArrayList <Bet> betsMade;
    private int playerPlaying;

    private String horseOfBet;
    private int moneyToBet;
    private int playerInBet;

    public Racecourse getRacecourse() {
        return racecourse;
    }
    public void setRacecourse(Racecourse racecourse) {
        this.racecourse = racecourse;
    }
    
    public String[] getPlayersNames() {
        return playersNames;
    }
    public void setPlayersNames(String[] playersNames) {
        this.playersNames = playersNames;
    }

    public Gambler[] getGamblers() {
        return gamblers;
    }
    public void setGamblers(Gambler[] gamblers) {
        this.gamblers = gamblers;
    }

    public Horse[] getHorses() {
        return horses;
    }
    public void setHorses(Horse[] horses) {
        this.horses = horses;
    }

    
    public String getHorseOfBet() {
        return horseOfBet;
    }
    public void setHorseOfBet(String HorseOfBet) {
        this.horseOfBet = HorseOfBet;
    }

    public int getMoneyTObet() {
        return moneyToBet;
    }
    public void setMoneyTObet(int moneyTObet) {
        this.moneyToBet = moneyTObet;
    }

    public int getPlayerinBet() {
        return playerInBet;
    }
    public void setPlayerinBet(int playerinBet) {
        this.playerInBet = playerinBet;
    }

    public ArrayList<Bet> getBetsMade() {
        return betsMade;
    }

    public void setBetsMade(ArrayList<Bet> betsMade) {
        this.betsMade = betsMade;
    }

    public int getPlayerPlaying() {
        return playerPlaying;
    }

    public void setPlayerPlaying(int playerPlaying) {
        this.playerPlaying = playerPlaying;
    }
    
    
    
    
    
    public MainFrame(String name1, String name2, String name3, String name4) {
        initComponents();
        
        String[] names = {name1,name2,name3,name4};
        this.setPlayersNames(names);
        
        this.setBetsMade(new ArrayList<Bet>());
        this.setPlayerPlaying(4);
        
        identifyPlayers();
        identifyHorses();
        setBetAtributes();
        
        this.betScreen.setVisible(true);
        this.betScreen1.setVisible(false);
        this.betInfo.setVisible(false);
        this.moneyBetInfo.setVisible(false);
        
        this.winner.setVisible(false);
        this.betButton.setVisible(false);
        this.positiveText.setVisible(false);
        this.negativeText.setVisible(false);
    }
    
    public void identifyPlayers(){
        Gambler[] players = new Gambler[this.getPlayersNames().length];
        for(int i=0; i<this.getPlayersNames().length; i++){
            players[i] = new Gambler(this.getPlayersNames()[i]);
        }
        this.setGamblers(players);
        
        this.name1.setText(this.getGamblers()[0].getName());
        this.name2.setText(this.getGamblers()[1].getName());
        this.name3.setText(this.getGamblers()[2].getName());
        this.name4.setText(this.getGamblers()[3].getName());
        
        this.money1.setText(String.valueOf(this.getGamblers()[0].getMoney()));
        this.money2.setText(String.valueOf(this.getGamblers()[1].getMoney()));
        this.money3.setText(String.valueOf(this.getGamblers()[2].getMoney()));
        this.money4.setText(String.valueOf(this.getGamblers()[3].getMoney()));
    }
    
    public void identifyHorses(){
        this.setRacecourse(new Racecourse());
        this.setHorses(racecourse.getHorses());
        
        this.horseName1.setText(this.getHorses()[0].getName());
        this.horseName2.setText(this.getHorses()[1].getName());
        this.horseName3.setText(this.getHorses()[2].getName());
        this.horseName4.setText(this.getHorses()[3].getName());
        
        this.HorseBreed1.setText(this.getHorses()[0].getHorseBreed());
        this.HorseBreed2.setText(this.getHorses()[1].getHorseBreed());
        this.HorseBreed3.setText(this.getHorses()[2].getHorseBreed());
        this.HorseBreed4.setText(this.getHorses()[3].getHorseBreed());
        
        this.horseNumber1.setText(String.valueOf(this.getHorses()[0].getDrawerNumber()));
        this.horseNumber2.setText(String.valueOf(this.getHorses()[1].getDrawerNumber()));
        this.horseNumber3.setText(String.valueOf(this.getHorses()[2].getDrawerNumber()));
        this.horseNumber4.setText(String.valueOf(this.getHorses()[3].getDrawerNumber()));
        
    }
    
    public void setBetAtributes(){
        this.getRacecourse().makeRacing();
        this.dataRacing1.setText("Type of racing: " + this.getRacecourse().getHorseRacing().getRacingType());
        this.dataRacing2.setText("Track:" + this.getRacecourse().getHorseRacing().getTrackType());
        this.dataRacing4.setText("Distance: " + this.getRacecourse().getHorseRacing().getRaceDistance());
    }
    
    public boolean hasChar(String word){
        
        if (word.length() == 0) {
        return false;
    }
    for (int x = 0; x < word.length(); x++) {
        char c = word.charAt(x);

        if (!(c >= '0' && c <= '9')) {
            return true;
        }
    }
    return false;
    }
    
    public void giveRedward(Horse winner,Bet bet){
        if(winner.getName().equals(bet.getBet())){
            this.getGamblers()[this.getPlayerinBet()].setMoney(this.getGamblers()[this.getPlayerinBet()].getMoney() + bet.getBetMoney()*2);
            
            if(this.getPlayerinBet() == 0){
                this.money1.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                this.playerPlace1.setBackground(Color.green);
            }
            if(this.getPlayerinBet() == 1){
                this.money2.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                this.playerPlace2.setBackground(Color.green);
            }
            if(this.getPlayerinBet() == 2){
                this.money3.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                this.playerPlace3.setBackground(Color.green);
            }
            if(this.getPlayerinBet() == 3){
                this.money4.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                this.playerPlace4.setBackground(Color.green);
            }
            
            
        }
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGRacing = new javax.swing.JPanel();
        betScreen1 = new javax.swing.JPanel();
        winner = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        betInfo = new javax.swing.JPanel();
        betTitle = new javax.swing.JLabel();
        horseInfo1 = new javax.swing.JPanel();
        horseName1 = new javax.swing.JLabel();
        horseNumber1 = new javax.swing.JLabel();
        HorseBreed1 = new javax.swing.JLabel();
        picture1 = new javax.swing.JLabel();
        horseInfo2 = new javax.swing.JPanel();
        horseName2 = new javax.swing.JLabel();
        horseNumber2 = new javax.swing.JLabel();
        HorseBreed2 = new javax.swing.JLabel();
        picture2 = new javax.swing.JLabel();
        horseInfo3 = new javax.swing.JPanel();
        horseName3 = new javax.swing.JLabel();
        horseNumber3 = new javax.swing.JLabel();
        HorseBreed3 = new javax.swing.JLabel();
        picture3 = new javax.swing.JLabel();
        horseInfo4 = new javax.swing.JPanel();
        horseName4 = new javax.swing.JLabel();
        picture4 = new javax.swing.JLabel();
        HorseBreed4 = new javax.swing.JLabel();
        horseNumber4 = new javax.swing.JLabel();
        racingInfo = new javax.swing.JPanel();
        dataRacing1 = new javax.swing.JLabel();
        dataRacing2 = new javax.swing.JLabel();
        dataRacing3 = new javax.swing.JLabel();
        dataRacing4 = new javax.swing.JLabel();
        bgBetInfo = new javax.swing.JLabel();
        moneyBetInfo = new javax.swing.JPanel();
        positiveText = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        negativeText = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        checkButton = new javax.swing.JButton();
        betButton = new javax.swing.JButton();
        betScreen = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        steps = new javax.swing.JPanel();
        playerPlace1 = new javax.swing.JPanel();
        Character1 = new javax.swing.JLabel();
        name1 = new javax.swing.JLabel();
        money1 = new javax.swing.JLabel();
        bet1 = new javax.swing.JButton();
        playerPlace2 = new javax.swing.JPanel();
        Character2 = new javax.swing.JLabel();
        name2 = new javax.swing.JLabel();
        money2 = new javax.swing.JLabel();
        bet2 = new javax.swing.JButton();
        playerPlace3 = new javax.swing.JPanel();
        Character3 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        money3 = new javax.swing.JLabel();
        bet3 = new javax.swing.JButton();
        playerPlace4 = new javax.swing.JPanel();
        Character4 = new javax.swing.JLabel();
        name4 = new javax.swing.JLabel();
        money4 = new javax.swing.JLabel();
        bet4 = new javax.swing.JButton();
        bgSteps = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(900, 500));
        setResizable(false);

        bGRacing.setBackground(new java.awt.Color(255, 255, 255));
        bGRacing.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        betScreen1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        winner.setBackground(new java.awt.Color(204, 0, 0));
        winner.setFont(new java.awt.Font("Roboto", 1, 62)); // NOI18N
        winner.setForeground(new java.awt.Color(0, 255, 0));
        winner.setText("jLabel6");
        betScreen1.add(winner, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 600, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/ezgif.com-gif-maker (1)_1.gif"))); // NOI18N
        betScreen1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 600, 230));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/hipD (1).jpg"))); // NOI18N
        betScreen1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bGRacing.add(betScreen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 240));

        betInfo.setBackground(new java.awt.Color(255, 204, 153));
        betInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        betTitle.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        betTitle.setText("Horses For Today");
        betInfo.add(betTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        horseInfo1.setBackground(new java.awt.Color(255, 255, 255));
        horseInfo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horseInfo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horseInfo1MouseClicked(evt);
            }
        });
        horseInfo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horseName1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        horseName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        horseName1.setText("Jlabel");
        horseInfo1.add(horseName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 70, 20));

        horseNumber1.setText("jLabel1");
        horseInfo1.add(horseNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        HorseBreed1.setText("jLabel1");
        horseInfo1.add(HorseBreed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        picture1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/apaa (1).jpg"))); // NOI18N
        horseInfo1.add(picture1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 160, 130));

        betInfo.add(horseInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 160, 170));

        horseInfo2.setBackground(new java.awt.Color(255, 255, 255));
        horseInfo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horseInfo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horseInfo2MouseClicked(evt);
            }
        });
        horseInfo2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horseName2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        horseName2.setText("jLabel1");
        horseInfo2.add(horseName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 114, -1, 20));

        horseNumber2.setText("jLabel1");
        horseInfo2.add(horseNumber2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        HorseBreed2.setText("jLabel1");
        horseInfo2.add(HorseBreed2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        picture2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/Paint-horse (1).jpg"))); // NOI18N
        horseInfo2.add(picture2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 110));

        betInfo.add(horseInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 170, 170));

        horseInfo3.setBackground(new java.awt.Color(255, 255, 255));
        horseInfo3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horseInfo3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horseInfo3MouseClicked(evt);
            }
        });
        horseInfo3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horseName3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        horseName3.setText("jLabel1");
        horseInfo3.add(horseName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        horseNumber3.setText("jLabel1");
        horseInfo3.add(horseNumber3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        HorseBreed3.setText("jLabel1");
        horseInfo3.add(HorseBreed3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        picture3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/arabe.jpg"))); // NOI18N
        picture3.setText("jLabel1");
        horseInfo3.add(picture3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 110));

        betInfo.add(horseInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 160, 170));

        horseInfo4.setBackground(new java.awt.Color(255, 255, 255));
        horseInfo4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        horseInfo4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                horseInfo4MouseClicked(evt);
            }
        });
        horseInfo4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        horseName4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        horseName4.setText("jLabel1");
        horseInfo4.add(horseName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        picture4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        picture4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/pure (1).jpg"))); // NOI18N
        horseInfo4.add(picture4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 110));

        HorseBreed4.setText("jLabel1");
        horseInfo4.add(HorseBreed4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, 20));

        horseNumber4.setText("jLabel1");
        horseInfo4.add(horseNumber4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 40, -1));

        betInfo.add(horseInfo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 150, 170));

        racingInfo.setBackground(new java.awt.Color(0, 0, 0));
        racingInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 0)));
        racingInfo.setForeground(new java.awt.Color(255, 255, 255));
        racingInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dataRacing1.setForeground(new java.awt.Color(255, 255, 255));
        dataRacing1.setText("jLabel1");
        racingInfo.add(dataRacing1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 70, 120, -1));

        dataRacing2.setForeground(new java.awt.Color(255, 255, 255));
        dataRacing2.setText("jLabel1");
        racingInfo.add(dataRacing2, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 90, 110, -1));

        dataRacing3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        dataRacing3.setForeground(new java.awt.Color(255, 255, 255));
        dataRacing3.setText("Racing Details");
        racingInfo.add(dataRacing3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        dataRacing4.setForeground(new java.awt.Color(255, 255, 255));
        dataRacing4.setText("jLabel1");
        racingInfo.add(dataRacing4, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 130, 110, -1));

        betInfo.add(racingInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 180, 170));

        bgBetInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/34389wide.jpg"))); // NOI18N
        betInfo.add(bgBetInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 760));

        bGRacing.add(betInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 240));

        moneyBetInfo.setBackground(new java.awt.Color(0, 0, 0));
        moneyBetInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        positiveText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        positiveText.setForeground(new java.awt.Color(255, 255, 255));
        positiveText.setText("Good! Press bet button now");
        moneyBetInfo.add(positiveText, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter the money to bet:  ");
        moneyBetInfo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, -1, -1));

        negativeText.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        negativeText.setForeground(new java.awt.Color(255, 255, 255));
        negativeText.setText("you do not have enough");
        moneyBetInfo.add(negativeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, -1, -1));

        moneyLabel.setBackground(new java.awt.Color(0, 0, 0));
        moneyLabel.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(255, 255, 255));
        moneyLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moneyLabelActionPerformed(evt);
            }
        });
        moneyBetInfo.add(moneyLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 140, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        checkButton.setBackground(new java.awt.Color(255, 255, 255));
        checkButton.setText("check");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        betButton.setBackground(new java.awt.Color(255, 255, 255));
        betButton.setText("Bet");
        betButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(betButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(checkButton)
                .addGap(56, 56, 56)
                .addComponent(betButton)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        moneyBetInfo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 200, 250));

        bGRacing.add(moneyBetInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 910, 260));

        betScreen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/ezgif.com-gif-maker.gif"))); // NOI18N
        betScreen.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 600, 230));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/hipD (1).jpg"))); // NOI18N
        betScreen.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bGRacing.add(betScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 880, 240));

        steps.setBackground(new java.awt.Color(102, 204, 255));
        steps.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playerPlace1.setBackground(new java.awt.Color(255, 255, 255));
        playerPlace1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Character1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/p1m.jpg"))); // NOI18N
        playerPlace1.add(Character1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, 90));

        name1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        name1.setText("jLabel2");
        playerPlace1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 70, -1));

        money1.setText("jLabel3");
        playerPlace1.add(money1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        bet1.setText("Make bet");
        bet1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bet1ActionPerformed(evt);
            }
        });
        playerPlace1.add(bet1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 151, 85, -1));

        steps.add(playerPlace1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, 210));

        playerPlace2.setBackground(new java.awt.Color(255, 255, 255));
        playerPlace2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Character2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/p2m.jpg"))); // NOI18N
        playerPlace2.add(Character2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 90));

        name2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        name2.setText("jLabel2");
        playerPlace2.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        money2.setText("jLabel3");
        playerPlace2.add(money2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 50, -1));

        bet2.setText("Make bet");
        bet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bet2ActionPerformed(evt);
            }
        });
        playerPlace2.add(bet2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        steps.add(playerPlace2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 170, 210));

        playerPlace3.setBackground(new java.awt.Color(255, 255, 255));
        playerPlace3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Character3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/p3m.jpg"))); // NOI18N
        playerPlace3.add(Character3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 90));

        name3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        name3.setText("jLabel2");
        playerPlace3.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        money3.setText("jLabel3");
        playerPlace3.add(money3, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 126, -1, -1));

        bet3.setText("Make bet");
        bet3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bet3ActionPerformed(evt);
            }
        });
        playerPlace3.add(bet3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 151, -1, -1));

        steps.add(playerPlace3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 170, 210));

        playerPlace4.setBackground(new java.awt.Color(255, 255, 255));
        playerPlace4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Character4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/p4m.png"))); // NOI18N
        playerPlace4.add(Character4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 100));

        name4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        name4.setText("jLabel2");
        playerPlace4.add(name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        money4.setText("jLabel3");
        playerPlace4.add(money4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        bet4.setText("Make bet");
        bet4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bet4ActionPerformed(evt);
            }
        });
        playerPlace4.add(bet4, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 151, -1, -1));

        steps.add(playerPlace4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 170, 210));

        bgSteps.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        bgSteps.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/hipD (1).jpg"))); // NOI18N
        steps.add(bgSteps, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -270, 920, 500));

        bGRacing.add(steps, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 880, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bGRacing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bGRacing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bet2ActionPerformed
        
        this.playerPlace2.setBackground(Color.yellow);
        
        this.betScreen.setVisible(false);
        this.betInfo.setVisible(true);
        this.setPlayerinBet(1);
        
        this.bet1.setVisible(false);
        this.bet2.setVisible(false);
        this.bet3.setVisible(false);
        this.bet4.setVisible(false);
        
        this.betScreen1.setVisible(false);
        this.winner.setVisible(false);
    }//GEN-LAST:event_bet2ActionPerformed

    private void horseInfo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horseInfo1MouseClicked
        this.setHorseOfBet("Mostufa");
        this.betInfo.setVisible(false);
        this.moneyBetInfo.setVisible(true);
    }//GEN-LAST:event_horseInfo1MouseClicked

    private void horseInfo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horseInfo2MouseClicked
        this.setHorseOfBet("Omicron");
        this.betInfo.setVisible(false);
        this.moneyBetInfo.setVisible(true);
    }//GEN-LAST:event_horseInfo2MouseClicked

    private void horseInfo3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horseInfo3MouseClicked
        this.setHorseOfBet("Paracron");
        this.betInfo.setVisible(false);
        this.moneyBetInfo.setVisible(true);
    }//GEN-LAST:event_horseInfo3MouseClicked
        
    private void horseInfo4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_horseInfo4MouseClicked
        this.setHorseOfBet("Trueno");
        this.betInfo.setVisible(false);
        this.moneyBetInfo.setVisible(true);
    }//GEN-LAST:event_horseInfo4MouseClicked

    private void bet1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bet1ActionPerformed
        
        this.playerPlace1.setBackground(Color.yellow);
        
        this.betScreen.setVisible(false);
        this.betInfo.setVisible(true);
        this.setPlayerinBet(0);
        
        this.bet1.setVisible(false);
        this.bet2.setVisible(false);
        this.bet3.setVisible(false);
        this.bet4.setVisible(false);

        this.betScreen1.setVisible(false);
        this.winner.setVisible(false);
    }//GEN-LAST:event_bet1ActionPerformed

    private void bet3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bet3ActionPerformed
        
        this.playerPlace3.setBackground(Color.yellow);
        
        this.betScreen.setVisible(false);
        this.betInfo.setVisible(true);
        this.setPlayerinBet(2);
        
        this.bet1.setVisible(false);
        this.bet2.setVisible(false);
        this.bet3.setVisible(false);
        this.bet4.setVisible(false);

        this.betScreen1.setVisible(false);
        this.winner.setVisible(false);
    }//GEN-LAST:event_bet3ActionPerformed

    private void bet4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bet4ActionPerformed
        
        this.playerPlace4.setBackground(Color.yellow);
        
        this.betScreen.setVisible(false);
        this.betInfo.setVisible(true);
        this.setPlayerinBet(3);
        
        this.bet1.setVisible(false);
        this.bet2.setVisible(false);
        this.bet3.setVisible(false);
        this.bet4.setVisible(false);
        
        this.betScreen1.setVisible(false);
        this.winner.setVisible(false);
    }//GEN-LAST:event_bet4ActionPerformed

    private void moneyLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moneyLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moneyLabelActionPerformed

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        
        if(!this.moneyLabel.getText().equals("") && !hasChar(this.moneyLabel.getText())){
            int testMoney = Integer.parseInt(this.moneyLabel.getText());
            
            if(this.getGamblers()[this.getPlayerinBet()].getMoney() - testMoney >= 0){
                this.setMoneyTObet(testMoney);
                this.getGamblers()[this.getPlayerinBet()].setMoney(this.getGamblers()[this.getPlayerinBet()].getMoney() - testMoney);
                
                if(this.getPlayerinBet() == 0){
                    this.money1.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                }
                if(this.getPlayerinBet() == 1){
                    this.money2.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                }
                if(this.getPlayerinBet() == 2){
                    this.money3.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                }
                if(this.getPlayerinBet() == 3){
                    this.money4.setText(String.valueOf(this.getGamblers()[this.getPlayerinBet()].getMoney()));
                }
                this.positiveText.setVisible(true);
                this.negativeText.setVisible(false);
                this.betButton.setVisible(true);
                
            }
            else{
                this.negativeText.setVisible(true);
                this.moneyLabel.setText("");
            }
        }
        
        
    }//GEN-LAST:event_checkButtonActionPerformed

    private void betButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betButtonActionPerformed
        
        Bet lastBet = new Bet(this.getPlayerinBet(), this.getHorseOfBet(), this.getMoneyTObet());
        this.getBetsMade().add(lastBet);
        
        this.setHorseOfBet("");
        this.setMoneyTObet(0);
        
        this.betButton.setVisible(false);
        this.positiveText.setVisible(false);
        this.moneyLabel.setText("");
        
        this.moneyBetInfo.setVisible(false);
        this.betScreen.setVisible(true);
        
        
        if(this.getPlayerinBet() == 0){
            this.bet2.setVisible(true);
            this.bet3.setVisible(true);
            this.bet4.setVisible(true);
            this.playerPlace1.setBackground(Color.white);
        }
        if(this.getPlayerinBet() == 1){
            this.bet1.setVisible(true);
            this.bet3.setVisible(true);
            this.bet4.setVisible(true);
            this.playerPlace2.setBackground(Color.white);
        }
        if(this.getPlayerinBet() == 2){
            this.bet2.setVisible(true);
            this.bet1.setVisible(true);
            this.bet4.setVisible(true);
            this.playerPlace3.setBackground(Color.white);
        }
        if(this.getPlayerinBet() == 3){
            this.bet2.setVisible(true);
            this.bet3.setVisible(true);
            this.bet1.setVisible(true);
            this.playerPlace4.setBackground(Color.white);
        }
        
        
        if(this.getBetsMade().size() == 4){

            this.betScreen.setVisible(false);
            this.betScreen1.setVisible(true);
            
            this.bet1.setVisible(true);
            this.bet2.setVisible(true);
            this.bet3.setVisible(true);
            this.bet4.setVisible(true);
            Horse winner = this.getRacecourse().getHorseRacing().showResults();
            
            this.winner.setText(winner.getName() + " WIN!");
            this.winner.setVisible(true);
            this.getBetsMade().forEach((bet)-> giveRedward(winner, bet));   
            
            //delete players
            if (this.getGamblers()[0].getMoney() <= 0) {
                this.playerPlace1.setVisible(false);
                this.setPlayerPlaying(this.getPlayerPlaying() - 1);
            }
            if (this.getGamblers()[1].getMoney() <= 0) {
                this.playerPlace2.setVisible(false);
                this.setPlayerPlaying(this.getPlayerPlaying() - 1);
            }
            if (this.getGamblers()[2].getMoney() <= 0) {
                this.playerPlace3.setVisible(false);
                this.setPlayerPlaying(this.getPlayerPlaying() - 1);
            }
            if (this.getGamblers()[3].getMoney() <= 0) {
                this.playerPlace4.setVisible(false);
                this.setPlayerPlaying(this.getPlayerPlaying() - 1);
            }

            if (this.getPlayerPlaying() <= 1) {
                JOptionPane.showMessageDialog(null,"No one has money.\nGame over!");
                this.dispose();
            }
        }
        
        
    }//GEN-LAST:event_betButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame("","","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Character1;
    private javax.swing.JLabel Character2;
    private javax.swing.JLabel Character3;
    private javax.swing.JLabel Character4;
    private javax.swing.JLabel HorseBreed1;
    private javax.swing.JLabel HorseBreed2;
    private javax.swing.JLabel HorseBreed3;
    private javax.swing.JLabel HorseBreed4;
    private javax.swing.JPanel bGRacing;
    private javax.swing.JButton bet1;
    private javax.swing.JButton bet2;
    private javax.swing.JButton bet3;
    private javax.swing.JButton bet4;
    private javax.swing.JButton betButton;
    private javax.swing.JPanel betInfo;
    private javax.swing.JPanel betScreen;
    private javax.swing.JPanel betScreen1;
    private javax.swing.JLabel betTitle;
    private javax.swing.JLabel bgBetInfo;
    private javax.swing.JLabel bgSteps;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel dataRacing1;
    private javax.swing.JLabel dataRacing2;
    private javax.swing.JLabel dataRacing3;
    private javax.swing.JLabel dataRacing4;
    private javax.swing.JPanel horseInfo1;
    private javax.swing.JPanel horseInfo2;
    private javax.swing.JPanel horseInfo3;
    private javax.swing.JPanel horseInfo4;
    private javax.swing.JLabel horseName1;
    private javax.swing.JLabel horseName2;
    private javax.swing.JLabel horseName3;
    private javax.swing.JLabel horseName4;
    private javax.swing.JLabel horseNumber1;
    private javax.swing.JLabel horseNumber2;
    private javax.swing.JLabel horseNumber3;
    private javax.swing.JLabel horseNumber4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel money1;
    private javax.swing.JLabel money2;
    private javax.swing.JLabel money3;
    private javax.swing.JLabel money4;
    private javax.swing.JPanel moneyBetInfo;
    private javax.swing.JTextField moneyLabel;
    private javax.swing.JLabel name1;
    private javax.swing.JLabel name2;
    private javax.swing.JLabel name3;
    private javax.swing.JLabel name4;
    private javax.swing.JLabel negativeText;
    private javax.swing.JLabel picture1;
    private javax.swing.JLabel picture2;
    private javax.swing.JLabel picture3;
    private javax.swing.JLabel picture4;
    private javax.swing.JPanel playerPlace1;
    private javax.swing.JPanel playerPlace2;
    private javax.swing.JPanel playerPlace3;
    private javax.swing.JPanel playerPlace4;
    private javax.swing.JLabel positiveText;
    private javax.swing.JPanel racingInfo;
    private javax.swing.JPanel steps;
    private javax.swing.JLabel winner;
    // End of variables declaration//GEN-END:variables
}
