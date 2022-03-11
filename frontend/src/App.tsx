import {
  BrowserRouter,
  Routes,
  Route
} from "react-router-dom";
import MoviesListing from 'pages/MoviesListing';
import EvaluationForm from 'pages/EvaluationForm';
import Navbar from "components/Navbar";

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<MoviesListing />} />
        <Route path="/EvaluationForm">
          <Route path=":movieId" element={<EvaluationForm />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;