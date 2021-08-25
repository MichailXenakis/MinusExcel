package MinusXLGUI;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;

public class FunctionDialog extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public FunctionDialog(Shell parent, int style) {
		super(parent, style);
		setText("Functions");
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
		shell.setSize(450, 300);
		shell.setText(getText());
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(10, 10, 424, 23);
		combo.setText("Select the type of function");
		
		Group group = new Group(shell, SWT.NONE);
		group.setBounds(10, 68, 101, 161);
		group.setText("Function List");
		
		List list = new List(group, SWT.BORDER);
		list.setBounds(10, 22, 71, 129);
		list.add("Sum");
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setBounds(325, 68, 70, 161);

	}
}
