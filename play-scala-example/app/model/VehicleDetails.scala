package model

/**
 * Created by mazinghafadgi on 30/10/2015.
 */
case class VehicleDetails(taxDueDate: String, mot: String,
                          make: String,
                          registrationNumber: String,
                          yearofmanufacture: String,
                          cc: String, co2: String,
                          fuelType: FuelType,
                          status: String,
                          colour: String,
                          approvalType: String,
                          wheelPlan: String,
                          revenueWeight: String)

