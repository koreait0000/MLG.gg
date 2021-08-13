let itemsArea = document.querySelector('#itemsArea');
let itemTagno = 0;

function clickEnt(itemNo) {
    const init = {
        method: 'POST',
        headers: {
            'accept': 'application/json',
            'content-type': 'application/json'
        }
    }
    fetch('firstItemMenu', init)
        .then(function (res) {
            return res.json();
        }).then(function (myJson) {
        for (let i = 0; i < myJson.length; i++) {
            if (myJson[i].itemNo == itemNo) {
                getItemDetail(myJson[i]);
            }
        }
    });
};


function byTag(num) {
    if (itemTagno == 0) {
        itemTagno = num;
    }
    document.querySelector('#tag' + itemTagno).classList.remove("tagselec");
    document.querySelector('#tag' + num).classList.add("tagselec");

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
            console.log(res)
            return res.json();
        })
        .then(function (myJson) {
            // for(let i=1; i<=15; i++) {
            //     document.querySelector('#tagsMenu').style.backgroundColor = 'rgba(13, 33, 38, 0.5)';
            // }
            // document.querySelector('#tag' + num).style.backgroundColor = "rgb(13, 33, 38)"
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
    itemTagno = num;
}


function getItemDetail(param) {
    var data = JSON.stringify(param);
    let intoDiv = document.querySelector('.intoDiv');
    let imgDiv = document.querySelector('.imgDiv');
    let totalDiv = document.querySelector('.totalDiv');
    let infoDiv = document.querySelector('.infoDiv');

    let intoUl = document.createElement('ul');
    let inImg = document.createElement('img');
    inImg.src = "http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/" + JSON.parse(data).itemNo + ".png"

    intoDiv.innerHTML = '';
    imgDiv.innerHTML = '';
    totalDiv.innerHTML = '';
    infoDiv.innerHTML = '';

    intoUl.className = 'intoUl';
    intoDiv.className = 'intoDiv';
    inImg.className = 'inImg';
    imgDiv.className = 'imgDiv';
    totalDiv.className = 'totalDiv';
    infoDiv.className = 'infoDiv';

    imgDiv.append(JSON.parse(data).name);
    imgDiv.append(inImg);
    totalDiv.append(JSON.parse(data).total + ' Gold');
    infoDiv.append(JSON.parse(data).plaintext);
    var intoUlWidth = 0;
    let intoList = JSON.parse(data).into;
    if (intoList.length != 0) {
        for (let i = 0; i < intoList.length; i++) {
            let intoLi = document.createElement('li');
            let intoImg = document.createElement('img');

            intoImg.className = 'intoImg';
            intoImg.src = "http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/" + intoList[i] + ".png";

            intoUlWidth += 100;

            intoLi.append(intoImg);
            intoUl.append(intoLi);
        }
        intoUl.style.width = intoUlWidth;
    }

    intoDiv.append(intoUl);
};


