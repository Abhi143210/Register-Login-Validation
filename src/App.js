import { BrowserRouter,Routes,Route } from "react-router-dom";
import Register from "./compontents/Register";
import Login from "./compontents/Login";
 
import Home from "./compontents/Home";


function App() {
  return (
    <div>

      <BrowserRouter>
      {/* <Home/> */}
            <Routes>
              <Route path="/home" element= { <Home/>} />
              <Route path="/register" element= { <Register/>} />
              <Route path="/login" element= { <Login/>} />
            </Routes>
        </BrowserRouter>
      
    </div>
  );
}

export default App;