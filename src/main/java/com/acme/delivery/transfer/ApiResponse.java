package com.acme.delivery.transfer;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
@Builder
public class ApiResponse<T> implements Serializable {

	transient T data;

	ApiError apiError;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss.SSS")
	LocalDateTime timestamp = LocalDateTime.now();
}
