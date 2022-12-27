// var username=document.getElementById("username");
// var msg1= document.createElement("div");
// msg1.innerText="아이디 오류";
// username.after(msg1);


// var password=document.getElementById("pw");
// var msg2= document.createElement("div");
// msg2.innerText="패스워드 오류";
// password.after(msg2);

// var passwordCheck = document.getElementById("pwCk");
// var msg3 = document.createElement("div");
// msg3.innerText = "패스워드 체크 오류";
// passwordCheck.after(msg3);

// var realname = document.getElementById("name");
// var msg4 = document.createElement("div");
// msg4.innerText = "이름 오류";
// realname.after(msg4);





window.onload = function validCheck() {
    var username = document.getElementById("username");
    var idError = document.getElementById("idError");
    username.addEventListener("input", function () {
        if (idError.nextElementSibling.id !== 'pwError') {
            idError.nextElementSibling.remove();
        }
        if (username.value.length < 5 || username.value.length > 20) {
            var error = createErrorMessage("5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
            idError.after(error);
            errorInput(username);
        } else {
            // element.style.borderColor = "black"; 
            username.style.borderStyle = "none";
        }
    });
    username.addEventListener("blur", function () {
        if (idError.nextElementSibling.id !== 'pwError') {
            idError.nextElementSibling.remove();
        }
        if (username.value==='') {
            var error = createErrorMessage("필수 정보입니다.(아이디)");
            idError.after(error);
            errorInput(username);
        } else {
            
            username.style.borderStyle = "none";
        }
    });







    var password = document.getElementById("pw");
    var pwError = document.getElementById("pwError");
    password.addEventListener("input", function () {
        if (pwError.nextElementSibling.id !== 'pwCkError') {
            pwError.nextElementSibling.remove();
        }
        if (password.value.length < 8 || password.value.length > 16) {
            var error = createErrorMessage("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
            pwError.after(error);
            errorInput(password);
        } else {
            password.style.borderStyle = "none";
        }
    });
    password.addEventListener("blur", function () {
        if (pwError.nextElementSibling.id !== 'pwCkError') {
            pwError.nextElementSibling.remove();
        }
        if (password.value==='') {
            var error = createErrorMessage("필수 정보입니다.(비밀번호)");
            pwError.after(error);
            errorInput(password);
        } else {
            password.style.borderStyle = "none";
        }
    });
    






    var passwordCheck = document.getElementById("pwCk");
    var pwCkError = document.getElementById("pwCkError");
    passwordCheck.addEventListener("blur", function(){
        if(pwCkError.nextElementSibling!==null){
            pwCkError.nextElementSibling.remove();
        }
        if(passwordCheck.value ==='') {
            var error = createErrorMessage("필수 정보입니다.(비밀번호 재확인)")
            pwCkError.after(error);
            errorInput(passwordCheck);
        }else if(password.value !== passwordCheck.value) {
            var error = createErrorMessage("패스워드를 다시 확인하세요.")
            pwCkError.after(error);
            errorInput(passwordCheck);
        }else {
            pwCk.style.borderStyle = "none";
        }
    });
    passwordCheck.addEventListener("input", function(){
        if(pwCkError.nextElementSibling!==null){
            pwCkError.nextElementSibling.remove();
        }
        if(password.value !== passwordCheck.value) {
            var error = createErrorMessage("패스워드를 다시 확인하세요.")
            pwCkError.after(error);
            errorInput(passwordCheck);
        }else{
            pwCk.style.borderStyle = "none";
        }
    });
    






    var Rname = document.getElementById("Rname");
    var RnameError = document.getElementById("RnameError");
    Rname.addEventListener("blur", function(){
        if(RnameError.nextElementSibling.className!=='input-group'){
            RnameError.nextElementSibling.remove();
        }
        if(Rname.value ==='') {
            var error = createErrorMessage("필수 정보입니다.(이름)")
            RnameError.after(error);
            errorInput(Rname);
        }else{
            Rname.style.borderStyle = "none";
        }
    });
    Rname.addEventListener("input", function(){
        if(RnameError.nextElementSibling.className!=='input-group'){
            RnameError.nextElementSibling.remove();
        }
        if(Rname.value ==='') {
            var error = createErrorMessage("필수 정보입니다.(이름)")
            RnameError.after(error);
            errorInput(Rname);
        }else{
            Rname.style.borderStyle = "none";
        }
    });




    var year= document.getElementById("year");
    var dateError= document.getElementById("dateError");
    year.addEventListener("blur",function(){
        if(dateError.nextElementSibling !== null){
            dateError.nextElementSibling.remove();
        }
        if(year.value.length!=4){
            var error= createErrorMessage("태어난 년도 4자리를 정확하게 입력하세요.")
            dateError.after(error);
            errorInput(year);
        } else{
            year.style.borderStyle = "none";
        } 

    });

    
    var month= document.getElementById("month");
    month.addEventListener("change",function(){
        if(dateError.nextElementSibling !== null){
            dateError.nextElementSibling.remove();
        }
        if(month.value==='월'){
            var error= createErrorMessage("태어난 월을 선택하세요.")
            dateError.after(error);
            errorInput(month);
        }  else{
            month.style.borderStyle = "none";
        } 

    });



    var date= document.getElementById("date");
    date.addEventListener("blur",function(){
        if(dateError.nextElementSibling !== null){
            dateError.nextElementSibling.remove();
        }
        if(date.value.length!=2){
            var error= createErrorMessage("태어난 일(날짜) 2자리를 정확하게 입력하세요.")
            dateError.after(error);
            errorInput(date);
        }   else{
            date.style.borderStyle = "none";
        } 

    });




    var gender= document.getElementById("gender");

    gender.addEventListener('change',function(){
        if(genderError.nextElementSibling !== null){
            genderError.nextElementSibling.remove();
        }
        if(gender.value=='성별'){ 
        var error= createErrorMessage("필수 정보입니다.")
        genderError.after(error);
        errorInput(gender);
        }else{
        gender.style.borderStyle = "none";
        }
    })

    var phone= document.getElementById("phone");
    var phoneError= document.getElementById("phoneError");
    phone.addEventListener('blur',function(){
        if(phoneError.nextElementSibling!==null){
            phoneError.nextElementSibling.remove()
        }
        if(phone.value==''){
            var error= createErrorMessage("필수 정보입니다.")
            phoneError.after(error);
            errorInput(phone);
        }else{
            phone.style.borderStyle = "none";
        }
    })
}











function errorInput(element) {
    // element.value = "";
    element.style.borderColor = "red";
    element.style.borderStyle = "solid";
    element.style.borderWidth="1px";
    // 부트스트랩을 하용하지 않을 때
    // element.classList.add("is-invalid");
}
function createErrorMessage(message) {
    var div = document.createElement("div");
    div.className = "invalid-feedback";
    div.innerText = message;
    return div;
}
// function check(element){
//     element.style.borderWidth="1px";
//     element.style.borderColor = "rgb(3,199,90)";
//     element.style.borderStyle = "solid";
// }

function createAuthNum(){
    var num =parseInt(Math.random()*9000)+1000;
    var authNum= document.getElementById("authNum");
    authNum.value=num;
    authNum.disabled=false;

}