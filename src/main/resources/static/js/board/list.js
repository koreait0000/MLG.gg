function order(psnum){
    console.log(psnum);
    var order=document.querySelector("#orderly").value;
    var pcnt=document.querySelector("#pcnt").value;
    var psnumval=psnum;
    const param={
        order:order,
        pcnt:pcnt,
        psnum:psnumval
    }
    const init={
        method:'POST',
        body: new URLSearchParams(param)
    }
    fetch('/board/page',init)
        .then(function (res){
            return res.json();})
        .then(function (dividing){
        fetch('/board/list',init)
            .then(function(res){return res.json();})
            .then(function(myJson){
                console.log(myJson);
                setdata(myJson,dividing);
            });
        });

}

function setdata(list,pagedividing){
    var datalist= document.querySelector("#datalist");
    var page= document.querySelector("#page");
    datalist.innerHTML='';
    page.innerHTML='';
    for(let i=0;i<pagedividing;i++){
        page.innerHTML+=`<span onclick="order(${i+1})">${i+1}</span>`
    }
    if(list.length==0){return;}
    for(let i=0;i<list.length;i++){
        let data=list[i];
        datalist.innerHTML+=
            `<tr>
                <td>${data.board_no}</td>
                <td onclick='location.href="detail?board_no=${data.board_no}"'>${data.title}</td>
                <td>${data.regdt}</td>
                <td>${data.user_no}</td>
                <td>${data.views}</td>
            </tr>`;
    }

}
