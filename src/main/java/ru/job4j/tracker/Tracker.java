package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * добавляет заявку, переданную в аргументах в массив заявок items
     * @param item заявка
     * @return item
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    /**
     * проверяет в цикле все элементы массива items, сравнивая id с аргументом int id
     * и возвращает найденный Item. Если Item не найден - возвращает null
     * @param id - уникальный номер
     * @return Item или null
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     * @return Item[] без пустых ячеек
     */
    public Item[] findAll() {
        int count = 0;
        Item[] itemsWithoutNull = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                itemsWithoutNull[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, count);
    }

    /**
     * проверяет в цикле все элементы массива items,
     * сравнивая name (используя метод getName класса Item) с аргументом метода String key.
     * Элементы, у которых совпадает name, копирует в результирующий массив и возвращает его
     * @param key - имя
     * @return Item[] с именами, равными key
     */
    public Item[] findByName(String key) {
        int count = 0;
        Item[] names = new Item[size];
        for (int i = 0; i < size; i++) {
           if (key.equals(items[i].getName())) {
               names[count] = items[i];
               count++;
           }
        }
        return Arrays.copyOf(names, count);
    }
}