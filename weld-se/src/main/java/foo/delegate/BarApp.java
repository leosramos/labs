package foo.delegate;

import foo.api.DelegateApp;

public class BarApp implements DelegateApp {

	@Override
	public void start() {
		System.out.println("Em delegate BarApp");
	}

}
