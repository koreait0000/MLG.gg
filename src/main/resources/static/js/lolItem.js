let itemDetail = document.querySelector('#itemDetail');
let itemsTable = document.querySelector('#itemsTable');
let itemsArea = document.querySelector('#itemsArea');

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
        .then(function(res){
            return res.json();
        })
        .then(function(myJson){
            console.log(myJson);

            itemsArea.innerHTML = '';

            for(let i=0; i<myJson.length; i++){
                let param = JSON.stringify(myJson[i]);

                let itemSpan = document.createElement('span');
                let itemDiv1 = document.createElement('div');
                let itemDiv2 = document.createElement('div');
                let itemDiv3 = document.createElement('div');
                let imgDiv = document.createElement('img');

                itemSpan.className = 'itemSpan';
                itemDiv1.className = 'itemDiv1';
                itemDiv2.className = 'itemDiv2';
                itemDiv3.className = 'itemDiv3';

                imgDiv.src = "http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/"+ myJson[i].itemNo + ".png";
                itemDiv1.append(imgDiv);
                itemDiv1.innerHTML = "<img onclick='getItemDetail(&quot;" + myJson[i] + "&quot;)' src='http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/" + myJson[i].itemNo + ".png'/>"
                // itemDiv1.addEventListener('click', getItemDetail(myJson[i]); return false;)
                // itemDiv1.onclick = getItemDetail(myJson[i]; return false);
                itemDiv2.append(myJson[i].total);
                itemDiv3.append(myJson[i].name);

                itemSpan.append(itemDiv1);
                itemSpan.append(itemDiv2);
                itemSpan.append(itemDiv3);
                itemsArea.append(itemSpan);
            }
        })
}




function getItemDetail(param) {
        console.log(param);
        // let intoDiv = document.querySelector('#intoDiv');
        // let imgDiv = document.querySelector('#imgDiv');
        // let totalDiv = document.querySelector('#totalDiv');
        // let infoDiv = document.querySelector('#infoDiv');
        // let statsDiv = document.querySelector('#statsDiv');
        // let inImg = document.createElement('img');
        // inImg.src = "http://ddragon.leagueoflegends.com/cdn/11.15.1/img/item/" + item.itemNo + ".png"
        //
        // imgDiv.append(imImg);
        // totalDiv.append(item.total);
        // infoDiv.append(item.plaintext);
        // statsDiv.append(item.stats);
        // // intoDiv.innerHTML = item.
        //
        //
        //
        // itemDetail.append(item.plaintext);
};