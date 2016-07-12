package foo.delegate;

import foo.api.DelegateApp;

public class FooApp implements DelegateApp {

	@Override
	public void start() {
		System.out.println("Em delegate FooApp");
	}

}
