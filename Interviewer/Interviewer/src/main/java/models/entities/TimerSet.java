package models.entities;

public class TimerSet implements Runnable {
	
	@SuppressWarnings("unused")
	private String description;
	private int timeForInterview;
	private int timeSpent;

	public TimerSet(String description, int timeForInterview, int timeSpent ) {
		super();
		this.description = description;
		this.timeForInterview = timeForInterview;
		this.timeSpent = 0;
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public int getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}
	
	@Override
	public void run() {

		try {
			for (int i=timeForInterview; i>0; i--){
				//System.out.println(description + i);
				setTimeSpent(i); 
				Thread.sleep(60000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
