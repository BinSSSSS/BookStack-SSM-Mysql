	function deleteByUsername(username) {
		if (!window.confirm("是否确定删除?")) {
			return;
		}
		$.ajax({
			url : "user_delete",
			method : "post",
			data : {
				_method : "DELETE",
				username : username
			},
			success : function(data) {
				if (data == SUCCESS) {
					console.log("成功");
					window.location.reload();
				} else if(data == USERNAME_NOT_EXIST){
					alert("用户不存在!");
				}else if(data == CAN_NOT_DEL_CURRENT_USER){
					alert("无法删除当前登录用户!");
				}else {
					window.location.reload();
				}
			},
			error : function(data) {
				alert(data);
			}
		});
	}