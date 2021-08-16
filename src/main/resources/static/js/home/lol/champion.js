var championArea = document.querySelector('#championArea');

function sortChampion(num1, num2) {
    const init = {
        method: 'POST',
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json'
        }
    }
    fetch('sortChampion', init)
        .then(function (res) {
            return res.json();
        }).then(function (myJson) {
        console.log(num1);
        console.log(num2);
        championArea.innerHTML = '';
        if (num1 == "0" && num2 != "0") {
            for (let i = num1; i <= num2; i++) {
                let nameAndimg = document.createElement('div');
                let nameDiv = document.createElement('div');
                let championImg = document.createElement('img');

                nameAndimg.className = 'nameAndimg';
                championImg.className = 'championImg';
                championImg.id = 'championImg' + i;

                championImg.src = 'http://ddragon.leagueoflegends.com/cdn/img/champion/loading/' + myJson[i].champion_name + '_0.jpg'
                $(document).ready(function () {
                    $('#championImg' + i).click(function () {
                        championDetail(myJson[i].champion_name);
                    })
                });

                nameDiv.append(myJson[i].champion_KRname);
                nameAndimg.append(championImg);
                nameAndimg.append(nameDiv);

                championArea.append(nameAndimg);
            }
        } else if(num2 == null) {
            for(let i=0; i<num1; i++) {
                let nameAndimg = document.createElement('div');
                let nameDiv = document.createElement('div');
                let championImg = document.createElement('img');

                nameAndimg.className = 'nameAndimg';
                championImg.className = 'championImg';
                championImg.id = 'championImg' + i;

                championImg.src = 'http://ddragon.leagueoflegends.com/cdn/img/champion/loading/' + myJson[i].champion_name + '_0.jpg'
                $(document).ready(function () {
                    $('#championImg' + i).click(function () {
                        championDetail(myJson[i].champion_name);
                    })
                });

                nameDiv.append(myJson[i].champion_KRname);
                nameAndimg.append(championImg);
                nameAndimg.append(nameDiv);

                championArea.append(nameAndimg);
            }
        }else {
            for (let i = num1 + 1; i <= num2; i++) {
                let nameAndimg = document.createElement('div');
                let nameDiv = document.createElement('div');
                let championImg = document.createElement('img');

                nameAndimg.className = 'nameAndimg';
                championImg.className = 'championImg';
                championImg.id = 'championImg' + i;

                championImg.src = 'http://ddragon.leagueoflegends.com/cdn/img/champion/loading/' + myJson[i].champion_name + '_0.jpg'
                $(document).ready(function () {
                    $('#championImg' + i).click(function () {
                        championDetail(myJson[i].champion_name);
                    })
                });

                nameDiv.append(myJson[i].champion_KRname);
                nameAndimg.append(championImg);
                nameAndimg.append(nameDiv);

                championArea.append(nameAndimg);
            }
        }
    });
}

function championDetail(champion_name) {
    let name = champion_name.toLowerCase();
    location.href='https://kr.leagueoflegends.com/ko-kr/champions/' + name + '/';
}








