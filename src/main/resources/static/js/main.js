/*-----------------------------declaration----------------------------------*/
const gnb1 = document.getElementById('gnb');
const gnb2 = document.getElementById('hero-left');
let isfixed = false;
const preloader = document.querySelector("#preloader");
const high = document.querySelector("#highest");

function sizing() {
    let hft = document.querySelector("html");
    let sht = document.querySelector("section");
    /*font resizing*/
    if (window.innerWidth < 800 || window.innerHeight < 600) {
        hft.style.fontSize = '10px';
    } else if (window.innerWidth < 1200 || window.innerHeight < 1000) {
        hft.style.fontSize = '16px';
    } else {
        hft.style.fontSize = '20px';
    }
    /*section resizing*/
    // sht.style.height=window.innerHeight+0.5;
}

/*----------------------------window.onfunc--------------------------------*/
window.addEventListener('load', function () {
    sizing();
    Preloader();
    sidebar();
    // var x = document.querySelector(".s-footer");
    // var y = document.querySelector("section");
    // var z = window.innerHeight;
    // console.log(y.offsetHeight);
    // x.style.top = document.body.scrollHeight - z;
});
window.addEventListener('scroll', function () {
    sidebar();
});
window.addEventListener('resize', function () {
    sizing();
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
var ws;

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
    console.log(goto);
    if (goto == "heaven") {
        window.scrollTo({top: 0, left: 0, behavior: "smooth"});
    }
    if (goto == "hell") {
        window.scrollTo({top: document.querySelector("footer").offsetTop, left: 0, behavior: "smooth"});
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


/*-------------------*/
// window.addEventListener('scroll', function (){
//     const botscr = window.scrollY+window.innerHeight;
//     const foottop = document.getElementById('footer').offsetTop;
//     if(botscr>foottop){
//         window.scrollTo({top:foottop+115, behavior: "auto"});
//     }
// })

=======
// 돌려놓기

let scc = document.querySelector(".scroll_container");
scc.addEventListener("scroll",function (){
    window.scrollTo({top:scc.scrollTop,left:0,behavior:"auto"});


});