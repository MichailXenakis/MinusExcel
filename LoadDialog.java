package MinusXLGUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

public class LoadDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	protected String s;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public LoadDialog(Shell parent, int style) {
		super(parent, style);
		setText("Load File");
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
		shell.setSize(497, 101);
		shell.setText(getText());
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblNewLabel.setBounds(10, 10, 90, 21);
		lblNewLabel.setText("File Name");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(175, 10, 260, 23);
		
		combo.add("File 1", 0);
		combo.add("File 2", 1);
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setBounds(406, 47, 75, 25);
		btnNewButton.setText("Load");
		btnNewButton.addMouseListener(new MouseListener(){

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				s=combo.getText();
				System.out.println("Loading.. :"+s);
				
				// Open requested file
				
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(325, 47, 75, 25);
		btnNewButton_1.setText("Cancel");
		btnNewButton_1.addMouseListener(new MouseListener(){
			
			public void mouseDoubleClick(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			public void mouseDown(MouseEvent arg0) {
				shell.close();
				return;
			}
			public void mouseUp(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
