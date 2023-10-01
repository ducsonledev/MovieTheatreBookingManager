import SideBarWithHeader from './components/shared/SideBar.jsx'
import TicketAddToCart from './components/Ticket.jsx'
import {getMovies} from "./services/client.js";
import {useState, useEffect} from 'react';
import { Spinner,
         Text,
         Wrap,
         WrapItem
} from '@chakra-ui/react'

function App() {

    const [movies, setMovies] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
            setLoading(true);
            setTimeout(() => {
                getMovies().then(res => {
                    setMovies(res.data)
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
    console.log("movies", movies);
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
            <Wrap justify='center' spacing='30px'>
                {movies.map((movie, index) => (
                    <WrapItem key={index}>
                        <TicketAddToCart {...movie}/>
                    </WrapItem>
                ))}
            </Wrap>
        </SideBarWithHeader>
    </>
    )
}

export default App
