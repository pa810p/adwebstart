/**
 * AdWebStart - snippet that can be used to create web project with:
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/bps2
 * License:    GNU General Public License v3.0  see: LICENSE
 */
import { useEffect } from 'react';

import './App.css';
import { Products } from './components/Products';
import { createTheme, ThemeProvider } from '@mui/material/styles';

const theme = createTheme({

  palette: {
    primary: {
      main: '#3498db',
    },
    secondary: {
      main: '#e74c3c',
    },
    background: {
      default: '#ecf0f1',
    },
    text: {
      primary: '#2c3e50',
    },
  },

})

export const App = () => {

  useEffect(() => {
    document.title = 'Products'; // Set your desired title here
  }, []);

  return (
    // <ThemeProvider theme={theme}>
      <div className='App'>
          <header>
            <h3>Products</h3>
          </header>
          <main>
            <div>
            <Products/>
            </div>
          </main>
      </div>
    // </ThemeProvider>
  )  
}

