var formElem = document.querySelector("#search_summoner");0
var apikey = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJmMDE5ZjNjMC1hNzEzLTAxMzktZGIxZi0xMThlNzI0MmJhN2UiLCJpc3MiOiJnYW1lbG9ja2VyIiwiaWF0IjoxNjIyNzc3Nzc0LCJwdWIiOiJibHVlaG9sZSIsInRpdGxlIjoicHViZyIsImFwcCI6Ii0wZDJmNmNjMy01OWE0LTQ5MjMtYTU5Ni1lM2I0NjEyMzY1MDkifQ.CEATShC9hbt-QhGX3COaVL8AJqCIC4PfwXVZRlDv3So"
var pubgElem = document.querySelector('#result')


function search_name() {
    var nickElem = formElem.search_text.value;
    console.log(nickElem);
    const init = {
        method: 'GET',
        headers:
            {
                "Authorization": apikey,
                "Accept": "application/vnd.api+json"
            }
    };
    fetch('https://cors-anywhere.herokuapp.com/https://api.pubg.com/shards/steam/players?filter[playerNames]='+nickElem, init)
        .then(function(res) {
            console.log(res);
            return res.json();
        })
        .then(function(myJson) {
            console.log(myJson)
            save(myJson)
            match(myJson)
        });
}


function save(data) {
    const init = {
        method: 'POST',
        body: JSON.stringify(data),
        headers:
            {
                'accept': 'application/json',
                'content-type': 'application/json;charset=UTF-8'
            }
    }
    console.log(init.body);
    fetch('save', init)
        .then(function(res){
            return res.json();
        })
        .then(function(myJson){

        })
}

function match(data) {
    const init = {
        method: 'GET',
        headers:
            {
                'Authorization': apikey,
                'Accept': "application/vnd.api+json"
            }
    }
    fetch('https://cors-anywhere.herokuapp.com/https://api.pubg.com/shards/steam/matches/9013fcd6-4e66-4326-980e-56f509657367', init)
        .then(function(res){
            return res.json();
        })
        .then(function(myJson){
            console.log(myJson)
            makee(myJson);
        })

}

function makee(param) {
    pubgElem.append('');
    pubgElem.innerHTML = '';
    var tableElem = document.createElement('table');
    var trElemTitle = document.createElement('tr');
    var thElemGame = document.createElement('th');
    var thElemDeal = document.createElement('th');
    var trElemType = document.createElement('th');

    thElemGame.append('게임');
    thElemDeal.append('딜');
    trElemType.append('타입');

    trElemTitle.append(thElemGame)
    trElemTitle.append(thElemDeal)
    trElemTitle.append(trElemType)

    tableElem.append(trElemTitle);
    pubgElem.append(tableElem);
}

