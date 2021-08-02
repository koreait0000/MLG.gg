/*---------------롤 디테일 모달창에 삽입------------------*/
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
            return res.json();
        })
        .then(function(myJson){

            let modalContent = document.querySelector('.content');
            modalContent.innerHTML = '';
            for(let i=0;i<10;i++) {
                let area = document.createElement("div");
                let area1 = document.createElement("img");
                let area2 = document.createElement("img");
                let area3 = document.createElement("img");
                area1.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/champion/' + myJson.details[i].champion_name +'.png'
                area2.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/spell/' + myJson.details[i].spell1_name + '.png'
                area3.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/spell/' + myJson.details[i].spell2_name + '.png'

                area.append(area1);
                area.append(area2);
                area.append(area3);

                modalContent.append(area);
            }
            modal.style.display = 'flex'
        });
}
/*----------------------------------------------------------*/

/*---------------------------modal-----------------------------*/
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
});
/*------------------------------------------------------------*/
