import React, { useState } from "react";

import Typography from "@mui/material/Typography";
import AppBar from "@mui/material/AppBar";
import Container from "@mui/material/Container";
import Toolbar from "@mui/material/Toolbar";
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';

export const Products : React.FC= () => {
    console.debug('Products');

    let productName = '';
    let productPrice = '';
    const [buttonEnabled, setButtonEnabled] = useState(false);
    const [priceValid, setPriceValid] = useState(false);

    const handleSubmitButton = () => {
        console.debug('handleSubmitButton')
    }

    const handleRefreshButton = () => {
        console.debug('handleRefreshButton')
    }

    const handlePriceChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        console.debug('handlePriceChange')
        const reg = /^[0-9]+(\.[0-9]{1,3})?$/
        productPrice = e.target.value;
        setPriceValid(reg.test(productPrice))
        setButtonEnabled(productName !== '' && priceValid);
    }

    const handleNameChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
        console.debug('handleNameChange')
        productName = e.target.value;
        setButtonEnabled(productName !== '' && priceValid)
    }

    return (
    <AppBar position="static">
        <Container maxWidth="xl">
            <Toolbar disableGutters>
            <Box paddingTop={3} sx={{ flexGrow: 0, display: { xs: 'flex', md: 'flex' } }}>
                <Typography sx={{flexGrow: 1, fontWeight: 700}}>
                    Product name:
                </Typography>
                <TextField
                    onChange={(event) => handleNameChange(event)}
                    label="Name"
                    variant="outlined"
                    sx={{mb: 2}}
                    />
                <br/>
                <TextField
                    onChange={(event) => handlePriceChange(event)}
                    label="Price"
                    variant="outlined"
                    error={!priceValid}
                    sx={{ mb: 2 }}
                    />
                
                <Button color="inherit"
                    disableElevation
                    style={{ textTransform: 'none' }}
                    onClick={handleSubmitButton}
                    disabled={!buttonEnabled}
                    >
                    Add
                </Button>
                <Button color="inherit"
                    disableElevation
                    style={{ textTransform: 'none' }}
                    onClick={handleRefreshButton}
                    >
                    Refresh
                </Button>
                </Box>
            </Toolbar>
        </Container>
    </AppBar>
        
    )
}