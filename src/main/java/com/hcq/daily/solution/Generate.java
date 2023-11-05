package com.hcq.daily.solution;

import java.util.ArrayList;
import java.util.List;

public class Generate {

    //  1
    //  1  1
    //  1  2  1
    //  1  3  3  1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> cons = new ArrayList<>();
        List<Integer> f = new ArrayList<>();
        f.add(1);
        cons.add(f);
        for (int i = 2; i <= numRows; ++i) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                List<Integer> list = cons.get(i - 2);
                cur.add((j == i - 1 ? 0 : list.get(j)) + (j == 0 ? 0 : list.get(j - 1)));
            }
            cons.add(cur);
        }
        return cons;
    }

}
