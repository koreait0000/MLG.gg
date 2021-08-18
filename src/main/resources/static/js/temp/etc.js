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
        inchat();
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
            $('#chating').scrollTop($('#chating')[0].scrollHeight);
            $('#chating').animate({ scrollToy: $(document).height()}, 500);
        }
    });
}
function send() {
    var uN = $("#userName").val();
    var msg = $("#chatting").val();
    ws.send(uN + " : " + msg);
    $('#chatting').val("");
}
function inchat() {
    var uN = $("#userName").val();
    ws.send(uN + " 님이 입장하셨습니다");
    $('#chatting').val("");
}


/*--------------------------------chat-------------------------------------*/
function openChatting(lname) {
    // var url = "chat?lname=" + lname;
    var open = window.open("/chat", "chat", "_blank, height=500, width=500");
}

/*--------------------------------profile link-------------------------------------*/
function profile(uid){
    location.href='/user/profile?uid='+uid;
}
