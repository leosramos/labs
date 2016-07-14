package foo;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

/**
 * Hello world!
 *
 */
public class App extends AbstractVerticle {

	// Convenience method so you can run it in your IDE
	public static void main(String[] args) {
		Runner.runExample(App.class);
	}

	@Override
	public void start() throws Exception {

		Router router = Router.router(vertx);

		router.route().handler(routingContext -> {
			routingContext.response().putHeader("content-type", "text/html").end("Hello World!");
		});

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);

		Router restAPI = Router.router(vertx);

		restAPI.get("/products/:productID").handler(rc -> {

			// TODO Handle the lookup of the product....
			rc.response().write("teste");

		});

		restAPI.put("/products/:productID").handler(rc -> {

			// TODO Add a new product...
			rc.response().end();

		});

		restAPI.delete("/products/:productID").handler(rc -> {

			// TODO delete the product...
			rc.response().end();

		});
		
		
//		Router mainRouter = Router.router(vertx);
//
//		// Handle static resources
//		mainRouter.route("/static/*").handler(myStaticHandler);
//
//		mainRouter.route(".*\\.templ").handler(myTemplateHandler);
		
		router.mountSubRouter("/productsAPI", restAPI);
	}
}
