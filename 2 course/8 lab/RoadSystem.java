import java.util.*; 
/* 
 Класс RoadSystem представляет собой систему дорогу 
 */ 
public class RoadSystem { 
    private Map<String, List<String>> roadSystem; 
     
    public RoadSystem() { 
        roadSystem = new HashMap<>(); 
    } 
     
    // Функция добавляет город 
    public void addTown(String town) { 
        if (!roadSystem.containsKey(town)) { 
            roadSystem.put(town, new ArrayList<>()); 
        } 
    } 
     
    // Функция добавляет дорогу 
    public void addRoad(Road road) { 
        String from = road.getFrom(); 
        String to = road.getTo(); 
        addTown(from); 
        addTown(to); 
        roadSystem.get(from).add(to); 
        roadSystem.get(to).add(from); 
    } 
 
 
    // Функция ищет дорогу между двумя пунктами 
    public List<String> findRoadBetween(String from, String to) { 
        List<String> way = new ArrayList<>(); 
        way.add(from); 
        List<String> result = findRoadBetweenHelper(way, to); 
        if (result == null) { 
            System.out.println("Дороги между пунктами " + from + " и " + to + " нет "); 
        } 
        return result; 
    } 
 
    public List<String> findRoadBetweenHelper(List<String> way, String to) { 
        String current = way.get(way.size() - 1); 
        for (String neighbor : roadSystem.get(current)) { 
            if (!way.contains(neighbor)) { 
                way.add(neighbor); 
                if (neighbor.equals(to)) { 
                    return way; 
                } 
                List<String> result = findRoadBetweenHelper(way, to); 
                if (result != null) { 
                    return result; 
                } 
                way.remove(way.size() - 1); 
            } 
        } 
        return null; 
    } 
     
    public String toString() { 
        StringBuilder sb = new StringBuilder(); 
        for (String town : roadSystem.keySet()) { 
            sb.append(town).append(": "); 
            for (String neighbor : roadSystem.get(town)) { 
                sb.append(neighbor).append(", "); 
            } 
            sb.append("\n"); 
        } 
        return sb.toString(); 
    } 
 
}
