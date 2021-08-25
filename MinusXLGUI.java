package MinusXLGUI;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Composite;

import java.io.File;

import javax.swing.JFileChooser;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabFolderAdapter;
import org.eclipse.swt.custom.CTabFolderEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;

public class MinusXLGUI {
	  
	   protected Display dis;
	   /**
		 * @wbp.parser.entryPoint
		 */

	 private Shell shell;
	   private Text text;
	  /**
	   * @wbp.parser.entryPoint
	   */
	  @SuppressWarnings("deprecation")
	MinusXLGUI(String s,int N,int M) {
		  
		  System.out.println("MinusXL :"+s+","+N+","+M);
		  /*JFileChooser js = new JFileChooser();
		  js.setCurrentDirectory(new File(System.getProperty("user.home")));
		  int result = js.showOpenDialog(null);*/
		  dis = Display.getCurrent();
		  shell=new Shell(dis);
		  shell.setModified(true);
		  shell.setSize(244, 280);
		  shell.setLayout(new GridLayout(1, false));
		  new Label(shell, SWT.NONE);
		  
		
		  
		  
		  Group group = new Group(shell, SWT.NONE);
		  GridData gd_group = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		  gd_group.widthHint = 450;
		  group.setLayoutData(gd_group);
		  
		  
		  
		  Button btnFunction = new Button(group,SWT.NONE);
		  btnFunction.setVisible(true);
		  btnFunction.setBounds(0, 10, 40, 25);
		  btnFunction.setText("F(x)");
		  btnFunction.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.BOLD | SWT.ITALIC));
		  btnFunction.addSelectionListener(new SelectionAdapter(){
			  public void widgetSelected(SelectionEvent event) {
			    	FunctionDialog fd = new FunctionDialog(shell,0);
			      }
		  });
		  
		  text = new Text(group, SWT.BORDER);
		  text.setBounds(46, 13, 400, 21);
		  text.setLayoutData(new GridData(SWT.FILL,SWT.FILL,true,false,1,1));
		  
		  //	WB Label
		  Label lblNewLabel = new Label(shell,  SWT.WRAP);
		  NewWBDialog wbs = new NewWBDialog(shell,0);
		  lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD | SWT.ITALIC));
		  lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		  lblNewLabel.setBounds(0, 10, 60, 15);
		  lblNewLabel.setText(wbs.returnValues());
		  lblNewLabel.setVisible(true);
		  
		  CTabFolder tabFolder = new CTabFolder(shell, SWT.TOP);
		  tabFolder.setBorderVisible(true);
		  tabFolder.setSimple(false);
		  tabFolder.setUnselectedCloseVisible(false);
		  tabFolder.setLayoutData(new GridData(GridData.FILL_BOTH));
		  tabFolder.addCTabFolderListener(new CTabFolderAdapter() {
		      public void itemClosed(final CTabFolderEvent event) {
		    	  //Add save option for current spreadsheet
		      }
		    });
		  
		  
		  Cell t = new Cell(tabFolder,N,M);
	      
		 
		  CTabItem newTab = new CTabItem(tabFolder,SWT.RIGHT|SWT.WRAP);
		  Button newTabbtn = new Button(tabFolder,SWT.NONE);
		  newTab.setText("+");
		  newTab.setControl(newTabbtn);
		  newTabbtn.setText("Click here to create a new Spreadsheet");
		  newTabbtn.addSelectionListener(new SelectionAdapter() {
		      public void widgetSelected(SelectionEvent event) {
		    	 Cell t = new Cell(tabFolder,6,7);
		      }
		  });
		  
		  
		
		  Menu menu = new Menu(shell, SWT.BAR);
		  shell.setMenuBar(menu);
		  
		  MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		  mntmFile.setText("File");
		  
		  Menu menu_1 = new Menu(mntmFile);
		  mntmFile.setMenu(menu_1);
		  
		  MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		  mntmSave.setText("Save");
		  
		  MenuItem mntmLoadFile = new MenuItem(menu_1, SWT.NONE);
		  mntmLoadFile.setText("Load file");
		  
		  MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		  mntmExit.setText("Exit");
		  mntmExit.addListener(SWT.Selection, new Listener(){
			  public void handleEvent(Event e)
				{	
				  	
				    System.out.println("Mouse Down.");
					shell.close();
					Display.getCurrent().close();
					System.exit(0);
				}

			
		  });
		  
		  MenuItem Draw = new MenuItem(menu, SWT.CASCADE);
		  Draw.setText("Draw Chart");
		  Menu menu_2 = new Menu(Draw);
		  Draw.setMenu(menu_2);
		  MenuItem mntmBar = new MenuItem(menu_2,SWT.NONE);
		  mntmBar.setText("Bar Chart");
		  MenuItem mntmLine = new MenuItem(menu_2,SWT.NONE);
		  mntmLine.setText("Line Chart");
		  
		  MenuItem Help = new MenuItem(menu, SWT.CASCADE);
		  Help.setText("Help");
		  Menu menu_3 = new Menu(Help);
		  Help.setMenu(menu_3);
		  MenuItem mntmHelp = new MenuItem(menu_3,SWT.NONE);
		  mntmHelp.setText("Help");
		  MenuItem mntmOnlineHelp = new MenuItem(menu_3,SWT.NONE);
		  mntmOnlineHelp.setText("Online Help");
		  

		  shell.pack();
		  
		  shell.open();
		  while(!shell.isDisposed()){
			  if(!dis.readAndDispatch()){
				 dis.sleep();
			  }
			  
		  }
		  dis.dispose();
	  } 
	
	  public static void main(String[] argv) {
		StartUp s1=new StartUp();
		
		
	    //new MinusXLGUI();
	  }
}
