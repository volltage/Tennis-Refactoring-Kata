class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var mScore1: Int = 0
    private var mScore2: Int = 0

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            mScore1 += 1
        else
            mScore2 += 1
    }

    override fun getScore() =
        when {
            mScore1 == mScore2 -> generateDeuceScore()
            mScore1 >= 4 || mScore2 >= 4 -> generateWinScore()
            else -> generateCurrentResult()
        }

    private fun generateCurrentResult() = listOf(mScore1, mScore2)
        .map {
            when (it) {
                0 -> "Love"
                1 -> "Fifteen"
                2 -> "Thirty"
                3 -> "Forty"
                else -> ""
            }
        }.joinToString("-")

    private fun generateWinScore() = when {
        mScore1 - mScore2 == 1 -> "Advantage player1"
        mScore1 - mScore2 == -1 -> "Advantage player2"
        mScore1 - mScore2 >= 2 -> "Win for player1"
        else -> "Win for player2"
    }

    private fun generateDeuceScore() = when (mScore1) {
        0 -> "Love-All"
        1 -> "Fifteen-All"
        2 -> "Thirty-All"
        else -> "Deuce"
    }
}
