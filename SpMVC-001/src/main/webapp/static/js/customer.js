document.addEventListener("DOMContentLoaded", () => {
  const cust_body = document.querySelector("tbody.cust_body");

  const cust_body_onClick_handler = (e) => {
    const target = e.target;
    if (target.tagName === "TD") {
      const TR = target.closest("TR");
      const ccode = TR.dataset.ccode;
      alert(ccode);
    }
  };
  cust_body.addEventListener(cust_body_onClick_handler);
});
