package cModel;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class RefreshTable extends AbstractTableModel{
	Model model=new Model();
	JTable table;
	public RefreshTable(){
		//System.out.println("�����ڹ��캯������");
		table=model.refresh();
	}
	
	//ֻҪ����һ������������������Ҿ��ܹ�����ˢ�±�
	//Ҳ������ҳ��������ʾ��
	public RefreshTable(JTable table){
		this.table=table;
	}
	
	
	public int getRowCount() {
		System.out.println("������getRowCount()����"+table.getRowCount());
		return table.getRowCount();
		
	}

	
	public int getColumnCount() {
		System.out.println("������getColumnCount()����"+table.getColumnCount());
		return table.getColumnCount();
		
	}


	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("������table.getValueAt����"+table.getValueAt(rowIndex, columnIndex));
		return table.getValueAt(rowIndex, columnIndex);
	}

}

