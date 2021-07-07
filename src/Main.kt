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
        println("Player one goes first!")
        println("Player one is X and player two is O")
        playerOne!!.symbol = 'X'
        playerTwo!!.symbol = 'O'
    } else {
        playerState = 2
        println("Player two goes first!")
        println("Player one is O and player two is X")
        playerOne!!.symbol = 'O'
        playerTwo!!.symbol = 'X'
    }

    var ticTacToeBoard = TicTacToeBoard()
    ticTacToeBoard.printBoard()
    var moveCount = 0

    while (true) {
        // TODO determine if board is filled
        // TODO determine if player has won
        print((if (playerState == 1) playerOne!!.name else playerTwo!!.name) + " enter your coordinates (space separated): ")
        val userCoordinates = readLine()?.split(" ")?.toTypedArray()
        var win: Char? = null
        if (playerState == 1) {
            if (userCoordinates != null) {
                ticTacToeBoard.setCoordinate(userCoordinates[0].toIntOrNull(), userCoordinates[1].toIntOrNull(), playerOne!!.symbol)
            }
            win = ticTacToeBoard.checkBoard(playerOne!!.symbol)
            playerState = 2
        } else if (playerState == 2) {
            if (userCoordinates != null) {
                ticTacToeBoard.setCoordinate(userCoordinates[0].toIntOrNull(), userCoordinates[1].toIntOrNull(), playerTwo!!.symbol)
            }
            win = ticTacToeBoard.checkBoard(playerTwo!!.symbol)
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