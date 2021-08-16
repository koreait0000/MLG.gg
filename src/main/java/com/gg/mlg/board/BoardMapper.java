package com.gg.mlg.board;

import com.gg.mlg.board.model.*;
import com.gg.mlg.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity param);
    List<BoardListDomain> selBoardList(SearchInfo param);
    BoardDomain selBoard(BoardEntity param);
    int viewsBoard(BoardEntity param);
    int dividePage(SearchInfo param);
    int delBoard(BoardEntity param);
    int upBoard(BoardEntity param);
    int insBoardImg(BoardimgEntity be);
    int delBoardImg(BoardEntity param);
    BoardimgEntity[] selBoardImg(BoardEntity param);
    UserEntity selLname(BoardEntity param);
}
