package ru.job4j.tracker.bank;

import java.util.Objects;

/**
 * Класс описывает сущность владельца банковского счета
 * @author mirraim
 * @version 1
 */
public class User {
    /**
     * Паспортные данные в формате String
     */
    private String passport;
    /**
     * Имя владельца счета в формате String
     */
    private String username;

    /**
     * Конструктор, при создании экземпляра класса инициализируются все поля
     * @param passport - паспортные данные
     * @param username - имя владельца счета
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить паспортные данные владельца счета
     * @return возвращает текущие паспортные данные в формате String
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет изменить паспортные данные
     * @param passport в качестве параметра принимает новые паспортные данные в формате String
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить имя владельца счета
     * @return возвращает текущие имя владельца в формате String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет изменить имя владельца
     * @param username в качестве параметра принимает новое имя в формате String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Проверяет объекты на идентичность.
     * Объекты считаются идентичными, если у них совпадают паспортные данные
     * Имя пользователя в сравнении не участвует
     * @param o принимает объект, с которым необходимо произвести сравнение
     * @return возвращает true, если объекты идентичны и false, если они разные.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хэш-код объекта для проверки на идентичность.
     * @return хэшкод паспортных данных
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
