//num: 3670631 & 3670460
import java.awt.*;
import graphic.Window;

public class TestDessineLigne2 {

	public static void main(String[] args) {
		Window f = new Window(480, 480, "Question 3");
		Point p1 = new Point(15, 465);
		Point p2 = new Point(240, 15);
		Point p3 = new Point(465, 465);
		
		new Thread(new DessineLigne2(p1, p2, f)).start();
		new Thread(new DessineLigne2(p1, p3, f)).start();
		new Thread(new DessineLigne2(p3, p2, f)).start();
	}

}
