import kotlin.math.absoluteValue

class TennisGame3(private val p1N: String, private val p2N: String) : TennisGame {

    private var p2: Int = 0
    private var p1: Int = 0

    override fun getScore(): String {
        return if (p1 < 4 && p2 < 4 && p1 + p2 != 6) {
            val pointsDescriptions = arrayOf("Love", "Fifteen", "Thirty", "Forty")
            val firstPart = pointsDescriptions[p1]
            val secondPart = if (p1 == p2) "All" else pointsDescriptions[p2]
            "$firstPart-$secondPart"
        } else {
             if (p1 == p2)
                "Deuce"
            else {
                val playerWon = if (p1 > p2) p1N else p2N
                if ((p1 - p2).absoluteValue == 1)
                    "Advantage $playerWon" else
                    "Win for $playerWon"
            }
        }
    }

    override fun wonPoint(playerName: String) {
        if (playerName === "player1")
            this.p1 += 1
        else
            this.p2 += 1

    }

}
