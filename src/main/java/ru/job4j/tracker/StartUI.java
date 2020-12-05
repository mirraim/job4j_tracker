package ru.job4j.tracker;

public class StartUI {
    /**
     * Инициализируем выбор пользователя
     * @param input input
     * @param tracker tracker
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                findAllItems(tracker);
            } else if (select == 2) {
                replaceItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findItemById(input, tracker);
            } else if (select == 5) {
                findItemsByName(input, tracker);
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
     * @param input input
     * @param tracker tracker
     */
    private static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    /**
     * Выводим в консоль все item
     * @param tracker tracker
     */
    private static void findAllItems(Tracker tracker) {
        System.out.println("=== List Of Items ====");
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
    }

    /**
     * Запрашиваем у пользователя Id и новое name
     * редактируем id
     * если id  не найден, сообщаем об этом
     * @param input input
     * @param tracker tracker
     */
    private static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit ====");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
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
     * @param input input
     * @param tracker tracker
     */
    private static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete by id ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Deleted");
        } else {
            System.out.println("incorrect id");
        }
    }

    /**
     * Запрашиваем id
     * выводим в консоль item или сообщение, что id не найден
     * @param input input
     * @param tracker tracker
     */
    private static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find by id ====");
        int id = input.askInt("Enter id: ");
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
     * @param input input
     * @param tracker tracker
     */
    private static void findItemsByName(Input input, Tracker tracker) {
        System.out.println("=== Find by name ====");
        String name = input.askStr("Enter name: ");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
