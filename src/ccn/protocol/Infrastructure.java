package ccn.protocol;

import java.util.List;

import ccn.entity.ContentStore;
import ccn.entity.FIB;
import ccn.entity.Message;
import ccn.entity.PIT;
import peersim.config.FastConfig;
import peersim.core.Network;
import peersim.core.Node;
import peersim.edsim.EDProtocol;
import peersim.transport.Transport;
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
		// drop the message with no requester
		if ( message.getRequester() == -1 ) return;
		
		// handling the interest packet
		if ( message.getMessageType().equals("Interest")){
			// check in content store
			if (contentStore.contains(message.getDataName())!=-1){
				// cache hit
				long requester = node.getID();
				Message data_message = new Message("Data",Integer.valueOf(Long.toString(requester)),message.getDataName());
				// send data packet back
				((Transport)node.getProtocol(FastConfig.getTransport(protocolID))).
				send(node, Network.get(message.getRequester()), data_message, protocolID);
			}
			else {
				// miss in cache, check PIT
				if (pit.containsKey(message.getDataName())){
					// hit in PIT, add face
					pit.addFace(message.getDataName(), message.getRequester());
				}
				else {
					// add entry in PIT
					pit.addEntry(message.getDataName(), message.getRequester());
					// check in FIB for forwarding
					int next_hop = fib.getNextHop(name);
					long requester = node.getID();
					Message forward = new Message(message.getMessageType(),Integer.valueOf(Long.toString(requester)),message.getDataName());
					((Transport)node.getProtocol(FastConfig.getTransport(protocolID))).
					send(node, Network.get(next_hop), forward, protocolID);
				}
			}
		}
		
		// handling the data packet
		if ( message.getMessageType().equals("Data")){
			// cache
			// check PIT and forward
			if (pit.containsKey(message.getDataName())){
				List facelist = pit.getFace(message.getDataName());
				if ( !facelist.isEmpty() ){
					for (int i=0; i<facelist.size(); i++){
						int target = (int) facelist.get(i);
						long requester = node.getID();
						Message data_message = new Message("Data",Integer.valueOf(Long.toString(requester)),message.getDataName());
						((Transport)node.getProtocol(FastConfig.getTransport(protocolID))).
						send(node, Network.get(target), data_message, protocolID);
					}
				}
			}
		}
	}

}
