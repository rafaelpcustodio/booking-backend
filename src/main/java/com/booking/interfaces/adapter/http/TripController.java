package com.booking.interfaces.adapter.http;

import com.booking.entity.booking.Booking;
import com.booking.entity.trip.Trip;
import com.booking.interfaces.adapter.http.dto.RequestBookingDTO;
import com.booking.interfaces.adapter.http.dto.RequestTripDTO;
import com.booking.interfaces.adapter.http.dto.ResponseBookingDTO;
import com.booking.interfaces.adapter.http.dto.ResponseTripDTO;
import com.booking.usecases.CreateTrip;
import com.booking.usecases.GetBooking;
import com.booking.usecases.GetTrip;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Api(value = "Trips", tags = {"Trips"})
public class TripController {

  private final GetTrip getTrip;
  private final CreateTrip createTrip;

  @ApiOperation(
      value = "Get trips",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "trips retrieved"),
      @ApiResponse(code = 404, message = "trips not found")
  })
  @GetMapping("/trips")
  public ResponseEntity<List<ResponseTripDTO>> getTrips() {
    final List<Trip> trips = getTrip.execute();

    return ResponseEntity.status(HttpStatus.OK).body(ResponseTripDTO.toResponseList(trips));
  }

  @ApiOperation(
      value = "Create trip",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Trip created"),
      @ApiResponse(code = 422, message = "Could not create trip"),
      @ApiResponse(code = 400, message = "Invalid request info"),
  })
  @PostMapping("/trips")
  public ResponseEntity<ResponseTripDTO> createTrip(
      @Valid @RequestBody final RequestTripDTO requestTripDTO) {

    final ResponseTripDTO response = ResponseTripDTO
        .toResponse(createTrip.execute(RequestTripDTO.toEntity(requestTripDTO)));

    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

}
