
package vista;

import java.awt.Color;

public class FormSudoku extends javax.swing.JFrame {

    private TableroSudoku tableroSudoku;
    private TableroNumeros tableroNumeros;
    
    public FormSudoku() {
        initComponents();
        iniciarComponentes();
    }
    public void iniciarComponentes(){
    tableroSudoku = new TableroSudoku();
    tableroSudoku.setTxtAltura(36);
    tableroSudoku.setTxtAncho(36);
    tableroSudoku.setTxtMargen(4);
    tableroSudoku.setTxtTamañoLetra(37);
    
    tableroSudoku.setPanelBackground(new Color(127,255,0));
    
   tableroSudoku.setTxtBackground1(Color.WHITE);
   tableroSudoku.setTxtForeground1(Color.BLACK);
   tableroSudoku.setTxtBackground2(new Color (232, 186, 186));
   tableroSudoku.setTxtForeground2(Color.BLACK);
   tableroSudoku.setTxtBackground3(new Color (232, 100, 186));
   tableroSudoku.setTxtForeground3(Color.BLACK);
    panelFondo.add(tableroSudoku);
    tableroSudoku.setLocation(20,60);
    tableroSudoku.setVisible(true);
    tableroSudoku.crearSudoku();
    
    
    tableroNumeros = new TableroNumeros();
    tableroNumeros.setTxtAncho(36);
    tableroNumeros.setTxtAltura(36);
    tableroNumeros.setTxtMargen(4);
    tableroNumeros.setTxtTamañoLetra(37);
    
    tableroNumeros.setPanelBackground(new Color(89,43,25));
   
    tableroNumeros.setTxtBackground1(new Color(239,229,216));
    tableroNumeros.setTxtForeground1(new Color(89,43,25));
    tableroNumeros.setTxtBackground1(new Color(143,72,72));
    tableroNumeros.setTxtBackground1(Color.WHITE);
    panelFondo.add(tableroNumeros);
    tableroNumeros.crearTablero();
    tableroNumeros.setLocation(20,60);
    tableroNumeros.setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(0, 153, 153));
        panelFondo.setPreferredSize(new java.awt.Dimension(540, 420));
        panelFondo.setVerifyInputWhenFocusTarget(false);
        panelFondo.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setText("SUDOKU");
        panelFondo.add(jLabel1);
        jLabel1.setBounds(10, 0, 240, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSudoku().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelFondo;
    // End of variables declaration//GEN-END:variables
}
