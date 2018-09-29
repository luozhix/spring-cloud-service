package cn.nice123.user.service;

import cn.nice123.user.dataobject.UserInfo;

public interface UserService {

	UserInfo findByOpenid(String openid);
}
