
package modelo;

public class Sudoku {
    private int sudoku[][];
    public Sudoku(){
        int sudo[][]={
            {0,6,0,1,0,4,0,5,0},
            {0,0,8,3,0,5,6,0,0},
            {2,0,0,0,0,0,0,0,1},
            {8,0,0,4,0,7,0,0,6},
            {0,0,6,0,0,0,3,0,0},
            {7,0,0,9,0,1,0,0,4},
            {5,0,0,0,0,0,0,0,2},
            {0,0,7,2,0,6,9,0,0},
            {0,4,0,5,0,8,0,7,0},
        };
        sudoku=sudo;
    }
    public boolean resolverSudoku(){
        for (int i = 0; i < sudoku.length; i++){                                   //Fila
            for (int j = 0; j < sudoku[0].length; j++){                             //Columna 
                if(sudoku[i][j]== 0){
                    for (int valor = 1; valor <=9; valor++){                       //valor de relleno sudoku
                        if(validarFila(i,valor)&&validarColumna(j,valor)&&validarCuadrante(i,j,valor)){
                        sudoku[i][j]=valor;
                            if(resolverSudoku()){
                                return true;
                            }
                        sudoku[i][j]=0;
                        }
                    }return false;
                }
            }  
        }return true;
    }
    public boolean validarFila(int i, int valor){
        for (int j = 0; j < sudoku[i].length; j++) {
            if(sudoku[i][j]==valor){
                return false;
            }
        }
        return true;
    }
    public boolean validarColumna( int j, int valor){
        for(int i = 0; i < sudoku.length; i++){
            if(sudoku[i][j]==valor){
                return false;
            }
        }
        return true;
    }
    public boolean validarCuadrante(int i, int j, int valor){
        int posI = subCuadranteActual(i);
        int posJ = subCuadranteActual(j);
         
        
        for (int k = posI-3; k < posI; k++){
            for (int l = posJ-3; l< posJ; l++ ){
                if(sudoku[k][l]==valor){
                    return false;
                }
            }
        }
        return true;
    }
    public int subCuadranteActual(int pos){
        if(pos<=2) return 3;
        else if (pos<=5) return 6;
        else return 9;
    }
    public void mostrarSudoku(){
        resolverSudoku();
        for(int i = 0; i < sudoku.length; i++){
            for(int j = 0; j< sudoku[0].length; j++){
                System.out.print(sudoku[i][j]);
                if(!(j==sudoku[0].length-1))System.out.print("-");
            }
            System.out.println();
            
        }
        }
    
    
    public int[][] getSudoku() {
        return sudoku;
    }

    public void setSudoku(int[][] sudoku) {
        this.sudoku = sudoku;
    }
    
}
