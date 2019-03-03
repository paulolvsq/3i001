//num: 3670631 & 3670460 
import java.awt.*;
import graphic.Window;

public class Question1 {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 480;
	public static void main(String[] args) {
		Point p1 = new Point(15, 465);
		Point p2 = new Point(240, 15);
		Point p3 = new Point(465, 465);
		Window w = new Window(WIDTH, HEIGHT, "Question 1");
		w.plotLine(p1, p2);
		w.plotLine(p1, p3);
		w.plotLine(p2, p3);
	}
}
