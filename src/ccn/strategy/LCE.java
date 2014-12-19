package ccn.strategy;

import peersim.core.CommonState;
import peersim.core.Node;
import ccn.entity.ContentStore;
import ccn.entity.Message;
import ccn.protocol.Infrastructure;

public class LCE extends CacheStrategy{

	public LCE() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cache(Node node, int protocolID, Message message) {
		// TODO Auto-generated method stub
		
		Infrastructure inf = (Infrastructure) node.getProtocol(protocolID);
		ContentStore cs = inf.getContentStore();
		if(cs.contains(message.getDataName())!=-1){
			cs.addItem(message.getDataName());
		}
	}

}
