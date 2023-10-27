package com.example.sys.controller;

import com.example.sys.entity.User;
import com.example.sys.service.IUserFavoriteService;
import com.example.sys.service.IUserFollowService;
import com.example.sys.service.IUserService;
import com.example.sys.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserFavoriteService userFavoriteService;
    @Autowired
    private IVideoService videoService;
    @Autowired
    private IUserFollowService userFollowService;
    @GetMapping("/all")
    public List<User> getAllUser(){
        List<User> list=userService.list();
        return list;
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        if (userService.checkPassword(user.getUsername(), user.getPassword())) {
            return "登录成功";
        } else {
            return "用户名或密码错误";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername());
        if (existingUser != null) {
            return "用户名已存在";
        }
        userService.register(user);
        return "注册成功";
    }

    @PostMapping("/favorite/{videoId}")
    public ResponseEntity<?> addUserFavorite(@RequestHeader("userId") Integer userId, @PathVariable("videoId") Integer videoId) {

        if(userFavoriteService.isVideoAlreadyFavorited(userId, videoId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Video is already favorited.");
        }
        boolean isAdded = userFavoriteService.addFavorite(userId, videoId);
        if (isAdded) {
            return ResponseEntity.ok("Video added to favorites successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to add video to favorites.");
        }
    }

    @PostMapping("/unfavorite/{videoId}")
    public ResponseEntity<?> unfavoriteVideo(@RequestHeader("userId") Integer userId, @PathVariable("videoId") Integer videoId) {
        boolean isUnfavorited = userFavoriteService.unfavoriteVideo(userId, videoId);
        if (isUnfavorited) {
            return ResponseEntity.ok("Video unfavorited successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to unfavorite video.");
        }
    }

    @GetMapping("/favorite/videos/urls")
    public ResponseEntity<List<String>> getFavoriteVideoUrls(@RequestHeader("userId") int userId) {
        List<String> videoUrls = userFavoriteService.getFavoriteVideoUrlsByUserId(userId);
        return ResponseEntity.ok(videoUrls);
    }

    @PostMapping("/follow/video/{videoId}")
    public ResponseEntity<?> followUserFromVideo(@RequestHeader("userId") Integer followerId, @PathVariable("videoId") Integer videoId) {
        //不能关注自己
        if(followerId == videoService.getUserIdByVideoId(videoId)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You cannot follow yourself.");
        }
        //不能重复关注
        if(userFollowService.isAlreadyFollowing(followerId, videoService.getUserIdByVideoId(videoId))) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You are already following this user.");
        }
        // 从视频ID获取视频作者的userId
        Integer followedId = videoService.getUserIdByVideoId(videoId);
        if (followedId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video or User not found.");
        }

        // 这里是关注的逻辑
        boolean isFollowed = userFollowService.followUser(followerId, followedId);
        if (isFollowed) {
            return ResponseEntity.ok("Followed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to follow user.");
        }
    }

    @PostMapping("/unfollow/video/{videoId}")
    public ResponseEntity<?> unfollowUserFromVideo(@RequestHeader("userId") Integer followerId, @PathVariable("videoId") Integer videoId) {
        Integer followedId = videoService.getUserIdByVideoId(videoId);
        if (followedId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Video or User not found.");
        }

        // 这里是取消关注的逻辑
        boolean isUnfollowed = userFollowService.unfollowUser(followerId, followedId);
        if (isUnfollowed) {
            return ResponseEntity.ok("Unfollowed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to unfollow user.");
        }
    }

    @GetMapping("/followers")
    public ResponseEntity<List<Integer>> getFollowers(@RequestHeader("userId") Integer userId) {
        List<Integer> followers = userFollowService.getFollowersByUserId(userId);
        return ResponseEntity.ok(followers);
    }

}
