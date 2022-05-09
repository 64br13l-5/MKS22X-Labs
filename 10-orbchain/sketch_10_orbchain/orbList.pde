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
        void add(OrbNode orb){
          last.prev = orb;
          first.next = first.next.next;
          
        }

        /**
        *complete this method
        *process all nodes by running move.
        */
        void processAll() {
          OrbNode current = first;
          while (current != null){
            current.move();
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
          }
          //advance current to next until it is null, display() each of the nodes
        }
      }
