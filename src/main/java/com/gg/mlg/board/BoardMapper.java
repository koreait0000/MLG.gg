package com.gg.mlg.board;

import com.gg.mlg.board.model.BoardDomain;
import com.gg.mlg.board.model.BoardEntity;
import com.gg.mlg.board.model.SearchInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity param);
    List<BoardEntity> selBoardList(SearchInfo param);
    BoardDomain selBoard(BoardEntity param);
    int viewsBoard(BoardEntity param);
    int dividePage(SearchInfo param);
    int delBoard(BoardEntity param);
    int upBoard(BoardEntity param);
}
