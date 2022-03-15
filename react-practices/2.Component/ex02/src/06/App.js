import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faBell,
  faCheckCircle,
  faTimesCircle,
} from "@fortawesome/free-solid-svg-icons";

// additional...
import { library } from "@fortawesome/fontawesome-svg-core";
import { far } from "@fortawesome/free-regular-svg-icons";
import { fab } from "@fortawesome/free-brands-svg-icons";

const App = () => {
  library.add(faBell, far, fab);
  return (
    <div>
      {/* example */}
      <FontAwesomeIcon icon={faBell} />
      <FontAwesomeIcon icon={faCheckCircle} />
      <FontAwesomeIcon icon={faTimesCircle} />
      <hr />
      {/* solid */}
      <FontAwesomeIcon icon={["fas", "bell"]} />
      <hr />
      {/* regular */}
      <FontAwesomeIcon icon={["far", "bell"]} />
      <hr />
      {/* brands */}
      <FontAwesomeIcon icon={["fab", "github"]} />
      <FontAwesomeIcon icon={["fab", "apple"]} />
      <FontAwesomeIcon icon={["fab", "microsoft"]} />
      <FontAwesomeIcon icon={["fab", "google"]} />
    </div>
  );
};

export default App;
