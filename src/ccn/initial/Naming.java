package ccn.initial;

import ccn.util.CommonInfo;
import peersim.config.Configuration;
import peersim.core.Control;

public class Naming implements Control{
	
	private static String PAR_PROT_INF = "inf_protocol";
	
	private static int pid_inf;
	
	public Naming(String prefix){
		Configuration.getPid(prefix+"."+PAR_PROT_INF);
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		for (int i=0; i < CommonInfo.startPoint.size()-1; i++){
			int start = (int) CommonInfo.startPoint.get(i);
			int end = (int) CommonInfo.startPoint.get(i+1);
			for (int j=start; j<end; j++){
				
			}
		}
		return false;
	}

}
