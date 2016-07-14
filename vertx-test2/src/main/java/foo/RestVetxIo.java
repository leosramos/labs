package foo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.mongo.MongoClient;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

public class RestVetxIo extends AbstractVerticle {

	private MongoClient client;

	public static void main(String[] args) {
		Runner.runExample(RestVetxIo.class);
	}

	@Override
	public void start() {
		client = MongoClient.createShared(vertx, new JsonObject().put("db_name", "bgd_rota_urbana"));

		Router router = Router.router(vertx);
		router.route().handler(BodyHandler.create());

		router.get("/distanciarotaconsulta/:param").handler(this::handleAddDistanciaRotaConsulta);
		router.get("/distanciarotaconsultas").handler(this::handleDistanciaRotaConsulta);

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}

	private void handleAddDistanciaRotaConsulta(RoutingContext routingContext) {
		String parametro = routingContext.request().getParam("param");
		System.out.println("!!!!!!!!!!!!");
		HttpServerResponse response = routingContext.response();

//		if (parametro == null) {
//			sendError(400, response);
//		} else {
//			JsonObject elemento = routingContext.getBodyAsJson();
			JsonObject elemento = new JsonObject().put("id", "prod3522268").put("name", "EggWhisk").put("price", 3.99).put("weight", 150);
//			if (elemento == null) {
//				sendError(400, response);
//			} else {
				addElement(elemento);
				response.end();
//			}
//		}
	}

	/**
	 * @param product
	 */
	private void addElement(JsonObject product) {
		client.save("drc", product, res -> {
			if (res.succeeded()) {
				String id = res.result();
				System.out.println("Saved drc with id " + id);
			} else {
				res.cause().printStackTrace();
			}
		});

	}

	private void handleDistanciaRotaConsulta(RoutingContext routingContext) {
		JsonArray arr = new JsonArray();
		JsonObject query = new JsonObject();
		client.find("drc", query, res -> {
			if (res.succeeded()) {
				for (JsonObject json : res.result()) {
					arr.add(json);
				}
				routingContext.response().putHeader("content-type", "application/json").end(arr.encodePrettily());
			} else {
				res.cause().printStackTrace();
			}

		});
		

	}

	private void sendError(int statusCode, HttpServerResponse response) {
		response.setStatusCode(statusCode).end();
	}
}
