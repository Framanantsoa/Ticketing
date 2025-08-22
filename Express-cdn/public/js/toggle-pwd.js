document.addEventListener("DOMContentLoaded", function () {
  const toggle = document.getElementById("togglePwd");
  const pwdField = document.getElementById("pwd");

  if (toggle && pwdField) {
    toggle.addEventListener("change", function () {
      pwdField.type = this.checked ? "text" : "password";
    });
  }
});

