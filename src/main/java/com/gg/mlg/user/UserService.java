package com.gg.mlg.user;

import com.gg.mlg.common.MyFileUtils;
import com.gg.mlg.security.IAuthenticationFacade;
import com.gg.mlg.user.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private FollowMapper followMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAuthenticationFacade auth;

    @Autowired
    private MyFileUtils myFileUtils;

    public void inJoin(UserEntity param) {
        String hashedPw = passwordEncoder.encode(param.getUpw());
        param.setUpw(hashedPw);
        mapper.inJoin(param);
    }

    public UserEntity selUser(UserEntity param) {
        return mapper.selUser(param);
    }

//
//    public void profileImg(MultipartFile[] imgArr) {
//        UserEntity loginUser = auth.getLoginUser();
//        int user_no = loginUser.getUser_no();
//
//        System.out.println("user_no : " + user_no);
//        String target = "profile/" + user_no;
//
//        UserProfileEntity param = new UserProfileEntity();
//        param.setUser_no(user_no); //11
//
//        for (MultipartFile img : imgArr) {
//            String saveFileNm = myFileUtils.transferTo(img, target); //"weioj435lknsio.jpg"
//            if (saveFileNm != null) {
//                param.setProfile_img(saveFileNm);
//                if (profileMapper.insUserProfile(param) == 1 && loginUser.getMainProfile() == null) {
//                    UserEntity param2 = new UserEntity();
//                    param2.setUser_no(user_no); //11
//                    param2.setMainProfile(saveFileNm);
//
//                    if (mapper.updUser(param2) == 1) {
//                        loginUser.setMainProfile(saveFileNm);
//                    }
//                }
//            }
//        }
//    }
//
//    public List<UserProfileEntity> selUserProfileList(UserEntity param) {
//        return profileMapper.selUserProfileList(param);
//    }
//
//    //메인 이미지 변경
//    public Map<String, Object> updUserMainProfile(UserProfileEntity param) {
//        UserEntity loginUser = auth.getLoginUser();
//
//        param.setUser_no(loginUser.getUser_no());
//        int result = mapper.updUserMainProfile(param);
//        if (result == 1) { //시큐리티 세션에 있는 loginUser에 있는 mainProfile값도 변경해주어야 한다.
//            System.out.println("img : " + param.getProfile_img());
//            loginUser.setMainProfile(param.getProfile_img());
//        }
//        Map<String, Object> res = new HashMap();
//        res.put("result", result);
//        res.put("img", param.getProfile_img());
//        return res;
//    }

    List<UserEntity> selfollow(UserEntity param) {
        return followMapper.selfollow(param);
    }
    List<UserEntity> selfollowing(UserEntity param) {
        UserEntity search_user=mapper.selUser(param);
        return followMapper.selfollowing(search_user);
    }

    public int indelfollow(UserEntity param) {
        if(followMapper.searchfollow(param)==0){
            followMapper.infollow(param);
            return 1;//ins
        }
        followMapper.delfollow(param);
        return 0;//del
    }

    public int selWriteCnt(int user_no) {
        int writeCnt = mapper.selWriteCnt(user_no);
        System.out.println(user_no);
        System.out.println(writeCnt);
        return writeCnt;
    }
}
