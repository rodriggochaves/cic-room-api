package models

import javax.inject.{ Inject, Singleton }
import play.api.db.slick.DatabaseConfigProvider
import slick.jdbc.JdbcProfile
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

case class User(id: Int, name: String, email: String, role: Int)

class UserRepository @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  val db = dbConfig.db
  import dbConfig.profile.api._
  private val users = TableQuery[UsersTable]

  def create(name: String, email: String, role: Int) : Future[String] = {
    val user = User(2, name, email, role)
    dbConfig.db.run(users += user).map(res => "User successfully added").recover {
      case ex: Exception => ex.getCause.getMessage
    }
  }

  private class UsersTable(tag: Tag) extends Table[User](tag, "users") {
    def id = column[Int]("id", O.AutoInc, O.PrimaryKey)
    def name = column[String]("name")
    def email = column[String]("email")
    def role = column[Int]("role")

    def * = (id, name, email, role) <> (User.tupled, User.unapply)
  }
}
