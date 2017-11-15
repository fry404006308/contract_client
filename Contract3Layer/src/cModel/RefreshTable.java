package cModel;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class RefreshTable extends AbstractTableModel{
	Model model=new Model();
	JTable table;
	public RefreshTable(){
		//System.out.println("这是在构造函数里面");
		table=model.refresh();
	}
	
	//只要给我一个表，调用这个函数，我就能够给你刷新表
	//也就是在页面上面显示表
	public RefreshTable(JTable table){
		this.table=table;
	}
	
	
	public int getRowCount() {
		System.out.println("这是在getRowCount()里面"+table.getRowCount());
		return table.getRowCount();
		
	}

	
	public int getColumnCount() {
		System.out.println("这是在getColumnCount()里面"+table.getColumnCount());
		return table.getColumnCount();
		
	}


	public Object getValueAt(int rowIndex, int columnIndex) {
		System.out.println("这是在table.getValueAt里面"+table.getValueAt(rowIndex, columnIndex));
		return table.getValueAt(rowIndex, columnIndex);
	}

}

