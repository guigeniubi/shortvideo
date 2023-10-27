package com.example.sys.controller;

import com.example.sys.entity.Video;
import com.example.sys.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author qiniuteam
 * @since 2023-10-25
 */
@RestController
@RequestMapping("/video")
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Video>> getVideosByCategoryId(@PathVariable Integer categoryId) {
        List<Video> videos = videoService.getVideosByCategoryId(categoryId);
        return new ResponseEntity<>(videos, HttpStatus.OK);
    }

    @PostMapping("/{videoId}/like")
    public ResponseEntity<?> likeVideo(@PathVariable("videoId") Integer videoId) {
        boolean isLiked = videoService.likeVideo(videoId);
        if (isLiked) {
            return ResponseEntity.ok("Video liked successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to like video.");
        }
    }
}
