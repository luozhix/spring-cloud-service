package cn.nice123.user.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.nice123.user.dataobject.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

	UserInfo findByOpenid(String openid);
}
