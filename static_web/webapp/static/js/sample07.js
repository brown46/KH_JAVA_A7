/**
 * 아이디, 패스워드를 검사 후 오류가 발생하는 경우
 * 사용자 입력 폼에 에러 메시지가 담긴 span 태그를 
 * 추가하고 입력 양식에는 테두리를 붉게 설정하여 사용자가
 * 잘못된 입력이라는 것을 알 수 있게 하세요
 * 
 * 아이디는 6자리 미만인 경우 오류가 발생하게 합니다.
    패스워드는 패스워드와 패스워드 확인이 동일하지 않을 때
    오류가 발생하게 합니다.
    패스워드도 4자리 미만인 경우 오류가 발생하기 합니다.
 */

function validCheck(form){
    var isValid=true;
    if(form.username.nextElementSibling!==null){
        form.username.nextElementSibling.remove();
    }
    if(form.passwordCheck.nextElementSibling!==null){
        form.passwordCheck.nextElementSibling.remove();
    }
    if(form.password.nextElementSibling!==null){
        form.password.nextElementSibling.remove();
    }
    if(form.password.value!==form.passwordCheck.value){
        spanErrorMessage(form.passwordCheck,"패스워드가 일치하지 않습니다.");
        form.passwordCheck.value="";
        isValid= false;
        form.passwordCheck.style.borderColor="red";
        form.passwordCheck.style.borderWidth="1px";
    }

    if(form.password.value===form.passwordCheck.value){
        spanErrorMessage(form.passwordCheck,"");
        form.passwordCheck.style.borderColor="black";
        form.passwordCheck.style.borderWidth="1px";
    }

    if(form.password.value.length<4){
        spanErrorMessage(form.password,"패스워드는 4자리 이상이어야 합니다.");
        form.password.value="";
        form.passwordCheck.value="";
        isValid= false;
        form.password.style.borderColor="red";
        form.password.style.borderWidth="1px";
    }
    if(form.password.value.length>=4){
        spanErrorMessage(form.password,"");
        form.password.style.borderColor="black";
        form.password.style.borderWidth="1px";
    }



    if(form.username.value.length<6){
        spanErrorMessage(form.username,"아이디를 6자리 이상 입력하세요.");
        form.username.value="";
        isValid= false;
        form.username.style.borderColor="red";
        form.username.style.borderWidth="1px";
    }
    if(form.username.value.length>=6){
        spanErrorMessage(form.username,"");
        form.username.style.borderColor="black";
        form.username.style.borderWidth="1px";
    }

    return isValid;
}



function spanErrorMessage(element,message){
    let msg= document.createElement("span");
    msg.innerText=message
    element.after(msg);
    return msg;
}
