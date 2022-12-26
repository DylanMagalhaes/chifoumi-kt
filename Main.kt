fun main() {
    startGame()
}


enum class Hand {
    ROCK,
    PAPER,
    CUT,
}

fun randomHand(): Hand = Hand.values().random()

fun hasPlayerWon(iaHand: Hand, playerHand: Hand): Boolean? =
    when (playerHand) {
        Hand.ROCK ->
            when (iaHand) {
                Hand.ROCK -> null
                Hand.PAPER -> false
                Hand.CUT -> true
            }

        Hand.PAPER ->
            when (iaHand) {
                Hand.ROCK -> true
                Hand.PAPER -> null
                Hand.CUT -> false
            }

        Hand.CUT ->
            when (iaHand) {
                Hand.ROCK -> false
                Hand.PAPER -> true
                Hand.CUT -> null
            }
    }

fun printWinner(iaHand: Hand, playerHand: Hand) {
    return when (hasPlayerWon(iaHand = iaHand, playerHand = playerHand)) {
        true -> println("YOU WIN")
        false -> println("YOU LOOSE")
        null -> println("DRAW")
    }
}


fun askToPlayAgain() {
    println("play again ? yes/no ")
    val continueGame = readLine()!!.uppercase()
    if (continueGame == "YES") {
        startGame()
    }
}

fun startGame() {
    println("Rock, paper or cut ?")
    val playerHand: Hand = Hand.valueOf(readLine()!!.uppercase())
    println("you played $playerHand")
    val iaHand = randomHand()
    println("IA played: $iaHand")
    printWinner(iaHand = iaHand, playerHand = playerHand)
    askToPlayAgain()
}

