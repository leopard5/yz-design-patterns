package com.yz.interpreter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Date: 12/14/15 - 12:08 PM
 *
 * @author Jeroen Meulemeester
 */
@RunWith(Parameterized.class)
public class NumberExpressionTest extends ExpressionTest<NumberExpression> {

  /**
   * Create a new set of test entries with the expected result
   *
   * @return The list of parameters used during this test
   */
  @Parameters
  public static List<Object[]> data() {
    return prepareParameters((f, s) -> f);
  }

  /**
   * Create a new test instance using the given test parameters and expected result
   *
   * @param first  The first expression parameter
   * @param second The second expression parameter
   * @param result The expected result
   */
  public NumberExpressionTest(final NumberExpression first, final NumberExpression second, final int result) {
    super(first, second, result, "number", (f, s) -> f);
  }

  /**
   * Verify if the {@link NumberExpression#NumberExpression(String)} constructor works as expected
   */
  @Test
  public void testFromString() throws Exception {
    final int expectedValue = getFirst().interpret();
    final String testStingValue = String.valueOf(expectedValue);
    final NumberExpression numberExpression = new NumberExpression(testStingValue);
    assertEquals(expectedValue, numberExpression.interpret());
  }

}