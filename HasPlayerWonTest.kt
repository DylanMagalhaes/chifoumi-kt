import org.testng.Assert.assertFalse
import org.testng.Assert.assertNull
import org.testng.Assert.assertTrue
import org.testng.annotations.Test

class HasPlayerWonTest {

    @Test
    fun `should return null when IA and player hands are the sames`() {
        //GIVEN
        Hand.values().forEach { hand ->
            //WHEN
            val actual = hasPlayerWon(iaHand = hand, playerHand = hand)

            //THEN
            assertNull(actual, "Hand = $hand")
        }
    }

    @Test
    fun `should return true when IA played ROCK and player played PAPER`() {
        //WHEN
        val actual = hasPlayerWon(iaHand = Hand.ROCK, playerHand = Hand.PAPER)

        //THEN
        assertTrue(actual!!)
    }

    @Test
    fun `should return false when IA played ROCK and player played CUT`() {
        //GIVEN
        val iaHand = Hand.ROCK
        val playerHand = Hand.CUT

        //WHEN
        val actual = hasPlayerWon(iaHand, playerHand)

        //THEN
        assertFalse(actual!!)
    }

    @Test
    fun `should return false when IA played PAPER and player played ROCK`() {
        //GIVEN
        val iaHand = Hand.PAPER
        val playerHand = Hand.ROCK

        //WHEN
        val actual = hasPlayerWon(iaHand, playerHand)

        //THEN
        assertFalse(actual!!)
    }

    @Test
    fun `should return true when IA played PAPER and player played CUT`() {
        //GIVEN
        val iaHand = Hand.PAPER
        val playerHand = Hand.CUT

        //WHEN
        val actual = hasPlayerWon(iaHand, playerHand)

        //THEN
        assertTrue(actual!!)
    }

    @Test
    fun `should return false when IA played CUT and player played PAPER`() {
        //GIVEN
        val iaHand = Hand.CUT
        val playerHand = Hand.PAPER

        //WHEN
        val actual = hasPlayerWon(iaHand, playerHand)

        //THEN
        assertFalse(actual!!)
    }

    @Test
    fun `should return true when IA played CUT and player played ROCK`() {
        //GIVEN
        val iaHand = Hand.CUT
        val playerHand = Hand.ROCK

        //WHEN
        val actual = hasPlayerWon(iaHand, playerHand)

        //THEN
        assertTrue(actual!!)
    }
}