import React, { useRef } from "react";
import style from "./assets/scss/RegisterForm.scss";
const RegisterFom = ({ callback }) => {
  const refForm = useRef(null);

  return (
    <div>
      <form
        ref={refForm}
        className={style.RegisterForm}
        onSubmit={(e) => {
          e.preventDefault();
          try {
            const newEmail = Array.from(e.target, (input) => {
              // simple validation
              if (input.value === "") {
                throw new Error(`${input.placeholder}이 비어있습니다.`);
              }

              return { n: input.name, v: input.value };
            })
              .filter(({ n }) => n !== "")
              .reduce((res, { n, v }) => {
                res[n] = v;
                return res;
              }, {});

            refForm.current.reset();

            callback(newEmail);

            // const newEmail = {
            //   firstName: e.target.firstName.value,
            //   lastName: e.target.lastName.value,
            //   email: e.target.email.value,
            // };
            // callback(newEmail);
          } catch (err) {
            console.error(err.message);
          }
        }}
      >
        <input
          type="text"
          name={`firstName`}
          placeholder="성"
          className={style.InputFirstName}
        />
        <input
          type="text"
          name={`lastName`}
          placeholder="이름"
          className={style.InputLastName}
        />
        <input
          type="text"
          name={`email`}
          placeholder="이메일"
          className={style.InputEmail}
        />
        <input type="submit" value="등록" />
      </form>
    </div>
  );
};

export default RegisterFom;
