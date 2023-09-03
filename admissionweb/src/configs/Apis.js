
import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/AdmissionSupport";

export const endpoint = {
    "typenews": `${SERVER_CONTEXT}/api/typenews/`,
    "news" : `${SERVER_CONTEXT}/api/news/`,
    "facultys": `${SERVER_CONTEXT}/api/facultys/`,
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "register": `${SERVER_CONTEXT}/api/accounts/`,
    "news-details": (id) => `${SERVER_CONTEXT}/api/news/${id}/`,
    "comments": (id) => `${SERVER_CONTEXT}/api/news/${id}/comments/`,
    "facultys-details": (id) => `${SERVER_CONTEXT}/api/facultys/${id}/`,
    "scores": (id) => `${SERVER_CONTEXT}/api/facultys/${id}/scores/`,
    "add-comment": `${SERVER_CONTEXT}/api/comments/`,
    "lives": `${SERVER_CONTEXT}/api/lives/`,
    "lives-details": (id) => `${SERVER_CONTEXT}/api/lives/${id}/`,
    "questions": (id) => `${SERVER_CONTEXT}/api/lives/${id}/questions/`,
    "add-question": `${SERVER_CONTEXT}/api/questions/add/`,
    "list-questions": `${SERVER_CONTEXT}/api/questions/`
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