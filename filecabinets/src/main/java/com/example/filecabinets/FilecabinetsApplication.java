package com.example.filecabinets;

import com.example.filecabinets.Util.TokenThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilecabinetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilecabinetsApplication.class, args);
		new Thread(new TokenThread()).start();
	}
}
