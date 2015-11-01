package model

class VehicleEnquiry {
  this:VehicleLocator =>

  def find(number: String, make: String): Option[VehicleDetails] = {
    find(number, make)
  }
}

trait VehicleLocator{
  def find(number:String, make:String):Option[VehicleDetails]
}

trait StubVehicleLocator extends VehicleLocator{

  val vd1 = VehicleDetails("01 April 2016",
    "10 February 2016",
    "BMW",
    "RN51 YJM",
    "11 February 2002",
    "2002",
    "2171cc",
     Petrol,
    "226 g/km",
    "BLUE",
    "Tax not due",
    "M1",
    "2 AXLE RIGID BODY")

  val vd2 = VehicleDetails("13 May 2016",
    "31 October 2016",
    "MERCEDES-BENZ",
    "KM23 XZW",
    "11 June 2002",
    "2006",
    "2221cc",
    Diesel,
    "334 g/km",
    "Tax not due",
    "RED",
    "M1",
    "2 AXLE RIGID BODY")

  val key1 = ("RN51 YJM", "BMW")
  val key2 = ("KM23 XZW", "MERCEDES-BENZ")
  val carRepo = Map(key1 -> vd1, key2 -> vd2)


  override def find(number:String, make:String):Option[VehicleDetails] ={
    val key = (number, make)
    carRepo.get(key)
  }

}
