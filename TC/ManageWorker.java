package TC;

public class ManageWorker {
	SmartWorker sw;
	LazyWorker lw;
	public ManageWorker(SmartWorker sw, LazyWorker lw) {
		super();
		this.sw = sw;
		this.lw = lw;

	}
	public void manageWorker() {
		sw.work();
		lw.work();
	}

}
