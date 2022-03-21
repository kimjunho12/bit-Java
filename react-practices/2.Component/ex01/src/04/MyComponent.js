import React, { Fragment } from "react";
import { PropTypes } from "prop-types";

export default function MyComponent({
  props01,
  props02,
  props03,
  props04,
  props05,
  props06,
  props07,
  props08,
  props09,
}) {
  return (
    <Fragment>
      <h2>Property Validation</h2>
      <span>props01 : {props01 ? props01 : "--- Not Set ---"}</span>
      <br />
      <span>props02 : {props02 ? props02 : "--- Not Set ---"}</span>
      <br />
      <span>props03 : {props03 ? `${props03}` : "--- Not Set ---"}</span>
      <br />
      <span>
        props04 : {props04 ? JSON.stringify(props04) : "--- Not Set ---"}
      </span>
      <br />
      <span>
        props05 :{" "}
        {props05
          ? props05.map((e, i) => <b key={i}>{e} </b>)
          : "--- Not Set ---"}
      </span>
      <br />
      <span>props06 : {props06 ? props06() : "--- Not Set ---"}</span>
      <br />
      <span>props07 : {props07 ? props07 : "--- Not Set ---"}</span>
      <br />
      <span>
        props08 :{" "}
        {props08
          ? props08.map((e, i) => <b key={i}>{`${e}`} </b>)
          : "--- Not Set ---"}
      </span>
      <br />
      <span>
        props09 : {props09 ? JSON.stringify(props09) : "--- Not Set ---"}
      </span>
      <br />
    </Fragment>
  );
}

MyComponent.propTypes = {
  // PropTypes Validator (primitive)
  props01: PropTypes.string,
  props02: PropTypes.number.isRequired,
  props03: PropTypes.bool.isRequired,
  props04: PropTypes.object.isRequired,
  props05: PropTypes.array.isRequired,
  props06: PropTypes.func.isRequired,

  // PropTypes Validator (combined primitive)
  props07: PropTypes.oneOfType([PropTypes.string, PropTypes.number]).isRequired,
  props08: PropTypes.arrayOf(PropTypes.bool).isRequired,
  props09: PropTypes.shape({
    no: PropTypes.number.isRequired,
    name: PropTypes.string.isRequired,
    email: PropTypes.string.isRequired,
  }),
};

// default value
MyComponent.defaultProps = {
  props01: "기본 값",
  props02: 222,
  props03: false,
  props04: {},
  props05: [],
  props06: () => {},
  props07: "문자 및 숫자 가능",
  props08: [1, 2, 3, 4],
  props09: { no: 333, name: "ss", email: "ss@email.com" },
};
