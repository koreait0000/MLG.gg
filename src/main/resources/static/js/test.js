// HTML
// <div class="sliding-box">
//     <img class="left" src="image/arrow.jpg" alt="다음" />
//     <div class="sliding-viwe">
//     <ul class="containner">
//     <li>
//     <img src="image/baby1.jpg" alt="" />
//     </li>
// <li>
//     <img src="image/baby2.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby3.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby4.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby5.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby6.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby7.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby8.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby9.jpg" alt="" />
// </li>
// <li>
//     <img src="image/baby10.jpg" alt="">
// </li>
// </ul>
// </div>
// <img class="right" src="image/arrow.jpg" alt="이전" />
// </div>
//
// CSS
// .sliding-box {
//     display: -webkit-box;
//     display: -ms-flexbox;
//     display: -webkit-flex;
//     display: flex;
//     margin: 0 auto;
//     width: 1020px;
//     height: auto;
//     justify-content: space-between;
// }
//
// .sliding-box .left,
// .sliding-box .right {
//     width: 30px;
//     height: 30px;
//     margin-top: 60px;
//     cursor: pointer;
// }
//
// .sliding-box .right {
//     -webkit-transform: rotate(-180deg);
//     -ms-transform: rotate(-180deg);
//     -moz-transform: rotate(-180deg);
//     -o-transform: rotate(-180deg);
//     transform: rotate(-180deg);
// }
//
// .sliding-viwe {
//     overflow: hidden;
//     position: relative;
//     flex-basis: 900px;
//     width: 900px;
//     height: 180px;
// }
//
// .sliding-viwe .containner {
//     position: absolute;
//     left: 0;
//     margin: 0px;
//     width: 1800px;
//     background-color: #fff;
// }
//
// .sliding-viwe .containner li {
//     float: left;
//     margin: 0px;
//     width: 180px;
//     height: 180px;
//     text-align: center;
// }
//
// .sliding-viwe .containner li img {
//     margin: 15px auto;
//     width: 150px;
// }
//
//
//
// jS
// $(function(){
//
// // 무한 반복 슬라이딩 //
//
//     let current= 0;
//     let show = 5;
//     let containner = $('#slidingMenu .sliding-viwe .containner');
//     let length = containner.find('>li').length;
//     let viwe =  $('#slidingMenu .sliding-viwe').width();
//     let tt = viwe/show; //이동거리 -한칸씩 움직이기//
//     let next = $('#slidingMenu .sliding-box .right');
//     let prev = $('#slidingMenu .sliding-box .left');
//
//     containner.css('width','length*tt');//컨테이너 길이 초기화//
//
//     next.on({
//         click:function(){
//
//             if(current == length) {//마지막 엘리먼트에 다다르면 current 초기화//
//                 current = 0;
//             }
//
//             if(current == 0){
//                 //먼저 복사된 엘리먼트 삭제하고 위치 초기화//
//                 containner.find('>li').eq(length-1).nextAll().remove();
//                 containner.css({left:0}).stop();
//
//                 //이동//
//                 current++;
//                 containner.stop().animate({left:tt*current*-1},{duration:900});
//
//                 //엘리먼트 복사 - 컨네이너의 자식 모두 복사//
//                 let cloneEl = containner.children().clone();
//                 //복사된 엘리먼트 수 만큼 길이 늘리고 붙이기//
//                 containner.css({width:containner.innerWidth()+(tt*length)});
//                 cloneEl.appendTo(containner);
//             }
//             else if(current >= 1){
//
//                 current++;
//                 containner.stop().animate({left:tt*current*-1},{duration:900});
//             }
//
//         },
//         mouseenter:function(){
//             clearInterval(Sliding);
//         },
//         mouseleave:function(){
//             slidingTimer();
//         }
//     });
//
//     prev.on({
//         click:function(){
//             if(current == 0){
//                 //먼저 복사된 엘리먼트 삭제하고 위치 초기화//
//                 containner.find('>li').eq(length-1).nextAll().remove();
//                 containner.css({left:0}).stop();
//
//                 //인덱스 순서를 length로 치환해줌//
//                 current=length;
//
//                 //앞쪽으로 엘리먼트 복사해서 붙이기//
//                 //길이 & 위치 초기화 -앞쪽으로 붙었기 떄문에 늘어난 길이 만큼 left시작 위치가 -가 되어야함//
//                 let cloneEl = containner.children().clone();
//
//                 containner.css({left:tt*length*-1,width:containner.innerWidth()+(tt*length)}).stop();
//                 cloneEl.prependTo(containner);
//
//                 //붙이고 나서 바로 이동 되도록//
//                 current--;
//                 containner.stop().animate({left:tt*current*-1},{duration:900});
//             }
//             else if(current > 0 ){
//                 current--;
//                 containner.stop().animate({left:tt*current*-1},{duration:900});
//             }
//
//         },
//         mouseenter:function(){
//             clearInterval(Sliding);
//         },
//         mouseleave:function(){
//             slidingTimer();
//         }
//     });
//
//
//     //컨테이너에 hover 되면 타이머 일시정지//
//     containner.on({
//         mouseenter:function(){
//             clearInterval(Sliding);
//         },
//         mouseleave:function(){
//             slidingTimer();
//         }
//     });
//
//     slidingTimer();
//
//     //자동 슬라이딩 타미머 함수 정의//
//     function slidingTimer(){
//         Sliding = setInterval(function(){
//
//             next.trigger('click');
//
//         },3000);
//     }
// });