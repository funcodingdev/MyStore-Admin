package com.store.dao;

import com.store.domain.Admin;

import java.sql.SQLException;

public interface IAdminDao {
    Admin checkAdmin(String username, String password) throws SQLException;
}
