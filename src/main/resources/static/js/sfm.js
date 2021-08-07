function sidebar() {//scroll for more
    let scrllVal = window.scrollY;
    let gtt = document.querySelector('.ss-go-top');
    let sfm = document.querySelector('.scroll-link');
    let headVal = document.querySelector("#s-head");
    let hs = document.querySelector('.hero-scroll');
    hs.style.display='block';
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