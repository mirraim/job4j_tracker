package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает работу банковского сервиса.
 * Связывает владельца (User) с его счетами(Account)
 * Управляет счетами
 * @author mirraim
 * @version 1
 */
public class BankService {
    /**
     * Перечень связывает владельца(User) с его счетами(Account).
     * User хранится в ключе
     * В значении хранится список Account
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет User в перечень, если в перечне такого User еще нет
     * @param user принимает в качестве параметра User,
     *             который должен быть добавлен в перечень
     */
    public void addUser(User user) {
            users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет новый Account в список счетов User-а
     * Сначала ищет владельца счета в перечне users
     * по его паспортным данным (String passport)
     * Если User найден, и добавляемого счета в списке его счетов нет,
     * то производится добавление счета в список.
     * @param passport принимает параметром паспортные данные в формате строки
     * @param account принимает параметром счет, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent() && !users.get(user.get()).contains(account)) {
            users.get(user.get()).add(account);
        }
    }

    /**
     * Метод ищет владельца счета в перечне users по его паспортным данным
     * @param passport принимает параметром паспортные данные в формате строки
     * @return возвращает User, если владелец счета найден в перечне users, или null
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> passport.equals(u.getPassport()))
                .findFirst();
    }

    /**
     * Метод ищет счет по реквизитам и паспортным данным владельца счета
     * @param passport принимает параметром паспортные данные в формате строки
     * @param requisite принимает параметром реквизиты в формате строки
     * @return Если счет найден, возвращает Account. Если не найден, то null
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        Optional<Account> rsl = Optional.empty();
        if (user.isPresent()) {
            rsl = users.get(user.get())
                    .stream()
                    .filter(acc -> acc.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
    }

    /**
     * Метод осуществляет перевод между счетами
     * @param srcPassport - паспортные данные владельца,
     *                    со счета которого осуществляется перевод
     * @param srcRequisite - реквизиты счета, с которого осуществляется перевод
     * @param destPassport - паспортные данные владельца,
     *                     на счет которого осуществляется перевод
     * @param destRequisite - реквизиты счета, на который осуществляется перевод
     * @param amount - сумма перевода
     * @return true, если перевод успешен, в противном случае false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isPresent()
        && destAccount.isPresent()
        && srcAccount.get().getBalance() >= amount) {
            srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
            destAccount.get().setBalance(destAccount.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
