function order(psnum){
    console.log(psnum);
    var order=document.querySelector("#orderly").value;
    var psnumval=psnum;
    const param={
        order:order,
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
                <td onclick='location.href="detail?board_no=${data.board_no}"'>${data.title}</td>
                <td>${data.user_no}</td>
                <td>${data.views}</td>
            </tr>`;
    }

}
