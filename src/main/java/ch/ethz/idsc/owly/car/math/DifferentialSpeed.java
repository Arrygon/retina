// code by jph
package ch.ethz.idsc.owly.car.math;

import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Scalars;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.TensorRuntimeException;
import ch.ethz.idsc.tensor.Tensors;
import ch.ethz.idsc.tensor.qty.UnitSystem;
import ch.ethz.idsc.tensor.sca.Cos;
import ch.ethz.idsc.tensor.sca.Sin;

/** class determines the no-slip velocity for tires at an offset from the center of
 * the rear axis depending on the steering angle of the tires at the front axis */
public class DifferentialSpeed {
  public static DifferentialSpeed fromSI(Scalar x_front, Scalar y_offset) {
    return new DifferentialSpeed( //
        UnitSystem.SI().apply(x_front), //
        UnitSystem.SI().apply(y_offset));
  }

  private final Scalar factor;

  /** Diagram:
   * 
   * -- y_offset [positive]
   * |
   * |
   * 0---------/- x_front [positive] -> and angle, turn left [positive]
   * |
   * |
   * -- y_offset [negative]
   * 
   * @param x_front non-zero distance from rear to front axis
   * @param y_offset distance from center of rear axis to tire */
  public DifferentialSpeed(Scalar x_front, Scalar y_offset) {
    if (Scalars.isZero(x_front))
      throw TensorRuntimeException.of(x_front, y_offset);
    factor = y_offset.divide(x_front);
  }

  /** @param speed of vehicle at center of front axis along the direction of steering
   * @param angle at center of front axis, beta == 0 for driving straight
   * @return speed at y_offset from center of rear axis */
  public Scalar get(Scalar speed, Scalar angle) {
    Scalar cos = Cos.FUNCTION.apply(angle);
    Scalar sin = Sin.FUNCTION.apply(angle);
    return cos.subtract(factor.multiply(sin)).multiply(speed);
  }

  /** computes speed for two tires the second of which is at a location mirrored
   * along the x-axis from the first tire.
   * 
   * @param speed
   * @param angle
   * @return */
  public Tensor pair(Scalar speed, Scalar angle) {
    Scalar cos = Cos.FUNCTION.apply(angle);
    Scalar sin = Sin.FUNCTION.apply(angle);
    Scalar res = factor.multiply(sin);
    return Tensors.of(cos.subtract(res), cos.add(res)).multiply(speed);
  }
}
