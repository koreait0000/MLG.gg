//메인이미지 바꾸기 아이콘에 이벤트 설정
function addIElemEvent(target) {
    target.addEventListener('click', () => {
        const iprofile = target.parentNode.dataset.profile_no;
        console.log(profile_no);
        changeMainProfile(profile_no);
    });
}

//메인 이미지 변경
function changeMainProfile(profile_no) {
    fetch(`/user/mainProfile?profile_no=${profile_no}`)
        .then(res => res.json())
        .then(myJson => {
            switch (myJson.result) {
                case 0:
                    alert('메인 이미지 변경에 실패하였습니다.');
                    break;
                case 1:
                    setMainProfileIcon(profile_no);

                    //section에 있는 프로필 이미지 변경
                    const src = profileImgElem.src;
                    const frontSrc = src.substring(0, src.lastIndexOf("/"));
                    const resultSrc = `${frontSrc}/${myJson.img}`
                    profileImgElem.src = resultSrc;

                    //헤더에 있는 프로필 이미지 변경
                    const headerProfileImgElem = document.querySelector('header .span__profile img');
                    headerProfileImgElem.src = resultSrc;
                    break;
            }
        });
}

//현재 mainProfile로 바뀐 iprofile값 입니다.
function setMainProfileIcon(profile_no) {
    profileImgParentList.forEach(item => {
        item.innerHTML = '';
        const itemIprofile = item.dataset.iprofile;
        if (profile_no !== itemIprofile) {
            const iElem = document.createElement('i');
            iElem.className = 'no-main-profile pointer fas fa-bell';
            item.append(iElem);
            addIElemEvent(iElem);
        }
    });
}

