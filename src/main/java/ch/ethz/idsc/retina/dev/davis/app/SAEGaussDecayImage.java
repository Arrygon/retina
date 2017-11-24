// code by az
package ch.ethz.idsc.retina.dev.davis.app;

import ch.ethz.idsc.retina.dev.davis.DavisDevice;
import ch.ethz.idsc.retina.dev.davis._240c.DavisDvsEvent;

/** surface of active events */
public class SAEGaussDecayImage extends AbstractAccumulatedImage {
  /** number of bits to drop */
  private static final int DROP = 7;
  // ---
  private final GaussDecayLookup gaussP;
  private final GaussDecayLookup gaussN;

  /** @param interval [us] */
  public SAEGaussDecayImage(DavisDevice davisDevice, int interval) {
    super(davisDevice, interval);
    // ---
    gaussP = new GaussDecayLookup(interval >> DROP, 2.5, +1);
    gaussN = new GaussDecayLookup(interval >> DROP, 2.5, -1);
  }

  @Override
  protected void assign(int delta, DavisDvsEvent dvsDavisEvent) {
    int index = dvsDavisEvent.x + (dvsDavisEvent.y) * width;
    bytes[index] = dvsDavisEvent.brightToDark() ? gaussN.get(delta >> DROP) : gaussP.get(delta >> DROP);
  }
}
