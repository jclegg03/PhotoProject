package pixlab.classes;

import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test zeroRed */
  public static void testZeroRed()
  {
	  Picture gengar = new Picture("gengar.png");
	  gengar.explore();
	  gengar.zeroRed();
	  gengar.explore();
  }
  
  /** Method to test zeroGreen */
  public static void testZeroGreen()
  {
	  Picture temple = new Picture("temple.jpg");
	  temple.explore();
	  temple.zeroGreen();
	  temple.explore();
  }
  
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
	  Picture gorge = new Picture("gorge.jpg");
	  gorge.explore();
	  gorge.keepOnlyBlue();
	  gorge.explore();
  }
  
  /** Method to test keepOnlyGreen */
  public static void testKeepOnlyGreen()
  {
	  Picture flower = new Picture("flower1.jpg");
	  flower.explore();
	  flower.keepOnlyGreen();
	  flower.explore();
  }
  
  /** Method to test keepOnlyRed */
  public static void testKeepOnlyRed()
  {
	  Picture flower = new Picture("flower2.jpg");
	  flower.explore();
	  flower.keepOnlyRed();
	  flower.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical(Picture.LEFT);
    caterpillar.explore();
  }
  
  /** Method to test mirrorHorizontal 
   * @author Jay Clegg*/
  public static void testMirrorHorizontal()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontal(Picture.TOP);
	  caterpillar.explore();
  }
  
  /** Method to test the mirrorBoth 
   * @author Jay Clegg*/
  public static void testMirrorBoth()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorBoth(Picture.VERTICAL, Picture.LEFT, Picture.TOP);
	  caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection 
   * @author Jay Clegg*/
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  /** Method to test negate 
   * @author Jay Clegg*/
  public static void testNegate()
  {
	  Picture arch = new Picture("arch.jpg");
	  arch.explore();
	  arch.negate();
	  arch.explore();
	  
	  arch.negate(25, 50, 50, 100);
	  arch.explore();
  }
  
  /** Method to test getCountRedOverValue 
   * @author Jay Clegg*/
  public static void testGetCountRedOverValue()
  {
	  Picture lion = new Picture("femaleLionAndHall.jpg");
	  
	  System.out.println(lion.getCountRedOverValue(24));
  }
  
  /** Method to test setGreenToHalfValueInTopHalf 
   * @author Jay Clegg*/
  public static void testSetGreenToHalfValueInTopHalf()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.setGreenToHalfValueInTopHalf();
	  beach.explore();
  }
  
  /**
   *  Method to test clearBlueOverValue
   *  @param value The maximum desired blue value. All other blue will be set to 0.
   *  @author Jay Clegg
   */
  public static void testClearBlueOverValue(int value)
  {
	  Picture door = new Picture("thruDoor.jpg");
	  door.explore();
	  door.clearBlueOverValue(value);
	  door.explore();
  }
  
  /**
   * Method to test getAverageForColumn
   * @param column The column which will be averaged.
   * @author Jay Clegg
   */
  public static void testGetAverageForColumn(int column)
  {
	  Picture annie = new Picture("annie.jpg");
	  Color average = annie.getAverageForColumn(column);
	  System.out.println("The average color is: Red: " + average.getRed() + " Green: " + average.getGreen() + " Blue: " + average.getBlue() + ".");
  }
  
  /** Method to test chromakey
   * @author Jay Clegg*/
  public static void testChromakey()
  {
	  Picture old = new Picture("beach.jpg");
	  Picture bg = new Picture("moon-surface.jpg");	 
	  
	  old.explore();
	  bg.explore();
	  old.betterChromakey(new Color(164, 204, 229), bg, 35.0);
	  old.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
//     uncomment a call here to run a test
//     and comment out the ones you don't want
//     to run
//    testZeroBlue();
//    testZeroRed();
//	  testZeroGreen();
//    testKeepOnlyBlue();
//    testKeepOnlyRed();
//    testKeepOnlyGreen();
//    testNegate();
//    testGrayscale();
//    testFixUnderwater();
//    testMirrorVertical();
//	  testMirrorHorizontal();
//	  testMirrorBoth();
//    testMirrorTemple();
//    testMirrorArms();
//    testMirrorGull();
//    testMirrorDiagonal();
//    testCollage();
//    testCopy();
//    testEdgeDetection();
//    testEdgeDetection2();
    testChromakey();
//    testEncodeAndDecode();
//    testGetCountRedOverValue(250);
//    testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
//    testGetAverageForColumn(0);
//	  testGetCountRedOverValue();
//	  testSetGreenToHalfValueInTopHalf();
  }
}