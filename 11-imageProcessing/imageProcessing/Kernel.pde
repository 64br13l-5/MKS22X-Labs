class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    float r =0, b=0, g =0;
    for (int i = 0; i <3; i++) {
      for (int j  =0; j<3; j++) {
        if (x+i < 0 || x+i > img.width || y+j <0 || y+j>img.height)return color(0);
        r += red(img.get(x+i, y+j)) * kernel[j][i]; 
        b += blue(img.get(x+i, y+j))* kernel[j][i];
        g += green(img.get(x+i, y+j))* kernel[j][i];
      }
    }
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    return color(constrain(r, 0, 255), constrain(g, 0, 255), constrain(b, 0, 255));
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int i =0; i<= source.width; i++) {
      for (int j = 0; j<=source.height; j++) {
        color c = calcNewColor(source, i, j);
        destination.set(i, j, c);
      }
    }
  }
}
