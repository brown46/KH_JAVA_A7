console.log("외부 자바스크립트 파일 실행")

function fn1(){
    document.getElementById("print_area").innerText= "함수가 실행되었습니다."
}


/* 매개변수가 있는 함수 */
function fn2(x,y){
    let tot =x+y;
    document.getElementById("print_area").innerText="x+y의 값은 "+tot+ "입니다."
}

/* 매개 변수에 기본값을 설정한 함수 */
function fn3(x=0,y=0){
    let tot =x+y;
    document.getElementById("print_area").innerText="x+y의 값은 "+tot+ "입니다."
}

/* 가변 매개변수 함수: 매개변수의 수가 0개 이상이 사용될 수 있는 함수 */
function fn4(...x){ 
    console.log(x);
    document.getElementById("print_area").innerText="가변 매개변수로 다음의 값을 받았습니다. -> "+x;
}


/*익명 함수: 함수를 만들때 함수의 이름 없이 만들어서 사용 */
var fn5= function(x,y){
    console.log(x+y)
    document.getElementById("print_area").innerText="익명함수가 실행되었습니다.";
}

/*화살표 함수: 익명 함수를 더 간략하게 만들어서 사용하기 위한 함수*/
var fn6 = () =>{
    document.getElementById("print_area").innerText="화살표 함수가 실행되었습니다."
}

var fn7=() => "Arrow Function";
var fn8=(x,y) => x+y;
