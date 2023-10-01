import axios from 'axios';

export const getMovies = async () => {
    try {
        return await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/v1/movies`);
    } catch (e) {
        throw e;
    }
}