package com.zero.programmer.be.rent.vehicle;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
		title = "Rent Vehicle Service API",
		version = "1.0",
		description = "Rent Vehicle Service Information")
)
public class BeRentVehicleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeRentVehicleApplication.class, args);
	}

}
