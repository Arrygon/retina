// code by jph
package ch.ethz.idsc.retina.demo.jph.davis;

import java.util.Objects;

import ch.ethz.idsc.retina.dev.davis.DavisDvsEventListener;
import ch.ethz.idsc.retina.dev.davis._240c.DavisDvsEvent;

/** experiments show that the dvs event stream has frequent gaps of 5-25 ms.
 * it seems that davis camera is event-blind during aps images read out. */
class DavisDvsIntervalTracker implements DavisDvsEventListener {
  private Integer last = null;
  final int[] bins = new int[40000];

  @Override
  public void dvs(DavisDvsEvent davisDvsEvent) {
    if (Objects.isNull(last))
      last = davisDvsEvent.time;
    else {
      int diff = davisDvsEvent.time - last;
      ++bins[diff];
      last = davisDvsEvent.time;
    }
  }
}
