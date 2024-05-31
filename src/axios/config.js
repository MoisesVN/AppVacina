import axios from "axios";

const blogFetch = axios.create({
    baseURL: "http://192.168.0.24:8080",
})

export default blogFetch;