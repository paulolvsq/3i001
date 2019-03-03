//num: 3670631 & 3670460
import java.awt.*;
import graphic.Window;

public class DessineLigne2 implements Runnable {
	
	private Point p1;
	private Point p2;
	private Window f;
	
	public DessineLigne2(Point p1, Point p2, Window f) {
		this.p1 = p1;
		this.p2 = p2;
		this.f = f;
	}
	public void run() {
		f.plotLine(p1, p2);
	}

}
