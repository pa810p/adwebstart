import React, { useState, useEffect } from "react";

import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import Toolbar from "@mui/material/Toolbar";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import axios from 'axios';
import { ProductTable, DataRow } from "./ProductTable";

const PRODUCTS_URL = 'http://localhost:9000/products'



export const Products : React.FC= () => {
    console.debug('Products');

    const [productName, setProductName] = useState('');
    const [productPrice, setProductPrice] = useState('');

    const [addButtonEnabled, setAddButtonEnabled] = useState(false);
    const [priceValid, setPriceValid] = useState(false);
    
    const [productData, setProductData] = useState<DataRow[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        handleRefresh();
    }, []);
  
    const handleRefresh = async () => {
        try {
            console.debug('fetch data');
            const response = await axios.get(PRODUCTS_URL);
            setProductData(response.data);
            setProductName('')
            setProductPrice('')
        } catch (error) {
            console.error('Error fetching data:', error);
        } finally {
            setLoading(false)
        }
    };

    const handleDelete = async (id: string) => {

        try {
            console.debug('handle delete');
            await axios.delete(PRODUCTS_URL + '/' + id);
            handleRefresh();
        } catch (error) {
          console.error('Error deleting data:', error);
        }
    };

    const handleAddButton = async () => {
        try {
            const data = {
                name: productName,
                price: productPrice
            }
            console.debug('add product');
            await axios.post(PRODUCTS_URL, data);
        } catch (error) {
            console.error('Error adding new project');
        } finally {
            setProductName('');
            setProductPrice('');
            handleRefresh();
        }

    }

    const handleRefreshButton = () => {
        console.debug('handleRefreshButton')
        handleRefresh();
        setLoading(true);    
    }

    const handleNameChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        console.debug('handleNameChange')
        setProductName(e.target.value);

        console.debug('name: ' + e.target.value + ' price: ' + productPrice + ' isValid: ' + priceValid);
        setAddButtonEnabled(e.target.value !== '' && priceValid)
    }

    const handlePriceChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        console.debug('handlePriceChange')
        const reg = /^[0-9]+(\.[0-9]{1,3})?$/
        setProductPrice(e.target.value);
        let isValid = reg.test(e.target.value)
        setPriceValid(isValid)

        setAddButtonEnabled(productName !== '' && isValid);

        console.debug('name: ' + productName + ' price: ' + productPrice + ' isValid: ' + isValid);
    }

    return (
        // <Container maxWidth="xl">
        <Box bgcolor="#f0f0f0">
            <Box paddingTop={1} paddingBottom={1}
                // sx={{ flexGrow: 0, display: { xs: "flex", md: "flex" } }}
                display="flex"
                // flexDirection="row"
                alignItems="center"
                justifyContent="left"
                // height="100vh"  // Adjust as needed
                >
                <div style={{ padding: '5 px'}}>
                        <Typography // className="custom-typography"
                            margin={1}
                            sx={{flexGrow: 0, fontWeight: 700}}>
                            Product:
                        </Typography>
                </div>
                <div style={{ padding: '5 px'}}>
                        <TextField
                            onChange={(event) => handleNameChange(event)}
                            label="Name"
                            variant="outlined"
                            value={productName}
                            sx={{mb: 2}}
                        />
                </div>
                <div style={{ padding: '5 px'}}>

                    <TextField
                        onChange={(event) => handlePriceChange(event)}
                        label="Price"
                        variant="outlined"
                        error={!priceValid}
                        value={productPrice}
                        sx={{ mb: 2 }}
                    />
                </div>
                <div style={{ padding: '5 px'}}>
            
                    <Button className="custom-button"
                    disableElevation
                    // style={{ textTransform: 'none' }}
                        variant="contained"
                        onClick={handleAddButton}
                        disabled={!addButtonEnabled}
                    >
                        Add
                    </Button>
                </div>
                <div style={{ paddingLeft: '5 px'}}>
                    <Button
                    // disableElevation
                    // style={{ textTransform: 'none' }}
                        variant="contained"
                        onClick={handleRefreshButton}
                    >
                        Refresh
                    </Button>
                </div>
            </Box>
                
            { loading ? (
                <p>Loading data...</p>
                ) : (
                <ProductTable data={productData} onDelete={handleDelete}/>
            )}
            </Box>
        // </Container>
    )
        
        
}