package MinusXLGUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class StartUp {

	protected Shell s;
	protected Display d;
	protected Shell sh;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	
	StartUp(){
		try {
			
			open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Open the window.
	 */
	public void open() {
		d = Display.getDefault();
		createContents();
		s.open();
		s.layout();
		while (!s.isDisposed()) {
			if (!d.readAndDispatch()) {
				d.sleep();
				
			}
			
		}
		
		d.dispose();
	}
	public void close(){
		s.close();
	}
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		s = new Shell();
		
		s.setSize(310, 549);
		s.setText("MinusXL");
		
		Button btnNewWB = new Button(s, SWT.BORDER | SWT.FLAT | SWT.CENTER);
		
		btnNewWB.setBounds(79, 90, 107, 25);
		btnNewWB.setText("New Workbook");
		btnNewWB.addMouseListener(new MouseListener()
		{
			public void mouseDown(MouseEvent e)
			{
				System.out.println("Mouse Down.");
				NewWBDialog wb= new NewWBDialog(s,0);
				String nm = wb.returnValues();
			}
			public void mouseUp(MouseEvent e)
			{
				System.out.println("Mouse Up.");
			}
			public void mouseDoubleClick(MouseEvent e)
			{
				System.out.println("Mouse Double click.");
			}
		
		});
		
		
		Button btnLoad = new Button(s, SWT.BORDER);
		btnLoad.setBounds(79, 172, 107, 25);
		btnLoad.setText("Load Workbook");
		btnLoad.addMouseListener(new MouseListener()
		{
			public void mouseDown(MouseEvent e)
			{
				System.out.println("Mouse Down.");
				LoadDialog ld = new LoadDialog(s,0);
			}
			public void mouseUp(MouseEvent e)
			{
				System.out.println("Mouse Up.");
			}
			public void mouseDoubleClick(MouseEvent e)
			{
				System.out.println("Mouse Double click.");
			}
		
		});
		
		
		
		Button btnExit = new Button(s, SWT.BORDER);
		btnExit.addMouseListener(new MouseListener()
		{
			public void mouseDown(MouseEvent e)
			{
				System.out.println("Mouse Down.");
				s.close();
				d.close();
				System.exit(0);
			}
			public void mouseUp(MouseEvent e)
			{
				System.out.println("Mouse Up.");
			}
			public void mouseDoubleClick(MouseEvent e)
			{
				System.out.println("Mouse Double click.");
			}
		
		});
		btnExit.setBounds(97, 293, 75, 25);
		btnExit.setText("Exit");
		
		Label lblNewLabel = new Label(s, SWT.HORIZONTAL | SWT.SHADOW_NONE | SWT.CENTER);
		lblNewLabel.setBounds(50, 10, 155, 45);
		lblNewLabel.setText("MinusXL");
		
	}
}
