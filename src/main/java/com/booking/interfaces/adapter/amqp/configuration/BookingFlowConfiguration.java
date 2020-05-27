package com.booking.interfaces.adapter.amqp.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BookingFlowConfiguration {

    @Bean
    Binding bindingFanOutMessageExchangeWithExchange(final FanoutExchange messageExchange,
                                                            final HeadersExchange bookingExchange) {
        return BindingBuilder
                .bind(bookingExchange)
                .to(messageExchange);
    }

    @Bean
    FanoutExchange messageExchange(@Value("${exchange.fanOut.messageExchange}") final String exchangeName) {
        return new FanoutExchange(exchangeName);
    }

    @Bean
    HeadersExchange bookingExchange(@Value("${exchange.headers.bookingExchange}") final String exchangeName) {
        return new HeadersExchange(exchangeName);
    }
}
