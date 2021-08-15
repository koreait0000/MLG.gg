/*-----------------------------declaration----------------------------------*/
const gnb1 = document.getElementById('gnb');
const gnb2 = document.getElementById('hero-left');
let isfixed = false;
let ischaton=false;

/*--------------------------------chat-------------------------------------*/
var ws;
function openChat() {
    if(ischaton==false){
        wsOpen();
        ischaton=true;
    }
    var chatmodal = document.querySelector("#chatting_modal");
    var chatcontent = document.querySelector("#chating");
    var chatcontainer = document.querySelector("#chat_container");
    var userName = document.querySelector('#userName');
    if (chatmodal.style.bottom == '-5%') {
        chatcontainer.style.visibility = 'visible';
        chatcontent.style.visibility = 'visible';
        chatmodal.style.bottom = "5%";
    } else {
        chatcontainer.style.visibility = 'hidden';
        chatcontent.style.visibility = 'hidden';
        chatmodal.style.bottom = "-5%";
    }
    document.getElementById("yourName").style.display = 'none';
    document.getElementById("yourMsg").style.display = 'block';
}

function wsOpen() {
    ws = new WebSocket("ws://" + location.host + "/chating");
    wsEvt();
}

function wsEvt() {
    ws.onopen = function (data) {
        //소켓이 열리면 초기화
    }
    ws.onmessage = function (data) {
        var msg = data.data;
        if (msg != null && msg.trim() != "") {
            $("#chating").append("<p class='txt_chat'>" + msg + "<p>");
        }
    }
    document.addEventListener("keypress", function (e) {
        if (e.keyCode == 13) { //enter press
            send();
        }
    });
}
function send() {
    var uN = $("#userName").val();
    var msg = $("#chatting").val();
    ws.send(uN + " : " + msg);
    $('#chatting').val("");
}

function closeChat() {
    var chatmodal = document.querySelector("#chatting_modal");
    var chatcontent = document.querySelector("#chating");
    var chatcontainer = document.querySelector("#chat_container");
    chatcontainer.style.visibility='hidden';
    chatcontent.style.visibility = 'hidden';
    chatmodal.style.bottom = "-5%";
}

/*-------------------------------sidebar-----------------------------------*/

gnb1.addEventListener('click', function () {
    gnb2.style.visibility = 'visible';
    gnb2.style.opacity = 1;
    gnb1.style.backgroundColor = '#037c82';
})

function closeSideBar() {
    gnb2.style.visibility = 'hidden';
    gnb2.style.opacity = 0;
    gnb1.style.background = 'rgba(0,0,0,0.5)';
}

// let scc = document.querySelector(".scroll_container");
// scc.addEventListener("scroll",function (){
//     window.scrollTo({top:scc.scrollTop,left:0,behavior:"auto"});
// });