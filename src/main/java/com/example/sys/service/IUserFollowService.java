package com.example.sys.service;

import com.example.sys.entity.UserFollow;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qiniuteam
 * @since 2023-10-25
 */
public interface IUserFollowService extends IService<UserFollow> {
    public boolean followUser(Integer followerId, Integer followedId);
    public boolean unfollowUser(Integer followerId, Integer followedId);

    List<Integer> getFollowersByUserId(Integer userId);
    boolean isAlreadyFollowing(Integer followerId, Integer followedId);
}
