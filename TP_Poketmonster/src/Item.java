

public abstract class Item {
	
	private int count;
//	private String name;
//	
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}
	
	public abstract void be_used();
		
}
