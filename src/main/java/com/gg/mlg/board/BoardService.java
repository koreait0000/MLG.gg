package com.gg.mlg.board;

import com.gg.mlg.board.model.BoardDomain;
import com.gg.mlg.board.model.BoardEntity;
import com.gg.mlg.board.model.BoardimgEntity;
import com.gg.mlg.board.model.SearchInfo;
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

    public List<BoardEntity> selBoardList(SearchInfo param) {
        return mapper.selBoardList(param);
    }

    public int insUpBoard(BoardEntity param, MultipartFile[] boardimg, int what) {

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
        System.out.println(boardimg);
        if (result !=0 && boardimg != null) {
            System.out.println(1);
            BoardimgEntity be = new BoardimgEntity();
            be.setBoard_no(param.getBoard_no());
            String target = "board/" + param.getBoard_no();
            for (MultipartFile img : boardimg) {
                System.out.println(2);
                String saveFileNm = myFileUtils.transferTo(img, target);
                if (saveFileNm != null) { //이미지 정보 DB에 저장
                    System.out.println(3);
                    be.setImg(saveFileNm);
                    mapper.insBoardImg(be);
                }
            }
        }
        return result;
    }

    public BoardDomain selBoard(BoardEntity param) {
        mapper.viewsBoard(param);
        return mapper.selBoard(param);
    }

    public int dividePage(SearchInfo param) {
        return mapper.dividePage(param);
    }

    public int delBoard(BoardEntity param) {
        mapper.delBoardImg(param);
        return mapper.delBoard(param);
    }

}
