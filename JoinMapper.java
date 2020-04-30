package MyJoin;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapred.FileSplit;
import org.apache.hadoop.mapreduce.Mapper;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;

public class JoinMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {

	private OrderBean ob = new OrderBean();
	private String fileName;

	@Override
	protected void setup(Mapper<LongWritable, Text, OrderBean, NullWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		FileSplit fs = (FileSplit) context.getInputSplit();
		fileName = fs.getPath().getName();

		super.setup(context);
	}

	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, OrderBean, NullWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String[] fields = value.toString().split(" ");
		// OID\ODATA\PID\PNAME\PRICE\OAMOUNT
		if (fileName.equals("product.txt")) {
			ob.setAll("", "", fields[0], fields[1], fields[2], "");
		} else {
			ob.setAll(fields[0], fields[1], fields[2], "", "", fields[3]);
		}
		context.write(ob, NullWritable.get());
		// super.map(key, value, context);
	}

}
