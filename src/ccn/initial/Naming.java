package ccn.initial;

import ccn.protocol.Infrastructure;
import peersim.config.Configuration;
import peersim.core.Control;
import peersim.core.Network;
import peersim.core.Node;

public class Naming implements Control{
	
	private static String PAR_PROT_INF = "inf_protocol";
	
	private static int pid_inf;
	
	public Naming(String prefix){
		pid_inf = Configuration.getPid(prefix+"."+PAR_PROT_INF);
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		for (int i=0; i < Network.size(); i++){
			Node node = Network.get(i);
			Infrastructure inf = (Infrastructure) node.getProtocol(pid_inf);
			inf.name = String.valueOf(node.getID());
		}
		return false;
	}

}
