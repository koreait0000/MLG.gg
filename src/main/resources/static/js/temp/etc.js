/*--------------------------------chat-------------------------------------*/
var ws;
var scrollh=0;
wsOpen();

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
// 보류하자 ------------------------------------------
// let chattting2 = document.querySelector('#chating');
// let scrcht = chattting2.scrollTop;
//
// chattting2.addEventListener('scroll', function (){
//     console.log(scrcht);
//     // console.log(chattting.scrollHeight -  window.innerHeight);
//     // $(document).scrollTop($(document).height());
// });
//





/*--------------------------------chat-------------------------------------*/
function openChatting(lname) {
    // var url = "chat?lname=" + lname;
    var open = window.open("/chat", "chat", "_blank, height=500, width=500");
}

function closeChat() {
    var chatmodal = document.querySelector("#chatting_modal");
    var chatcontent = document.querySelector("#chating");
    var chatcontainer = document.querySelector("#chat_container");
    chatcontainer.style.visibility='hidden';
    chatcontent.style.visibility = 'hidden';
    chatmodal.style.bottom = "-5%";
}

/*--------------------------------profile link-------------------------------------*/
function profile(uid){
    location.href='/user/profile?uid='+uid;
}
/*--------------------------------profile link-------------------------------------*/
/*------------------------------scroll for more------------------------------------*/
// function sidebar() {//scroll for more
//     let scrllVal = document.querySelector("#alpha");
//     let gtt = document.querySelector('.ss-go-top');
//     let sfm = document.querySelector('.scroll-link');
//     let headVal = document.querySelector("#s-head");
//     let hs = document.querySelector('.hero-scroll');
//     hs.style.display='block';
//     if (scrllVal == 0) {
//         gtt.style.opacity = 0;
//         gtt.style.visibility = 'hidden';
//         sfm.style.visibility = 'visible';
//         sfm.style.opacity = 1;
//         headVal.style.position = 'relative';
//         headVal.style.background = 'rgba(0,0,0,1)';
//         isfixed = false;
//     }
//     if (scrllVal > 0 || pageYOffset > 0) {
//         if (!isfixed) {
//             headVal.style.position = 'fixed';
//             isfixed = true;
//             headVal.style.background = 'rgba(0,0,0,0.6)';
//         }
//         gtt.style.opacity = 1;
//         gtt.style.visibility = 'visible';
//         sfm.style.visibility = 'hidden';
//         sfm.style.opacity = 0;
//         console.log(scrllVal);
//     }
// }
