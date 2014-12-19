package ccn.strategy;

import peersim.core.Node;
import ccn.entity.ContentStore;
import ccn.entity.Message;
import ccn.protocol.Infrastructure;

public class LRU extends ReplaceStrategy{

	@Override
	public void replace(Node node, int protocolID, Message message) {
		// TODO Auto-generated method stub
		Infrastructure inf = (Infrastructure) node.getProtocol(protocolID);
		ContentStore cs = inf.getContentStore();
		while ( cs.size() > cs.getCacheSize()){
			int index = cs.getLatestItem();
			cs.remove(index);
		}
	}

}
