package pixlab.classes;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  public static final boolean VERTICAL = true;
  public static final boolean HORIZONTAL = false;
  public static final boolean LEFT = true;
  public static final boolean RIGHT = false;
  public static final boolean TOP = true;
  public static final boolean BOTTOM = false;
  
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 
   * @author Jay Clegg*/
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to set the red to 0 
   * @author Jay Clegg*/
  public void zeroRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length; row++)
	  {
		  for(int col = 0; col < pixels[row].length; col++)
		  {
			  pixels[row][col].setRed(0);
		  }
	  }
  }
  
  /** Method to set the green to 0 
   * @author Jay Clegg*/
  public void zeroGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] row : pixels)
	  {
		  for(Pixel pixel : row)
		  {
			  pixel.setGreen(0);
		  }
	  }
  }
  
  /** Method to keep only blue 
   * @author Jay Clegg*/
  public void keepOnlyBlue()
  {
	  zeroRed();
	  zeroGreen();
  }
  
  /** Method to keep only green 
   * @author Jay Clegg*/
  public void keepOnlyGreen()
  {
	  zeroRed();
	  zeroBlue();
  }
  
  /** Method to keep only red 
   * @author Jay Clegg*/
  public void keepOnlyRed()
  {
	  zeroGreen();
	  zeroBlue();
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical(boolean mirrorLeft)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
    	if(mirrorLeft)
    	{
    		leftPixel = pixels[row][col];
            rightPixel = pixels[row][width - 1 - col];
            rightPixel.setColor(leftPixel.getColor());
    	}
    	else
    	{
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width - 1 - col];
	        leftPixel.setColor(rightPixel.getColor());
    	}
      }
    } 
  }
  
  /** Method to mirror the image horizontally 
   * @author Jay Clegg*/
  public void mirrorHorizontal(boolean mirrorTop)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  for(int row = 0; row < pixels.length / 2; row++)
	  {
		  for(int col = 0; col < pixels[row].length; col++)
		  {
			  if(mirrorTop)
			  {
				  pixels[pixels.length - row - 1][col].setColor(pixels[row][col].getColor());
			  }
			  else
			  {
				  pixels[row][col].setColor(pixels[pixels.length - row - 1][col].getColor());
			  }
		  }
	  }
  }
  
  /**
   * Mirrors an image both vertically and horizontally.
   * @param mirrorVertFirst Determines if the picture is mirrored vertically first or second.
   * @param mirrorLeft Determines the direction of the vertical mirror.
   * @param mirrorTop Determines the direction of the horizontal mirror.
   * @author Jay Clegg
   */
  public void mirrorBoth(boolean mirrorVertFirst, boolean mirrorLeft, boolean mirrorTop)
  {
	  if(mirrorVertFirst)
	  {
		  mirrorVertical(mirrorLeft);
		  mirrorHorizontal(mirrorTop);
	  }
	  else
	  {
		  mirrorHorizontal(mirrorTop);
		  mirrorVertical(mirrorLeft);
	  }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical(LEFT);
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  /** Method to negate an image 
   * @author Jay Clegg*/
  public void negate()
  {
	  for(Pixel[] pixels : this.getPixels2D())
	  {
		  for(Pixel pixel : pixels)
		  {
			  pixel.setColor(new Color(255 - pixel.getRed(), 255 - pixel.getGreen(), 255 - pixel.getBlue()));
		  }
	  }
  }
  
  /**
   * Method to negate part of an image
   * @param startRow The first row to negate
   * @param endRow The last row to negate
   * @param startCol The first column to negate
   * @param endCol The last column to negate
   * @author Jay Clegg
   */
  public void negate(int startRow, int endRow, int startCol, int endCol)
  {
	  Pixel[][] image = this.getPixels2D();
	  
	  if(startRow >= 0 && startRow <= endRow && startRow < image.length)
	  {
		  for(int row = startRow; row < endRow; row++)
		  {
			  if(startCol >= 0 && startCol <= endCol && startCol < image[row].length)
			  {
				  for(int col = startCol; col < endCol; col++)
				  {
					  image[row][col].setColor(new Color(255 - image[row][col].getRed(), 255 - image[row][col].getGreen(), 255 - image[row][col].getBlue()));
				  }
			  }
		  }
	  }
  }
  
  /**
   * Method to determine the amount of pixels that are more red than a given value
   * @param value How red the pixels must be to be measured
   * @return The number of pixels above the value.
   * @author Jay Clegg
   */
  public int getCountRedOverValue(int value)
  {
	  int count = 0;
	  
	  for(Pixel[] pixels : this.getPixels2D())
	  {
		  for(Pixel pixel : pixels)
		  {
			  if(pixel.getRed() > value)
			  {
				  count++;
			  }
		  }
	  }
	  
	  return count;
  }
  
  /** Method to set the green value to half its current value in the top half of the picture
   * @author Jay Clegg */
  public void setGreenToHalfValueInTopHalf()
  {
	  Pixel[][] image = this.getPixels2D();
	  
	  int rows = image.length / 2;
	  for(int index = 0; index < rows; index++)
	  {
		  for(Pixel pixel : image[index])
		  {
			  pixel.setGreen(pixel.getGreen() / 2);
		  }
	  }
  }
  
  /**
   * Method to remove all blue from pixels with more blue than a given value
   * @param value The maximum desired blue value. All other blue will be removed.
   * @author Jay Clegg
   */
  public void clearBlueOverValue(int value)
  {
	  for(Pixel[] pixels : this.getPixels2D())
	  {
		  for(Pixel pixel : pixels)
		  {
			  if(pixel.getBlue() > value)
			  {
				  pixel.setBlue(0);
			  }
		  }
	  }
  }
  
  /**
   * Method to get the average color of a given column of pixels.
   * @param column The column to be analyzed.
   * @return The average color of the column.
   * @author Jay Clegg
   */
  public Color getAverageForColumn(int column)
  {
	  Pixel[][] image = this.getPixels2D();
	  int red = 0;
	  int green = 0;
	  int blue = 0;
	  int total = image[column].length;
	  
	  for(Pixel pixel : image[column])
	  {
		  red += Math.pow(pixel.getRed(), 2);
		  green += Math.pow(pixel.getGreen(), 2);
		  blue += Math.pow(pixel.getBlue(), 2);
	  }
	  
	  red /= total;
	  red = (int) Math.sqrt(red);
	  green /= total;
	  green = (int) Math.sqrt(green);
	  blue /= total;
	  blue = (int) Math.sqrt(blue);
	  
	  return new Color(red, green, blue);
  }
  
  /**
   * Method to get the average color of pixels in a given row over a specified amount of columns
   * @param pixels The image's 2D array of pixels.
   * @param row The row which will be analyzed.
   * @param startCol The first column to be analyzed.
   * @param endCol The last column to be analyzed.
   * @return The average color of the pixels
   * @author Jay Clegg
   */
  private Color getAverageColorInRowRange(Pixel[][] pixels, int row, int startCol, int endCol)
  {
	  Color average = null;
	  
	  int red = 0;
	  int green = 0;
	  int blue = 0;
	  int size = endCol - startCol;
	  
	  if(startCol <= endCol && row < pixels.length && pixels[row].length > startCol && startCol >= 0 && endCol < pixels[row].length)
	  {
		  for(int index = startCol; index <= endCol; index++)
		  {
			  red += Math.pow(pixels[row][index].getRed(), 2);
			  green += Math.pow(pixels[row][index].getGreen(), 2);
			  blue += Math.pow(pixels[row][index].getBlue(), 2);
		  }
	  }
	  
	  red /= size;
	  red = (int) Math.sqrt(red);
	  green /= size;
	  green = (int) Math.sqrt(green);
	  blue /= size;
	  blue = (int) Math.sqrt(blue);
	  
	  return average;
  }
  
  /** Removes all pixels that are blue and not much of any other color.
   * @param background The background image to be displayed on the green screen.
   * @author Jay Clegg */
  public void chromakey(Picture background)
  {
	  Pixel[][] image = this.getPixels2D();
	  Pixel[][] bg = background.getPixels2D();
	  int bgRowCenter = bg.length / 2;
	  int bgColCenter = bg[0].length / 2;
	  int averageRow = 0;
	  int averageCol = 0;
	  int loopCount = 0;
	  
	  int bgRow = 0;
	  int bgCol = 0;
	  
	  for(int row = 0; row < image.length; row++)
	  {
		  for(int col = 0; col < image[row].length; col++)
		  {
			  Color pixelColor = image[row][col].getColor();
			  if(pixelColor.getBlue() >= 20)
			  {
				  if(pixelColor.getRed() < 40 && pixelColor.getGreen() < 53)
				  {
					  averageRow += row;
					  averageCol += col;
					  loopCount++;
				  }
			  }
		  }
	  }
	  
	  averageRow /= loopCount;
	  averageCol /= loopCount;
	  
	  bgRow = bgRowCenter;
	  boolean maxSize = false;
	  for(int row = averageRow; row < image.length; row++)
	  {
		  bgCol = bgColCenter;
		  for(int col = averageCol; col < image[row].length; col++)
		  {
			  Color color = image[row][col].getColor();
			  double closeFactor = image[row][col].colorDistance(Color.BLUE);
			  if(color.getBlue() >= 20)
			  {
				  if(color.getRed() < 30 && color.getGreen() < 53 && bgCol < bg[bgRow].length)
				  {
					  if(! maxSize)
					  {
						  image[row][col].setColor(bg[bgRow][bgCol].getColor());
					  }
				  }
			  }
			  bgCol++;
		  }
		  bgCol = 0;
		  for(int col = 0; col < averageCol; col++)
		  {
			  Color color = image[row][col].getColor();
			  if(color.getBlue() >= 1)
			  {
				  if(color.getRed() < 40 && color.getGreen() < 53)
				  {
					  if(! maxSize)
					  {
						  image[row][col].setColor(bg[bgRow][bgCol].getColor());
					  }
				  }
			  }
			  bgCol++;
		  }
		  if(bgRow < bg.length - 1)
		  {
			  bgRow++;
		  }
		  else
		  {
			  maxSize = true;
		  }
	  }
	  
	  bgRow = 0;
	  maxSize = false;
	  for(int row = 0; row < averageRow; row++)
	  {
		  bgCol = bgColCenter;
		  for(int col = averageCol; col < image[row].length; col++)
		  {
			  Color color = image[row][col].getColor();
			  if(color.getBlue() >= 20)
			  {
				  if(color.getRed() < 30 && color.getGreen() < 53 && bgCol < bg[bgRow].length)
				  {
					  if(! maxSize)
					  {
						  image[row][col].setColor(bg[bgRow][bgCol].getColor());
					  }
				  }
			  }
			  bgCol++;
		  }
		  bgCol = 0;
		  for(int col = 0; col < averageCol; col++)
		  {
			  Color color = image[row][col].getColor();
			  if(color.getBlue() >= 1)
			  {
				  if(color.getRed() < 40 && color.getGreen() < 53)
				  {
					  if(! maxSize)
					  {
						  image[row][col].setColor(bg[bgRow][bgCol].getColor());
					  }
				  }
			  }
			  bgCol++;
		  }
		  if(bgRow < bg.length - 1)
		  {
			  bgRow++;
		  }
		  else
		  {
			  maxSize = true;
		  }
	  }
  }
  
  public void betterChromakey(Color replace, Picture background, double distance)
  {
	  Pixel[][] picture = this.getPixels2D();
	  Pixel[][] bg = background.getPixels2D();
	  
	  for(int row = 0; row < picture.length; row++)
	  {
		  for(int col = 0; col < picture[row].length; col++)
		  {
			  Pixel current = picture[row][col];
			  
			  if(current.colorDistance(replace) < distance)
			  {
				  current.setColor(bg[row][col].getColor());
			  }
		  }
	  }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture gengar = new Picture("gengar.png");
    gengar.explore();
    gengar.zeroBlue();
    gengar.explore();

    Picture annie = new Picture("annie.jpg");
    annie.explore();
    annie.zeroBlue();
    annie.explore();
  }
} // this } is the end of class Picture, put all new methods before this
