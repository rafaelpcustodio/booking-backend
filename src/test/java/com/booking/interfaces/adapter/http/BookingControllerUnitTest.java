package com.booking.interfaces.adapter.http;

import com.booking.entity.booking.Booking;
import com.booking.interfaces.adapter.http.dto.RequestBookingDTO;
import com.booking.interfaces.adapter.http.dto.ResponseBookingDTO;
import com.booking.interfaces.adapter.http.fixture.BookingFixture;
import com.booking.interfaces.adapter.http.fixture.RequestBookingDTOFixture;
import com.booking.interfaces.adapter.http.fixture.ResponseBookingDTOFixture;
import com.booking.interfaces.adapter.serialization.JacksonConfiguration;
import com.booking.usecases.CreateBooking;
import com.booking.usecases.DeleteBooking;
import com.booking.usecases.UpdateBooking;
import com.booking.usecases.GetBooking;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BookingControllerUnitTest {
    @Mock
    private GetBooking getBooking;
    @Mock
    private UpdateBooking updateBooking;
    @Mock
    private DeleteBooking deleteBooking;
    @Mock
    private CreateBooking createBooking;
    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new JacksonConfiguration().objectMapper();
    private static final String BOOKING_ID = "5c38e1e7-25a2-4411-abbf-d529775c60c6";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        BookingController bookingController = new BookingController(getBooking, updateBooking, deleteBooking, createBooking);
        mockMvc = MockMvcBuilders.standaloneSetup(bookingController).build();
    }

    @Test
    @DisplayName("Should get all bookings")
    public void shouldReturnOkStatusWithAllBookings() throws Exception {
        final List<ResponseBookingDTO> response = ResponseBookingDTOFixture.validBookings();
        final List<Booking> bookingEntities = BookingFixture.validBookingEntities();
        when(getBooking.execute()).thenReturn(bookingEntities);
        mockMvc.perform(get("/api/v1/bookings"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(response)));
    }


    @Test
    @DisplayName("Should get bookings by id")
    public void shouldReturnOkStatusWithAllBookingsById() throws Exception {
        final ResponseBookingDTO response = ResponseBookingDTOFixture.validBooking();
        final Booking bookingEntity = BookingFixture.validBooking();
        when(getBooking.executeWith(BOOKING_ID)).thenReturn(bookingEntity);
        mockMvc.perform(get("/api/v1/bookings/" + BOOKING_ID))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    @DisplayName("Should create a booking")
    public void shouldCreateOneBooking() throws Exception {
        final Booking booking = BookingFixture.validBooking();
        final RequestBookingDTO request = RequestBookingDTOFixture.validBooking();
        final ResponseBookingDTO response = ResponseBookingDTOFixture.validBooking();;
        when(createBooking.execute(any())).thenReturn(booking);
        mockMvc.perform(post("/api/v1/bookings")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    @DisplayName("Should delete a booking")
    public void shouldDeleteOneBooking() throws Exception {
        doNothing().when(deleteBooking).execute(eq(BOOKING_ID));
        mockMvc.perform(delete("/api/v1/bookings/" + BOOKING_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
        verify(deleteBooking, times(1)).execute(BOOKING_ID);
    }
}
