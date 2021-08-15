/*----------------------------declation--------------------------------*/
// let currentscrollitem=
/*----------------------------declation--------------------------------*/
/*----------------------------window.onfunc--------------------------------*/
window.addEventListener('load', function () {
    waitForImages();
    // sidebar();
});
window.addEventListener('scroll', function () {
    // sidebar();
});
window.addEventListener('resize', function () {
    headerRe();
});

/*-----------------------------preloader-----------------------------------*/
const { gsap, imagesLoaded } = window;
const waitForImages = () => {
    const images = [...document.querySelectorAll("img")];
    const totalImages = images.length;
    let loadedImages = 0;
    const loaderEl = document.querySelector(".loader span");

    images.forEach((image) => {
        imagesLoaded(image, (instance) => {
            if (instance.isComplete) {
                loadedImages++;
                let loadProgress = loadedImages / totalImages;

                gsap.to(loaderEl, {
                    duration: 1,
                    scaleX: loadProgress,
                    backgroundColor: `hsl(${loadProgress * 120}, 100%, 50%`,
                });

                if (totalImages == loadedImages) {
                    gsap.timeline()
                        .to(".loading__wrapper", {
                            duration: 0.8,
                            opacity: 0,
                            pointerEvents: "none",
                        })
                        .call(() => init());
                }
            }
        });
    });
};

/*-----------------------------preloader-----------------------------------*/
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
/*------------------------------header------------------------------------*/
/*------------------------------scroll for more------------------------------------*/
// function sidebar() {//scroll for more
//     let scrllVal = document.querySelector("#alpha");
//     let gtt = document.querySelector('.ss-go-top');
//     let sfm = document.querySelector('.scroll-link');
//     let headVal = document.querySelector("#s-head");
//     let hs = document.querySelector('.hero-scroll');
//     hs.style.display='block';
//     if (scrllVal == 0) {
//         gtt.style.opacity = 0;
//         gtt.style.visibility = 'hidden';
//         sfm.style.visibility = 'visible';
//         sfm.style.opacity = 1;
//         headVal.style.position = 'relative';
//         headVal.style.background = 'rgba(0,0,0,1)';
//         isfixed = false;
//     }
//     if (scrllVal > 0 || pageYOffset > 0) {
//         if (!isfixed) {
//             headVal.style.position = 'fixed';
//             isfixed = true;
//             headVal.style.background = 'rgba(0,0,0,0.6)';
//         }
//         gtt.style.opacity = 1;
//         gtt.style.visibility = 'visible';
//         sfm.style.visibility = 'hidden';
//         sfm.style.opacity = 0;
//         console.log(scrllVal);
//     }
// }
// function movesmooth(goto) {
//     if (goto == "heaven") {
//         window.scrollTo({top: 0, left: 0, behavior: "smooth"});
//     }
//     if (goto == "hell") {
//         window.scrollTo({top: document.querySelector("footer").offsetTop, left: 0, behavior: "smooth"});
//     }
// }
/*------------------------------scroll for more------------------------------------*/
