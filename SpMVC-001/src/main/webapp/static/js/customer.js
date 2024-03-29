document.addEventListener("DOMContentLoaded", () => {
  const cust_body = document.querySelector("tbody.cust_body");
  const btn_update = document.querySelector("input.btn_update");
  const btn_delete = document.querySelector("input.btn_delete");

  const cust_body_onClick_handler = (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const TR = target.closest("TR");
      const ccode = TR.dataset.ccode;
      // alert(ccode);
      document.location.href = `${rootPath}/customer/detail?c_code=${ccode}`;
    }
  };
  cust_body?.addEventListener("click", cust_body_onClick_handler);

  btn_update?.addEventListener("click", (e) => {
    const ccode = e.target.dataset.ccode;
    // alert(ccode);
    document.location.href = `${rootPath}/customer/update?ccode=${ccode}`;
  });

  btn_delete.addEventListener("click", (e) => {
    const ccode = e.target.dataset.ccode;

    if (confirm("정말 삭제할까요?")) {
      document.location.replace(
        `${rootPath}/customer/delete/${ccode}`
      );
    }
  });
});
