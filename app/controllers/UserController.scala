package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.libs.functional.syntax._

import models.{UserRepository}

@Singleton
class UserController @Inject()(userRepository: UserRepository,
                               cc: ControllerComponents)
  extends AbstractController(cc) {

  implicit val rds = (
    (__ \ 'name).read[String] and
    (__ \ 'email).read[String]
  ) tupled

  def create() = Action(parse.json) { request =>
    request.body.validate[(String, String)].map{
      case (name, email) => {
        userRepository.create(name, email, 1)
        Created("")
      }
    }.recoverTotal{
      e => BadRequest("Detected error:"+ JsError.toJson(e))
    }
  }

}
