// code by jph
package ch.ethz.idsc.retina.dev.rimo;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

import ch.ethz.idsc.retina.sys.OfflineUse;
import ch.ethz.idsc.retina.sys.SafetyCritical;
import ch.ethz.idsc.retina.util.data.Word;
import ch.ethz.idsc.tensor.Scalar;
import ch.ethz.idsc.tensor.Tensor;
import ch.ethz.idsc.tensor.Tensors;
import ch.ethz.idsc.tensor.qty.Quantity;
import ch.ethz.idsc.tensor.qty.QuantityMagnitude;
import ch.ethz.idsc.tensor.qty.Unit;
import ch.ethz.idsc.tensor.sca.ScalarUnaryOperator;

@SafetyCritical
public class RimoPutTire implements Serializable {
  public static final Unit UNIT_TORQUE = Unit.of("ARMS");
  public static final ScalarUnaryOperator MAGNITUDE_ARMS = QuantityMagnitude.singleton(UNIT_TORQUE);
  public static final Word OPERATION = Word.createShort("OPERATION", (short) 0x0009);
  public static final List<Word> COMMANDS = Arrays.asList(OPERATION);
  /* package */ static final RimoPutTire PASSIVE = new RimoPutTire(OPERATION, (short) 0, (short) 0);
  public static final Word TRIG_OFF = Word.createByte("OFF", (byte) 0);
  public static final Word TRIG_ON = Word.createByte("ON", (byte) 1);
  public static final List<Word> TRIGGERS = Arrays.asList(TRIG_OFF, TRIG_ON);
  // ---
  /** 4 bytes encoding length */
  /* package */ static final int LENGTH = 15;
  /** the datasheet bounds the speed between -8000 and 8000
   * according to tests on the bench the max effective speed is ~6300 */
  public static final short MIN_SPEED = -6500;
  public static final short MAX_SPEED = +6500;
  /** the torque bounds are taken from the datasheet
   * the unit of the torque is in ARMS, i.e. ampere average root-mean square */
  public static final short MIN_TORQUE = -2317;
  public static final short MAX_TORQUE = +2316;
  // ---
  private final short command;
  /** angular rate in rad/min */
  private final short rate;
  private final short torque;
  // ---
  public byte trigger;
  public byte sdoCommand;
  public short mainIndex;
  public byte subIndex;
  public int sdoData;

  /** @param command raw value
   * @param rate raw value
   * @param torque raw value */
  public RimoPutTire(Word command, short rate, short torque) {
    this.command = command.getShort();
    this.rate = rate;
    this.torque = torque;
  }

  /** for use in display and tests
   * 
   * @return */
  public short getRateRaw() {
    return rate;
  }

  /** for use in display and tests
   * 
   * @return */
  public short getTorqueRaw() {
    return torque;
  }

  /** @return torque with unit "ARMS" */
  public Scalar getTorque() {
    return Quantity.of(torque, UNIT_TORQUE);
  }

  void insert(ByteBuffer byteBuffer) {
    byteBuffer.putShort(command); // 0
    byteBuffer.putShort(rate); // 2
    byteBuffer.putShort(torque); // 4
    // ---
    byteBuffer.put(trigger); // 6
    byteBuffer.put(sdoCommand); // 7
    byteBuffer.putShort(mainIndex); // 8
    byteBuffer.put(subIndex); // 10
    byteBuffer.putInt(sdoData); // 11 ... total == 15
  }

  public String toSDOHexString() {
    return String.format("%02x %04x.%02x %08x", sdoCommand, mainIndex, subIndex, sdoData);
  }

  @OfflineUse
  public Tensor vector_raw() {
    return Tensors.vector(command, rate, torque, trigger, sdoCommand, mainIndex, subIndex, sdoData);
  }
}
