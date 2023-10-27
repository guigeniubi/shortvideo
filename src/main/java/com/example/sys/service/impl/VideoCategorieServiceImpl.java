package com.example.sys.service.impl;

import com.example.sys.entity.VideoCategorie;
import com.example.sys.mapper.UserMapper;
import com.example.sys.mapper.VideoCategorieMapper;
import com.example.sys.service.IVideoCategorieService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author qiniuteam
 * @since 2023-10-25
 */
@Service
public class VideoCategorieServiceImpl extends ServiceImpl<VideoCategorieMapper, VideoCategorie> implements IVideoCategorieService {
    @Autowired
    private VideoCategorieMapper videoCategorieMapper;

}
