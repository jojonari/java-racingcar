package racingGame;

import racingGame.domain.Racing;
import racingGame.view.InputView;
import racingGame.view.OutputView;

public class MainController {

    public static void main(String[] args) {
        String inputNames = InputView.inputNames();
        int inputTime = InputView.countTime();

        Racing racing = new Racing(inputTime, Util.stringSplitToList(inputNames, ","));
        racing.raceStart();

        OutputView.printRace(racing.getCars(), inputTime);
        OutputView.printWinners(Util.joinListString(racing.getWinnerNames(), ", "));
    }
}
