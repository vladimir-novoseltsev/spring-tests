package com.raikiri.mapper.test.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionResource {

	public class Version {
		private final String version;

		public Version(String version) {
			this.version = version;
		}

		public String getVersion() {
			return version;
		}
	}

	@GetMapping(path = "/api/version")
	public Version version() {
		return new Version("1.0");
	}

}
