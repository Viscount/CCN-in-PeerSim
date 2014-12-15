package ccn.protocol;

import ccn.entity.ContentStore;
import ccn.entity.FIB;
import ccn.entity.Message;
import ccn.entity.PIT;
import peersim.core.Node;
import peersim.edsim.EDProtocol;
import peersim.vector.SingleValueHolder;

public class Infrastructure extends SingleValueHolder implements EDProtocol{
	
	public String name;
	public String type;
	
	private PIT pit;
	private FIB fib;
	private ContentStore contentStore;
	
	

	public Infrastructure(String prefix) {
		// TODO Auto-generated constructor stub
		super(prefix);
	}

	@Override
	public void processEvent(Node node, int protocolID, Object event) {
		// TODO Auto-generated method stub
		Message message = (Message) event;
	}

}
