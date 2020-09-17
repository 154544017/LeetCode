import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] input = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solveSudoku(input);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    public static void solveSudoku(char[][] board) {
        solve(board,0);
    }

    //    public static boolean solve(char[][]board){
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                char v = board[i][j];
//                if (v == '.'){
//                    for (int k = 1; k < 10; k++) {
//                        char temp = (char)('0'+k);
//                        if (checkSudoku(board,i,j,temp)){
//                            board[i][j] = temp;
//                            if (solve(board)){
//                                return true;
//                            }else {
//                                board[i][j] = '.';
//                            }
//                        }
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//
//    public static boolean checkSudoku(char[][] board, int row, int col, char v){
//        for (int i = 0; i < 9; i++) {
//            //check row             check col               check box
//            if (board[row][i] == v || board[i][col] == v || board[row/3*3+i/3][col/3*3+i%3] == v ){
//                return false;
//            }
//        }
//        return true;
//    }
    public static boolean solve(char[][] board, int depth) {
        if (depth == 81) {
            return true;
        }
        int i = depth / 9, j = depth % 9;
        char v = board[i][j];
        if (v != '.'){
            return solve(board, depth+1);
        }
        boolean[] validate = new boolean[10];
        checkSudoku(board, i, j, validate);
        for (int k = 1; k < 10; k++) {
            if (validate[k]) {
                char temp = (char) ('0' + k);
                board[i][j] = temp;
                if (solve(board, depth+1)) {
                    return true;
                }
            }
        }
        board[i][j] = '.';
        return false;
    }


    public static void checkSudoku(char[][] board, int row, int col, boolean[] validate) {
        Arrays.fill(validate, true);
        for (int i = 0; i < 9; i++) {
            char c;
            if ((c = board[row][i]) != '.') {
                validate[c - '0'] = false;
            }
            if ((c = board[i][col]) != '.') {
                validate[c - '0'] = false;
            }
            if ((c = board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3]) != '.') {
                validate[c - '0'] = false;
            }
        }
    }
}
