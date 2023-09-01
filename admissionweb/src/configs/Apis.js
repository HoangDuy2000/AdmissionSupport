
import axios from "axios";
import cookie from "react-cookie";

const SERVER_CONTEXT = "/AdmissionSupport";

export const endpoint = {
    "typenews": `${SERVER_CONTEXT}/api/typenews/`,
    "news" : `${SERVER_CONTEXT}/api/news/`,
    "facultys": `${SERVER_CONTEXT}/api/facultys/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "register": `${SERVER_CONTEXT}/api/users/`,
}

export const authApis = () => {
    return axios.create({
        baseURL: "http://localhost:8080",
        headers: {
            "Authorization": cookie.load("token")
        }
    });
}

export default axios.create({
    baseURL: "http://localhost:8080"
});