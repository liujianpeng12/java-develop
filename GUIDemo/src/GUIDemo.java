import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class GUIDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new MyFrame();
	}

}

class MyFrame extends Frame {
	public MyFrame(){
		initComponents();
	}

	private void initComponents() {
		this.setTitle("Title");
		this.setSize(400, 300);
		
		Toolkit t=Toolkit.getDefaultToolkit();
		Dimension d=t.getScreenSize();
		int x=(int)(d.getWidth()-400)/2;
		int y=(int)(d.getHeight()-300)/2;
		this.setLocation(x,y);
		
		URL url=this.getClass().getClassLoader().getResource("images/save.png");
		Image img=t.getImage(url);
		this.setIconImage(img);
		
		this.setLayout(new FlowLayout());

		Button b1 = new Button("°´Å¥1");
		this.add(b1);
		Button b2 = new Button("°´Å¥2");
		this.add(b2);
		
		addPanel();
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});

		this.setVisible(true);
	}
	
	private void addPanel(){
		Panel p=new Panel();
		p.setBackground(Color.yellow);
		p.add(new Button("button1"));
		p.add(new Button("button2"));
		p.add(new Button("button3"));
		this.add(p);
	}
}