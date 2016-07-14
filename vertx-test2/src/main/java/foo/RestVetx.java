package foo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class RestVetx extends AbstractVerticle {

	public static void main(String[] args) {
		Runner.runExample(RestVetx.class);
	}

	// private Map<String, JsonObject> products = new HashMap<>();
	private MongoClient client;

	@Override
	public void start() {

		// setUpInitialData();

		client = MongoClient.createShared(vertx, new JsonObject().put("db_name", "bgd_rota_urbana"));

		Router router = Router.router(vertx);
		router.route().handler(BodyHandler.create());

		router.put("/distanciarotaconsulta/:param").handler(this::handleAddDistanciaRotaConsulta);
		router.get("/distanciarotaconsultas").handler(this::handleDistanciaRotaConsulta);

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}

	private void handleAddDistanciaRotaConsulta(RoutingContext routingContext) {
		String productID = routingContext.request().getParam("param");
		HttpServerResponse response = routingContext.response();
		if (productID == null) {
			sendError(400, response);
		} else {
			JsonObject product = routingContext.getBodyAsJson();

			if (product == null) {
				sendError(400, response);
			} else {
				client.save("books", product, res -> {

					if (res.succeeded()) {

						String id = res.result();
						System.out.println("Saved book with id " + id);

					} else {
						res.cause().printStackTrace();
					}

				});
				// products.put(productID, product);
				response.end();
			}
		}
	}

	private void handleDistanciaRotaConsulta(RoutingContext routingContext) {
		JsonArray arr = new JsonArray();
		// products.forEach((k, v) -> arr.add(v));
		JsonObject query = new JsonObject();

		client.find("books", query, res -> {
			if (res.succeeded()) {
				for (JsonObject json : res.result()) {
					arr.add(json);
				}
			} else {
				res.cause().printStackTrace();
			}

		});

		routingContext.response().putHeader("content-type", "application/json").end(arr.encodePrettily());
	}

	private void sendError(int statusCode, HttpServerResponse response) {
		response.setStatusCode(statusCode).end();
	}

	private void setUpInitialData() {
		client = MongoClient.createShared(vertx, new JsonObject().put("db_name", "bgd_rota_urbana"));
		// addProduct(new JsonObject().put("id", "prod3568").put("name", "Egg
		// Whisk").put("price", 3.99).put("weight", 150));
		// addProduct(new JsonObject().put("id", "prod7340").put("name", "Tea
		// Cosy").put("price", 5.99).put("weight", 100));
		// addProduct(new JsonObject().put("id", "prod8643").put("name",
		// "Spatula").put("price", 1.00).put("weight", 80));
	}

	private void addProduct(JsonObject product) {
		// products.put(product.getString("id"), product);
		// client.save("books", product, res -> {
		//
		// if (res.succeeded()) {
		//
		// String id = res.result();
		// System.out.println("Saved product with id " + id);
		//
		// } else {
		// res.cause().printStackTrace();
		// }
		//
		// });
	}

	// private void handleGetProduct(RoutingContext routingContext) {
	// String productID = routingContext.request().getParam("productID");
	// HttpServerResponse response = routingContext.response();
	// if (productID == null) {
	// sendError(400, response);
	// } else {
	// JsonObject product = products.get(productID);
	// if (product == null) {
	// sendError(404, response);
	// } else {
	// response.putHeader("content-type",
	// "application/json").end(product.encodePrettily());
	// }
	// }
	// }
}
