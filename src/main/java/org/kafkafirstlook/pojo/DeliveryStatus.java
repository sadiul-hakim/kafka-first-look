package org.kafkafirstlook.pojo;


import java.time.ZonedDateTime;

public record DeliveryStatus(String message, ZonedDateTime zonedDateTime) {
}
