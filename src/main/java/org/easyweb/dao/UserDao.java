package org.easyweb.dao;

import org.easyweb.model.UserModel;

public interface UserDao {
    void InsertByUser(UserModel user);
    void DeleteByName(UserModel user);
    void UpdateByName(UserModel user);
    UserModel SelectByName(UserModel user);
}
