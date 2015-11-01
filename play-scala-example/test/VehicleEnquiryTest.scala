import model.{VehicleEnquiry, StubVehicleLocator}
import org.specs2.mutable.Specification

class VehicleEnquiryTest extends Specification {

  val vehicleReo = new VehicleEnquiry() with StubVehicleLocator

  "The vehicle enquiry " should {
    "find the vehicle details " in {
      val vehicleDetails = vehicleReo.find("RN51 YJM", "BMW")
      (vehicleDetails isDefined) mustEqual true
    }
  }

  "The vehicle enquiry " should {
    "not find the vehicle details " in {
      val vehicleDetails = vehicleReo.find("XXX", "XXX")
      (vehicleDetails isDefined) mustEqual false
    }
  }

}