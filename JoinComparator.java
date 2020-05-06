package MyJoin;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class JoinComparator extends WritableComparator{

	public JoinComparator() {

		super(OrderBean.class, true);
	}
	
	@Override
	public int compare(WritableComparable a, WritableComparable b) {//自定义分组

		OrderBean oa = (OrderBean)a;
		OrderBean ob = (OrderBean)b;
		return oa.getPId().compareTo(ob.getPId());//相同pid分到一组
	}
}
