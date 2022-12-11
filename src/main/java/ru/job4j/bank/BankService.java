package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Класс описывает работу банковской системы.
 * В котором можно регистрировать, удалять пользователя из системы,
 * добавлять пользователю банковский счет(счетов может быть несколько),
 * а также переводить деньги с одного счета на другой.
 * @author Vyacheslav Voinov
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение задания осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод принимает на вход пользователя и регистрирует в системе
     * аккаунт пользователя и его счета
     * @param user пользователь, который добавляется в систему.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Этот метод должен добавить новый счет к пользователю
     * @param passport номер паспорта по которому идентифицируется пользователь
     * @param account номер счета, который нужно добавить
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод должен вернуть пользователя по паспорту
     * @param passport паспорт пользователя
     * @return возвращает пользователя или null, если он не найден
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(u -> u.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     * @param passport паспорт пользователя
     * @param requisite номер счета
     * @return возвращает счет пользователя, или null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(u -> u.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param srcPassport номер паспорта пользователя у которого списывают деньги
     * @param srcRequisite номер счета на который переводят деньги
     * @param destPassport номер паспорта пользователя у которого списывают деньги
     * @param destRequisite номер счета на который переводят деньги
     * @param amount сумма перевода
     * @return возвращает true, если перевод был выполнен, иначе - false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}