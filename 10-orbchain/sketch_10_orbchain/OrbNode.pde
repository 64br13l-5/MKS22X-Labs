
      public class OrbNode {
        float x, y;
        float dx, dy;
        float radius;
        color c;
        OrbNode next, prev;
        public OrbNode() {  }
        public OrbNode(float x_, float y_) {
          this(x_, y_, 0.0, 0.0, 50.0);
        }
        public OrbNode(float x_, float y_, float dx_, float dy_, float radius_ ) {
          x = x_;
          y = y_;
          dx = dx_;
          dy = dy_;
          radius = radius_;
          c = color(random(255), random(255), random(255), 200);
        }
        /**
        *complete this method
        */
        void display() {
          fill(c);
          ellipse(x, y, radius*2, radius*2);
         if(prev != null)
            line(prev.x,prev.y,x,y);
            
          
          if(next != null)
            line(x,y,next.x,next.y);
          


        }

        void springAttract(OrbNode other) {
          float dist = dist(x, y, other.x, other.y) ;
          float force = (dist - SPRING_LENGTH) * SPRING_CONSTANT;
          float displacex = (x - other.x) ;
          float displacey = (y - other.y) ;
          other.dx += displacex * force / dist;
          other.dy += displacey * force / dist;
          other.dx*= SPRING_DAMPEN;
          other.dy*= SPRING_DAMPEN;
        }

        /**
        *complete this method
        */
        public void attractSpring(OrbNode other) {
    float d = dist(x, y, other.x, other.y);
    float force = (d-SPRING_LENGTH)*SPRING_CONSTANT;
    other.dx += force * ((x-other.x)/d);   
    other.dy += force * ((y-other.y)/d);
    other.dx *= SPRING_DAMPEN;
    other.dy *= SPRING_DAMPEN;
    stroke(30);
    strokeWeight(2);
    line(x, y, other.x, other.y);
  }
        void move() {
          //have prev and next apply spring force to this node;
          /*you write this part*/
          if (prev != null)
          prev.attractSpring(this);
         if (next != null) this.attractSpring(next);
          //apply velocity to position
          x+=dx;
          y+=dy;
          //apply gravity
          dy+=0.35;
        }
      }

      public class FixedOrbNode extends OrbNode{
        void move() {
        }
        FixedOrbNode(float x_, float y_) {
          x = x_;
          y = y_;
          radius = 30;
          c = color(0);
        }
      }
