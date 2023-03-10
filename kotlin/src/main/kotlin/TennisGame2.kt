class TennisGame2(private val player1Name: String, private val player2Name: String) : TennisGame {
    var P1point: Int = 0
    var P2point: Int = 0

    override fun getScore(): String {
        return when {
            P2point == P1point -> if (P1point < 3) "${calculateScore(P1point)}-All" else "Deuce"
            P2point >= 4 && P2point - P1point >= 2 -> "Win for player2"
            P1point >= 4 && P1point - P2point >= 2 -> "Win for player1"
            P2point > P1point && P1point >= 3 -> "Advantage player2"
            P1point > P2point && P2point >= 3 -> "Advantage player1"
            else -> "${calculateScore(P1point)}-${calculateScore(P2point)}"
        }

    }

    private fun calculateScore(scoreAmount: Int) = when (scoreAmount) {
        0 -> "Love"
        1 -> "Fifteen"
        2 -> "Thirty"
        3 -> "Forty"
        else -> ""
    }

    fun SetP1Score(number: Int) {

        for (i in 0 until number) {
            P1Score()
        }

    }

    fun SetP2Score(number: Int) {

        for (i in 0 until number) {
            P2Score()
        }

    }

    fun P1Score() {
        P1point++
    }

    fun P2Score() {
        P2point++
    }

    override fun wonPoint(player: String) {
        if (player === "player1") P1Score()
        else P2Score()
    }
}