package ccn.protocol;

import peersim.core.Node;
import peersim.edsim.EDProtocol;
import peersim.vector.SingleValueHolder;

public class Infrastructure extends SingleValueHolder implements EDProtocol{
	
	public String name;
	public String type;
	
	

	public Infrastructure(String prefix) {
		// TODO Auto-generated constructor stub
		super(prefix);
	}

	@Override
	public void processEvent(Node node, int protocolID, Object message) {
		// TODO Auto-generated method stub
		
	}

}
