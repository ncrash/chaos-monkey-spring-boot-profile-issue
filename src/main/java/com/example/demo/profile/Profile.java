package com.example.demo.profile;

public enum Profile {
	LOCAL("local"), DEV("develop"), PROD("production");

	private String[] aliases;

	Profile(String... aliases) {
		this.aliases = aliases;
	}

	public static Profile find(String profile) {
		for (Profile each : values()) {
			if (each.name().equalsIgnoreCase(profile)) {
				return each;
			}

			for (String alias : each.getAliases()) {
				if (alias.equalsIgnoreCase(profile)) {
					return each;
				}
			}
		}
		throw new RuntimeException("unknown profile : " + profile);
	}

	public String[] getAliases() {
		return aliases;
	}
}
