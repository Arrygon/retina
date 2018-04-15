// code by jph
package ch.ethz.idsc.retina.util.math;

import ch.ethz.idsc.tensor.RealScalar;
import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;
import junit.framework.TestCase;

public class PRBS7SignalTest extends TestCase {
  public void testSimple() {
    Tensor vector = PRBS7.sequence();
    PRBS7Signal prbs7Signal = new PRBS7Signal(RealScalar.of(1));
    for (int index = 0; index < 256; ++index) {
      Scalar value = prbs7Signal.apply(RealScalar.of(index));
      assertEquals(value, vector.Get(index % 127));
    }
  }

  public void testScaled() {
    Tensor vector = PRBS7.sequence();
    PRBS7Signal prbs7Signal = new PRBS7Signal(RealScalar.of(.25));
    for (int index = 0; index < 256; ++index) {
      Scalar value = prbs7Signal.apply(RealScalar.of(index * 0.25));
      assertEquals(value, vector.Get(index % 127));
    }
  }
}
