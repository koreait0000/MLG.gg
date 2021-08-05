/*---------------롤 디테일 모달창에 삽입------------------*/
function getGameId(gameId) {
    const init = {
        method: "POST",
        body: JSON.stringify(gameId),
        headers:
            {
                'accept': 'application/json',
                'content-type': 'application/json'
            }
    }
    console.log(init.body);
    fetch('/getDetail', init)
        .then(function (res) {
            return res.json();
        })
        .then(function (myJson) {

            let modalContent = document.querySelector('.content');
            modalContent.innerHTML = '';
            let winDiv = document.createElement("div");
            let loseDiv = document.createElement("div");
            for (let i = 0; i < 10; i++) {
                let areaDiv = document.createElement("div");
                let areaSpan = document.createElement("span");
                let areaItemDiv = document.createElement('div');
                let areaSpells = document.createElement('div');
                let areaItemSpan1 = document.createElement("span");
                let areaItemSpan2 = document.createElement("span");
                let areaChampion = document.createElement("img");
                let areaSpell1 = document.createElement("img");
                let areaSpell2 = document.createElement("img");
                let areaItem1 = document.createElement("img");
                let areaItem2 = document.createElement("img");
                let areaItem3 = document.createElement("img");
                let areaItem4 = document.createElement("img");
                let areaItem5 = document.createElement("img");
                let areaItem6 = document.createElement("img");
                let areaKDA = document.createElement("span");

                areaChampion.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/champion/' + myJson.details[i].champion_name + '.png'
                areaSpell1.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/spell/' + myJson.details[i].spell1_name + '.png'
                areaSpell2.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/spell/' + myJson.details[i].spell2_name + '.png'
                areaItem1.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/' + myJson.details[i].stats.item0 + '.png';
                areaItem2.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/' + myJson.details[i].stats.item1 + '.png';
                areaItem3.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/' + myJson.details[i].stats.item2 + '.png';
                areaItem4.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/' + myJson.details[i].stats.item3 + '.png';
                areaItem5.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/' + myJson.details[i].stats.item4 + '.png';
                areaItem6.src = 'http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/' + myJson.details[i].stats.item5 + '.png';

                areaItem1.className = 'itemImg';
                areaItem2.className = 'itemImg';
                areaItem3.className = 'itemImg';
                areaItem4.className = 'itemImg';
                areaItem5.className = 'itemImg';
                areaItem6.className = 'itemImg';

                winDiv.id = 'win';
                winDiv.classList.add("team");
                loseDiv.id= 'lose';
                loseDiv.classList.add("team");
                areaKDA.id = 'KDA';
                areaSpan.id = 'chamAndSpell';
                areaChampion.id = 'championImg';
                areaSpell1.className = 'spellImg';
                areaSpell2.className = 'spellImg';

                areaKDA.innerHTML += myJson.details[i].stats.kills;
                areaKDA.innerHTML += '/';
                areaKDA.innerHTML += myJson.details[i].stats.deaths;
                areaKDA.innerHTML += '/';
                areaKDA.innerHTML += myJson.details[i].stats.assists;
                areaKDA.innerHTML += '<br>'
                areaKDA.innerHTML += 'DEAL: ';
                areaKDA.innerHTML += myJson.details[i].stats.totalDamageDealtToChampions;
                areaKDA.innerHTML += '<br>'
                areaKDA.innerHTML += 'CS: ';
                areaKDA.innerHTML += myJson.details[i].stats.totalMinionsKilled;
                areaKDA.style.color = 'black';
                areaKDA.style.fontWeight = 'bold';

                if (myJson.details[i].stats.item0 == 0) {
                    areaItem1.src='img/blank.png';
                    areaItem1.style.opacity='0.55';
                }
                if (myJson.details[i].stats.item1 == 0) {
                    areaItem2.src = 'img/blank.png';
                    areaItem2.style.opacity='0.55';
                }
                if (myJson.details[i].stats.item2 == 0) {
                    areaItem3.src = 'img/blank.png';
                    areaItem3.style.opacity='0.55';
                }
                if (myJson.details[i].stats.item3 == 0) {
                    areaItem4.src = 'img/blank.png';
                    areaItem4.style.opacity='0.55';
                }
                if (myJson.details[i].stats.item4 == 0) {
                    areaItem5.src = 'img/blank.png';
                    areaItem5.style.opacity='0.55';
                }
                if (myJson.details[i].stats.item5 == 0) {
                    areaItem6.src = 'img/blank.png';
                    areaItem6.style.opacity='0.55';
                }

                areaItemSpan1.append(areaItem1);
                areaItemSpan1.append(areaItem2);
                areaItemSpan1.append(areaItem3);
                areaItemSpan2.append(areaItem4);
                areaItemSpan2.append(areaItem5);
                areaItemSpan2.append(areaItem6);

                areaItemSpan1.classList.add("threeItem");
                areaItemSpan2.classList.add("threeItem");

                areaItemDiv.append(areaItemSpan1);
                areaItemDiv.append(areaItemSpan2);

                areaItemDiv.classList.add("allItem");


                areaSpells.append(areaSpell1);
                areaSpells.append(areaSpell2);

                areaSpells.classList.add("spells");

                areaSpan.append(areaChampion);
                areaSpan.append(areaSpells);

                areaDiv.append(areaSpan);
                areaDiv.append(areaKDA);
                areaDiv.append(areaItemDiv);
                areaDiv.classList.add("players");

                console.log(myJson.details[i].stats.win);
                if(myJson.details[i].stats.win == 'true') {
                    winDiv.append(areaDiv);
                } else {
                    loseDiv.append(areaDiv);
                }
        }

            loseDiv.style.backgroundColor='rgba(243,195,195,0.79)';
            winDiv.style.backgroundColor='rgba(204,255,245,0.78)';
            winDiv.style.marginRight='20px';
            modalContent.append(winDiv);
            modalContent.append(loseDiv);

    modal.style.display = 'flex'
}

)
;
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
    if (evTarget.classList.contains('modal-overlay')) {
        modal.style.display = 'none'
    }
});

window.addEventListener('keyup', e => {
    if (modal.style.display === 'flex' && e.key === 'Escape') {
        modal.style.display = 'none'
    }
});
/*------------------------------------------------------------*/
