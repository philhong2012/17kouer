import com.seventeenkouer.da.model.DrugstoreInfo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xubing.hong on 2/17/2017.
 */
public class TestCase {


    public static  void main(String[] args) {
        BigDecimal decimal = new BigDecimal(5);

        decimal.setScale(2,BigDecimal.ROUND_HALF_UP);


        System.out.println(decimal);
        Map<String,DrugstoreInfo> map = new HashMap<String, DrugstoreInfo>(100000);

        for(int i = 0; i < 700000; i ++) {
            map.put(String.valueOf(i),new DrugstoreInfo());
            System.out.println(i);
        }

        while (true) {

        }

    }
}
