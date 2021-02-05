package com.example.demo.profile;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileFinder {
	private Profile profile;

	@Autowired
	public ProfileFinder(Environment environment) {
		String[] activeProfiles = environment.getActiveProfiles();
		Preconditions.checkNotNull(activeProfiles, "must have spring profile value.");
		Preconditions.checkState(activeProfiles.length > 0, "must have at least one profile value.");
		this.profile = Profile.find(activeProfiles[0]);
	}

	public Profile find() { return profile; }
}
