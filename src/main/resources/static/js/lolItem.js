let itemsArea = document.querySelector('#itemsArea');

clickEnt();

function clickEnt() {
    const init = {
        method: 'POST',
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json'
        }
    }
    fetch('/firstItemMenu', init)
        .then(function (res) {
            return res;
        })
        .then(function(myJson) {
            console.log(myJson);
            for (let i = 0; i < myJson.length; i++) {
                $(document).ready(function () {
                    $('#itemimg' + i).click(function () {
                        getItemDetail(myJson[i]);
                    })
                })
            }

        })
}

function byTag(num) {
    const init = {
        method: 'POST',
        body: JSON.stringify(num),
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json'
        }
    }
    fetch('/lolItem', init)
        .then(function (res) {
            return res.json();
        })
        .then(function (myJson) {
            console.log(myJson);

            itemsArea.innerHTML = '';

            for (let i = 0; i < myJson.length; i++) {
                let itemSpan = document.createElement('span');
                let itemDiv1 = document.createElement('div');
                let itemDiv2 = document.createElement('div');
                let itemDiv3 = document.createElement('div');
                let itemimg = document.createElement('img');

                itemSpan.className = 'itemSpan';
                itemimg.id = 'itemimg' + i;
                itemimg.className = 'itemimg'
                itemDiv1.className = 'itemDiv1';
                itemDiv2.className = 'itemDiv2';
                itemDiv3.className = 'itemDiv3';

                itemimg.src = "http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/" + myJson[i].itemNo + ".png";
                itemDiv1.append(itemimg);

                itemDiv2.append(myJson[i].total + ' Gold');
                itemDiv3.append(myJson[i].name);
                itemSpan.append(itemDiv1);
                itemSpan.append(itemDiv2);
                itemSpan.append(itemDiv3);
                itemsArea.append(itemSpan);
                $(document).ready(function () {
                    $('#itemimg' + i).click(function () {
                        getItemDetail(myJson[i]);
                    })
                })
            }
        })
}


function getItemDetail(param) {
    var data = JSON.stringify(param);
    console.log(data);
    console.log(JSON.parse(data).itemNo);
    // if(JSON.parse(data).itemNo == undefined) {
    // console.log(JSON.);
    // console.log(typeof(item))
    // }


    let intoDiv = document.querySelector('.intoDiv');
    let imgDiv = document.querySelector('.imgDiv');
    let totalDiv = document.querySelector('.totalDiv');
    let infoDiv = document.querySelector('.infoDiv');
    let statsDiv = document.querySelector('.statsDiv');
    let inImg = document.createElement('img');
    inImg.src = "http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/" + JSON.parse(data).itemNo + ".png"

    intoDiv.innerHTML = '';
    imgDiv.innerHTML = '';
    totalDiv.innerHTML = '';
    infoDiv.innerHTML = '';
    // statsDiv.innerHTML = '';

    intoDiv.className = 'intoDiv';
    inImg.className = 'inImg';
    imgDiv.className = 'imgDiv';
    totalDiv.className = 'totalDiv';
    infoDiv.className = 'infoDiv';


    // console.log(intoList.length);


    imgDiv.append(JSON.parse(data).name);
    imgDiv.append(inImg);
    totalDiv.append(JSON.parse(data).total + ' Gold');
    infoDiv.append(JSON.parse(data).plaintext);
    // statsDiv.append(JSON.parse(data).stats);

    let intoList = JSON.parse(data).into;
    if (intoList.length != 0) {

        for (let i = 0; i < intoList.length; i++) {
            let intoImg = document.createElement('img');
            intoImg.className = 'intoImg';
            intoImg.src = "http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/" + intoList[i] + ".png";
            intoDiv.append(intoImg)
        }
    }

};