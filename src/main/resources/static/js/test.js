let isfixed=false;
window.addEventListener('scroll',function (){
    let scrllVal=window.scrollY;
    console.log(scrllVal);
    let secVal=document.querySelector("section");
    let headVal=document.querySelector("#s-head");
    if(scrllVal==0){
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

        console.log(scrllVal);
    }
});
// window.addEventListener('scroll', function (){
//     let scllVal=window.scrollY;
//     let asideVal=document.querySelector('#hero-left');
//     if(scllVal>500){
//         asideVal.style.position='absolute';
//     }
// })