// (1) 회원정보 수정
function update(userId) {
	let data = $("#profileUpdate").serialize(); // 해당 태그가 가지고 있는 모든 input값을 찾아낸다.
	console.log(data);	
	
	$.ajax({ // 자바스크립트 오브젝트가 들어가는 영역
		type: "put", // 통신할 method
		url: `/api/user/${userId}`, // 변수가 있을 시 ``(backtick) 사용
		data: data, //전송할 데이터
		contentType: "application/x-www-form-urlencoded; charset=utf-8", // data가 무엇인지 서버에 설명해주는 공간
		dataType: "json" // 서버로부터 응답받고 싶은 데이터 타입
	}).done(res=>{ // 성공했을 시 응답하는 영역
		console.log("update 성공", res);
		alert("회원정보가 성공적으로 수정되었습니다.");
		location.href = `/user/${userId}`;
	}).fail(error=>{ // 실패했을 시 응답하는 영역
		console.log("update 실패", error);
	});
}