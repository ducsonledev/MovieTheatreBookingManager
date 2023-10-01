import SideBarWithHeader from './components/shared/SideBar.jsx'
import Ticket from './components/Ticket.jsx'
import {getMovies} from "./services/client.js";
import {useState, useEffect} from 'react';
import { Spinner,
         Text
} from '@chakra-ui/react'

function App() {

    const [movies, setMovies] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
            setLoading(true);
            setTimeout(() => {
                getMovies().then(res => {
                    getMovies(res.data)
                }).catch(err => {
                    console.log(err)
                }).finally(() => {
                    setLoading(false)
                })
            }, 3000)
        },[])

    if (loading) {
        return (
            <SideBarWithHeader>
                <Spinner
                  thickness='4px'
                  speed='0.65s'
                  emptyColor='gray.200'
                  color='blue.500'
                  size='xl'
                />
            </SideBarWithHeader>
        )
    }

    if(movies.length <= 0) {
        return (
            <SideBarWithHeader>
                <Text>No movies available!</Text>
            </SideBarWithHeader>
        )
    }

    return (
    <>
        <SideBarWithHeader>
            <Ticket/>
        </SideBarWithHeader>
    </>
    )
}

export default App
