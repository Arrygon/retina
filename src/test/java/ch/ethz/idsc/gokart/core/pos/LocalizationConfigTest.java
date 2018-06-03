// code by jph
package ch.ethz.idsc.gokart.core.pos;

import ch.ethz.idsc.retina.util.math.Magnitude;
import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.sca.Clip;
import junit.framework.TestCase;

public class LocalizationConfigTest extends TestCase {
  public void testVlp16_emulate() {
    Scalar emulation_deg = //
        Magnitude.DEGREE_ANGLE.apply(LocalizationConfig.GLOBAL.horizon);
    Clip.function(0.5, 1.0).requireInside(emulation_deg);
  }
}
