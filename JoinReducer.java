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
		final String price = key.getPrice();//得到Pname及Price
		while (iterator.hasNext()) {
			iterator.next();
			key.setPName(pName);
			key.setPrice(price);//为所有项写入
			context.write(key, NullWritable.get());
		}

	}
}
