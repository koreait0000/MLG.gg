/* 씨발보류1 */
// $('#sliding_containner').on('scroll touchmove mousewheel', function(e){
//
//     e.preventDefault();
//
//     e.stopPropagation();
//
//     return false;
//
// })

/* 씨발보류2 */
// $(document).ready(function (){
//     $('#sliding_containner').mouseover(function (e){
//         $('#templete_container').on('scroll mousewheel', function (e){
//             e.preventDefault();
//             e.stopPropagation();
//             return false;
//         })
//     });
// });



// ziral=function (){
//     var _scrX = $('#sliding_containner').scrollLeft();
//     $('#sliding_containner').scrollLeft(_scrX + 1000);
// };

// let testtest = document.querySelector('#sliding_containner');
// let testtest2 = document.querySelector('#templete_container');
//
// testtest.addEventListener('mouseover',function (){
//     testtest2.style.overflowY='hidden';
// });
// testtest.addEventListener('wheel', function (){
//    // console.log(event.originalEvent.deltaY);
// });
//
//
// testtest.addEventListener('mousewheel', function (){
//    testtest.scrollLeft+=1000;
// });

/*---------------------  스크롤 휠   ---------------------------*/
var scr_X = $('#sliding_containner').scrollLeft();

$('.sliding_box').on('wheel', function (event){

    console.log(event.originalEvent.deltaY);

    if (event.originalEvent.deltaY < 0) {
        $('#sliding_containner').scrollLeft(scr_X -= 1000);

    }
    else {
        $('#sliding_containner').scrollLeft(scr_X += 1000);

    }
});
let scrVert = document.querySelector('.sliding_box');
let scrHorizen = document.querySelector('#templete_container');
scrVert.addEventListener('mouseover', function (){
    scrHorizen.style.overflowY='hidden';
});
scrVert.addEventListener('mouseout', function (){
   scrHorizen.style.overflowY='scroll';
});


// window.addEventListener('scroll', function (){
//     let slideScrX = document.querySelector('#sliding_containner').scrollLeft;
//
//
// });







// function ziral() {
//     document.querySelector('#sliding_containner').scrollLeft(document.querySelector('#sliding_containner')+3000);
// }

/* 씨발보류3 */
// $("#sliding_containner").on('mouseover',function(e){
//
//     var wheelDelta = e.originalEvent.wheelDelta;
//
//     if(wheelDelta > 0){
//
//         console.log("up");
//
//         $(this).scrollLeft(-wheelDelta + $(this).scrollLeft());
//
//     }else{
//
//         console.log("down");
//
//         $(this).scrollLeft(-wheelDelta + $(this).scrollLeft());
//
//     }
//
// });
//

// window.addEventListener('scroll', function (){
//    console.log(document.querySelector('body').scrollTop);
//    console.log(document.querySelector('#sliding_containner').scrollLeft);
// });






