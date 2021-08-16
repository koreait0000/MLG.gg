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
    championArea.innerHTML = '';
    for (let i = 1; i < 20; i++) {
        let nameAndimg = document.createElement('div');
        let championImg = document.createElement('img');

        nameAndimg.className = 'nameAndimg';
        championImg.className = 'championSkin';
        championImg.id = 'championSkin' + i;

        championImg.src = 'http://ddragon.leagueoflegends.com/cdn/img/champion/splash/' + champion_name + '_' + i + '.jpg';
        // championImg.onerror = noImage();
        // $().ready(function() {
        //     $("img").error(function() {
        //         $(".championSkin").attr("src", "data:image/jpeg;base64,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");
        //     })
        // });

        nameAndimg.append(championImg);
        championArea.append(nameAndimg);
    }
}

function noImage() {
    $('img').error(function() {
        $(this).hide();
    })
}






