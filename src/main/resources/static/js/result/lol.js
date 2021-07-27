// const btnModal = document.getElementById('btn_modal')

function getGameId(gameId) {
    const init = {
        method:"POST",
        body: JSON.stringify(gameId),
        headers:
            {
                'accept': 'application/json',
                'content-type': 'application/json'
            }
    }
    console.log(init.body);
    fetch('/getDetail',init)
        .then(function(res){
            console.log(res);
        })
        .then(function(myJson){
            console.log(gameId);
            modal.style.display = 'flex'
        });
}



let modal = document.getElementById('modal')

function modalOn() {
    modal.style.display = 'flex'
}

function isModalOn() {
    return modal.style.display === 'flex'
}

function modalOff() {
    modal.style.display = 'none'
}

// const btnModal = document.getElementById('btn-modal')
// btnModal.addEventListener('click', e => {
//     modal.style.display = 'flex'
// });

const closeBtn = modal.querySelector('.close-area')
closeBtn.addEventListener('click', e => {
    modal.style.display = 'none'
});

modal.addEventListener('click', e => {
    const evTarget = e.target
    if(evTarget.classList.contains('modal-overlay')) {
        modal.style.display = 'none'
    }
});

window.addEventListener('keyup', e => {
    if(modal.style.display === 'flex' && e.key === 'Escape') {
        modal.style.display = 'none'
    }
})
