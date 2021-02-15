package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        EasyStream easyStream = new EasyStream();
        easyStream.setList(source);
        return easyStream;
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer number : this.getList()) {
           rsl.add(fun.apply(number));
        }
        this.setList(rsl);
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> rsl = new ArrayList<>();
        for (Integer number : this.getList()) {
            if (fun.test(number)) {
                rsl.add(number);
            }
        }
        this.setList(rsl);
        return this;
    }

    public List<Integer> collect() {
        return this.getList();
    }
}
