final static int SPRING = 2;
 static float SPRING_LENGTH = 50;
 static float SPRING_DAMPEN = 0.990;
 static float SPRING_CONSTANT = 0.015;
final static int MODE = SPRING;
static float GRAVITY = 0.35; 
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
}
void keyPressed() {
  if (key == '1') SPRING_CONSTANT += 0.005; 
  if (key == '2') SPRING_CONSTANT -= 0.005; 
  if (key == '3') SPRING_DAMPEN += 0.01; 
  if (key == '4') SPRING_DAMPEN -= 0.01; 
  if (key == '5') SPRING_LENGTH += 5; 
  if (key == '6') SPRING_LENGTH -= 5; 
  if (key == '7') GRAVITY += 0.02; 
  if (key == '8') GRAVITY -= 0.02; 


}

void draw() {
  background(255);
  text("Spring Constant is: " + SPRING_CONSTANT, 0, 10);
  text("Spring Dampen is: " +SPRING_DAMPEN, 0, 25);
  text("Spring Length is: " +SPRING_LENGTH, 0, 40);
  text("Gravity is: " +GRAVITY, 0, 55);


  orbs.processAll();

  orbs.display();
}
