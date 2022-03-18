import React from "react";
import style from "./assets/scss/RegisterForm.scss";
const RegisterFom = () => {
  return (
    <div>
      <form className={style.RegisterForm}>
        <input type="text" placeholder="성" className={style.InputFirstName} />
        <input type="text" placeholder="이름" className={style.InputLastName} />
        <input type="text" placeholder="이메일" className={style.InputEmail} />
        <input type="submit" value="등록" />
      </form>
    </div>
  );
};

export default RegisterFom;
