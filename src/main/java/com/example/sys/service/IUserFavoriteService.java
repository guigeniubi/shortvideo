package com.example.sys.service;

import com.example.sys.entity.UserFavorite;
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
public interface IUserFavoriteService extends IService<UserFavorite> {

    boolean isVideoAlreadyFavorited(Integer userId, Integer videoId);
    public boolean addFavorite(Integer userId, Integer videoId);

    public boolean unfavoriteVideo(Integer userId, Integer videoId);
    public List<String> getFavoriteVideoUrlsByUserId(int userId);
}
