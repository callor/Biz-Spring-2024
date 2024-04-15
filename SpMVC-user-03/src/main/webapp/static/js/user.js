document.addEventListener("DOMContentLoaded", () => {
  const join_form = document.querySelector("form.join");
  const username = join_form.querySelector("input[name='u_name']");
  const password = join_form.querySelector(
    "input[name='u_password']"
  );
  const re_password = join_form.querySelector(
    "input[name='re_password']"
  );
  const btn_join = join_form.querySelector("button");

  btn_join.addEventListener("click", () => {
    if (!username.value) {
      alert("USERNAME 은 반드시 입력하세요");
      username.select();
      return false;
    }
    if (!password.value) {
      alert("PASSWORD 는 반드시 입력하세요");
      password.select();
      return false;
    }
    if (!re_password.value) {
      alert("PASSWORD 확인은 반드시 입력하세요");
      re_password.select();
      return false;
    }
    if (password.value !== re_password.value) {
      alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
      password.select();
      return false;
    }
    // form 의 전송 실행하기
    join_form.submit();
  });
});
