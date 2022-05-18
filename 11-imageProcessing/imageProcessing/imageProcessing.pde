
String[] names = new String[]{
    "Identity", "Blur", "Sharpen",
    "Outline", "Left Sobel", "Right Sobel",
    "Top Sobel", "Emboss"
  };
  int i = 0;

   Kernel[] kernels = new Kernel[] {
    new Kernel( new float[][] {
    {0, 0, 0},
    {0, 1, 0},
    {0, 0, 0}    }) ,
    new Kernel( new float[][] {
    {.111, .111, .111},
    {.111, .111, .111},
    {.111, .111, .111}    }) ,
    new Kernel( new float[][] {
    {0, -1, 0},
    {-1, 5, -1},
    {0, -1, 0}    }) ,
    new Kernel( new float[][] {
    {-1, -1, -1},
    {-1, 8, -1},
    {-1, -1, -1}    }) ,
    new Kernel( new float[][] {
    {1, 0, -1},
    {2, 0, -2},
    {1, 0, -1}    }) ,
    new Kernel( new float[][] {
    {-1, 0, 1},
    {-2, 0, 2},
    {-1, 0, 1}    }) ,
    new Kernel( new float[][] {
    {1, 2,  1},
    {0, 0, 0},
    {-1, -2, -1}    }),
        new Kernel( new float[][] {
    {-2, -1,  0},
    {-1, 1, 1},
    {0, 1, 2}    })
  };
void setup(){
      size(1450,500);

    }
void keyPressed(){
      i++;
      if(i> names.length-1)i=0;

}
void draw(){
   PImage car = loadImage("redcar.png");
      PImage output = car.copy();
      kernels[i].apply(car,output);    
      image(car,0,0);
      image(output,car.width,0);     
      text(names[i],width-50,height-20);
}

    
