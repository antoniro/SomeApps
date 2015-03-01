import junit.framework.TestCase;
import junit.framework.Assert;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class MineSweeperLibTest extends TestCase {
  
  /*********************************/
  /*  Tests for generateMineField  */
  /*********************************/
  
  /**
   * Goal: test the generation of a field 1x1
   */
  public void testField1by1() 
  { 
    boolean[][] expected = { { true } }; // Result expected
    boolean[][] res = MineSweeperLib.generateMineField (1, 1, 1);
    
    // Verification
    boolean verdict = MatrixLib.compareBool(res, expected);
    Assert.assertTrue(verdict);
  }
  
  
  /**
   * Goal: test the generation of a 2x3 field of 6 mines
   */
  public void testField2by3() 
  { 
    boolean[][] expected = { { true, true, true },
      { true, true, true } }; // Result expected
    boolean[][] res = MineSweeperLib.generateMineField (2, 3, 6);
    
    // Verification
    boolean verdict = MatrixLib.compareBool(res, expected);
    Assert.assertTrue(verdict);
  }
  
  /**
   * But: test the generation of a 5x5 field of 10 mines
   */
  public void testField5by5() 
  { 
    int expected = 10; // Result expected
    boolean[][] res = MineSweeperLib.generateMineField (5, 5, expected);
    
    // Verification
    int numberMines = MatrixLib.countTrue(res);
    boolean verdict = (numberMines == expected);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: test the generation of a 20x20 field of 100 mines
   */
  public void testField20by20() 
  { 
    int expected = 100; // Result expected
    boolean[][] res = MineSweeperLib.generateMineField (20, 20, expected);
    
    // Verification
    int numberMines = MatrixLib.countTrue(res);
    boolean verdict = (numberMines == expected);
    
    Assert.assertTrue(verdict);
  }

  
  /*******************************/
  /* Tests pour calculateProximity */
  /*******************************/

  /**
   * But: test the calculation of the proximity in a 2x2 field
   */
  public void testProximity2x2() 
  { 
    boolean[][] champ = { {true, false}, 
                          {false, false} }; // given
    int[][] expected = { {0, 1 },
                        {1, 1 } } ; // Result expected
    int[][] res = MineSweeperLib.calculateProximity(champ);
    
    // Verification
    boolean verdict = MatrixLib.compareInt(res, expected);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: test the calculation of the proximity in a 4x4 field, v1
   */
  public void testProximity4x4v1() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // given
    int[][] expected = { {1, 2, 2, 1 },
                        {1, 0, 0, 1 },
                        {1, 3, 3, 2 },
                        {0, 1, 0, 1 } } ; // Result expected
    int[][] res = MineSweeperLib.calculateProximity(champ);
    
    // Verification
    boolean verdict = MatrixLib.compareInt(res, expected);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: test the calculation of the proximity in a 4x4 field, v2
   */
  public void testProximity4x4v2() 
  { 
    boolean[][] champ = { {true, true, true, false}, 
                          {true, false, true, false},
                          {true, true, true, false},
                          {false, false, false, false} }; // given
    int[][] expected = { {0, 0, 0, 2 },
                        {0, 8, 0, 3 },
                        {0, 0, 0, 2 },
                        {2, 3, 2, 1 } } ; // Result expected
    int[][] res = MineSweeperLib.calculateProximity(champ);
    
    // Verification
    boolean verdict = MatrixLib.compareInt(res, expected);
    
    Assert.assertTrue(verdict);
  }
  
  /*****************************/
  /* Tests pour allFound */
  /*****************************/
  
  /**
   * But: test the verification in a 2x3 field of 2 mines, incomplete
   */
  public void testFoundField2by3() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Given
    boolean[][] tentatives = { { true, false, false}, 
                               { false, false, false } }; // Given 
    boolean expected = false;// Result expected
    boolean res = MineSweeperLib.allFound (champ, tentatives);
    
    // Verification
    boolean verdict = (res == expected);
    Assert.assertTrue(verdict);
  }

  /**
   * But: test the verification in a 2x3 field of 2 mines, complete
   */
  public void testFoundField2by3OK() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Given
    boolean[][] tentatives = { { true, false, false}, 
                               { false, true, false } }; // Given 
    boolean expected = false;// Result expected
    boolean res = MineSweeperLib.allFound (champ, tentatives);
    
    // Verification
    boolean verdict = (res == expected);
    Assert.assertTrue(verdict);
  }

  /**
   * But: test the verification in a 4x4 field of 3 mines, incorrect
   */
  public void testFoundField4x4() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Given
    boolean[][] tentatives = { {true, false, false, false}, 
                               {false, false, true, false},
                               {false, false, false, false},
                               {false, false, true, false} }; // Given
    boolean expected = false;// Result expected
    boolean res = MineSweeperLib.allFound (champ, tentatives);
    
    // Verification
    boolean verdict = (res == expected);
    Assert.assertTrue(verdict);
  }

  /**
   * But: test the verification in a 4x4 field of 3 mines, complete
   */
  public void testFoundField4x4OK() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Given
    boolean[][] tentatives = { {false, false, false, false}, 
                               {false, true, true, false},
                               {false, false, false, false},
                               {false, false, true, false} }; // Given
    boolean expected = false;// Result expected
    boolean res = MineSweeperLib.allFound (champ, tentatives);
    
    // Verification
    boolean verdict = (res == expected);
    Assert.assertTrue(verdict);
  }  
}
