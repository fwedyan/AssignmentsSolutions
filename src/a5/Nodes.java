package a5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import a6.ThreeDNode;

public class Nodes {
    private ArrayList<INode> list;
    public Nodes() {
    	
    	list = new ArrayList<INode>();
    	Collections.sort(list, new NodesSorter());
    	
    }
    
}
class NodesSorter implements Comparator <INode>{

	@Override
	public int compare(INode o1, INode o2) {
		int sum1;
		int sum2;
		if (o1.getClass()==Node.class) {
			Node obj1 = (Node) o1; 
			sum1 = obj1.getX()+obj1.getY();
		}else
		{
			ThreeDNode obj1 = (ThreeDNode) o1; 
			sum1 = obj1.getX()+obj1.getY()+obj1.getZ();
		}
		
		if (o2.getClass()==Node.class) {
			Node obj2 = (Node) o2; 
			sum2 = obj2.getX()+obj2.getY();
		}else
		{
			ThreeDNode obj2 = (ThreeDNode) o2; 
			sum2 = obj2.getX()+obj2.getY()+obj2.getZ();
		}	
		if (sum1>sum2)
			return 1;
		if (sum1==sum2)
			return 0;
		return -1;
	}
	
}