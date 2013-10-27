package gatling

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import io.gatling.http.Headers.Names._
import scala.concurrent.duration._
import bootstrap._
import assertions._

class PetClinicSimulation extends Simulation {

  val httpProtocol = http.baseURL(System.getProperty("base.url", "http://localhost:8080/petclinic")).disableFollowRedirect

val scn = scenario("Basic Load Test Scenario")
  .group("Find Owner") {
    exec( http("request_1") .get("/") .check(status.is(200)))
    .exec( http("request_2") .get("/owners/find.html") .check(status.is(200)))
    .exec( http("request_3") .get("/owners.html").queryParam("lastName", "von Essen") .check(status.is(200)))
  }

  setUp(scn.inject(ramp(3 users) over (10 seconds)))
    .protocols(httpProtocol)
      .assertions(
        global.successfulRequests.percent.is(100), details("Find Owner" / "request_1").responseTime.max.lessThan(2000))
}
