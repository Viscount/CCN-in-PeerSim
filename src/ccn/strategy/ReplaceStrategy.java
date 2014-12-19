package ccn.strategy;

import ccn.entity.Message;
import peersim.core.Node;

public abstract class ReplaceStrategy {
	
	public abstract void replace(Node node, int protocolID, Message message);

}
