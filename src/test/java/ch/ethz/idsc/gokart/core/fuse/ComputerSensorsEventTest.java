// code by jph
package ch.ethz.idsc.gokart.core.fuse;

import java.nio.ByteBuffer;

import ch.ethz.idsc.retina.util.math.SI;
import ch.ethz.idsc.tensor.qty.Quantity;
import junit.framework.TestCase;

public class ComputerSensorsEventTest extends TestCase {
  public void testSimple() {
    byte[] array = new byte[] { 0, 1, 0, 3, 60, 67, 64 };
    ComputerSensorsEvent cse = new ComputerSensorsEvent(ByteBuffer.wrap(array));
    // TODO
    assertEquals(cse.getTemperatureMax(), Quantity.of(67, SI.DEGREE_CELSIUS));
    assertEquals(cse.getTemperatureMin(), Quantity.of(60, SI.DEGREE_CELSIUS));
  }
}
