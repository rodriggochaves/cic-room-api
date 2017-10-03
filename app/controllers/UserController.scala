package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import models.{UserRepository}

@Singleton
class UserController @Inject()(userRepository: UserRepository,
                               cc: ControllerComponents) 
  extends AbstractController(cc) {

  def create() = Action { request =>
    userRepository.create("diogo", "diogo@email.com")
    Ok("Got request [" + request + "]")
  }

}