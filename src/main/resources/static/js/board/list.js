function order(pnum) {
    var order = document.querySelector("#orderly").value;
    var pnumval = pnum;
    var searchval = document.querySelector("#searchval").value;
    const param = {
        "searchval": searchval,
        "order": order,
        "pnum": pnumval
    }
    const init = {
        method: 'POST',
        body: new URLSearchParams(param)
    }
    fetch('/board/page', init)
        .then(function (res) {
            return res.json();
        })
        .then(function (dividing) {
            fetch('/board/list', init)
                .then(function (res) {
                    return res.json();
                })
                .then(function (myJson) {
                    setdata(myJson, dividing);
                });
        });

}

function setdata(list, pagedividing) {
    let boardlist = document.querySelector("#board_lists");
    let pagelist = document.querySelector("#pagearr");
    boardlist.innerHTML = '';
    pagelist.innerHTML = '';
    for (var i = 0; i++ < pagedividing;) {
        pagelist.innerHTML += '<span class="pageSpan" onclick=order(' + i + ')>' + (i) + '</span>'
    }
    if (list.length == 0) {
        return;
    }
    let tb_board = document.createElement("table");
    let tr_fir = document.createElement("tr");
    tb_board.classList.add("tb_board");
    tr_fir.innerHTML = '  <th>번호</th>\n' +
        '                      <th>제목</th>\n' +
        '                      <th>작성자</th>\n' +
        '                      <th>작성일</th>\n' +
        '                      <th>조회</th>';
    tr_fir.classList.add("fir_tr");
    tb_board.append(tr_fir);
    for (let i = 0; i < list.length; i++) {
        let data = list[i];
        let tr_sec=document.createElement("tr");
        tr_sec.innerHTML = '  <td>'+data.board_no+'</td>\n' +
            '                      <td>'+data.title+'</td>\n' +
            '                      <td>'+data.user_no+'</td>\n' +
            '                      <td>'+data.regdt+'</td>\n' +
            '                      <td>'+data.views+'</td>';
        tr_sec.classList.add("sec_tr");
        tr_sec.addEventListener("click",
            function (){location.href='detail?board_no='+data.board_no});
        tb_board.append(tr_sec);
    }
    boardlist.append(tb_board);
}
