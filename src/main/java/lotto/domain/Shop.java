package lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.utils.ValidationChecker.exceptionCheck;
import static lotto.utils.ValidationChecker.isEmptyOrNull;

public class Shop {
    private static final int LOTTO_PRICE = 1_000;

    private Shop() {}

    public static Lottos buyLottos(String money) {
        isEmptyOrNull(money);
        exceptionCheck(money);
        long lottoCount = Long.parseLong(money) / LOTTO_PRICE;
        return new Lottos(Stream.generate(() -> new Lotto(Numbers.getNumbers())).limit(lottoCount).collect(Collectors.toList()));
    }
}
