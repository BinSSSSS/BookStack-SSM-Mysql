function deleteByFileId(fileId) {

	if (!window.confirm("确定要删除吗?")) {
		return;
	}
	console.log("删除操作被触发");
	
	$.ajax({
		url : "upload_file_delete",
		method : "POST",
		data:{
			_method: "DELETE",
			fileId: fileId
		},
		success : function(data) {
			if (data == SUCCESS) {
				window.location.reload();
			} else if(data ==  FILE_NOT_EXIST){
				alert("文件不存在");
			} else if(data == FAILED){
				alert("文件删除失败");
			}else{
				window.location.reload();
			}
		}
	});
}

function downloadByFileId(fileId){
	
	console.log("资源文件被下载");
	$.ajax({
		url : "upload_file_download",
		type : "GET",
		data: {
			fileId: fileId
		},
		success : function(data) {
			if (data != "404") {
				$("body").after(
						"<a id='download' href='" + data
								+ "' download=''></a>");
				document.getElementById("download").click();
				$("#download").remove();
				console.log("data: " + data);
			} else {
				alert("资源文件不存在或不允许被下载!");
			}
		}
	});
}