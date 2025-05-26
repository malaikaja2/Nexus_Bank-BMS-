package com.bankmanagementsystem.service;

import com.bankmanagementsystem.dao.CustomerProfileDAO;
import com.bankmanagementsystem.model.CustomerProfile;

public class CustomerProfileService {
    private CustomerProfileDAO dao = new CustomerProfileDAO();

    public void createProfile(CustomerProfile profile) {
        dao.saveProfile(profile);
    }
}
