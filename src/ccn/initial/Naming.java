package ccn.initial;

import ccn.protocol.Infrastructure;
import ccn.util.CommonInfo;
import peersim.config.Configuration;
import peersim.core.Control;
import peersim.core.Network;

public class Naming implements Control{
	
	private static String PAR_PROT_INF = "inf_protocol";
	
	private static int pid_inf;
	
	public Naming(String prefix){
		Configuration.getPid(prefix+"."+PAR_PROT_INF);
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		String parent = "";
		for (int i=0; i < CommonInfo.startPoint.size()-1; i++){
			int nameIndex = 0;
			int start = (int) CommonInfo.startPoint.get(i);
			int end = (int) CommonInfo.startPoint.get(i+1);
			for (int j=start; j<end; j++){
				Infrastructure inf = (Infrastructure) Network.get(j).getProtocol(pid_inf);
				if (inf.name == null){
					if (j == start){
						if ((int)CommonInfo.parent.get(j)!=-1){
							int parentID = (int)CommonInfo.parent.get(j);
							Infrastructure inf_p = (Infrastructure) Network.get(parentID).getProtocol(pid_inf);
							parent = inf_p.name;
							inf.name = parent + String.valueOf(nameIndex);
						}
						else inf.name = String.valueOf(nameIndex);
					}
					else {
						inf.name = parent + String.valueOf(nameIndex);
					}
				}
				nameIndex++;
			}
		}
		return false;
	}

}
