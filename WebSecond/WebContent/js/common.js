
function hobbyChk() {
	var frm = document.querySelector('#frm');
	
	var elei_hobby = frm.i_hobby;
	var elenm = frm.nm;
	
	if(elei_hobby.value == '') {
		alert('i_hobby값을 입력해 주세요');
		elei_hobby.focus();
		return false;
		
	} else if(elenm.value.length == 0) {
		alert('취미값을 입력해주세요');
		elenm.focut();
		return false;
	}
	
}

function chkDel(i_hobby) {
	if(confirm(`${i_hobby}번 취미를 삭제하시겠습니까?`)) {
		location.href = `/WebSecond/delHobby?i_hobby=${i_hobby}`;
	}
}