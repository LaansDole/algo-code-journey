package RMIT.Test2_2023A;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoraCakeTest {

    DoraCake.Topic topic1 = new DoraCake.Topic(8.0, 7.0);
    DoraCake.Topic topic2 = new DoraCake.Topic(10.0, 8.0);
    DoraCake.Topic topic3 = new DoraCake.Topic(5.0, 3.0);
    DoraCake cake = new DoraCake((new DoraCake.Topic[]{topic1 , topic2 , topic3}) , 10);

    @Test
    void doubleMergeSort() {
        double[] arr = new double[]{1.2, 5.3, 1.1};
        new DoraCake.MergeSort().mergeSort(arr);

        for(double a : arr) {
            System.out.println(a);
        }
    }
}