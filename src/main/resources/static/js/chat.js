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

