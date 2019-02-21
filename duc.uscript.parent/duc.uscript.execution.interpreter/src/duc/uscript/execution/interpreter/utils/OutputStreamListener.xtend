package duc.uscript.execution.interpreter.utils

import org.eclipse.emf.common.notify.impl.AdapterImpl
import java.io.OutputStream
import org.eclipse.emf.common.notify.Notification

class OutputStreamListener extends AdapterImpl {
	OutputStream out;
	
	new(OutputStream out) {
		this.out = out;
	}
	
	 override void notifyChanged(Notification msg) {
	    if(msg.eventType == Notification.ADD || msg.eventType == Notification.ADD_MANY) {
	    	val newValue = msg.newStringValue
	    	out.write(newValue.bytes)
	    	out.write("\n".bytes)
	    }
	 }
}
