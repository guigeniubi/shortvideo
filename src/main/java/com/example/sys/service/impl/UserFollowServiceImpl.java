package com.example.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sys.entity.UserFollow;
import com.example.sys.mapper.UserFollowMapper;
import com.example.sys.service.IUserFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiniuteam
 * @since 2023-10-25
 */
@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow> implements IUserFollowService {

    @Autowired
    private UserFollowMapper userFollowMapper;
    @Override
    public boolean followUser(Integer followerId, Integer followedId) {
        UserFollow userFollow = new UserFollow();
        userFollow.setFollowerId(followerId);
        userFollow.setFollowedId(followedId);
        int result = userFollowMapper.insert(userFollow);
        return result > 0;
    }

    @Override
    public boolean unfollowUser(Integer followerId, Integer followedId) {
        QueryWrapper<UserFollow> query = new QueryWrapper<>();
        query.eq("follower_id", followerId).eq("followed_id", followedId);

        int result = userFollowMapper.delete(query);
        return result > 0;
    }

    @Override
    public List<Integer> getFollowersByUserId(Integer userId) {
        return userFollowMapper.getFollowersByUserId(userId);
    }

    @Override
    public boolean isAlreadyFollowing(Integer followerId, Integer followedId) {
        return userFollowMapper.checkFollowing(followerId, followedId) > 0;
    }
}
