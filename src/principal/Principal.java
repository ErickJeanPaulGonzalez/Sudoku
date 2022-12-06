package principal;

//import modelo.Sudoku;
import vista.FormSudoku;

public class Principal {

    public static void main(String[] args) {
      
        //Sudoku sudoku = new Sudoku();
        //sudoku.mostrarSudoku();
        FormSudoku sudoku = new FormSudoku();
        sudoku.setVisible(true);
    }
    
}
