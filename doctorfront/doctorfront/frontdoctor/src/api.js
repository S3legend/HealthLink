import axios from "axios";

const api = axios.create({
    baseURL: "http://localhost:8082/api", // URL du back-end
});

export default api;