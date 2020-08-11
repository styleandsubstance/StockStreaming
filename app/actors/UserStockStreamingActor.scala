package actors

import akka.actor._

object UserStockStreamingActor {
  def props(out: ActorRef) = Props(new UserStockStreamingActor(out))
}

class UserStockStreamingActor(out: ActorRef) extends Actor {






  def receive = {
    case msg: String =>
      out ! ("I received your message: " + msg + " " + this.self.path.name)
  }

//  def junk = {
//    context.system.scheduler.schedule
//  }

}
