var slider = document.querySelector("#menu_slider");
var slider_btn=document.querySelector("#slider_btn");;
var side_bar = document.querySelector("#side_bar");
var bts = true;

function a(){

    console.log(bts);
    if(bts === true){
        slider.style.left=`0%`;
        slider_btn.className="fas fa-angle-double-right"
        side_bar.style.left=`-30%`;
        bts = false;
        return ;
    }
    if(bts === false){
        slider.style.left=`30%`;
        slider_btn.className="fas fa-angle-double-left";
        side_bar.style.left=`0%`;
        bts = true;
        return;
    }

}