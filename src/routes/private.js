import React, { useContext } from "react";
import { AuthContext } from "../context/auth";
import Main from "../components/main"

const PrivateRoute = ({ children }) => {
    const { idToken } = useContext(AuthContext);
    return idToken ? children : <Main />;
}

export default PrivateRoute;