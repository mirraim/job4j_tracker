package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    /**
     * Инициализируем выбор пользователя
     * @param scanner scanner
     * @param tracker tracker
     */
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                create(scanner, tracker);
            } else if (select == 1) {
                findAll(tracker);
            } else if (select == 2) {
                edit(scanner, tracker);
            } else if (select == 3) {
                delete(scanner, tracker);
            } else if (select == 4) {
                findItemById(scanner, tracker);
            } else if (select == 5) {
                findItemsByName(scanner, tracker);
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("incorrect value");
            }
        }
    }

    /**
     * Выводим меню в консоль
     */
    private void showMenu() {
        System.out.println("Menu.");
        for (String item : getMenu()) {
            System.out.println(item);
        }
    }

    /**
     * запрашиваем имя
     * Создаем новый Item
     * записываем в items
     * @param scanner scanner
     * @param tracker tracker
     */
    private void create(Scanner scanner, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Item item = new Item(name);
        tracker.add(item);
    }

    /**
     * Выводим в консоль все item
     * @param tracker tracker
     */
    private void findAll(Tracker tracker) {
        System.out.println("=== List Of Items ====");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }

    /**
     * Запрашиваем у пользователя Id и новое name
     * редактируем id
     * если id  не найден, сообщаем об этом
     * @param scanner scanner
     * @param tracker tracker
     */
    private void edit(Scanner scanner, Tracker tracker) {
        System.out.println("=== Edit ====");
        System.out.println("Enter id: ");
        int id = Integer.valueOf(scanner.nextLine());
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Edit is successful");
        } else {
            System.out.println("incorrect id");
        }
    }

    /**
     * Запрашиваем id
     * Удаляем item с указанным id
     * сообщаем о результате
     * @param scanner scanner
     * @param tracker tracker
     */
    private void delete(Scanner scanner, Tracker tracker) {
        System.out.println("=== Delete by id ====");
        System.out.println("Enter id: ");
        int id = Integer.valueOf(scanner.nextLine());
        if (tracker.delete(id)) {
            System.out.println("Deleted");
        } else {
            System.out.println("incorrect id");
        }
    }

    /**
     * Запрашиваем id
     * выводим в консоль item или сообщение, что id не найден
     * @param scanner scanner
     * @param tracker tracker
     */
    private void findItemById(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find by id ====");
        System.out.println("Enter id: ");
        int id = Integer.valueOf(scanner.nextLine());
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Id is not found");
        }
    }

    /**
     * Запрашиваем name
     * выводим в консоль список item или сообщение, что name не найдено
     * @param scanner scanner
     * @param tracker tracker
     */
    private void findItemsByName(Scanner scanner, Tracker tracker) {
        System.out.println("=== Find by name ====");
        System.out.println("Enter id: ");
        String name = scanner.nextLine();
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Name is not found");
        }
    }

    /**
     * Задаем пункты меню
     * @return меню
     */
    private String[] getMenu() {
        String[] menu = new String[7];
        menu[0] =  "0. Add new Item";
        menu[1] = "1. Show all items";
        menu[2] = "2. Edit item";
        menu[3] = "3. Delete item";
        menu[4] = "4. Find item by Id";
        menu[5] = "5. Find items by name";
        menu[6] = "6. Exit Program";
        return menu;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
