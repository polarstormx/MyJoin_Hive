package MyJoin;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class JoinPartitioner extends Partitioner<OrderBean, NullWritable> {
	@Override
	public int getPartition(OrderBean ob, NullWritable nw, int i) {
		// TODO Auto-generated method stub
		return Integer.parseInt(ob.getPId()) - 1;
		// return 0;
	}
}
