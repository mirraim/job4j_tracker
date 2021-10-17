package ru.job4j.tracker.store;

import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {

    }

    /**
     * добавляет заявку, переданную в аргументах в массив заявок items
     * @param item заявка
     * @return item
     */
    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    /**
     * проверяет в цикле все элементы массива items,
     * сравнивая id с аргументом int id
     * и возвращает найденный Item. Если Item не найден - возвращает null
     * @param id - уникальный номер
     * @return Item или null
     */
    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    /**
     * возвращает копию массива items без null элементов (без пустых ячеек)
     * @return Item[] без пустых ячеек
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * проверяет в цикле все элементы массива items,
     * сравнивая name (используя метод getName класса Item)
     * с аргументом метода String key.
     * Элементы, у которых совпадает name,
     * копирует в результирующий массив и возвращает его
     * @param key - имя
     * @return Item[] с именами, равными key
     */
    public List<Item> findByName(String key) {
        List<Item> names = new ArrayList<>();
        for (Item item : items) {
            if (key.equals(item.getName())) {
                names.add(item);
            }
        }
        return names;
    }

    /**
     * Меняет Item на другую, id при этом остается неизменным
     * @param id id
     * @param item item
     * @return была ли произведена замена
     */
    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    /**
     * возвращает индекс по id
     * @param id id
     * @return index
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    /**
     * Замена заполненной ячейки массива на null
     * @param id id
     * @return была ли удалена заявка
     */
    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {

    }
}