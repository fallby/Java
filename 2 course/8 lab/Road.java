/*
Класс Road представляет собой дорогу между пунктами from и to
 */
public class Road {
     private String from;    
     private String to;
     public Road(String from, String to) {
        this.from = from;        
        this.to = to;
    }    
    public String getFrom() {
        return from;    
    }
    public String getTo() {        
      return to;
    }
}
