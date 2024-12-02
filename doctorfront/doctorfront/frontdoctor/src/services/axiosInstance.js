import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8082", // URL de ton backend (change si besoin)
  headers: {
    "Content-Type": "application/json",
  },
});

export default axiosInstance;
