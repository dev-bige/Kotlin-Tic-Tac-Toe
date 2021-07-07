class TicTacToeBoard() {

    private var board = Array(3) { CharArray(3)  {'.'} }

    fun printBoard() {
        println()
        for (row in board) {
            print("\t")
            for (cord in row) {
                print(cord + "\t")
            }
            println()
        }
        println()
    }

    fun setCoordinate(row: Int?, col: Int?, symbol: Char?) {
        if (symbol == 'X') {
            board[row!!][col!!] = 'X'
        } else if (symbol == 'O') {
            board[row!!][col!!] = 'O'
        }
    }

    fun checkBoard(symbolToCheck: Char?): Char? {
        return checkRow(symbolToCheck)
    }

    fun checkRow(symbolToCheck: Char?): Char? {
        var count = 0
        for (row in board) {
            for (cord in row) {
                if (cord == symbolToCheck) {
                    count++
                }
            }
        }
        return if (count == 3) symbolToCheck else null
    }

    // TODO add logic for column check
    fun checkCol(symbolToCheck: Char): Char {
        var count = 0
        for (column in 0 until board[0].size) {
            for (row in board.indices) {

            }
        }
        return 'z'
    }

    // TODO add logic for diagonal
    fun checkDiagonal(symbolToCheck: Char): Char {
        return 'd'
    }
}
