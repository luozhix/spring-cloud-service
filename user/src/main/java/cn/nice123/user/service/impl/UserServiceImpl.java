package cn.nice123.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.nice123.user.dataobject.UserInfo;
import cn.nice123.user.repositiry.UserInfoRepository;
import cn.nice123.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo findByOpenid(String openid) {
		return userInfoRepository.findByOpenid(openid);
	}

}
