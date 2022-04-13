package com.hanghae.dogfootbirdfoot_be.controller;

import com.hanghae.dogfootbirdfoot_be.model.Comment;
import com.hanghae.dogfootbirdfoot_be.model.Post;
import com.hanghae.dogfootbirdfoot_be.security.UserDetailsImpl;
import com.hanghae.dogfootbirdfoot_be.service.CommentService;
import com.hanghae.dogfootbirdfoot_be.service.PostService;
import com.hanghae.dogfootbirdfoot_be.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MyPageController {

    private final PostService postService;
    private final CommentService commentService;
    private final UserService userService;

    @GetMapping("/mypage")
    public HashMap findUser(@AuthenticationPrincipal  UserDetailsImpl userDetails){
        if (userDetails == null){
            throw new BadCredentialsException("회원 정보를 찾을 수 없습니다.");
        }
        return userService.findUser(userDetails.getUsername());
    }

    //내가 작성한 게시물 가져오기.
    @GetMapping("/mypage/mypost")
    public Map<String, Object> getMypost(@AuthenticationPrincipal UserDetailsImpl userDetails) throws BadCredentialsException {
        Post post = postService.getMypostLists(userDetails.getUser().getUserId());
        Map<String, Object> result = new HashMap<>();

        result.put("postId", post.getId());
        result.put("postTitle", post.getPostTitle());
        result.put("createdAt", post.getCreatedAt());

        return result;
    }
    //내 댓글 조회 2022-04-13
    @GetMapping("/mypage/mycomment")
    public Map<String, Object> getMycomment(@AuthenticationPrincipal UserDetailsImpl userDetails) throws BadCredentialsException {
        Comment comment = commentService.getMycommentLists(userDetails.getUser().getUserId());
        Map<String, Object> result = new HashMap<>();

        result.put("postId", comment.getPostId());
        result.put("commentId", comment.getId());
        result.put("comment", comment.getComments());
        result.put("createdAt", comment.getCreatedAt());

        return result;
    }

//    @GetMapping("/api/mypage/{userId}/mypost")
//    public List<Post> getMyposts(@PathVariable Long userId){
//        return postService.getMyposts(userId);
//    }

    //내가 작성한 댓글 가져오기.
//    @GetMapping("/mypage/mycomment")
//    public Page<Comment> getMyComments(@AuthenticationPrincipal UserDetailsImpl userDetails){
//        return commentService.getMyComments(userDetails.getUser());
//    }

//    @GetMapping("/api/mypage/{userId}/mycomment")
//    public List<Comment> getMyComments(@PathVariable Long userId){
//        return commentService.getMyComments(userId);
//    }
//    @PostMapping(value = "/userProfile", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
//    public ResponseEntity<?> addFiles(MultipartFile file){
//        return ResponseEntity.ok(null);
//    }
//
//    public void saveFiole(MultipartFile file, String directoryPath) throws IOException {
//        // parent directory를 찾는다.
//        Path directory = Paths.get(directoryPath).toAbsolutePath().normalize();
//
//        // directory 해당 경로까지 디렉토리를 모두 만든다.
//        Files.createDirectories(directory);
//
//        // 파일명을 바르게 수정한다.
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//
//        // 파일명에 '..' 문자가 들어 있다면 오류를 발생하고 아니라면 진행(해킹및 오류방지)
//        Assert.state(!fileName.contains(".."), "Name of file cannot contain '..'");
//        // 파일을 저장할 경로를 Path 객체로 받는다.
//        Path targetPath = directory.resolve(fileName).normalize();
//
//        // 파일이 이미 존재하는지 확인하여 존재한다면 오류를 발생하고 없다면 저장한다.
//        Assert.state(!Files.exists(targetPath), fileName + " File alerdy exists.");
//        file.transferTo(targetPath);
//    }

//    @PostMapping("/mypage/userProfile")
//    public ModelAndView photoUpload()
//





}
