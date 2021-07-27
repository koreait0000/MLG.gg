const Preloader = function() {
    let x= document.querySelector("#preloader");
    x.classList.add('mlg-preload');
    window.onload= function (){
        x.classList.remove('mlg-preload');
        x.classList.add('mlg-loaded')
    };
};
Preloader();