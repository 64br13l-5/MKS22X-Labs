ArrayList<Orb>orbList;
Orb center;
String MODE = "ORBIT";
int mode = 1;
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
    case 0: 
      MODE = "ORBIT";  
      mode++;
      break;
    case 1: 
      MODE = "GRAVITY"; 
      mode--;
      break;
    }
  }
}
void draw() {
  background(255);
  center.display();
  for (Orb o : orbList) {
    if (mode == 1)
      center.attract(o);
    else
      o.move();

    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
  text(MODE, 20, 60);
}
public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;
  float G;
  public void attract(Orb other) {
    float d = dist(x, y, other.x, other.y);
    other.xSpeed += G*(x-other.x)/pow(d,2);
    other.ySpeed += G*(y-other.y)/pow(d,2);
    other.x += other.xSpeed;
    other.y += other.ySpeed;
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
    line(x,y,x+(xSpeed*5),y+(ySpeed*5));
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
    if (mode != 1) { 
      if (this.x+radius >= width || this.x-radius < 0)
        xSpeed *= -1;
         if(int(this.x+radius) > width )
          this.x = width-radius;
        else if( this.x-radius < 0)
          this.x = 0+radius;
      if (int(this.y+radius) > height || this.y-radius < 0) {
        //  this.y = height-radius;          
        ySpeed *= -1;
        if(int(this.y+radius) > height )
          this.y = height-radius;
        else if( this.y-radius < 0)
          this.y = 0+radius;
      }
      ySpeed += 0.15;
    }
    //if(int(this.y) < height)
    //       ySpeed += 2;

    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant (find the value that looks nice experimentally, 9.8 will not work well).
  }
}
