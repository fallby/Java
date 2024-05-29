import java.util.List; 
 
/* 
Система дорог. Задана система дорог, состоящая из N населенных пунктов и списка 
соединяющих населенные пункты попарно дорог. Представить систему дорог в виде 
подходящей коллекции. Реализовать на системе дорог рекурсивный алгоритм поиска 
пути из пункта с номером A в пункт с номером B. 
*/ 
public class RoadSystemRun { 
    public static void main(String[] args) { 
        // Создаем систему дорог 
        RoadSystem roadSystem = new RoadSystem(); 
 
        // Добавляем дороги  
        roadSystem.addRoad(new Road("A", "B")); 
        roadSystem.addRoad(new Road("B", "E")); 
        roadSystem.addRoad(new Road("D", "E")); 
        roadSystem.addRoad(new Road("A", "D")); 
        roadSystem.addRoad(new Road("E", "C")); 
        roadSystem.addRoad(new Road("A", "W")); 
         
        roadSystem.addRoad(new Road("F", "T")); 
 
        // Поиск дороги между двумя пунктами 
        List<String> roadBetween = roadSystem.findRoadBetween("C", "W"); 
        List<String> roadBetween1 = roadSystem.findRoadBetween("A", "F"); 
 
        System.out.println(roadSystem); 
        System.out.println(roadBetween); 
        System.out.println(roadBetween1); 
    } 
}
