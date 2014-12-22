package ccn.util;

import java.util.ArrayList;
import java.util.List;

import peersim.core.Network;

public class CommonInfo {
	
	public static List startPoint;
	public static List nodeChild;
	public static int bb_start;
	public static int dm_start;
	public static int branch;
	
	public static void init(){
		startPoint = new ArrayList();
		nodeChild = new ArrayList();
		for (int i=0; i<Network.size(); i++){
			List childList = new ArrayList();
			nodeChild.add(childList);
		}
		bb_start = 0;
		dm_start = 0;
		branch = 0;
	}
	
	public static void addChildNode(int nodeID, int childNodeID){
		 List childList = (List) nodeChild.get(nodeID);
		 childList.add(childNodeID);
		 nodeChild.set(nodeID, childList);
	}

}
