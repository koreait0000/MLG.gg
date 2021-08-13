/*---------------------  리스트 가로 스크롤   ---------------------------*/
var scr_X = $('#sliding_containner').scrollLeft();
scr_X = 0;
$('.sliding_box').on('wheel', function (event) {

    console.log(event.originalEvent.deltaY);
    console.log(scr_X);
    if (event.originalEvent.deltaY < 0) {
        if(scr_X>0) {
            $('#sliding_containner').scrollLeft(scr_X-=1000);
        }
    } else {
        if(scr_X<16000) {
            $('#sliding_containner').scrollLeft(scr_X+=1000);
        }
    }


});

/* 수평 수직 스크롤 전환 */
// let scrVert = document.querySelector('.sliding_box');
// let scrHorizen = document.querySelector('#templete_container');
// scrVert.addEventListener('mouseover', function (){
//     scrHorizen.style.overflowY='hidden';
// });
// scrVert.addEventListener('mouseout', function (){
//    scrHorizen.style.overflowY='scroll';
// });