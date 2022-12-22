function validForm(){
    
    var form = document.forms[0];
    var pw =form.password.value;
    var pwc =form.passwordCheck.value;
    if(pw===pwc){
        return true
    }else{
        document.getElementById('msg').innerText='비밀번호가 일치하지 않습니다.';
        form.passwordCheck.value='';
        return false;//전송하지 않음 
    }
}
