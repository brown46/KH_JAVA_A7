


function createList(id){
    var resultDiv =document.getElementById(id);
    var items=getListItems();
    console.log(items);
    var ultag= "";
    for(let i=0;i<items.length;i++){
        ultag+="<li>"+items[i]+"</li>";
        console.log(ultag);
    }
    
    resultDiv.innerHTML="<ul>"+ultag+"</ul>";
    
}

/*프롬프트로 입력 받은 문자열을 배열로 만들어서 반환하는 함수*/
function getListItems(){
    var items=prompt("쉼표를 구분자로 하는 목록을 작성하세요.").split(',');
    
    return items;
}

/*1월~12월 까지 생성. 현재 월이 select 태그에 초기 선택되어 나와야한다. */
function createMonth(id){
    var selectTag= document.getElementById(id);
    var date = new Date();
    var currentMonth=date.getMonth();
    var month;
    for(let i=0;i<12;i++){
        if(currentMonth==i){
            month+="<option selected>"+(i+1)+"월</option>"
        }else{
            month+="<option>"+(i+1)+"월</option>"
        }
        // month += m === currentMonth + 1 ? "<option selected>" : "<option>";
        // month += m + "월</option>";
    }
    selectTag.innerHTML=month;   
}
