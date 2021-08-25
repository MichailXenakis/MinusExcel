package MinusXLGUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class NewWBDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private String s;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public NewWBDialog(Shell parent, int style) {
		super(parent, style);
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
		shell.setSize(450, 143);
		shell.setText(getText());
		
		Label lbl_SS = new Label(shell, SWT.NONE);
		lbl_SS.setBounds(10, 30, 148, 15);
		lbl_SS.setText("Enter Workbook's name :");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(179, 27, 255, 21);
		
		Button btnDoneButton = new Button(shell, SWT.NONE);
		btnDoneButton.setBounds(351, 83, 75, 25);
		btnDoneButton.setText("Done");
		btnDoneButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event) {
		    	s = text.getText();
		    	if(s.length()==0){
		    		s="New Workbook";
		    	}
		    	NewSpreadsheet ss = new NewSpreadsheet(shell,0);
		    	//shell.close();
		      }
			
		});
		
		Button btnCancelButton = new Button(shell, SWT.NONE);
		btnCancelButton.setBounds(270, 83, 75, 25);
		btnCancelButton.setText("Cancel");
		btnCancelButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event) {
		    	s="New Workbook";
		    	shell.close();
		      }
		});
		
	}
	
	public String returnValues(){
		
		return s;
	}
}
