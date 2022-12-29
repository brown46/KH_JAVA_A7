$(document).ready(function() {


    $(".header-center a").on("click",function(e){
        $(".header-center a").attr("style","color:black");
        $(e.target).attr("style","color:blue");
    })

    $(".sector1 a").on("click",function(e){
        $(".sector1 a").attr("style","color:black");
        $(e.target).attr("style","color:blue");
    })


    $(".sector2 table tr").hover(function(e){
        $(".sector2 table tr").attr("style","background-color:white");
        $(".sector2 table tr:nth-child(2n+1)").attr("style"," background-color: rgb(238, 237, 239);");
        $(e.target.parentNode).attr("style","background-color:gray");
    })


        $("#select option:selected").val();








    $(".buttons botton").on("click",function(e){
        $(".buttons button").attr("style","color:white");
        $(e.target).attr("style","color:blue");
    })


    $(".sector3 a").on("click",function(e){
        $(".sector3 a").attr("style","color:black");
        $(e.target).attr("style","color:blue");
    })


    
});


function showRow(){
    var tr=$("<tr></tr>")
}