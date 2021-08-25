package MinusXLGUI;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Shell;

public class Cell {
	private int insertMark = -1;
	private String SpreadsheetName;
	private Shell s = new Shell();

	@SuppressWarnings("null")
	public Cell(CTabFolder tab,int N,int M){
		final Table table = new Table(tab,SWT.BORDER);
		CTabItem tbtmNewItem = new CTabItem(tab, SWT.NONE|SWT.RIGHT,insertMark+1);
		//NewSpreadsheet ss = new NewSpreadsheet(s,0);
		//SpreadsheetName = s;
		//System.out.println(SpreadsheetName);
		//tbtmNewItem.setText(SpreadsheetName);
		//tbtmNewItem.setControl(table);
		
		    
		  
	  
	  table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	  table.setBounds(0, 27, 904, 445);
	  table.setHeaderVisible(true);
	  table.setLinesVisible(true);
	  
	  final TableEditor ed = new TableEditor(table);
	  ed.horizontalAlignment = SWT.LEFT;
	  ed.grabHorizontal=true;
	  table.addListener(SWT.MouseDown, new Listener(){
		  public void handleEvent(Event e){
			  Rectangle clientArea = table.getClientArea();
			  Point p = new Point(e.x,e.y);
			  System.out.println("clicked:"+e.x+","+e.y);
			  int index = table.getTopIndex();
			  while(index < table.getItemCount()){
				  boolean visible = false;
				  TableItem item = table.getItem(index);
				  for(int i =1;i<table.getColumnCount();i++){
					  Rectangle rect = item.getBounds(i);
					  if(rect.contains(p)){
						  int column=i;
						  Text text = new Text(table,SWT.NONE);
						  Listener textListener = new Listener(){
							  public void handleEvent(final Event event){
								  switch(event.type){
								  case SWT.FocusOut:
									  item.setText(column,text.getText());
									  text.dispose();
									  break;
								  case SWT.Traverse:
									  switch(e.detail){
									  case SWT.TRAVERSE_RETURN:
										  item.setText(column,text.getText());
										  
									  case SWT.TRAVERSE_ESCAPE:
										  text.dispose();
										  e.doit=false;
									  }
									  break;
								  }
							  }
						  };
						  text.addListener(SWT.FocusOut, textListener);
						  text.addListener(SWT.Traverse, textListener);
						  ed.setEditor(text, item, i);
						  text.setText(item.getText(i));
						  text.selectAll();
						  text.setFocus();	 
						  System.out.println(item.getText(i));
						  return;
					  }
					  if(!visible && rect.intersects(clientArea)){
						  visible = true;
					  }
				  }
					  if(!visible)
						  return; 
					  index++;
				  }
			  
		  
	  }
	  }	);  
	  
	  TableColumn c = new TableColumn(table,SWT.NONE);
	  c.setWidth(100);

	  for (int i=65;i<=65+M-1;i++){
		  TableColumn col = new TableColumn(table,SWT.NONE);
		  col.setWidth(100);
	  
		  col.setText(Character.toString((char) i));
	  }
	  for (int i=1;i<N+1;i++){
		  TableItem item = new TableItem(table,SWT.NONE);
	  
		  item.setText(""+i);
	  }
	}
}
