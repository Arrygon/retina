// code by jph
package ch.ethz.idsc.retina.demo.jph;

import ch.ethz.idsc.retina.dev.davis.DavisDecoder;
import ch.ethz.idsc.retina.dev.davis.DavisEventProvider;
import ch.ethz.idsc.retina.dev.davis._240c.Davis240c;
import ch.ethz.idsc.retina.dvs.app.AedatLogViewer;
import ch.ethz.idsc.retina.dvs.io.aedat.AedatFileSupplier;

enum DavisViewerDemo {
  ;
  public static void main(String[] args) throws Exception {
    DavisDecoder davisDecoder = Davis240c.INSTANCE.createDecoder();
    DavisEventProvider davisEventProvider = new AedatFileSupplier(Datahaki.LOG_03.file, davisDecoder);
    AedatLogViewer.of(davisEventProvider, davisDecoder, Davis240c.INSTANCE, 0.5);
  }
}
