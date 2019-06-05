

public class RecoveryPotion extends Item {

	private int count;
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}
	
	@Override
	public void be_used() {
		// TODO Auto-generated method stub
		if(this.count==0)
		{
			System.out.println("회복포션이 없습니다.");
		}
		else
		{
			this.count--;
		}
	}

}
