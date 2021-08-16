package com.gg.mlg.board;

import com.gg.mlg.board.model.*;
import com.gg.mlg.common.MyFileUtils;
import com.gg.mlg.security.AuthenticationFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper mapper;
    @Autowired
    private AuthenticationFacadeImpl auth;
    @Autowired
    private MyFileUtils myFileUtils;

    public List<BoardListDomain> selBoardList(SearchInfo param) {
        return mapper.selBoardList(param);
    }

    public int insUpBoard(BoardEntity param, MultipartFile[] boardimg, int what) {
        System.out.println(param);
        param.setUser_no(auth.getLoginUserPk());
        int result=0;
        switch (what) {
            case 0:
                result = mapper.insBoard(param);
                break;
            case 1:
                result = mapper.upBoard(param);
                break;
        }
        System.out.println(result);
        System.out.println(param);
        if (result !=0 && boardimg.length>0) {
            BoardimgEntity bie = new BoardimgEntity();
            bie.setBoard_no(param.getBoard_no());
            String target = "board/" + param.getBoard_no();
            for (MultipartFile img : boardimg) {
                String saveFileNm = myFileUtils.transferTo(img, target);
                if (saveFileNm != null) { //이미지 정보 DB에 저장
                    bie.setImg(saveFileNm);
                    mapper.insBoardImg(bie);
                }else {
                    myFileUtils.delFolders( myFileUtils.getSavePath(target));
                    mapper.delBoardImg(param);
                }
            }
        }
        return result;
    }

    public BoardDomain selBoard(BoardEntity param) {
        mapper.viewsBoard(param);
        BoardDomain bd=mapper.selBoard(param);
        bd.setImgArr(mapper.selBoardImg(param));
        bd.setLname(mapper.selLname(bd).getLname());
        return bd;
    }

    public int dividePage(SearchInfo param) {
        return mapper.dividePage(param);
    }

    public int delBoard(BoardEntity param) {
        String target = "board/" + param.getBoard_no();
        myFileUtils.delFolders( myFileUtils.getSavePath(target));
        mapper.delBoardImg(param);
        return mapper.delBoard(param);
    }

}
