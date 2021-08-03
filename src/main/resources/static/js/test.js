const toggleButton = document.querySelector('.header-menu-toggle');
toggleButton.addEventListener("click", () =>{

    const menu = document.querySelector('.header-nav-wrap');
    if(menu.style.display=='none'){
        menu.style.display = "flex";
    }else{
        menu.style.display = "none";
    }
})
window.onresize=function (){
    const menu = document.querySelector('.header-nav-wrap');
    if(window.innerWidth>=768){
        menu.style.display = "flex";
    }
    if(window.innerWidth<=768){
        menu.style.display = "none";
    }

};

