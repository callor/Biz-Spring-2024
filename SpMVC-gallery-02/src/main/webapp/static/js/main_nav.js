// main-nav 각 tag className 을 키로 하는 객체 선언

/*
JSON type 의 객체
  형식 = { Key:value }
  console.log(NAV_INDEX.home) 결과는 ? {url : "/"}
  console.log(NAV_INDEX.hom.url) 결과는 ? "/"
  console.log(NAV_INDEX["home"]) 결과는 ?  {url : "/"}

*/
const NAV_INDEX = {
  home: { url: "" },
  notice: { url: "bbs/notice" },
  free: { url: "bbs/free" },
};
document.addEventListener("DOMContentLoaded", () => {
  const mainNav = document.querySelector("nav.main");
  const navItmes = mainNav.querySelectorAll("li");

  mainNav?.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "LI") {
      const className = target.classList[0];
      const url = NAV_INDEX[className].url;
      document.location.href = `${rootPath}${url}`;
      // nav 각 클릭 되었을때 active 한 UI 를 보여주기 위한 설정
      // 그런데 nav 를 클릭하면 화면이 refresh 되버리기 때문에 의미가 없다
      // 모든 nav.main li tag 에 active 라는 class 를 제거하기
      // navItmes.forEach((item) => {
      //   item.classList.remove("active");
      // });
      // // 클릭된 항목에 active 라는 클래스를 추가하기
      // target.classList.add("active");
    }
  });

  // 화면이 새로 refresh 되었을때, 또는 화면이 최초로 보일때 실행할 코드

  // 현재 화면이 보여지는 URL
  // http://localhost:8080/gallery/bbs/free/write
  const path = document.location.pathname;

  // pathname 을 슬래스(/)를 기준으로 단어단위로 자르기
  const pathArr = path.split("/");

  // locahost:8080/gallery/ 로 끝나면 localhost:8080/gallery/home 이라고 만들어라
  pathArr[pathArr.length - 1] || pathArr.push("home");

  // URL 중에서 가장 끝에 오는 URL 문자열은?
  // 가장 끝의 문자열이 "" 이면 "home" 문자열로 대치
  // const pathname = pathArr[pathArr.length - 1] || "home";

  // nav 가 1단계만 있을 경우
  // document
  //   .querySelector(`nav.main li.${pathname}`)
  //   ?.classList.add("active");

  // // nav 가 2단계 이상일 경우
  // // JSON type 의 데이터를 Array type 의 데이터로 변환하기
  // const navs = Object.values(NAV_INDEX);
  // navs.forEach((nav) => {
  //   // 배열.join("sp") : 배열을 sp 문자열을 중간에 추가하여 하나의 문자열로 바꾸는 함수
  //   if (pathArr.join(" ").includes(nav.name)) {
  //     document
  //       .querySelector(`nav.main li.${nav.name}`)
  //       ?.classList.add("active");
  //   }
  // });

  // navs 는 home, notice, free 라는 요소가 있는 배열이 된다
  const navs = Object.keys(NAV_INDEX);
  navs.forEach((key) => {
    if (pathArr.join(" ").includes(key)) {
      document
        .querySelector(`nav.main li.${key}`)
        ?.classList.add("active");
    }
  });
});
