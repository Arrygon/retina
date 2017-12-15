// code by jph
package ch.ethz.idsc.retina.gui.gokart;

import java.util.Objects;

import javax.swing.WindowConstants;

import ch.ethz.idsc.retina.dev.davis.DavisDevice;
import ch.ethz.idsc.retina.dev.davis._240c.Davis240c;
import ch.ethz.idsc.retina.dev.davis.app.AccumulatedEventsGrayImage;
import ch.ethz.idsc.retina.dev.davis.app.DavisImageBuffer;
import ch.ethz.idsc.retina.dev.davis.app.DavisQuickFrame;
import ch.ethz.idsc.retina.dev.davis.app.SignalResetDifference;
import ch.ethz.idsc.retina.lcm.davis.DavisLcmClient;
import ch.ethz.idsc.retina.lcm.lidar.Vlp16LcmHandler;
import ch.ethz.idsc.retina.sys.AbstractModule;
import ch.ethz.idsc.retina.sys.AppCustomization;
import ch.ethz.idsc.retina.util.gui.WindowConfiguration;

/** contains hard-coded channel names and magic constants */
public class DavisOverviewModule extends AbstractModule {
  private DavisLcmClient davisLcmClient = new DavisLcmClient(GokartLcmChannel.DAVIS_OVERVIEW);
  private DavisQuickFrame davisViewerFrame;
  private final WindowConfiguration windowConfiguration = //
      AppCustomization.load(getClass(), new WindowConfiguration());
  private final Vlp16LcmHandler vlp16LcmHandler = new Vlp16LcmHandler(GokartLcmChannel.VLP16_CENTER);

  @Override
  protected void first() throws Exception {
    int period_us = 10_000;
    DavisDevice davisDevice = Davis240c.INSTANCE;
    DavisLidarComponent davisLidarComponent = new DavisLidarComponent();
    vlp16LcmHandler.lidarAngularFiringCollector.addListener(davisLidarComponent);
    davisViewerFrame = new DavisQuickFrame(davisDevice, davisLidarComponent);
    // handle dvs
    AccumulatedEventsGrayImage accumulatedEventsImage = new AccumulatedEventsGrayImage(davisDevice, period_us);
    davisLcmClient.davisDvsDatagramDecoder.addDvsListener(accumulatedEventsImage);
    accumulatedEventsImage.addListener(davisViewerFrame.davisViewerComponent.dvsImageListener);
    // handle dif
    DavisImageBuffer davisImageBuffer = new DavisImageBuffer();
    davisLcmClient.davisRstDatagramDecoder.addListener(davisImageBuffer);
    SignalResetDifference signalResetDifference = SignalResetDifference.amplified(davisImageBuffer);
    davisLcmClient.davisSigDatagramDecoder.addListener(signalResetDifference);
    signalResetDifference.addListener(davisViewerFrame.davisViewerComponent.difListener);
    // start to listen
    davisLcmClient.startSubscriptions();
    windowConfiguration.attach(getClass(), davisViewerFrame.jFrame);
    davisViewerFrame.jFrame.setVisible(true);
    vlp16LcmHandler.startSubscriptions();
  }

  @Override
  protected void last() {
    vlp16LcmHandler.stopSubscriptions();
    davisLcmClient.stopSubscriptions();
    if (Objects.nonNull(davisViewerFrame)) {
      davisViewerFrame.jFrame.setVisible(false);
      davisViewerFrame.jFrame.dispose();
    }
  }

  public static void standalone() throws Exception {
    DavisOverviewModule davisDetailModule = new DavisOverviewModule();
    davisDetailModule.first();
    davisDetailModule.davisViewerFrame //
        .jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
  }

  public static void main(String[] args) throws Exception {
    standalone();
  }
}
