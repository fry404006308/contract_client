package cDatabase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JTable;


public class ResultSet2Table {
	Vector field;
	Vector record;
	public JTable CompleteRs2T(ResultSet rs) throws SQLException {
		field=new Vector();
		record=new Vector();
		field.add("合同ID");
		field.add("合同编号");
		field.add("合同名称");
		field.add("合同分类");
		field.add("合同甲方");
		field.add("合同乙方");
		field.add("合同金额");
		field.add("开始时间");
		field.add("结束时间");
		field.add("收付款");
		field.add("合同上传");
		field.add("合同操作员");
		field.add("合同简介");
		
		while(rs.next())
		{
			Vector row=new Vector();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			row.add(rs.getString(3));
			row.add(rs.getString(4));
			row.add(rs.getString(5));
			row.add(rs.getString(6));
			row.add(rs.getDouble(7));
			row.add(rs.getDate(8));
			row.add(rs.getDate(9));
			row.add(rs.getString(10));
			row.add(rs.getString(11));
			row.add(rs.getString(12));
			row.add(rs.getString(13));

			record.add(row);
		}
		if(rs!=null){	rs.close();}
		JTable table=new JTable(record,field);
		return table;

	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ((Vector)this.record.get(rowIndex)).get(columnIndex);
	}


}
