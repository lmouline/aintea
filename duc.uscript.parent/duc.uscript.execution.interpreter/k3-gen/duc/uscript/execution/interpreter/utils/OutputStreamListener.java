package duc.uscript.execution.interpreter.utils;

import java.io.OutputStream;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class OutputStreamListener extends AdapterImpl {
  private OutputStream out;
  
  public OutputStreamListener(final OutputStream out) {
    this.out = out;
  }
  
  @Override
  public void notifyChanged(final Notification msg) {
    try {
      if (((msg.getEventType() == Notification.ADD) || (msg.getEventType() == Notification.ADD_MANY))) {
        final String newValue = msg.getNewStringValue();
        this.out.write(newValue.getBytes());
        this.out.write("\n".getBytes());
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
