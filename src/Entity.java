import java.util.List;

/*
 * Abstract Class Entity
 * 
 */

/**
 *
 * @author Arantza
 */
public abstract class Entity {
 protected char symbol; // symbol that represents the entity
 protected String type; // every entity is of a type
 protected int x; // x coordinate in the room
 protected int y; // y coordinate in the room
 
 
 public Entity () {
     type = "entity";
          
 }

 public char getSymbol() {
     return symbol;
 }
 
 public void setSymbol(char c) {
     symbol = c;
 }

 public int getX() {
     return x;
 }
 
 public int getY() {
     return y;
 }
 public void setPosition (int x, int y) {
    this.x=x;
    this.y=y;
 }

 public String getType() {
     return type;
 }
 
 public void setType(String type) {
     this.type = type;
 }
 
 //objects with special moving options will override this method
 public void move(List<Entity> list){}

 
/**
 * 
 * @return string with information about an abstract entity 
 */
   public String toString() {      
       String st = "Entity Properties \n";
       st = st + "TYPE:  " + getType();
       return st;
   }
   

}
