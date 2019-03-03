import graphic.Window;
import java.awt.Point;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VonKochMono {
	private final static double LG_MIN = 8.0;
	Window f;
	
	public VonKochMono (Window f, Point a, Point b, Point c) {
		this.f = f;
		
		ExecutorService exec = Executors.newFixedThreadPool(5);
		exec.execute(new Cote(f, b, a, exec));
		exec.execute(new Cote(f, a, c, exec));
		exec.execute(new Cote(f, c, b, exec));
		//exec.shutdown();
	}
	
}
