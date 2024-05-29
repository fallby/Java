/*
Класс Node представляет собой узел двусвязного списка,
который содержит данные и ссылки на следующий и предыдущий элементы
*/
public class Node<T> {
    T data;
    Node<T> next;
    Node<T> pred;

    public Node(T data) {
        this.data = data;
    }
}
