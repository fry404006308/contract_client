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
		field.add("��ͬID");
		field.add("��ͬ���");
		field.add("��ͬ����");
		field.add("��ͬ����");
		field.add("��ͬ�׷�");
		field.add("��ͬ�ҷ�");
		field.add("��ͬ���");
		field.add("��ʼʱ��");
		field.add("����ʱ��");
		field.add("�ո���");
		field.add("��ͬ�ϴ�");
		field.add("��ͬ����Ա");
		field.add("��ͬ���");
		
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
