ArrayList<Orb>orbList;
Orb center;
String MODE = "ORBIT";
int mode = 1;
int bg = 1;
int grav = 1;
private static final float SPRING_CONSTANT = 0.005;
private static final int SPRING_LENGTH = 150;
private static final float SPRING_DAMPEN = 0.990;
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  center = new Orb(width/2, height/2, 10);
}
void mouseClicked() {

  orbList.add(new Orb(float(mouseX), float(mouseY), 5, 0, 20));
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
}
void keyPressed() {
  if (key == BACKSPACE) {
    orbList.clear();
  }
  if (key == 32) {
    switch(mode) {
    case 2: 
      MODE = "SPRING"; 
      mode = 0;
      break;
    case 0: 
      MODE = "ORBIT";  
      mode++;
      break;
    case 1: 
      MODE = "GRAVITY"; 
      mode++;
      break;
    }
  }
  if (key == 'G' || key == 'g') {
    switch(grav) {
    case 0: 
      grav++;
      break;
    case 1: 
      grav--;
      break;
    }
  }
  if (key == 'B' || key == 'b') {
    switch(bg) {
    case 0: 
      bg++;
      break;
    case 1: 
      bg--;
      break;
    }
  }
}
void draw() {
  if (bg == 1)
    background(255);
  center.display();
  for (Orb o : orbList) {
    if (mode == 1)
      center.attract(o);
    else if (mode == 0)
      center.attractSpring(o);
    o.move();

    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  text(MODE, 20, 60);
  text(mode, 20, 80);
  if (grav == 1) text("grav", 20, 100);
}
public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;
  float G;
  public void attract(Orb other) {
    float d = dist(x, y, other.x, other.y);
    other.xSpeed += G*(x-other.x)/pow(d, 2);
    other.ySpeed += G*(y-other.y)/pow(d, 2);
  }
  public void attractSpring(Orb other) {
    float d = dist(x, y, other.x, other.y);
    float force = (d-SPRING_LENGTH)*SPRING_CONSTANT;
    other.xSpeed += force * ((x-other.x)/d);   
    other.ySpeed += force * ((y-other.y)/d);
    other.xSpeed *= SPRING_DAMPEN;
    other.ySpeed *= SPRING_DAMPEN;
    stroke(30);
    strokeWeight(2);
    line(x, y, other.x, other.y);
  }
  public Orb(float x_, float y_, float radius_ ) {
    x = x_;
    y = y_;
    radius = radius_;
    G = 20; 
    //random color... why not.
    c = color(random(255), random(255), random(255));
  }
  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255), random(255), random(255));
  }




  void display() {

    fill(c);
    noStroke();
    ellipse(x, y, radius*2, radius*2);
    stroke(0);
    strokeWeight(5);
    line(x, y, x+(xSpeed*5), y+(ySpeed*5));
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
  }

  void move() {
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
    this.x += xSpeed;
    this.y += ySpeed;
    //PART 3
    //Change the speed when you collide with the end of the screen (all 4 sides)
    if (mode == 2) { 
      if (this.x+radius >= width || this.x-radius < 0)
        xSpeed *= -1;
      if (int(this.x+radius) > width )
        this.x = width-radius;
      else if ( this.x-radius < 0)
        this.x = 0+radius;
      if (int(this.y+radius) > height || this.y-radius < 0) {
        //  this.y = height-radius;          
        ySpeed *= -1;
        if (int(this.y+radius) > height )
          this.y = height-radius;
        else if ( this.y-radius < 0)
          this.y = 0+radius;
      }
    }
    if (grav ==  1) ySpeed += 0.15;  
    //if(int(this.y) < height)
    //       ySpeed += 2;

    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
  }
}
