package com.reto01.simulador.constants;

public final class QueryStatement {

//   public static final String QUERY_STATIONS_AVAILABLE =
//       "SELECT * FROM STATION WHERE is_active = true;";

//   public static final String QUERY_QUANTITY_BIKES_BY_STATIONS_AVAILABLE =
//       "SELECT d.station_id, d.bike_id, b.type, b.brand, d.quantity, b.price_by_minute"
//           + " FROM DETAILSTATIONS d INNER JOIN BIKE b ON b.bike_id = d.bike_id WHERE d.station_id = :station_id;";

  public static final String QUERY_INSERT_BOOKING =
      "INSERT INTO BOOKING(is_canceled, created_at, user_id, bike_id) VALUES(false, ?, ?, ?)";

  public static final String QUERY_INSERT_RENTAL_DETAILS =
      "INSERT INTO RENTALDETAILS(booking_id, origin_station_id, destination_station_id, start_date, end_date) "
      + "VALUES((SELECT BOOKING_ID FROM BOOKING WHERE CREATED_AT = ? AND USER_ID = ? AND is_canceled = false), ?, ?, ?, ?)";

//   public static final String QUERY_RENTS_HISTORY_BY_USER =
//       "SELECT b.booking_id, b.created_at, d.start_date, d.end_date, so.station_id as origin_id, so.name as origin_name, "
//           + "so.location as origin_location, dt.station_id as destination_id, dt.name as destination_name, "
//           + "dt.location as destination_location, k.bike_id, k.type, k.brand, k.price_by_minute FROM booking b "
//           + "inner join rentaldetails d on b.booking_id = d.booking_id inner join station so "
//           + "on d.origin_station_id = so.station_id inner join station dt "
//           + "on d.destination_station_id = dt.station_id inner join bike k on b.bike_id = k.bike_id"
//           + " WHERE b.is_canceled = false AND user_id = :user_id";

  public static final String QUERY_BIKE_RENTAL_BY_BOOKING =
      "SELECT b.booking_id, b.created_at, d.start_date, d.end_date, so.station_id as origin_id, so.name as origin_name, "
          + "so.location as origin_location, dt.station_id as destination_id, dt.name as destination_name, "
          + "dt.location as destination_location, k.bike_id, k.type, k.brand, k.price_by_minute FROM booking b "
          + "inner join rentaldetails d on b.booking_id = d.booking_id inner join station so "
          + "on d.origin_station_id = so.station_id inner join station dt "
          + "on d.destination_station_id = dt.station_id inner join bike k on b.bike_id = k.bike_id"
                  + " WHERE b.booking_id = ? AND b.is_canceled IN  (false, null);";

  public static final String QUERY_UPDATE_DESTINATION_STATION_BOOKING =
      "UPDATE rentaldetails SET "
          + "destination_station_id = ? WHERE booking_id = ?";

  public static final String QUERY_CANCELLING_BOOKING =
          "DELETE FROM RENTALDETAILS WHERE booking_id = ?; DELETE FROM booking WHERE booking_id = ?";
}
