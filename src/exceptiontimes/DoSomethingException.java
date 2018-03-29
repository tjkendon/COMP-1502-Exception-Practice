package exceptiontimes;

public class DoSomethingException extends Exception{

	
	private int causeCount;
	
	public DoSomethingException(int causeCount) {
		super("Cause count was " + causeCount);
		this.causeCount = causeCount;
	}
	
	public int getCauseCount() {
		return causeCount;
	}
	
}
