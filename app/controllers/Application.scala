package controllers

import java.util.UUID

import play.api._
import play.api.mvc._
import util.OAuth2
import scala.trace._

object Application extends Controller {

  def index: Action[AnyContent] = Action { implicit request =>
    Macro.codeOut(request)
    val oauth2 = new OAuth2(Play.current)
    val callbackUrl = util.routes.OAuth2.callback(None, None).absoluteURL()
    val scope = "repo"   // github scope - request repo access
    val state: String = UUID.randomUUID().toString  // random confirmation string
    Macro.codeOut(state)
    val redirectUrl: String = oauth2.getAuthorizationUrl(callbackUrl, scope, state)
    Ok(views.html.index("Your new application is ready.", redirectUrl)).
      withSession("oauth-state" -> state)
  }

}