import kotlin.random.Random

/*
    Main spot to run application
 */

private var playerOne: Player? = null
private var playerTwo: Player? = null

fun main() {
    println("Welcome to tic tac toe!\n")
    run()
}

fun run() {
    print("Player one enter your name: ")
    playerOne = Player(readLine())

    print("Player two enter your name: ")
    playerTwo = Player(readLine())

    val turn: Int = Random.nextInt(0, 1)
    var playerState: Int
    if (turn == 1) {
        playerState = 1
        println(playerOne!!.name + " goes first!")
        println(playerOne!!.name + " is X and " + playerTwo!!.name + " is O")
        playerOne!!.symbol = 'X'
        playerTwo!!.symbol = 'O'
    } else {
        playerState = 2
        println(playerTwo!!.name + " goes first!")
        println(playerOne!!.name + " is O and " + playerTwo!!.name + " is X")
        playerOne!!.symbol = 'O'
        playerTwo!!.symbol = 'X'
    }

    var ticTacToeBoard = TicTacToeBoard()
    ticTacToeBoard.printBoard()
    var moveCount = 0

    while (true) {
        print((if (playerState == 1) playerOne!!.name else playerTwo!!.name) + " enter your coordinates (space separated): ")
        val userCoordinates = readLine()?.split(" ")?.toTypedArray()
        var win: Char? = null
        if (playerState == 1) {
            if (userCoordinates != null && ticTacToeBoard.checkCoordinate(userCoordinates[0].toIntOrNull(), userCoordinates[1].toIntOrNull())) {
                ticTacToeBoard.setCoordinate(userCoordinates[0].toIntOrNull(), userCoordinates[1].toIntOrNull(), playerOne!!.symbol)
            } else {
                println("\nCoordinates have already been set, please try again!\n" )
                ticTacToeBoard.printBoard()
                continue
            }
            if (ticTacToeBoard.checkBoard(playerOne!!.symbol)) {
                win = playerOne!!.symbol
            }
            playerState = 2
        } else if (playerState == 2) {
            if (userCoordinates != null && ticTacToeBoard.checkCoordinate(userCoordinates[0].toIntOrNull(), userCoordinates[1].toIntOrNull())) {
                ticTacToeBoard.setCoordinate(userCoordinates[0].toIntOrNull(), userCoordinates[1].toIntOrNull(), playerTwo!!.symbol)
            } else {
                println("\nCoordinates have already been set, please try again!\n" )
                ticTacToeBoard.printBoard()
                continue
            }
            if (ticTacToeBoard.checkBoard(playerTwo!!.symbol)) {
                win = playerTwo!!.symbol
            }
            playerState = 1
        }
        moveCount++
        ticTacToeBoard.printBoard()
        if (win == playerOne!!.symbol) {
            println(playerOne!!.name + "has won!")
            break;
        } else if (win == playerTwo!!.symbol) {
            println(playerTwo!!.name + " has won!")
            break;
        }

        if (moveCount == 9) {
            println("Game has ended in a tie!")
            break;
        }
    }
}