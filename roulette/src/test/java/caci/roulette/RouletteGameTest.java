package caci.roulette;

import caci.roulette.exception.RouletteGameException;
import caci.roulette.rules.impl.EvenWinningRule;
import caci.roulette.rules.impl.OddOrEvenWinningRule;
import caci.roulette.rules.impl.OddWinningRule;
import caci.roulette.rules.impl.PocketWinningRule;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;

/**
 * Created by gezas on 2017. 03. 17..
 */
public class RouletteGameTest {

    private Player player = new Player("name");

    @Mock
    private Wheel mockWheel;

    @InjectMocks
    private RouletteGame rouletteGame;

    @BeforeTest
    public void setup() {
        MockitoAnnotations.initMocks(this);
        rouletteGame.addPlayer(player);
    }

    @Test
    public void shouldPlayerWinZeroWhenPocketRuleAndLosingPocket() throws Exception {
        //given
        Pocket betPocket = new Pocket(10);
        Pocket winningPocket = new Pocket(11);
        player.makeBet(new Bet(10, new PocketWinningRule(betPocket)));
        given(mockWheel.spin()).willReturn(winningPocket);

        //when
        rouletteGame.doPlay();

        //then
        assertThat(player.getWin(), equalTo(0));
    }

    @Test
    public void shouldPlayerWin36xWhenPocketRuleAndWinningPocket() throws Exception {
        //given
        Pocket betPocket = new Pocket(10);
        player.makeBet(new Bet(10, new PocketWinningRule(betPocket)));
        given(mockWheel.spin()).willReturn(betPocket);

        //when
        rouletteGame.doPlay();

        //then
        assertThat(player.getWin(), equalTo(360));
    }

    @Test
    public void shouldExceptionThrownWhenBetWithNonPositiveAmount() throws Exception {
        //given
        try {
            player.makeBet(new Bet(-1, new OddOrEvenWinningRule()));
        } catch (RouletteGameException re) {
            assertThat(re.getMessage(), equalTo("Amount of the bet must be greater than zero!"));
        }
    }

    @Test
    public void shouldExceptionThrownWhenBetWithInvalidPocket() throws Exception {
        //given
        try {
            player.makeBet(new Bet(10, new PocketWinningRule(new Pocket(-1))));
        } catch (RouletteGameException re) {
            assertThat(re.getMessage(), equalTo("Invalid pocket!"));
        }
    }

    @Test
    public void shouldPlayerWinZeroWhenOddOrEvenAndZeroPocket() throws Exception {
        //given
        player.makeBet(new Bet(10, new OddOrEvenWinningRule()));
        Pocket winningPocket = new Pocket(0);
        given(mockWheel.spin()).willReturn(winningPocket);

        //when
        rouletteGame.doPlay();

        //then
        assertThat(player.getWin(), equalTo(0));
    }

    @Test
    public void shouldPlayerWinDoubleWhenEvenRuleAndEvenPocket() throws Exception {
        //given
        player.makeBet(new Bet(10, new EvenWinningRule()));
        Pocket winningPocket = new Pocket(20);
        given(mockWheel.spin()).willReturn(winningPocket);

        //when
        rouletteGame.doPlay();

        //then
        assertThat(player.getWin(), equalTo(player.getActualBet().getAmount() * 2));
    }

    @Test
    public void shouldPlayerWinZeroWhenEvenRuleAndOddPocket() throws Exception {
        //given
        player.makeBet(new Bet(10, new EvenWinningRule()));
        Pocket winningPocket = new Pocket(21);
        given(mockWheel.spin()).willReturn(winningPocket);

        //when
        rouletteGame.doPlay();

        //then
        assertThat(player.getWin(), equalTo(0));
    }

    @Test
    public void shouldPlayerWinZeroWhenOddRuleAndEvenPocket() throws Exception {
        //given
        player.makeBet(new Bet(10, new OddWinningRule()));
        Pocket winningPocket = new Pocket(20);
        given(mockWheel.spin()).willReturn(winningPocket);

        //when
        rouletteGame.doPlay();

        //then
        assertThat(player.getWin(), equalTo(0));
    }

    @Test
    public void shouldPlayerWinDoubleWhenOddRuleAndOddPocket() throws Exception {
        //given
        player.makeBet(new Bet(10, new OddWinningRule()));
        Pocket winningPocket = new Pocket(9);
        given(mockWheel.spin()).willReturn(winningPocket);

        //when
        rouletteGame.doPlay();

        //then
        assertThat(player.getWin(), equalTo(player.getActualBet().getAmount() * 2));
    }
}