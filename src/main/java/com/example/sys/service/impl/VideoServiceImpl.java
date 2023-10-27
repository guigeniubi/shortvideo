package com.example.sys.service.impl;

import com.example.sys.entity.Video;
import com.example.sys.mapper.VideoMapper;
import com.example.sys.service.IVideoService;
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
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> getVideosByCategoryId(Integer categoryId) {
        List<Video> videos=this.baseMapper.selectVideosByCategoryId(categoryId);
        return videos;
    }

    @Override
    public Integer getUserIdByVideoId(Integer videoId) {
        return videoMapper.getUserIdByVideoId(videoId);
    }

    @Override
    public boolean likeVideo(Integer videoId) {
        Video video = videoMapper.selectById(videoId);
        if (video != null) {
            video.setLikes(video.getLikes() + 1);
            int result = videoMapper.updateById(video);
            return result > 0;
        }
        return false;
    }


}
