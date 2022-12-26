/**
 * 실시간 검사
 *      아이디는 6~12자 사이의 값을 입력하였는지 실시간으로 검사하여 문제가 있는 경우
 *      붉은색 테두리와 에러 메시지로 사용자에게 즉시 알릴 수 있도록 하고 정상 입력인 경우
 *      초록색 테두리와 정상 메시지로 사용자에게 즉시 알릴 수 있도록 한다.
 * 
 *      패스워드는 4~12 자 사이의 값을 입력하였는지 실시간으로 검사하여 위의 아이디와 동일한
 *      처리를 하도록 한다.
 *      
 *      패스워드 확인은 기존에 입력한 패스워드와 동일한 값인지를 실시간으로 검사하여 위의 아이디와
 *      동일한 처리를 하도록 한다.
 */




window.onload= function validCheck() {
    var form = document.forms[0];
    form.username.addEventListener("input", function(){
        if(form.username.nextElementSibling!==null){
            form.username.nextElementSibling.remove();
        }
        if(form.username.value.length < 6 || form.username.value.length >12) {
            var error = createErrorMessage("아이디는 6자리 이상 12자리 이하여야 합니다.");
            form.username.after(error);
            errorInput(form.username);
        }else{
            form.username.classList.remove("is-invalid");
            form.username.classList.add("is-valid");
        }
    });


    form.password.addEventListener("input", function(){
        if(form.password.nextElementSibling!==null){
            form.password.nextElementSibling.remove();
        }
        if(form.password.value.length < 4||form.password.value.length > 12) {
            var error = createErrorMessage("패스워드는 4자리 이상 이상 12자리 이하여야 합니다.");
            form.password.after(error);
            errorInput(form.password);
        }else{
            form.password.classList.remove("is-invalid");
            form.password.classList.add("is-valid");
            
        }
    });
    
    form.passwordCheck.addEventListener("input", function(){
        if(form.passwordCheck.nextElementSibling!==null){
            form.passwordCheck.nextElementSibling.remove();
        }
        if(form.password.value !== form.passwordCheck.value) {
            var error = createErrorMessage("패스워드를 다시 확인하세요.")
            form.passwordCheck.after(error);
            errorInput(form.passwordCheck);
        }else{
            form.passwordCheck.classList.remove("is-invalid");
            form.passwordCheck.classList.add("is-valid");
        }
    });

}
function errorInput(element) {
    // element.value = "";
    /* element.style.borderColor = "red"; */
    /* element.style.borderStyle = "solid"; 
    부트스트랩을 하용하지 않을 때*/
    element.classList.add("is-invalid");
}
function createErrorMessage(message) {
    var div = document.createElement("div");
    div.className = "invalid-feedback";
    div.innerText = message;
    return div;
}

















// window.onload= function(){
//     var div=document.getElementById("id_div");
//     var input = document.getElementById("id_input");
//     var select = document.getElementById("id_select");

//     // input.addEventListener("focus", function(){
//     //     console.log("focus 이벤트 발생");
//     // })
//     input.onfocus= function(){
//         console.log("focus 이벤트 발생");
//     }

//     input.addEventListener("blur", function(){console.log("blur이벤트 발생")});

//     input.addEventListener("input", function(){console.log("input 이벤트 발생")});

//     div.addEventListener("mouseenter", function(){console.log("마우스가 요소 위에 올려져 있을 때")})
//     input.addEventListener("mouseenter", function(){console.log("마우스가 요소 위에 올려져 있을 때")})

//     div.addEventListener("mouseleave", function(){console.log("마우스가 요소에서 벗어날 때")})
//     input.addEventListener("mouseleave", function(){console.log("마우스가 요소에서 벗어날 때")})

//     div.addEventListener("click", eventHandler);
//     div.addEventListener("dblclick", function(){console.log("더블 클릭을 할 때")});

//     input.addEventListener("change", function(){console.log("값이 변경되었을 때")});
//     select.addEventListener("change", function(){console.log("값이 변경되었을 때")});
// }

function eventHandler(e) {
    switch(e.type) {
        case "click":
            console.log("클릭 이벤트 발생!!"); break;
        case "dblclick":
            console.log("더블 클릭 이벤트 발생!!"); break;
        case "focus":
            console.log("포커스 이벤트 발생!!"); break;
        case "blur":
            console.log("블러 이벤트 발생"); break;
        case "input":
            console.log("입력 이벤트 발생"); break;
        case "change":
            console.log("값 변경 이벤트 발생"); break;
        case "mouseenter":
            console.log("마우스엔터 이벤트 발생"); break;
        case "mouseleave":
            console.log("마우스리브 이벤트 발생"); break;
    }
    console.log(e.target);
}