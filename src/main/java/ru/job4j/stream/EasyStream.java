package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    private EasyStream() {
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer number : this.list) {
           rsl.add(fun.apply(number));
        }
        return new EasyStream(rsl);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer number : this.list) {
            if (fun.test(number)) {
                rsl.add(number);
            }
        }
        return new EasyStream(rsl);
    }

    public List<Integer> collect() {
        return this.list;
    }
}
