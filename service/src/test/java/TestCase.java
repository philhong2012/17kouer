import java.math.BigDecimal;

/**
 * Created by xubing.hong on 2/17/2017.
 */
public class TestCase {
    public static  void main(String[] args) {
        BigDecimal decimal = new BigDecimal(5);

        decimal.setScale(2,BigDecimal.ROUND_HALF_UP);


        System.out.println(decimal);

    }
}
