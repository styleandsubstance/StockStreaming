package controllers;

import actors.UserStockStreamingActor
import play.api.mvc._
import play.api.libs.streams.ActorFlow
import javax.inject.Inject
import akka.actor.ActorSystem
import akka.stream.Materializer

class WebSocketController @Inject() (cc:ControllerComponents) (implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {

  def socket = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { out =>
      UserStockStreamingActor.props(out)
    }
  }

}
