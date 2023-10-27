package com.example.sys.mapper;

import com.example.sys.entity.Video;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qiniuteam
 * @since 2023-10-25
 */
public interface VideoMapper extends BaseMapper<Video> {

    List<Video> selectVideosByCategoryId(Integer categoryId);

    Integer getUserIdByVideoId(Integer videoId);
}
