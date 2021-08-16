function follow(uid, user_no) {
    const init = {
        method: "POST",
        body: JSON.stringify({
            "uid": uid,
            "user_no": user_no
        }),
        headers:
            {
                'accept': 'application/json',
                'content-type': 'application/json'
            }
    }
    console.log(init.body);
    fetch('/user/follow', init)
        .then(function (res) {
            console.log(res);
            return res.json();
        })
        .then(function (myJson) {
            if (myJson == 0) {
                alert("언팔로우 하였습니다")
            }else{
                alert("팔로우 하였습니다")
            }
            location.href = "";
        });
}

