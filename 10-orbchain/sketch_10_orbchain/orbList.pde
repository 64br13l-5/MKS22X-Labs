public class OrbList {
        OrbNode first, last;

        //create a fixed orb
        OrbList() {
          first = new FixedOrbNode(0, height/5);
          last = new FixedOrbNode(width, height/5);
          //link them to eachother
          first.next = last;
          last.prev = first;
        }

        /**
        *complete this method
        */
        void add(OrbNode orb, int xval){
          OrbNode current = first;
          while (current.x <=xval){
            current = current.next;
          }
          orb.prev = current.prev;
          current.prev.next = orb;
          orb.next = current; 
          current.prev = orb;
        }
        void add(OrbNode orb){
          orb.prev = last.prev;
          last.prev.next = orb;
          orb.next = last; 
          last.prev = orb;
        
        }
        void delete(OrbNode orb){
          if(orb != null){
             orb.next.prev = orb.prev;
             orb.prev.next = orb.next;


          }
        }
        OrbNode getNodeAt(int x, int y){
             OrbNode current = first.next;
          while (current != last){
            if(x < current.x +current.radius && x > current.x - current.radius && y<current.y+current.radius && y > current.y-current.radius)
              return current;            
            current = current.next;
          }
          return null; 
        }
        

        /**
        *complete this method
        *process all nodes by running move.
        */
        void processAll() {
          OrbNode current = first;
          while (current != null){
            current.move();
            current = current.next;
          }
          //advance current to next until it is null, move() each of the nodes
        }
        /**
        *complete this method
        *Display all nodes by running their display().
        */
        void display() {
          OrbNode current = first;
          while (current != null){
            current.display();
             current = current.next;

          }
          //advance current to next until it is null, display() each of the nodes
        }
      }
