//num: 3670631 & 3670460
import java.awt.*;
import graphic.Window;

public class TestDessineLigne {
	
	public static void main(String[] args) {
		Window f = new Window(480, 480, "Question 2");
		Point p1 = new Point(15, 465);
		Point p2 = new Point(240, 15);
		Point p3 = new Point(465, 465);
		
		DessineLigne d1 = new DessineLigne(p1,p2,f);
		DessineLigne d2 = new DessineLigne(p3,p2,f);
		DessineLigne d3 = new DessineLigne(p3,p1,f);
		
		d1.start();
		d2.start();
		d3.start();
		
	}
}
