console.clear();
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

waitForImages();
window.addEventListener('resize', function () {
    headerRe();
});
function headerRe() {
    const menu = document.querySelector('.header-nav-wrap');
    if (window.innerWidth >= 768) {
        menu.style.display = "flex";
    }
    if (window.innerWidth <= 768) {
        menu.style.display = "none";
    }
};
