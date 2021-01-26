package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {
    /**
     * Этот метод фильтрует список по условию
     * @param students список для фильтрации
     * @param predict условие, в соответствии с которым необходимо произвести отбор
     * @return отфильтрованный список
     */
    public List<Student> collect(List<Student> students,
                                 Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }

    /**
     * Этот метод преобразует список в карту. Ключ - фамилия ученика,
     * значение - объект класса Student
     * @param students Принимает список
     * @return возвращает карту
     */
    public Map<String, Student> collectToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        st -> st,
                        (st1, st2) -> st1.getScore() > st2.getScore() ? st1 : st2
                ));
    }
}
