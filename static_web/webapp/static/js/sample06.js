/**
 * 
 */
function addItem(form){
    /*목록을 추가하는 함수 */

    // 

    var list = document.getElementById("list");
    var li= document.createElement("li");
    li.innerText= form.item.value;
    
    
    if(form.loc.value=="first"){
        list.prepend(li);
    }else if(form.loc.value==="last"){
        list.append(li);
    }
    form.item.value="";
    
    // 매개변수로 this.element 받음
    // var item = element.previousElementSibling.value;
    // var li = document.createElement("li");
    // li.innerText = item;
    // var list = document.getElementById("list");
    // list.append(li);
    // element.previousElement5ibling.value=""
}

function addRow(){
    /* 테이블에 행을 추가하는 함수로 한 행에는 5열이 들어간다.
        사용자 입력으로 제목과 작성자는 받을 수 있으며 번호는 
        전체 행수 +1 이 설정되게 하고(tbody의 행수만).
        작성일은 new Date() 객체를 사용하여 현재 날짜를 구하여 쓰며
        조회수는 기본 0으로 설정한다. */
    date =new Date();
    
    var form2 =document.forms[1];
    var tbody =document.getElementById("table").lastElementChild;
    // var tr=document.createElement("tr");
    // tbody.innerHTML='<tr id="trr"  onclick="counting(this);"> </tr>';
    var td1=document.createElement("td");
    var table = document.getElementById("table");
    var count =table.tBodies[0].rows.length;
    var tr =document.getElementById("trr");

    var tr= createTableRow(5);    
    tr.children[0].innerText=count+1;
    tr.children[1].innerText=setAndClear(form2.title);
    tr.children[2].innerText=setAndClear(form2.writer);
    tr.children[3].innerText=date.getFullYear()+"년 "+(date.getMonth()+1)+"월 "+date.getDate()+"일" ;
    tr.children[4].innerText=0;

    tbody.append(tr);
    form2.title.value="";
    form2.writer.value="";
}

function setAndClear(inputElement){
    var value =inputElement.value;
    inputElement.value="";
    return value;
}


function createTableRow(columCount){
    var row= document.createElement("tr");
    for(let idx=0; idx<columCount;idx++){
        let column = document.createElement("td");
        row.append(column);
    }
    return row;
}


function counting(element){
    var count= element.lastElementChild;
    count.innerText=(parseInt(count.innerText)+1);
}

function validCheck(form){
    /**
     * 동일한 패스워드를 사용하는지 검사 후 동일하지 않은 값을 입력한 경우
     * 패스워드 확인 입력 양식 옆에 "다시 입력하시오."  라는 메시지가 나오도록 합니다.
     * username 에서는 6자리 이상의 아이디가 아닌 경우 패스워드와 동일하게 
     * 아이디 입력 양식 옆에 "6자리 이상 입력하시오." 라는 메시지가 나오도록 합니다.
     */

    
    var isValid=true;
    if(form.username.nextElementSibling!==null){
        form.username.nextElementSibling.remove();
    }
    if(form.passwordCheck.nextElementSibling!==null){
        form.passwordCheck.nextElementSibling.remove();
    }
    if(form.password!==form.passwordCheck){
        spanErrorMessage(form.passwordCheck,"다시 입력하시오.");
        form.passwordCheck.value="";
        isValid= false;
    }
    if(form.username.value.length<6){
        spanErrorMessage(form.username,"6자리 이상 입력하시오.");
        form.username.value="";
        isValid= false;
    }
    return isValid;
}

function spanErrorMessage(element,message){
    let msg= document.createElement("span");
    msg.innerText=message
    element.after(msg);
    return msg;

}