// code by jph
package ch.ethz.idsc.retina.gui.gokart;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import ch.ethz.idsc.retina.dev.linmot.LinmotSocket;
import ch.ethz.idsc.retina.dev.misc.MiscSocket;
import ch.ethz.idsc.retina.dev.rimo.RimoSocket;
import ch.ethz.idsc.retina.dev.steer.SteerSocket;
import ch.ethz.idsc.retina.sys.AbstractModule;

public class AutoboxTestingModule extends AbstractModule {
  private final List<AutoboxTestingComponent<?, ?>> list = new LinkedList<>();
  private final JTabbedPane jTabbedPane = new JTabbedPane();
  private final RimoComponent rimoComponent = new RimoComponent();
  private final LinmotComponent linmotComponent = new LinmotComponent();
  private final SteerComponent steerComponent = new SteerComponent();
  private final MiscComponent miscComponent = new MiscComponent();
  private final JFrame jFrame = new JFrame();

  @Override
  protected void first() throws Exception {
    RimoSocket.INSTANCE.addAll(rimoComponent);
    addTab(rimoComponent);
    // ---
    LinmotSocket.INSTANCE.addAll(linmotComponent);
    addTab(linmotComponent);
    // ---
    SteerSocket.INSTANCE.addAll(steerComponent);
    addTab(steerComponent);
    // ---
    MiscSocket.INSTANCE.addAll(miscComponent);
    addTab(miscComponent);
    // ---
    jTabbedPane.setSelectedIndex(0);
    // ---
    jFrame.setContentPane(jTabbedPane);
    jFrame.setBounds(100, 80, 500, 700);
    jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    jFrame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent windowEvent) {
        RimoSocket.INSTANCE.removeAll(rimoComponent);
        LinmotSocket.INSTANCE.removeAll(linmotComponent);
        SteerSocket.INSTANCE.removeAll(steerComponent);
        MiscSocket.INSTANCE.removeAll(miscComponent);
        System.out.println("removed listeners and providers");
      }
    });
    jFrame.setVisible(true);
  }

  @Override
  protected void last() {
    jFrame.setVisible(false);
    jFrame.dispose();
  }

  private void addTab(AutoboxTestingComponent<?, ?> autoboxTestingComponent) {
    list.add(autoboxTestingComponent);
    String string = autoboxTestingComponent.getClass().getSimpleName();
    string = string.substring(0, string.length() - 9);
    JPanel jPanel = new JPanel(new BorderLayout());
    jPanel.add(autoboxTestingComponent.getComponent(), BorderLayout.NORTH);
    JScrollPane jScrollPane = new JScrollPane(jPanel);
    jTabbedPane.addTab(string, jScrollPane);
  }
}