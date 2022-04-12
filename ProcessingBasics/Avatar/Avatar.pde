
  int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 1;
           x = width/2;
           y = height/2;
  }
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
  }
  void avatar(int x, int y){
  //your code here
  rect(x,y,50,100,15);
  beginShape();
  vertex(x+5,y+2);
  bezierVertex(x-7,y+5, x-10,y+15, x-11,y+20);
  vertex(x-15,y+80);
   vertex(x-10,y+125);
   vertex(x-1,y+125);
   vertex(x-4,y+80);
   vertex(x,y+30);
  endShape();
  x += 50;
  beginShape();
  vertex(x-5,y+2);
  bezierVertex(x+7,y+5, x+10,y+15, x+11,y+20);
  vertex(x+15,y+80);
   vertex(x+10,y+125);
   vertex(x+1,y+125);
   vertex(x+4,y+80);
   vertex(x,y+30);
  endShape();
  x -= 50;
  ellipse(x+25,y-28,40,50);
  beginShape();
  vertex(x+14,y-7);
  quadraticVertex(x+14, y-4, x+15, y);
  endShape();
  beginShape();
  vertex(x+36,y-7);
  quadraticVertex(x+36, y-4, x+35, y);
  endShape();
  beginShape();
  vertex(x+2,y+92);
  vertex(x,y+160);
   vertex(x+3,y+250);
   vertex(x+22,y+250);
   vertex(x+15,y+160);
   vertex(x+22,y+99);
  endShape();
  x+= 50;
    beginShape();
  vertex(x-2,y+92);
  vertex(x,y+160);
   vertex(x-3,y+250);
   vertex(x-22,y+250);
   vertex(x-15,y+160);
   vertex(x-22,y+99);
  endShape();
//replace the rectangle with something better


}
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */

    switch(MODE){
     case 1:
       return int(random(801));
     case 2:
       return value + int(random(-1,2));
     case 3:
        if (value > width) {
          return 0;
        }
        return value+1;
     default:
       return width/2;
    }
  }
  void mouseClicked(){
    if(MODE < 3)
      MODE++;
    else MODE = 0;
    
    
  }
