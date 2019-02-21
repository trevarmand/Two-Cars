package Model;


import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Due to the small size and relative simplicity of individual methods, this project has a limited
 * number of tests. They were added during development on a when-needed basis.
 */
public class ModelTest {

  TwoCarsModelImpl model;

  public void initData() {
    model = new TwoCarsModelImpl();
  }

  @Test
  public void testFindHighest() {
    this.initData();
    //Param 0 should find the highest (lowest Y) object in the left two lanes.
    assertEquals(-300, model.findHighestMover(0).getYPosn());
    assertEquals(-300, model.findHighestMover(1).getYPosn());

    assertEquals(-430, model.findHighestMover(2).getYPosn());
    assertEquals(-430, model.findHighestMover(3).getYPosn());
  }
}
