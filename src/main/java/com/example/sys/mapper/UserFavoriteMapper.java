package com.example.sys.mapper;

import com.example.sys.entity.UserFavorite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sys.entity.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qiniuteam
 * @since 2023-10-25
 */
public interface UserFavoriteMapper extends BaseMapper<UserFavorite> {

    List<String> selectFavoriteVideoUrlsByUserId(Integer userId);
    int checkVideoFavorite(Integer userId, Integer videoId);

}
