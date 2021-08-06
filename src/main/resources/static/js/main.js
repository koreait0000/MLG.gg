/*-----------------------------declaration----------------------------------*/
const preloader = document.querySelector("#preloader");
const high = document.querySelector("#highest");
function fontresizing() {
    let hft=document.querySelector("html");
    if (window.innerWidth < 800 || window.innerHeight < 600) {
       hft.style.fontSize='10px';
    }else if(window.innerWidth < 1200 || window.innerHeight < 1000){
        hft.style.fontSize='16px';
    }else{
        hft.style.fontSize='20px';

    }
}

/*----------------------------window.onfunc--------------------------------*/
window.addEventListener('load', function () {
    fontresizing();
    Preloader();
    sidebar();
    var x = document.querySelector(".s-footer");
    var y = document.querySelector("section");
    var z = window.innerHeight;
    console.log(y.offsetHeight);
    x.style.top = document.body.scrollHeight - z;
});
window.addEventListener('scroll', function () {
    sidebar();
});
window.addEventListener('resize', function () {
    fontresizing();
    headerRe();
});

/*-----------------------------preloader-----------------------------------*/
function Preloader() {
    preloader.classList.remove('mlg-preload');
    preloader.classList.add('mlg-loaded')
    high.style.display = 'block';
    high.style.animationName = 'fadeIn';
    high.style.animationDuration = '1s';
};

/*--------------------------------chat-------------------------------------*/
function openChat() {
    var chatmodal = document.querySelector("#chatting_modal");
    var chatcontent = document.querySelector("#chating");
    var chatcontainer = document.querySelector("#chat_container");
    if (chatmodal.style.bottom == '-5%') {
        chatcontainer.style.visibility = 'visible';
        chatcontent.style.visibility = 'visible';
        chatmodal.style.bottom = "5%";
    } else {
        chatcontainer.style.visibility = 'hidden';
        chatcontent.style.visibility = 'hidden';
        chatmodal.style.bottom = "-5%";
    }
}

var ws;

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
            $("#chating").append("<p>" + msg + "<p>");
        }
    }
    document.addEventListener("keypress", function (e) {
        if (e.keyCode == 13) { //enter press
            send();
        }
    });
}

function chatName() {
    var userName = document.querySelector('#userName');
    if (userName == null) {
        alert("사용자 이름을 입력해주세요.");
    } else {
        wsOpen();
        document.getElementById("yourName").style.display = 'none';
        document.getElementById("yourMsg").style.display = 'block';
    }
}

function send() {
    var uN = $("#userName").val();
    var msg = $("#chatting").val();
    ws.send(uN + ":" + msg);
    $('#chatting').val("");
}

/*-------------------------------sidebar-----------------------------------*/
const gnb1 = document.getElementById('gnb');
const gnb2 = document.getElementById('hero-left');
let isfixed = false;

function sidebar() {
    let scrllVal = window.scrollY;
    let gtt = document.querySelector('.ss-go-top');
    let sfm = document.querySelector('.scroll-link');
    let headVal = document.querySelector("#s-head");
    if (scrllVal == 0) {
        gtt.style.opacity = 0;
        gtt.style.visibility = 'hidden';
        sfm.style.visibility = 'visible';
        sfm.style.opacity = 1;
        headVal.style.position = 'relative';
        headVal.style.background = 'rgba(0,0,0,1)';
        isfixed = false;
    }
    if (scrllVal > 0 || pageYOffset > 0) {
        if (!isfixed) {
            headVal.style.position = 'fixed';
            isfixed = true;
            headVal.style.background = 'rgba(0,0,0,0.6)';
        }
        gtt.style.opacity = 1;
        gtt.style.visibility = 'visible';
        sfm.style.visibility = 'hidden';
        sfm.style.opacity = 0;
        console.log(scrllVal);
    }
}

gnb1.addEventListener('mouseover', function () {
    gnb2.style.visibility = 'visible';
    gnb2.style.opacity = 1;
    gnb1.style.backgroundColor = '#037c82';
})

function closeSideBar() {
    gnb2.style.visibility = 'hidden';
    gnb2.style.opacity = 0;
    gnb1.style.background = 'rgba(0,0,0,0.5)';
}

function movesmooth(goto) {
    if (goto == "heaven") {
        window.scrollTo({top: 0, left: 0, behavior: "smooth"});
    }
    if (goto == "hell") {
        window.scrollTo({top: document.querySelector("body").scrollHeight, left: 0, behavior: "smooth"});
    }
}

/*------------------------------header------------------------------------*/
const toggleButton = document.querySelector('.header-menu-toggle');
toggleButton.addEventListener("click", () => {
    const menu = document.querySelector('.header-nav-wrap');
    if (menu.style.display == 'none') {
        menu.style.display = "flex";
    } else {
        menu.style.display = "none";
    }
})

function headerRe() {
    const menu = document.querySelector('.header-nav-wrap');
    if (window.innerWidth >= 768) {
        menu.style.display = "flex";
    }
    if (window.innerWidth <= 768) {
        menu.style.display = "none";
    }
};
