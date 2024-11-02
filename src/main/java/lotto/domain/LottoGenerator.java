package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    public List<Lotto> generateLotto(int ticket) {
        return Stream.generate(() -> new Lotto(generateLottoNumbers()))
                .limit(ticket)
                .collect(Collectors.toList());
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        ascending(numbers);
        return numbers;
    }

    private static void ascending(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
