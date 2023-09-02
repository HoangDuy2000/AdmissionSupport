import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import Footer from "./layout/Footer";
import Home from "./components/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Container } from "react-bootstrap";
import News from "./components/News";
import Facultys from "./components/Facultys";
import Login from "./components/Login";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import Register from "./components/Register";
import NewsDetails from "./components/NewsDetails";
import 'moment/locale/vi';

export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);
  return (<>
      <MyUserContext.Provider value={[user, dispatch]}>
      <BrowserRouter>
      <Header/>
      <Container>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/news" element={<News/>}/>
        <Route path="/news/:newsId" element={<NewsDetails />} />
        <Route path="/register" element={<Register />} />
        <Route path="/facultys" element={<Facultys/>}/>
        <Route path="/login" element={<Login/>}/>
      </Routes>
      </Container>
      <Footer/>
    </BrowserRouter>
    </MyUserContext.Provider>
    </>

  );
}

export default App;