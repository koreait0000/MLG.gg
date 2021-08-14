function order(pnum) {
    currentpage = pnum;
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
    let datalist = document.querySelector("#datalist");
    let pagelist = document.querySelector("#pagearr");
    datalist.innerHTML = '';
    pagelist.innerHTML = '';
    for (var i = 0; i++ < pagedividing;) {
        pagelist.innerHTML += '<span onclick=order('+i+')>'+(i)+'</span>'
    }
    if (list.length == 0) {
        return;
    }
    for (let i = 0; i < list.length; i++) {
        let data = list[i];
        datalist.innerHTML +=
            `<tr>
                <td onclick='location.href="detail?board_no=${data.board_no}"'>${data.title}</td>
                <td>${data.user_no}</td>
                <td>${data.views}</td>
            </tr>`;
    }
}
