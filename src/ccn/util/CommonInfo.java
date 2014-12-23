package ccn.util;

import java.util.ArrayList;
import java.util.List;

import peersim.core.Network;

public class CommonInfo {
	
	public static List startPoint;
	public static List parent;
	public static int bb_start;
	public static int dm_start;
	public static int branch;
	
	public static void init(){
		startPoint = new ArrayList();
		parent = new ArrayList();
		for (int i=0; i<Network.size(); i++){
			parent.add(-1);
		}
		bb_start = 0;
		dm_start = 0;
		branch = 0;
	}

}
