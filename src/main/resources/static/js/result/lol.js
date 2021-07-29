

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
            console.log(myJson);
            console.log(gameId);
            modal.style.display = 'flex'
        });
}

// function makeFeedList(data) {
//     if(data.length == 0) { return; }
//     let beforeifeed = 0;
//     let swiperWrapperDiv = null;
//     for(let i=0; i<data.length; i++) {
//         const item = data[i];
//
//         if(beforeifeed !== item.ifeed) { //새로운 feed 시작이다.
//             beforeifeed = item.ifeed;
//
//             const itemContainer = document.createElement('div');
//             itemContainer.classList.add('item');
//
//             const topDiv = document.createElement('div');
//             topDiv.classList.add('top')
//             topDiv.innerHTML = `
//             <div class="itemProfileCont">
//                 <img src="/pic/profile/${item.iuser}/${item.mainProfile}">
//             </div>
//             <div>
//                 <div>${item.writer}</div>
//                 <div>${item.location == null ? '' : item.location}</div>
//             </div>
//             `;
//             const imgDiv = document.createElement('div');
//             imgDiv.classList.add('itemImg');
//
//             const swiperContainerDiv = document.createElement('div');
//             swiperContainerDiv.classList.add('swiper-container');
//
//             swiperWrapperDiv = document.createElement('div');
//             swiperWrapperDiv.classList.add('swiper-wrapper');
//
//             swiperContainerDiv.append(swiperWrapperDiv);
//             imgDiv.append(swiperContainerDiv);
//
//             itemContainer.append(topDiv);
//             itemContainer.append(imgDiv);
//             if(item.ctnt != null) {
//                 const ctntDiv = document.createElement('div');
//                 ctntDiv.innerText = item.ctnt;
//                 ctntDiv.classList.add('itemCtnt');
//                 itemContainer.append(ctntDiv);
//             }
//             feedContainerElem.append(itemContainer);
//         }



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

// const btnModal = document.getElementById('btn-modal')
// btnModal.addEventListener('click', e => {
//     modal.style.display = 'flex'
// });

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
