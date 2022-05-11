final static int SPRING = 2;
 static float SPRING_LENGTH = 50;
 static float SPRING_DAMPEN = 0.990;
 static float SPRING_CONSTANT = 0.015;
final static int MODE = SPRING;
static float GRAVITY = 0.35; 
static int clickMode = 0;
static String ClickMode = "Add(ToEnd)";
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if(clickMode == 0)
  orbs.add(new OrbNode(mouseX, mouseY, 0, 0, 30));
  if(clickMode == 1)
    orbs.add(new OrbNode(mouseX,mouseY,0,0,30),mouseX);
 if (clickMode == 2)
     orbs.delete(orbs.getNodeAt(mouseX,mouseY));
}
void keyPressed() {
  if (key == '1') SPRING_CONSTANT *= 1.01; 
  if (key == '2') SPRING_CONSTANT *= 0.99; 
  if (key == '3'){ if(SPRING_DAMPEN < 1) SPRING_DAMPEN *= 1.01;}
  if (key == '4') SPRING_DAMPEN *= 0.99; 
  if (key == '5') SPRING_LENGTH *= 1.01;
  if (key == '6') SPRING_LENGTH *= 0.99; 
  if (key == '7') GRAVITY *= 1.01;
  if (key == '8') GRAVITY *= 0.99; 
  if (key == ' '){switch(clickMode) {
    case 2:
      ClickMode = "Add(ToEnd)";
      clickMode = 0;
      break;
    case 0: 
      ClickMode = "Insert(atMouse)";  
      clickMode++;
      break;
    case 1: 
      ClickMode = "Delete(Closest)"; 
      clickMode++;
      break;
    }
  }
  


}

void draw() {
  background(255);
  text("Spring Constant is: " + nf(SPRING_CONSTANT,0,4), 0, 10);
  text("Spring Dampen is: " + nf(SPRING_DAMPEN,0,2), 0, 25);
  text("Spring Length is: " +nf(SPRING_LENGTH,0,1), 0, 40);
  text("Gravity is: " +nf(GRAVITY,0,3), 0, 55);
  text("Click Mode is: " + ClickMode,0,70);

  orbs.processAll();

  orbs.display();
}
