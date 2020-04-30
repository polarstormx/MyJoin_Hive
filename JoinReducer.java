package MyJoin;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class JoinReducer extends Reducer<OrderBean, NullWritable, OrderBean, NullWritable>{

	@Override
	protected void reduce(final OrderBean key, final Iterable<NullWritable> val,
			Reducer<OrderBean, NullWritable, OrderBean, NullWritable>.Context context)
			throws IOException, InterruptedException {
		final Iterator<NullWritable> iterator = val.iterator();
		iterator.next();
		final String pName = key.getPName();
		final String price = key.getPrice();
		while (iterator.hasNext()) {
			iterator.next();
			key.setPName(pName);
			key.setPrice(price);
			context.write(key, NullWritable.get());
		}
		// TODO Auto-generated method stub
		// super.reduce(arg0, arg1, arg2);
	}
}
