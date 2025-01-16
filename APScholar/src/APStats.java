import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class APStats {
    public static List<Tuple<String, Double>> getStats(List<APStudent> students) {
        int noAward = 0,
                APScholar = 0,
                apsWithHonor = 0,
                apsWithDistinction = 0;

        for (APStudent student : students) {
            switch (student.getAwardLevel()) {
                case 3:
                    apsWithDistinction++;
                    break;
                case 2:
                    apsWithHonor++;
                    break;
                case 1:
                    APScholar++;
                    break;
                default:
                    noAward++;
                    break;
            }
        }

        int sum = noAward + APScholar + apsWithHonor + apsWithDistinction;

        double
                pNoAward = (sum == 0) ? 0 : (double) noAward / sum,
                pAPScholar = (sum == 0) ? 0 : (double) APScholar / sum,
                pAPsWithHonor = (sum == 0) ? 0 : (double) apsWithHonor / sum,
                pAPsWithDistinction = (sum == 0) ? 0 : (double) apsWithDistinction / sum;

        Tuple<String, Double>
                first = Tuple.of("Percent of no award:", pNoAward * 100),
                second = Tuple.of("Percent of AP Scholar:", pAPScholar * 100),
                third = Tuple.of("Percent of AP Scholar with Honors:", pAPsWithHonor * 100),
                fourth = Tuple.of("Percent of AP Scholar with Distinction:", pAPsWithDistinction * 100);

        return new ArrayList<Tuple<String, Double>>(
                Arrays.asList(
                        first,
                        second,
                        third,
                        fourth
                )
        );
    }
}
