package ccn.initial;

import ccn.util.CommonInfo;
import peersim.config.Configuration;
import peersim.core.CommonState;
import peersim.dynamics.WireGraph;
import peersim.graph.Graph;

public class WireTopology extends WireGraph{
	
	private static final String PAR_BRANCH = "branch";
	private static final String PAR_AS_SIZE = "as_size";
	private static final String PAR_BACKBONE_SIZE = "backbone_size";
	private static final String PAR_DOMAIN_SIZE = "domain_size";
	private static final String PAR_DEGREE = "degree";
	
	private final int branch;
	private final int degree;
	private final int as_size;
	private final int backbone_size;
	private final int domain_size;

	public WireTopology(String prefix) {
		// TODO Auto-generated constructor stub
		super(prefix);
		branch = Configuration.getInt(prefix+"."+PAR_BRANCH,2);
		as_size = Configuration.getInt(prefix+"."+PAR_AS_SIZE,1);
		backbone_size = Configuration.getInt(prefix+"."+PAR_BACKBONE_SIZE,1);
		domain_size = Configuration.getInt(prefix+"."+PAR_DOMAIN_SIZE,1);
		degree = Configuration.getInt(prefix+"."+PAR_DEGREE,2);
	}

	@Override
	public void wire(Graph g) {
		// TODO Auto-generated method stub
		int as_num = 1;
		int bb_num = branch;
		int dm_num = branch*branch;
		CommonInfo.branch = branch;
		// get start point of each domain
		CommonInfo.startPoint.add(0);
		CommonInfo.startPoint.add(as_size);
		CommonInfo.bb_start = as_size;
		for (int i=0; i<bb_num; i++){
			int base = (int) CommonInfo.startPoint.get(i+1);
			CommonInfo.startPoint.add(base+backbone_size);
		}
		CommonInfo.dm_start = (int) CommonInfo.startPoint.get(CommonInfo.startPoint.size()-1);
		for (int i=0; i<dm_num; i++){
			int base = (int) CommonInfo.startPoint.get(i+branch+1);
			CommonInfo.startPoint.add(base+domain_size);
		}
		// wire topology in each domain
		for (int i=0; i<CommonInfo.startPoint.size()-1; i++){
			int start = (int) CommonInfo.startPoint.get(i);
			int end = (int) CommonInfo.startPoint.get(i+1);
			int size = end - start;
			for (int j=start; j<end; j++){
				for (int times=0; times<degree; times++){
					int node = start + CommonState.r.nextInt(size);
					g.setEdge(j, node);
					g.setEdge(node, j);
				}
			}
		}
		// wire topology between domains
		int index = 0;
		for (int i=0; i<CommonInfo.startPoint.size()-1; i++){
			int start = (int) CommonInfo.startPoint.get(i);
			int end = (int) CommonInfo.startPoint.get(i+1);
			for (int j=0; j<branch; j++){
				index++;
				if (index < CommonInfo.startPoint.size()-1){
					int root = start + CommonState.r.nextInt(branch);
					CommonInfo.parent.set((int) CommonInfo.startPoint.get(index),root);
					g.setEdge(root, (int) CommonInfo.startPoint.get(index) );
					g.setEdge((int) CommonInfo.startPoint.get(index),root );
				}
			}
		}

	}

}
