const express = require('express');
const app = express();

app.get('/wait', async (request, response) => {
    await new Promise((resolve) => setTimeout(resolve, 60000));
    response.send("Job Done......:)");
});

app.post('/wait', async (request, response) => {
    response.send("Job Done......:)");
});

app.listen(8191);
