package com.bankmanagementsystem.dao;

import com.bankmanagementsystem.model.CustomerProfile;
import java.util.ArrayList;
import java.util.List;

public class CustomerProfileDAO {
    private static List<CustomerProfile> profiles = new ArrayList<>();

    // Save profile to "database" (for demo, just add to list)
    public void saveProfile(CustomerProfile profile) {
        profiles.add(profile);
    }

    public List<CustomerProfile> getAllProfiles() {
        return profiles;
    }
}
