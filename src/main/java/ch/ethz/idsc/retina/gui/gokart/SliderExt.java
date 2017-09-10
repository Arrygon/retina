// code by jph
package ch.ethz.idsc.retina.gui.gokart;

import java.util.Objects;
import java.util.function.Function;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ch.ethz.idsc.tensor.RealScalar;
import ch.ethz.idsc.tensor.Scalar;

public class SliderExt implements ChangeListener {
  public static SliderExt wrap(JSlider jSlider) {
    return new SliderExt(jSlider);
  }

  public final JSlider jSlider;
  public final JLabel jLabel = new JLabel();
  public Function<Scalar, Scalar> physics;

  private SliderExt(JSlider jSlider) {
    this.jSlider = jSlider;
    stateChanged(null);
    jSlider.addChangeListener(this);
  }

  @Override
  public void stateChanged(ChangeEvent changeEvent) {
    StringBuffer stringBuffer = new StringBuffer();
    if (Objects.isNull(physics)) {
      stringBuffer.append(jSlider.getValue());
    } else {
      Scalar scalar = physics.apply(RealScalar.of(jSlider.getValue()));
      stringBuffer.append(scalar.toString());
      String toolTip = "" + jSlider.getValue();
      jLabel.setToolTipText(toolTip);
      jSlider.setToolTipText(toolTip);
    }
    jLabel.setText(stringBuffer.toString());
  }

  public void addToComponent(JToolBar jToolBar) {
    jToolBar.add(jSlider);
    jToolBar.add(jLabel);
  }
}
