/*--------------------------chat------------------------*/
function openChat(){
    var chatmodal=document.querySelector("#chatting_modal");
    chatmodal.style.bottom="5%";
}
function closeChat(){
    var chatmodal=document.querySelector("#chatting_modal");
    chatmodal.style.bottom="-5%";
}

var ws;
function wsOpen() {
    ws = new WebSocket("ws://" + location.host + "/chating");
    wsEvt();
}
function wsEvt() {
    ws.onopen = function(data) {
        //소켓이 열리면 초기화
    }
    ws.onmessage = function(data) {
        var msg = data.data;
        if (msg != null && msg.trim() != "") {
            $("#chating").append("<p>" + msg + "<p>");
        }
    }
    document.addEventListener("keypress", function(e){
        if(e.keyCode == 13) { //enter press
            send();
        }
    });
}
function chatName() {
    var userName = document.querySelector('#userName');
    if(userName == null) {
        alert("사용자 이름을 입력해주세요.");
    } else {
        wsOpen();
        document.getElementById("yourName").style.display='none';
        document.getElementById("yourMsg").style.display='block';
    }
}

function send() {
    var uN = $("#userName").val();
    var msg = $("#chatting").val();
    ws.send(uN+":"+msg);
    $('#chatting').val("");
}

/*-----------------------sidebar--------------------------------------*/
const gnb1 = document.getElementById('gnb');
const gnb2 = document.getElementById('hero-left');
let isfixed=false;
window.addEventListener('scroll',function (){
    let scrllVal=window.scrollY;
    let gtt = document.querySelector('.ss-go-top');
    let sfm = document.querySelector('.scroll-link');
    let headVal=document.querySelector("#s-head");

    console.log(scrllVal);
    if(scrllVal==0){
        gtt.style.opacity=0;
        gtt.style.visibility='hidden';
        sfm.style.visibility = 'visible';
        sfm.style.opacity = 1;
        headVal.style.position='relative';
        headVal.style.background='rgba(0,0,0,1)';
        isfixed=false;
    }

    if(scrllVal>0){
        if(!isfixed){
            headVal.style.position='fixed';
            isfixed=true;
            headVal.style.background='rgba(0,0,0,0.6)';
        }
        gtt.style.opacity=1;
        gtt.style.visibility='visible';
        sfm.style.visibility = 'hidden';
        sfm.style.opacity = 0;
        console.log(scrllVal);
    }
});
gnb1.addEventListener('mouseover', function (){
    // gnb2.style.display='block';
    gnb2.style.visibility='visible';
    gnb2.style.opacity=1;

    gnb1.style.backgroundColor='#037c82';
})

function closeSideBar() {
    gnb2.style.visibility='hidden';
    gnb2.style.opacity=0;
    gnb1.style.background='rgba(0,0,0,0.5)';
}
function movesmooth(goto){
    if(goto=="heaven"){
        window.scrollTo({top:0,left:0,behavior:"smooth"});
    }
    if(goto=="hell"){
        window.scrollTo({top:document.querySelector("body").scrollHeight,left:0,behavior:"smooth"});
    }
}