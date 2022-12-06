package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import modelo.Sudoku;

public class TableroSudoku extends JPanel{
    
    private JTextField[][] listatxt;
    private int txtAncho;
    private int txtAltura;
    private int txtMargen;
    private int txtTamañoLetra;
    private Color panelBackground;
    private Color txtBackground1;
    private Color txtForeground1;
    private Color txtBackground2;
    private Color txtForeground2;  
    private Color txtBackground3;
    private Color txtForeground3;
    private Sudoku sudoku;
    private ArrayList<JTextField> listaTxtAux;
    
   public TableroSudoku(){
       iniciarComponentes();
 
   }
   public void iniciarComponentes(){
   listatxt = new JTextField[9][9];
   txtAncho = 35;
   txtAltura = 36;
   txtMargen = 4;
   txtTamañoLetra = 27;
   panelBackground = Color.BLUE;
   txtBackground1 = Color.WHITE;
   txtForeground1 = Color.BLACK;
   txtBackground2 = Color.WHITE;
   txtForeground2 = Color.BLACK;
   txtBackground3 = Color.WHITE;
   txtForeground3 = Color.BLACK;
   sudoku = new Sudoku();
   listaTxtAux = new ArrayList<>();
   }
   
   public void crearSudoku(){
   this.setLayout(null);
   this.setSize(txtAncho*9 + (txtMargen*4),txtAltura*9+(txtMargen*4));
   this.setBackground(panelBackground);
   crearCamposTxt();
   }
   
   public void crearCamposTxt(){
       int x = txtMargen;
       int y = txtMargen;
       
       for (int i = 0; i < listatxt.length; i++) {
           for (int j = 0; j < listatxt[0].length; j++) {
               JTextField txt = new JTextField();
               this.add(txt);
               txt.setBounds(x, y,txtAncho, txtAltura);
               txt.setBackground(txtBackground1);
               txt.setForeground(txtForeground1);
               txt.setFont(new Font("Monserrat",Font.BOLD,txtTamañoLetra));
               txt.setEditable(false);
               txt.setCursor(new Cursor(Cursor.HAND_CURSOR));
               txt.setBorder(BorderFactory.createLineBorder(panelBackground));
               txt.setVisible(true);
               x+=txtAncho;
               if((j+1)%3==0){
                   x+=txtMargen;
               }
               listatxt[i][j]= txt;
               generarEventos(txt);
           }
           x=txtMargen;
           y+=txtAltura;
           if((i+1)%3==0){
               y+=txtMargen;
           }
       }
    }
    public void generarEventos(JTextField txt){
        MouseListener evento = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            pressed(txt);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        KeyListener eventoTecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar()>=49&&e.getKeyChar()<=57){
                txt.setText(String.valueOf(e.getKeyChar()));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        txt.addMouseListener(evento);
        txt.addKeyListener(eventoTecla);
    }
    public void pressed(JTextField txt){ 
        for(JTextField jTxt : listaTxtAux){
            jTxt.setBackground(txtBackground1);
            jTxt.setForeground(txtForeground1);
            jTxt.setBorder(BorderFactory.createLineBorder(panelBackground,1));
            
        }
        listaTxtAux.clear();
        for (int i = 0; i < listatxt.length; i++) {
            for (int j = 0; j < listatxt[0].length; j++) {
               if (listatxt[i][j]==txt) {
                    for (int k = 0; k < listatxt.length; k++) {
                       listatxt[k][j].setBackground(txtBackground2);
                       listatxt[k][j].setForeground(txtForeground2);
                       listaTxtAux.add(listatxt[k][j]);
                    }
                    for (int k = 0; k < listatxt[0].length; k++) {
                        listatxt[i][k].setBackground(txtBackground2);
                        listatxt[i][k].setForeground(txtForeground2);
                        listaTxtAux.add(listatxt[i][k]);
                    }
                    int posI = sudoku.subCuadranteActual(i);
                    int posJ = sudoku.subCuadranteActual(j);
                    for (int k = posI-3; k< posI; k++){
                        for (int l = posJ-3; l < posJ; l++) {
                            listatxt[k][l].setBackground(txtBackground2);
                            listatxt[k][l].setForeground(txtForeground2);
                            listaTxtAux.add(listatxt[k][l]);
                        }
                    }
                    listatxt[i][j].setBackground(txtBackground3);
                    listatxt[i][j].setForeground(txtForeground3);
                    listatxt[i][j].setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));
                    return;
               }
            }
        }
    }
    public JTextField[][] getListatxt() {
        return listatxt;
    }

    public void setListatxt(JTextField[][] listatxt) {
        this.listatxt = listatxt;
    }

    public int getTxtAncho() {
        return txtAncho;
    }

    public void setTxtAncho(int txtAncho) {
        this.txtAncho = txtAncho;
    }

    public int getTxtAltura() {
        return txtAltura;
    }

    public void setTxtAltura(int txtAltura) {
        this.txtAltura = txtAltura;
    }

    public int getTxtMargen() {
        return txtMargen;
    }

    public void setTxtMargen(int txtMargen) {
        this.txtMargen = txtMargen;
    }

    public int getTxtTamañoLetra() {
        return txtTamañoLetra;
    }

    public void setTxtTamañoLetra(int txtTamañoLetra) {
        this.txtTamañoLetra = txtTamañoLetra;
    }

    public Color getPanelBackground() {
        return panelBackground;
    }

    public void setPanelBackground(Color panelBackground) {
        this.panelBackground = panelBackground;
    }

    public Color getTxtBackground1() {
        return txtBackground1;
    }

    public void setTxtBackground1(Color txtBackground1) {
        this.txtBackground1 = txtBackground1;
    }

    public Color getTxtForeground1() {
        return txtForeground1;
    }

    public void setTxtForeground1(Color txtForeground1) {
        this.txtForeground1 = txtForeground1;
    }

    public Color getTxtBackground2() {
        return txtBackground2;
    }

    public void setTxtBackground2(Color txtBackground2) {
        this.txtBackground2 = txtBackground2;
    }

    public Color getTxtForeground2() {
        return txtForeground2;
    }

    public void setTxtForeground2(Color txtForeground2) {
        this.txtForeground2 = txtForeground2;
    }

    public Color getTxtBackground3() {
        return txtBackground3;
    }

    public void setTxtBackground3(Color txtBackground3) {
        this.txtBackground3 = txtBackground3;
    }

    public Color getTxtForeground3() {
        return txtForeground3;
    }

    public void setTxtForeground3(Color txtForeground3) {
        this.txtForeground3 = txtForeground3;
    }
   
   
}

