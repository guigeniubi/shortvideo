package com.example.sys.service;

import com.example.sys.entity.Video;
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
public interface IVideoService extends IService<Video> {
    List<Video> getVideosByCategoryId(Integer categoryId);

    Integer getUserIdByVideoId(Integer videoId);
    public boolean likeVideo(Integer videoId);
}
