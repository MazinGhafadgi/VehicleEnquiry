package controllers

import model._
import play.api.Play.current
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._;

class Application extends Controller {

  def index = Action {
    Ok(views.html.index(current.configuration.getString("dvla.message1") match {
      case Some(x) => x
      case None => "'dvla.message1' must be configured in config file"
    }))
  }

  val vehicleSearchForm:Form[VehicleSearchCriteria] = Form{
    mapping("number" -> nonEmptyText, "make" -> nonEmptyText)(VehicleSearchCriteria.apply)(VehicleSearchCriteria.unapply)
  }

  def getVehicleDetails = Action { implicit  request =>
    val vehicleSearch = vehicleSearchForm.bindFromRequest().get
    print(vehicleSearch.number, vehicleSearch.make)

    val dao =new VehicleEnquiry() with StubVehicleLocator

    val vehicleDetails = dao.find(vehicleSearch.number, vehicleSearch.make)
    vehicleDetails match{
      case Some(v) => Ok(views.html.vehicle(v))
      case None =>  Ok(views.html.notFound(current.configuration.getString("dvla.message2") match {
        case Some(x) => x
        case None => "'dvla.message2' must be configured in config file"
      }))
    }
  }
}
