const videoElem = document.querySelector('.sample-video');
let progress;
let currentFrame;

function init() {
    document.body.classList.remove('before-load');
    window.addEventListener('scroll', function () {
        progress = pageYOffset / (document.body.offsetHeight - window.innerHeight);
        console.log(progress);
        if (progress < 0) progress = 0;
        if (progress > 1) progress = 1;
        videoElem.currentTime = videoElem.duration * progress;
    });
    $(document).ready(function($) {
        $('a').smoothScroll({
            speed: 4000,
            easing: 'easeInOutCubic'
        });
    });
}

window.addEventListener('load', init);
