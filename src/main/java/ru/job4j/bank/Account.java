package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает сущность "банковский счет"
 * @author mirraim
 * @version 1
 */
public class Account {
    /**
     * Реквизиты счета хранятся в переменной типа String
     */
    private String requisite;
    /**
     * Остаток на счете - число с плавающей точкой
     */
    private double balance;

    /**
     * Конструктор. При создании объекта инициализируются все поля класса
     * @param requisite - реквизиты
     * @param balance - остаток на момент открытия счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Дает возможность прочитать реквизиты счета
     * @return возвращает текущие реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод производит изменение реквизитов при необходимости
     * @param requisite принимает новые реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Дает возможность получить баланс счета
     * @return возвращает текущий баланс счета в формате double
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет изменить текущий баланс на другой
     * @param balance Принимает на вход число с плавающей точкой (double)
     *                - новое значение переменной balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Проверяет объекты на идентичность.
     * Объекты считаются идентичными, если у них совпадают реквизиты
     * Баланс в сравнении не участвует
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хэш-код объекта для проверки на идентичность.
     * @return хэшкод реквизитов
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
