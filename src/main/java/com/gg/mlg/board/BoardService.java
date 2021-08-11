package com.gg.mlg.board;

import com.gg.mlg.board.model.BoardDomain;
import com.gg.mlg.board.model.BoardEntity;
import com.gg.mlg.board.model.SearchInfo;
import com.gg.mlg.security.AuthenticationFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private  BoardMapper mapper;
    @Autowired
    private AuthenticationFacadeImpl auth;

    public List<BoardEntity> selBoardList(SearchInfo param) {
        return mapper.selBoardList(param);
    }
    public int insBoard(BoardEntity param){
        param.setUser_no(auth.getLoginUserPk());
        return mapper.insBoard(param);
    }

    public BoardDomain selBoard(BoardEntity param) {
        mapper.viewsBoard(param);
        return mapper.selBoard(param);
    }

    public int dividePage(SearchInfo param) {
        return mapper.dividePage(param);
    }

    public int delBoard(BoardEntity param) {
        return mapper.delBoard(param);
    }

    public int upBoard(BoardEntity param){
        return mapper.upBoard(param);
    }
}
