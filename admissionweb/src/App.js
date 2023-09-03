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
import FacultyDetail from "./components/FacultyDetails";
import Lives from "./components/Lives";
import Questions from "./components/Questions";
import LiveDetails from "./components/LiveDetails";

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
        <Route path="/lives" element={<Lives/>}/>
        <Route path="/lives/:livesId" element={<LiveDetails />} />
        <Route path="/questions" element={<Questions/>}/>
        <Route path="/facultys" element={<Facultys/>}/>
        <Route path="/facultys/:facultysId" element={<FacultyDetail />} />
        <Route path="/login" element={<Login/>}/>
        <Route path="/register" element={<Register />} />
      </Routes>
      </Container>
      <Footer/>
    </BrowserRouter>
    </MyUserContext.Provider>
    </>

  );
}

export default App;