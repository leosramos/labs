package foo;

import java.util.Iterator;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import foo.api.DelegateApp;

public class App {
	
	@Inject
	private Instance<DelegateApp> apps;
	
	public void start() {
		System.out.println("Olá mundo");
		
		Iterator<DelegateApp> iter = apps.iterator();
		while(iter.hasNext()) {
			DelegateApp app = iter.next();
			app.start();
		}
	}
	
	public static void main(String[] args) {
		Weld weld = new Weld();

		WeldContainer container = weld.initialize();

		App app = container.instance().select(App.class).get();
		
		app.start();
		
		weld.shutdown();
	}
}
