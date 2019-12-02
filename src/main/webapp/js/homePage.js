

$(function(){
  
    ///站长心语
    var $myHeat = $(".about");
    var $words = $(".words");

    //点击按钮事件
    $myHeat.click(function(){
    	if($words.css("display") == 'none')
    	{
    		$words.css({
			display: "block"
			})
    	}
    	else{
    		$words.css({
			display: "none"
			})
    	}
	});

    
    ///点击关注
    var $follows = $(".follow");

    //点击关注按钮
    for(var i = 0; i < $follows.length; ++i){
    	$($follows[i]).click(function(){

    	    //如果未关注的话，点击则进行关注
    	    if($.trim(($(this).text())) == "关注"){
                $(this).text(" 已关注");
                $(this).prepend("<i class='iconfont icon-yiguanzhu'></i>");
                $(this).css({
                    color: "orange"
                });
            }
            //关注了之后点击则取消关注
            else
            {
                $(this).css({
                    color: "blue"
                });
                $(this).text(" 关注");
                $(this).prepend("<i class='iconfont icon-jia'></i>");
            }
    	})
    }
})


	
