package com.store.service;

import com.store.domain.Admin;

import java.sql.SQLException;

public interface IAdminService {
    Admin login(String username, String password) throws Exception;
}
