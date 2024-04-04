const NAV = {
  Home: { name: "Home", url: "/" },
  상품관리: { name: "상품관리", url: "/product" },
  고객관리: { name: "고객관리", url: "/customer" },
  매입매출관리: { name: "매입매출관리", url: "/iolist" },
  로그인: { name: "로그인", url: "/user/login" },
  마이페이지: {
    name: "마이페이지",
    url: "/user/mypage",
  },
  로그아웃: { name: "로그아웃", url: "/user/logout" },
};
document.addEventListener("DOMContentLoaded", () => {
  const main_nav = document.querySelector("nav.main");
  main_nav.addEventListener("click", (e) => {
    const target = e.target;
    if (target.tagName === "LI") {
      const text = target.innerText;
      const url = NAV[text].url;
      // alert(url);
      document.location.href = `${rootPath}${url}`;
    }
  });
});
