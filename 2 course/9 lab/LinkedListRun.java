/*
LinkedList. Создать собственную реализацию generic-класса LinkedList,
представляющую собой хранилище, основанное на двусвязном динамическом списке.
Необходимые операции создание списка: доступ к элементу по индексу с возможностью его
изменения; размер списка; проверка на пустоту; push_back(); pop_back(); insert().
Использовать стандартные коллекции нельзя, нужно использовать двусвязный список.
*/
public class LinkedListRun {
    public static void main(String[] args) {
        // Создаем списки с различными типами данных
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        LinkedList<String> stringLinkedList = new LinkedList<>();
        LinkedList<Double> doubleLinkedList = new LinkedList<>();

        // Добавление элементов в списки
        integerLinkedList.push_back(1);
        integerLinkedList.push_back(2);
        integerLinkedList.push_back(3);

        stringLinkedList.push_back("first");
        stringLinkedList.push_back("second");
        stringLinkedList.push_back("third");

        doubleLinkedList.push_back(1.23);
        doubleLinkedList.push_back(7.88);
        doubleLinkedList.push_back(5.45);

        // Вывод исходных списков на экран
        System.out.println("integerLinkedList: " + integerLinkedList);
        System.out.println("stringLinkedList: " + stringLinkedList);
        System.out.println("doubleLinkedList: " + doubleLinkedList);

        // Вывод информации о размерах списков
        System.out.println("Размеры списков: ");
        System.out.println("integerLinkedList: " + integerLinkedList.getSize());
        System.out.println("stringLinkedList: " + stringLinkedList.getSize());
        System.out.println("doubleLinkedList: " + doubleLinkedList.getSize());

        // Проверка списков на пустоту
        System.out.println("Проверка списков на пустоту: ");
        System.out.println("integerLinkedList: " + integerLinkedList.isEmpty());
        System.out.println("stringLinkedList: " + stringLinkedList.isEmpty());
        System.out.println("doubleLinkedList: " + doubleLinkedList.isEmpty());

        // Изменение элемента по его индексу
        integerLinkedList.setData(1, 10);
        stringLinkedList.setData(1, "второй");
        doubleLinkedList.setData(1, 9.99);

        System.out.println("Измененные списки: ");
        System.out.println("integerLinkedList: " + integerLinkedList);
        System.out.println("stringLinkedList: " + stringLinkedList);
        System.out.println("doubleLinkedList: " + doubleLinkedList);

        // Добавление элемента по индексу
        integerLinkedList.insert(0, 20);
        stringLinkedList.insert(1, "!");
        doubleLinkedList.insert(1, 10.55);

        System.out.println("Списки с добавленными элементами: ");
        System.out.println("integerLinkedList: " + integerLinkedList);
        System.out.println("stringLinkedList: " + stringLinkedList);
        System.out.println("doubleLinkedList: " + doubleLinkedList);

        // Удаление последнего элемента в списке
        integerLinkedList.pop_back();
        stringLinkedList.pop_back();
        doubleLinkedList.pop_back();

        System.out.println("Списки с удаленными последними элементами: ");
        System.out.println("integerLinkedList: " + integerLinkedList);
        System.out.println("stringLinkedList: " + stringLinkedList);
        System.out.println("doubleLinkedList: " + doubleLinkedList);


    }
}
