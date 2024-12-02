import axiosInstance from "./axiosInstance";

export const getAllDoctors = () => axiosInstance.get("/doctor");
export const getDoctorById = (id) => axiosInstance.get(`/doctor/${id}`);
export const createDoctor = (data) => axiosInstance.post("/doctor", data);
export const updateDoctor = (id, data) => axiosInstance.put(`/doctor/${id}`, data);
export const deleteDoctor = (id) => axiosInstance.delete(`/doctor/${id}`);
