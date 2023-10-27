package com.example.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sys.entity.UserFavorite;
import com.example.sys.entity.Video;
import com.example.sys.mapper.UserFavoriteMapper;
import com.example.sys.service.IUserFavoriteService;
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
public class UserFavoriteServiceImpl extends ServiceImpl<UserFavoriteMapper, UserFavorite> implements IUserFavoriteService {

    @Autowired
    private UserFavoriteMapper userFavoriteMapper;

    @Override
    public boolean isVideoAlreadyFavorited(Integer userId, Integer videoId) {
        return userFavoriteMapper.checkVideoFavorite(userId, videoId) > 0;
    }

    @Override
    public boolean addFavorite(Integer userId, Integer videoId){
        UserFavorite userFavorite = new UserFavorite();
        userFavorite.setUserId(userId);
        userFavorite.setVideoId(videoId);
        int result = userFavoriteMapper.insert(userFavorite);
        return result > 0;
    }

    @Override
    public boolean unfavoriteVideo(Integer userId, Integer videoId) {
        QueryWrapper<UserFavorite> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId).eq("video_id", videoId);
        int result = userFavoriteMapper.delete(queryWrapper);

        return result > 0;
    }

    @Override
    public List<String> getFavoriteVideoUrlsByUserId(int userId){
        return userFavoriteMapper.selectFavoriteVideoUrlsByUserId(userId);
    }


}
