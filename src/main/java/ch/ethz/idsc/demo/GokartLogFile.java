// code by jph
package ch.ethz.idsc.demo;

import ch.ethz.idsc.gokart.offline.api.LogFile;
import ch.ethz.idsc.retina.dev.linmot.LinmotFireFighter;

public enum GokartLogFile implements LogFile {
  /* 2017-12-07 */
  /** joystick driving */
  _20171207T105632_59f9bc78, //
  /** joystick driving with 1[m/s] */
  _20171207T121043_59f9bc78, //
  /** joystick driving with up to 6[m/s] */
  _20171207T133222_59f9bc78, //
  /** joystick driving with up to 6[m/s] */
  _20171207T134930_59f9bc78, //
  /***************************************************/
  /* 2017-12-08 */
  /** joystick driving */
  _20171208T102427_a03fba2d, //
  /** joystick driving with up to 4[m/s] */
  _20171208T110839_a03fba2d, //
  /** joystick driving */
  _20171208T115237_a03fba2d, //
  /***************************************************/
  /* 2017-12-13 */
  /** lot's of braking */
  _20171213T161500_55710a6b, //
  /** brake distance testing */
  _20171213T162832_55710a6b, //
  /***************************************************/
  /* 2017-12-18 */
  // gokart.pose.lidar does not contain quality field
  /** moving gokart */
  _20171218T121006_9b56b71b, //
  /** pure pursuit oval up to 2[m/s] */
  _20171218T130515_4794c081, //
  /** pure pursuit oval */
  _20171218T133833_2eb2bfb0, //
  /** pure pursuit oval up to 2[m/s] */
  _20171218T135141_2eb2bfb0, //
  /***************************************************/
  /* 2018-01-08 */
  /** no movement at all
   * linmot failure at 662.75[s]; */
  _20180108T152648_5f742add, //
  /**  */
  _20180108T154035_5f742add, //
  /** linmot failure at 571.65[s]; */
  _20180108T160752_5f742add, //
  /** linmot failure at 128.25[s]; */
  _20180108T162528_5f742add, //
  /** joystick with max torque;
   * 332[s] oval pursuit in reverse */
  _20180108T165210_5f742add, //
  /***************************************************/
  /* 2018-01-12 */
  /** no movement at all
   * 708.50[s] linmot failure */
  _20180112T103859_9e1d3699, //
  /**  */
  _20180112T105400_9e1d3699, //
  /** 565[s] oval pursuit
   * 1578.05[s] linmot failure */
  _20180112T113153_9e1d3699, //
  /** oval pursuit 758.18[s] */
  _20180112T154355_9e1d3699, //
  /***************************************************/
  /* 2018-02-26 */
  /** joystick driving */
  _20180226T150533_ed1c7f0a, //
  /** joystick driving */
  _20180226T164802_ed1c7f0a, //
  /***************************************************/
  /* 2018-03-05 */
  /** joystick */
  _20180305T114356_9e1dc13c, //
  /** NOT MUCH HAPPENS HERE */
  _20180305T121016_9e1dc13c, //
  /** joystick driving
   * contains LCM_SELF_TEST */
  _20180305T150255_9e1dc13c, //
  /** joystick */
  _20180305T151234_9e1dc13c, //
  /** pure pursuit without davis */
  _20180305T170018_9e1dc13c, //
  /***************************************************/
  /* 2018-03-07 */
  /** joystick slow, with safety barriers for demo */
  _20180307T095540_1cd7a2e2, //
  /** pure pursuit with localization failure */
  _20180307T150715_28f09b86, //
  /** pure pursuit of oval shape */
  _20180307T151633_28f09b86, //
  /** pure pursuit of figure 8 */
  _20180307T154859_0cd18c6b, //
  /** autonomous driving shape 8
   * velocity peak ~3.6[m*s^-1] */
  _20180307T165102_6e45300d, //
  /** autonomous driving shape 8 */
  _20180307T171311_fc084dc9, //
  /***************************************************/
  /* 2018-03-08 */
  /** no driving */
  _20180308T145954_45b9eed8, //
  /** pure pursuit figure 8 */
  _20180308T151702_45b9eed8, //
  /** pure pursuit figure 8 */
  _20180308T165333_1ab0c811, //
  /***************************************************/
  /* 2018-03-10 DEMO DAY */
  /** pure pursuit figure 8 */
  _20180310T102810_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T110029_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T112508_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T120222_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T130740_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T132414_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T135043_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T142811_1ab0c811, //
  /** not moving */
  _20180310T151418_1ab0c811, //
  /** not moving */
  _20180310T152653_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T153409_1ab0c811, //
  /** pure pursuit figure 8 */
  _20180310T160324_1ab0c811, //
  /***************************************************/
  /* 2018-03-19 */
  /** pure pursuit figure 8 */
  _20180319T133213_1ab0c811, //
  /***************************************************/
  /* 2018-03-22 */
  /** pure pursuit figure 8 */
  _20180322T120834_d520ea0d, //
  /** fast pure pursuit figure 8 with escapes */
  _20180322T124329_d520ea0d, //
  /***************************************************/
  /* 2018-04-09 */
  _20180409T150925_d520ea0d, //
  /***************************************************/
  /* 2018-04-12 */
  _20180412T114245_7e5b46c2, //
  /** stationary gokart in center of hangar
   * {46.9657[m], 48.4280[m], 1.1587704741}
   * pedestrians, bicycles and motorcycles moving around
   * no Davis240C */
  _20180412T163109_7e5b46c2, //
  /** stationary gokart in center of hangar
   * {46.9249[m], 48.6060[m], 1.1602311755}
   * pedestrians and bicycles moving around */
  _20180412T163855_7e5b46c2, //
  /** manual drive with markers on floor for davis240c
   * without cones
   * contains linmot failure */
  _20180412T164740_7e5b46c2, //
  /***************************************************/
  /* 2018-04-18 */
  /** joystick driving and single prbs */
  _20180418T102854_5a650fbf, //
  /** pure pursuit */
  _20180418T125913_bca165ae, //
  /** multiple prbs */
  _20180418T132333_bca165ae, //
  /***************************************************/
  /* 2018-04-19 */
  /** pure pursuit with hangar doors closed and then open */
  _20180419T124700_7373f83e, //
  /** pure pursuit with speed controller going in reverse */
  _20180419T150253_7373f83e, //
  /** pure pursuit with speed controller going in reverse */
  _20180419T172115_f80284e9, //
  /** joystick driving along figure 8 */
  _20180419T172918_f80284e9, //
  /***************************************************/
  /* 2018-04-23 */
  /** pure pursuit with controller driving backwards */
  _20180423T181849_633cc6e6, //
  /***************************************************/
  /* 2018-04-27 */
  /** joystick driving small circles at different speeds
   * used to approx. min turning radius 2.45[m] */
  _20180427T105421_08cf25f5, //
  /** torque signals to rimo for sys id */
  _20180427T121545_22662115, //
  /** torque signals to rimo for sys id */
  _20180427T123334_22662115, //
  /** rimo PI controller with Kp=74 Ki==0
   * exhibits backwards driving
   * log includes internals of PI controller
   * channel rimo.controller.pi is encoded in BIG_ENDIAN */
  _20180427T125356_22662115, //
  /** slow and medium joystick driving with 2 pedestrians walking
   * gokart localization not successful */
  _20180427T140645_22662115, //
  /** trajectory planning and pure pursuit */
  _20180427T155210_987cb124, //
  /** trajectory planning and pure pursuit */
  _20180427T155709_987cb124, //
  /***************************************************/
  /* 2018-04-30 */
  /** pure pursuit at different speeds with pedestrians walking
   * PI-controller with Kp==20 and Ki==0 */
  _20180430T104113_a5291af9, //
  /** slow driving for recording improved map with hangar doors open+closed
   * at the end: driving fast circles */
  _20180430T141530_a5291af9, //
  /** joystick driving along oval with markers for dvs */
  _20180430T153747_0e959fc6, //
  /** no driving */
  _20180430T161506_0e959fc6, //
  /** taking pictures with APS for Davis240C calibration
   * no driving */
  _20180430T163141_0e959fc6, //
  /** joystick driving with camera calibrated
   * localization not working */
  _20180430T164704_0e959fc6, //
  /***************************************************/
  /* 2018-05-03 */
  /** slow pure pursuit oval with Kp==30, Ki==0 */
  _20180503T094457_ce8724ba, //
  /** pure pursuit oval
   * initial localization failure
   * last round success */
  _20180503T103916_836189cd, //
  /** motion planning with driving speeds up to 4[m/s] */
  _20180503T140722_16144bb6, //
  /** motion planning with driving speeds up to 3[m/s] */
  _20180503T150559_16144bb6, //
  /** motion planning
   * pure pursuit figure 8 */
  _20180503T151615_16144bb6, //
  /** pure pursuit figure 8 with Kp==40, Ki==0
   * first at slow speed then up to 4[m/s]
   * pedestrians, bicycle, static obstacles
   * speed controller allows very minor backwards motion */
  _20180503T160522_16144bb6, //
  /***************************************************/
  /* 2018-05-07 */
  /** pure pursuit figure 8 */
  _20180507T090040_28e21174, //
  /** pure pursuit figure 8 with speed then up to 5[m/s] */
  _20180507T132022_588d4c6c, //
  /** pure pursuit figure 8 with speed then up to 5[m/s]
   * exhibits backwards driving */
  _20180507T135949_588d4c6c, //
  /** pure pursuit figure 8 with davis camera calibrated */
  _20180507T143002_588d4c6c, //
  /** trajectory planning
   * several ovals until planner stop */
  _20180507T152619_8d5acc24, //
  /** trajectory planning few ovals */
  _20180507T153455_8d5acc24, //
  /** stationary gokart single pedestrian walking at various distances */
  _20180507T160755_8d5acc24, //
  /** driving by joystick fast */
  _20180507T161322_8d5acc24, //
  /***************************************************/
  /* 2018-05-09 */
  /** joystick driving */
  _20180509T120343_8d5acc24, //
  /***************************************************/
  /* 2018-05-14 */
  /** slow joystick driving to establish
   * min torque to set gokart in motion */
  _20180514T101430_3a743349, //
  /** slow joystick driving to establish
   * min torque to set gokart in motion */
  _20180514T105947_eda6fc3d, //
  /** record waypoints for duct-tape track */
  _20180514T151138_767e5417, //
  /** pure pursuit of duct-tape track */
  _20180514T153139_767e5417, //
  /** pure pursuit of duct-tape track
   * second half includes pedestrians */
  _20180514T155248_767e5417, //
  /***************************************************/
  /* 2018-05-17 */
  /** joystick driving up to 5[m/s]
   * with consistent localization */
  _20180517T152605_c1876fc4, //
  /** figure eight up to 3[m/s] */
  _20180517T153517_c1876fc4, //
  /** path planning with static obstacles */
  _20180517T161015_294bf075, //
  /** path planning with static obstacles */
  _20180517T161714_294bf075, //
  /** path planning with static obstacles, several pure pursuit
   * failures due to large curvature */
  _20180517T162431_294bf075, //
  /** path planning with static obstacles, several failures
   * because gokart reaches end of trajectory before replanning */
  _20180517T163528_294bf075, //
  /** path planning with static obstacles, several pure pursuit
   * failures due to large curvature, gokart cuts through center */
  _20180517T172517_a7130894, //
  /** path planning with static obstacles
   * start from point away from waypoints */
  _20180517T174022_a7130894, //
  /***************************************************/
  /* 2018-05-22 */
  /** pure pursuit figure 8 with speeds up to 6[m/s] */
  _20180522T111414_6806b8fd, //
  /** oval pure pursuit slow */
  _20180522T114650_6806b8fd, //
  /** trajectory planning with moving obstacles */
  _20180522T135700_2da7e1f5, //
  /** trajectory planning with moving obstacles */
  _20180522T140901_2da7e1f5, //
  /** joystick driving with 1000[ARMS] */
  _20180522T144106_2da7e1f5, //
  /** trajectory planning */
  _20180522T145910_2da7e1f5, //
  /** trajectory planning with moving obstacles */
  _20180522T150418_2da7e1f5, //
  /***************************************************/
  /* 2018-05-24 */
  /** different rimo P/PI controller values
   * pure pursuit figure 8 */
  _20180524T142610_0c5750cc, //
  /** trajectory planning, pure pursuit figure 8 */
  _20180524T163738_65ff8506, //
  /** pure pursuit figure 8
   * involves localization failure */
  _20180524T164438_65ff8506, //
  /** trajectory planning oval waypoints, no obstacles */
  _20180524T165519_65ff8506, //
  /** trajectory planning oval waypoints, no obstacles */
  _20180524T165934_65ff8506, //
  /** trajectory planning oval waypoints, shifting obstacles */
  _20180524T175331_f5b40700, //
  /***************************************************/
  /* 2018-05-28 */
  /** joystick driving and parking */
  _20180528T092757_3d02888c, //
  /** slow figure eight */
  _20180528T114144_3d02888c, //
  /** slow joystick driving */
  _20180528T115153_3d02888c, //
  /** joystick driving on wet surface */
  _20180528T130940_3d02888c, //
  /** joystick driving */
  _20180528T160809_3d02888c, //
  /** joystick driving */
  _20180528T161753_bb8cdede, //
  /** autonomous figure eight with tent at side */
  _20180528T163638_bb8cdede, //
  /***************************************************/
  /* 2018-05-29 */
  /** joystick driving
   * autonomous figure eight */
  _20180529T113303_bb8cdede, //
  /** trajectory planning with changing obstacle locations */
  _20180529T121927_701d9748, //
  /***************************************************/
  /* 2018-05-31 */
  /** autonomous figure eight */
  _20180531T144153_701d9748, //
  /** joystick driving with stops for map building
   * with two large tents and bus tent in place */
  _20180531T162851_701d9748, //
  /** joystick driving with stops for map building
   * with two large tents and bus tent in place */
  _20180531T171521_701d9748, //
  /***************************************************/
  /* 2018-06-04 */
  /** autonomous driving figure eight with tents */
  _20180604T092030_270dd1ab, //
  /** collecting waypoints */
  _20180604T100452_a2e94332, //
  /** waypoint following */
  _20180604T102303_a2e94332, //
  /** joystick driving fast and slow */
  _20180604T104509_a2e94332, //
  /** joystick driving as car in a city */
  _20180604T105353_a2e94332, //
  /** pedestrians walking with stationary gokart */
  _20180604T120216_a2e94332, //
  /** pure pursuit figure eight reverse */
  _20180604T122138_d2234286, //
  /** pure pursuit figure eight reverse
   * localization issues at certain configuration */
  _20180604T132432_d2234286, //
  /** testing brake and linmot with stationary gokart */
  _20180604T140448_d2234286, //
  /** testing brake and linmot with stationary gokart
   * {@link LinmotFireFighter} switches off linmot */
  _20180604T142924_77ab1670, //
  /** pure pursuit figure eight slow driving
   * with pedestriants around */
  _20180604T150508_15e65bba, //
  /** pure pursuit figure eight */
  _20180604T153602_15e65bba, //
  /***************************************************/
  /* 2018-06-07 */
  /** emergency brake testing */
  _20180607T095321_e5ca0ea5, //
  /** emergency brake testing */
  _20180607T122743_edd2e720, //
  /** emergency brake testing */
  _20180607T124405_edd2e720, //
  /** gokart investigation */
  _20180607T140443_e9d47681, //
  /** gokart investigation */
  _20180607T142738_e9d47681, //
  /** current measurement of steering
   * at the end, steering failure */
  _20180607T144545_e9d47681, //
  /** gokart investigation */
  _20180607T165530_e9d47681, //
  /** pure pursuit figure eight reverse
   * including emergency brake testing */
  _20180607T170837_e9d47681, //
  /***************************************************/
  /* 2018-06-11 */
  /** autonomous figure eight */
  _20180611T095800_851c404d, //
  /** trajectory planning, but incomplete because of virtual obstacle
   * pure pursuit figure eight including emergency stops,
   * localization failure after emergency stop */
  _20180611T101502_851c404d, //
  /** trajectory planning, but incomplete because of virtual obstacle */
  _20180611T143955_44b96dd6, //
  /** trajectory planning successful: complete loop, proximity to waypoints
   * aborted because of steering system failure */
  _20180611T144759_44b96dd6, //
  ;
  @Override
  public String getFilename() {
    return name().substring(1) + ".lcm.00";
  }

  @Override
  public String getTitle() {
    return name().substring(1, 16);
  }
}
