class TicTacToeBoard() {

    private var board = Array(3) { CharArray(3)  {'.'} }

    fun printBoard() {
        println()
        print("\t0\t1\t2\n")
        for ((count, row) in board.withIndex()) {
            print(count.toString() + "\t")
            for (cord in row) {
                print(cord + "\t")
            }
            println()
        }
        println()
    }

    fun checkCoordinate(row: Int?, col: Int?): Boolean {
        return board[row!!][col!!] == '.'
    }

    fun setCoordinate(row: Int?, col: Int?, symbol: Char?) {
        if (checkCoordinate(row, col)) {
            if (symbol == 'X') {
                board[row!!][col!!] = 'X'
            } else if (symbol == 'O') {
                board[row!!][col!!] = 'O'
            }
        }
    }

    fun checkBoard(symbolToCheck: Char?): Boolean {
        return checkRow(symbolToCheck) || checkCol(symbolToCheck) || checkDiagonal(symbolToCheck)
    }

    private fun checkRow(symbolToCheck: Char?): Boolean {
        var count = 0
        for (row in board) {
            for (cord in row) {
                if (cord == symbolToCheck) {
                    count++
                }
            }
        }
        return count == 3
    }

    // TODO fix
    private fun checkCol(symbolToCheck: Char?): Boolean {
        var count = 0
        for (j in 0 until board[0].size) {
            for (i in board.indices) {
                if (board[i][j] == symbolToCheck) {
                    count++
                }
            }
        }
        return count == 3
    }

    private fun checkDiagonal(symbolToCheck: Char?): Boolean {
        return (board[0][0] == symbolToCheck && board[1][1] == symbolToCheck && board[2][2] == symbolToCheck) ||
                (board[0][2] == symbolToCheck && board[1][1] == symbolToCheck && board[0][2] == symbolToCheck)
    }
}
