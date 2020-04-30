package MyJoin;

import org.apache.*;
import org.apache.hadoop.io.WritableComparable;

import java.io.*;

public class OrderBean implements WritableComparable<OrderBean> {

	private String oId;
	private String oData;
	private String pId;
	private String pName;
	private String price;
	private String oAmount;

	@Override
	public void readFields(DataInput d) throws IOException {
		// TODO Auto-generated method stub
		this.oId = d.readUTF();
		this.oData = d.readUTF();
		this.pId = d.readUTF();
		this.pName = d.readUTF();
		this.price = d.readUTF();
		this.oAmount = d.readUTF();
	}

	@Override
	public void write(DataOutput d) throws IOException {
		// TODO Auto-generated method stub
		d.writeUTF(oId);
		d.writeUTF(oData);
		d.writeUTF(pId);
		d.writeUTF(pName);
		d.writeUTF(price);
		d.writeUTF(oAmount);
	}

	@Override
	public int compareTo(OrderBean o) {
		// TODO Auto-generated method stub

		int comRes = this.pId.compareTo(o.pId);
		if (comRes == 0) {
			return o.pName.compareTo(this.pName);
		} else {
			return comRes;
		}
	}

	public String getOId() {
		return oId;
	}

	public String getOData() {
		return oData;
	}

	public String getPId() {
		return pId;
	}

	public String getPName() {
		return pName;
	}

	public String getPrice() {
		return price;
	}

	public String getOAmount() {
		return oAmount;
	}

	public void setOId(String val) {
		this.oId = val;
	}

	public void setOData(String val) {
		this.oData = val;
	}

	public void setPId(String val) {
		this.pId = val;
	}

	public void setPName(String val) {
		this.pName = val;
	}

	public void setPrice(String val) {
		this.price = val;
	}

	public void setOAmount(String val) {
		this.oAmount = val;
	}

	// OID\ODATA\PID\PNAME\PRICE\OAMOUNT
	public void setAll(String s1, String s2, String s3, String s4, String s5, String s6) {
		setOId(s1);
		setOData(s2);
		setPId(s3);
		setPName(s4);
		setPrice(s5);
		setOAmount(s6);
	}

}
