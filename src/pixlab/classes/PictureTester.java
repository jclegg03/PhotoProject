package pixlab.classes;
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
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontal();
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
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
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
//    testMirrorTemple();
//    testMirrorArms();
//    testMirrorGull();
//    testMirrorDiagonal();
//    testCollage();
//    testCopy();
//    testEdgeDetection();
//    testEdgeDetection2();
//    testChromakey();
//    testEncodeAndDecode();
//    testGetCountRedOverValue(250);
//    testSetRedToHalfValueInTopHalf();
//    testClearBlueOverValue(200);
//    testGetAverageForColumn(0);
  }
}