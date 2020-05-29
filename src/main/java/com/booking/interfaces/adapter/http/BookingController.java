package com.booking.interfaces.adapter.http;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.adapter.http.dto.ResponseBookingDTO;
import com.booking.interfaces.adapter.http.dto.RequestBookingDTO;
import com.booking.interfaces.adapter.http.exceptions.NoBookingFoundException;
import com.booking.usecases.CreateBooking;
import com.booking.usecases.DeleteBooking;
import com.booking.usecases.UpdateBooking;
import com.booking.usecases.GetBookings;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
@Api(value = "Bookings", tags = {"Bookings"})
public class BookingController {

    private final GetBookings getBookings;
    private final UpdateBooking updateBooking;
    private final DeleteBooking deleteBooking;
    private final CreateBooking createBooking;

    @ApiOperation(
            value = "Get bookings",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Bookings retrieved"),
            @ApiResponse(code = 404, message = "Bookings not found")
    })
    @GetMapping("/bookings")
    public ResponseEntity<List<ResponseBookingDTO>> getBookings() {

        final List<Booking> bookings = getBookings.execute();

        return ResponseEntity.status(HttpStatus.OK).body(ResponseBookingDTO.toResponseList(bookings));
    }


    @ApiOperation(
            value = "Get bookings with same id",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Bookings with same id retrieved"),
            @ApiResponse(code = 404, message = "Bookings with same ig not found")
    })
    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<ResponseBookingDTO> getBookingsById(@PathVariable final String bookingId) {

        final Booking bookingsWithSameId = getBookings.executeWith(bookingId);

        return ResponseEntity.status(HttpStatus.OK).body(ResponseBookingDTO.toResponse(bookingsWithSameId));
    }


    @ApiOperation(
            value = "Create booking",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Booking created"),
            @ApiResponse(code = 422, message = "Could not create booking"),
            @ApiResponse(code = 400, message = "Invalid request info"),
    })
    @PostMapping("/bookings")
    public ResponseEntity<ResponseBookingDTO> createBooking(
            @Valid @RequestBody final RequestBookingDTO requestBookingDTO) {

        final ResponseBookingDTO response = ResponseBookingDTO
                .toResponse(createBooking.execute(RequestBookingDTO.toEntity(requestBookingDTO)));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @ApiOperation(
            value = "Create booking",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Booking edited"),
            @ApiResponse(code = 422, message = "Could not edit booking"),
            @ApiResponse(code = 400, message = "Invalid request info"),
    })
    @PutMapping("/bookings/{bookingId}")
    public ResponseEntity<Void> editBooking(
            @RequestBody @Valid final RequestBookingDTO requestBookingDTO,
            @PathVariable final String bookingId) {

        updateBooking.execute(RequestBookingDTO.toEntity(requestBookingDTO), bookingId);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(
            value = "Delete booking",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Booking deleted with success"),
            @ApiResponse(code = 404, message = "Booking not found"),
            @ApiResponse(code = 412, message = "Invalid request info"),
            @ApiResponse(code = 500, message = "Internal server error"),
            @ApiResponse(code = 502, message = "An error occurred when communicating with external service")
    })
    @DeleteMapping("/bookings/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteBookingsById(@PathVariable final String bookingId) {

        deleteBooking.execute(bookingId);

        return ResponseEntity.noContent().build();
    }


}
