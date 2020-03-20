package org.easyweb.service;

import org.easyweb.model.UserModel;

public interface UserService {
    void InsertByUser(UserModel user);
    void DeleteByName(UserModel user);
    void UpdateByName(UserModel user);
    UserModel SelectByName(UserModel user);
}
