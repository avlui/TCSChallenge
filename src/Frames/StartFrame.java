/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

/**
 *
 * @author avlui
 */
public class StartFrame extends javax.swing.JFrame {

    /**
     * Creates new form StartFrame
     */
    public StartFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        gameTitle = new javax.swing.JLabel();
        gameTitle1 = new javax.swing.JLabel();
        startButton = new javax.swing.JPanel();
        buttonText1 = new javax.swing.JLabel();
        buttonText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(900, 500));
        setPreferredSize(new java.awt.Dimension(900, 500));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gameTitle.setFont(new java.awt.Font("Roboto", 1, 60)); // NOI18N
        gameTitle.setText("ULTIMATE HORSE RACING");
        jPanel1.add(gameTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 770, 60));

        gameTitle1.setFont(new java.awt.Font("Roboto", 1, 60)); // NOI18N
        gameTitle1.setForeground(new java.awt.Color(102, 102, 102));
        gameTitle1.setText("ULTIMATE HORSE RACING");
        jPanel1.add(gameTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 770, 60));

        startButton.setBackground(new java.awt.Color(255, 255, 255));
        startButton.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 153, 153)));
        startButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        startButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startButtonMouseClicked(evt);
            }
        });
        startButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonText1.setBackground(new java.awt.Color(153, 153, 153));
        buttonText1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        buttonText1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonText1.setText("Start");
        startButton.add(buttonText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 80, 20));

        buttonText.setBackground(new java.awt.Color(153, 153, 153));
        buttonText.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        buttonText.setForeground(new java.awt.Color(153, 153, 153));
        buttonText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonText.setText("Start");
        startButton.add(buttonText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 20));

        jPanel1.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/img/hipodromos.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-160, 0, 1080, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startButtonMouseClicked
        EntryFrame startGame = new EntryFrame();
        startGame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_startButtonMouseClicked

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
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonText;
    private javax.swing.JLabel buttonText1;
    private javax.swing.JLabel gameTitle;
    private javax.swing.JLabel gameTitle1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel startButton;
    // End of variables declaration//GEN-END:variables
}