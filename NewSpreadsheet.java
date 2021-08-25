package MinusXLGUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class NewSpreadsheet extends Dialog {
	private int n,m;
	private String name;
	protected Object result;
	protected static Shell shell;
	private String st;
	String defWB = "New Workbook";

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	
	public NewSpreadsheet(Shell parent, int style) {
		super(parent, style);
		
		//setText("SWT Dialog");
		open();
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(491, 166);
		shell.setText(getText());
		
		
		Text text = new Text(shell, SWT.BORDER);
		text.setBounds(149, 10, 246, 21);
		
		
		Label Label_SS = new Label(shell, SWT.NONE);
		Label_SS.setBounds(27, 13, 116, 15);
		Label_SS.setText("Spreadsheet Name:");
		
		Text text_N = new Text(shell, SWT.BORDER);
		text_N.setBounds(149, 56, 76, 21);
		
		Text text_M = new Text(shell, SWT.BORDER);
		text_M.setBounds(319, 56, 76, 21);
		
		Label Label_N = new Label(shell, SWT.NONE);
		Label_N.setBounds(131, 59, 12, 15);
		Label_N.setText("N:");
		
		Label Label_M = new Label(shell, SWT.NONE);
		Label_M.setBounds(301, 59, 12, 15);
		Label_M.setText("M:");
		
		Label lblTableSize = new Label(shell, SWT.NONE);
		lblTableSize.setBounds(10, 56, 95, 15);
		lblTableSize.setText("Table Size(NxM)");
		
		Button btnDoneButton = new Button(shell, SWT.NONE);
		btnDoneButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnDoneButton.setBounds(400, 98, 75, 25);
		btnDoneButton.setText("Done");
		btnDoneButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				//shell.close();
				
				st=text.getText();
				System.out.println("QQ"+st);
				System.out.println(text_N.getText()+","+text_M.getText());
				if(st.length()==0 &&  text_N.getText().length() == 0 && text_M.getText().length() == 0 ){
					System.out.println("NONE");
					n=m=10;
					name = defWB;
				
					
				}else if(st.length()!=0 &&  text_N.getText().length() != 0 && text_M.getText().length() == 0 ){
					
					n=Integer.parseInt(text_N.getText());
					m=10;
					name = st;
					System.out.println("STN");
					
				}else if(st.length()!=0 &&  text_N.getText().length() == 0 && text_M.getText().length() == 0) {
					System.out.println("ST");
					n=m=10;
					name = st;
				
				}else if(st.length()!=0 &&  text_N.getText().length() == 0 && text_M.getText().length() != 0){
					m =Integer.parseInt(text_M.getText());
					System.out.println("STM");
					n=10;
					name = st;
				}else if(st.length()==0 && text_N.getText().length() != 0 && text_M.getText().length() != 0){
					n=Integer.parseInt(text_N.getText());
					m =Integer.parseInt(text_M.getText());
					System.out.println("NM");
					
					name = defWB;
				}else if(st.length()==0 && text_N.getText().length() != 0 && text_M.getText().length() == 0 ){
					n=Integer.parseInt(text_N.getText());
					System.out.println("N");
					m=10;
					name = defWB;
				}else if(st.length()==0 &&  text_N.getText().length() == 0 && text_M.getText().length() != 0 )	{
					m =Integer.parseInt(text_M.getText());
					System.out.println("M");
					n=10;
					name = defWB;
					
				
					
				}else{
					n=Integer.parseInt(text_N.getText());
					m =Integer.parseInt(text_M.getText());
					name = st;
					System.out.print("WB:  "+st);
					
				}
			
				
				//shell.setVisible(false);
				shell.close();
				MinusXLGUI mg = new MinusXLGUI(name,n,m);
				
				
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
		
		
		
	
		/*btnCancel.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
			public void mouseDown(MouseEvent arg0) {
				shell.close();
				return;
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});*/
			

	}
	
	
	public String returnName(){
		return name;
	}

}
