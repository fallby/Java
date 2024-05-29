/* 
Класс LinkedList представляет собой двусвязный список, 
имеет такие поля как начало списка head, конец списка tail и размер списка 
*/ 
public class LinkedList<T> { 
    private Node<T> head; 
    private Node<T> tail; 
    private int size; 
 
    // Функция возвращает размер списка 
    public int getSize() { 
        return size; 
    } 
 
    // Функция проверяет список на пустоту 
    public boolean isEmpty() { 
        if (size == 0) { 
           // System.out.println("Список пуст"); 
            return true; 
        } 
       // System.out.println("Список не пуст"); 
        return false; 
    } 
 
    // Функция обращается к элементу по индексу и изменяет данные в нём 
    public void setData(int index, T data) { 
     if (index < 0 || index >= size) { 
      //throw new IndexOutOfBoundsException(); 
      System.out.println("Индекс выходит за границы списка"); 
      return; 
     } 
        Node<T> current = head; 
        for (int i = 0; i < index; i++) { 
            current = current.next; 
        } 
        current.data = data; 
    } 
 
    // Функция вставляет элемент в конец списка 
    public void push_back(T data) { 
        Node node = new Node(data); 
 
        if (size == 0) { 
            head = node; 
        } else { 
            tail.next = node; 
            node.pred = tail; 
        } 
 
        tail = node; 
        size++; 
    } 
 
    // Функция удаляет элемент из конца списка 
    public void pop_back() { 
        if (size != 0) { 
            if (size == 1) { 
                head = null; 
                tail = null; 
            } else { 
                tail.pred.next = null; 
                tail = tail.pred; 
            } 
 
            size--; 
        } 
    } 
 
    // Функция вставляет элемент в указанное место 
    public void insert(int index, T data) { 
     if (index < 0 || index > size) { 
      //throw new IndexOutOfBoundsException(); 
      System.out.println("Индекс выходит за границы списка"); 
      return; 
     } 
        Node<T> newNode = new Node<>(data); 
        if (index == 0) { 
            newNode.next = head; 
            head.pred = newNode; 
            head = newNode; 
        } else if (index == size) { 
            tail.next = newNode; 
            newNode.pred = tail; 
            tail = newNode; 
        } else { 
            Node<T> current = head; 
            for (int i = 0; i < index; i++) { 
                current = current.next; 
            } 
            newNode.next = current.next; 
            current.next.pred = newNode; 
            current.next = newNode; 
            newNode.pred = current; 
        } 
        size++; 
    } 
 
    public String toString() { 
        String result = "["; 
        Node<T> current = head; 
        while (current != null) { 
            result += current.data + ", "; 
            current = current.next; 
        } 
        if (result.length() > 1) { 
            result = result.substring(0, result.length() - 2); 
        } 
        result += "]"; 
        return result; 
    } 
}
