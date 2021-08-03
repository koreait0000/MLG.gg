const toggleButton = document.querySelector('.header-menu-toggle');

toggleButton.addEventListener("click", () =>{
    const menu = document.querySelector('.header-nav');
    menu.style.display = "block";
    menu.style.top= "100px";
})

