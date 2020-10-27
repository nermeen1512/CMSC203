
public class Plot {
	
	
	//declaration of the class fields
	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	//---------------------------------------------------------------constructors
	//----------------empty constructor
	public Plot() {
		x=0;
		y=0;
		width=1;
		depth=1;
	}
	
	//--------------------copy constructor
	public Plot(Plot p) {
		this.x = p.x; 
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	//-------------parameterized constructor
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	//-----------------------------------------------------------the gets methods
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getDepth() {
		return depth;
	}
	
	
	//-----------------------------------------------------------the sets methods
	public void setX(int x) {
		this.x =x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setWidth( int width) {
		this.width = width;
	}
	public void setDepth( int depth) {
		this.depth = depth;
	}
	//-----------------------------------------------------the boolean functions to check on overlapping and encompasses
	public boolean overlaps(Plot plot) {
		//return x < plot.x + plot.width && x + width > plot.x && y < plot.y + plot.depth && y + depth > plot.y;
		if(((plot.getX() >= x + width)||((plot.getX() + plot.getWidth()) <= x)) && ((plot.getY() >= y + depth)||((plot.getY() + plot.getDepth()) <= y)))
			return true;
		return false;
	}
	
	public boolean encompasses(Plot plot) {
		if(plot.x >= x && plot.x <= x + width && plot.width <= (x+width-plot.x) && plot.y >= y && plot.y <= y + depth && plot.depth <= (y+depth-plot.y) )
		{ return true;}
		else { return false;}
	}
	//--------------------------------------------------------the toString method to display the information
	public String toString() {
		String s = "Upper left:(" +x+ ","+y +"); Width: "+width + " Depth: "+depth ;
		return s;
	}
}