$(document).ready(function(){
    // $("form>button").on("click", bookmark);
    // $("ul a").hover(
    //     function(e) {
    //     var herf=$(e.target).attr("href");
    //     var name=$(e.target).text();
    //     $("form [name=url]").val(herf);
    //     $("form [name=name]").val(name);
    //     },
    //     function(e) {
    //         $("form [name=url]").val("");
    //         $("form [name=name]").val("");
    //     } 
    // );
    $("form > button").on("click",
        function(e) {
            if($(e.target).attr("on") ==="false"){
                $(e.target).css("border-color", "red");
                $(e.target).attr("on", "true");
            } else {
                $(e.target).removeAttr("style");
                $(e.target).attr("on", "false");
            }   
        }
    );
});
//     var input1 =$("form").find("input").eq(0);
//     var input2 =$("form").find("input").eq(1);
//     var li=$("<a></a>").attr("href",input1.val()).append(input2.val())
//     $("<li></li>").append(li).appendTo("ul");
// }
// )
function bookmark(event){
    console.log(event);
    var input1 =$(event.target.form.url);
    var input2 =$(event.target.form.name);
    var li=$("<a></a>").attr("href",input1.val()).append(input2.val())
    $("<li></li>").append(li).appendTo("ul");
    $(event.target.form).children("input").val("");
}