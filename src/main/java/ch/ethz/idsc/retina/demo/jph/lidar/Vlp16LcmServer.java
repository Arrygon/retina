package ch.ethz.idsc.retina.demo.jph.lidar;

import ch.ethz.idsc.retina.dev.velodyne.VelodyneModel;
import ch.ethz.idsc.retina.dev.velodyne.VelodyneStatics;
import ch.ethz.idsc.retina.lcm.lidar.VelodyneLcmServer;

public enum Vlp16LcmServer {
  ;
  public static void main(String[] args) {
    VelodyneLcmServer velodyneLcmServer = new VelodyneLcmServer(VelodyneModel.VLP16, "center", //
        VelodyneStatics.RAY_DEFAULT_PORT, VelodyneStatics.POS_DEFAULT_PORT);
    velodyneLcmServer.start();
  }
}