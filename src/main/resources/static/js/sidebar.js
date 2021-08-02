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