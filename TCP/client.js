const net = require('net');
const port = 42181;
const host = '127.0.0.1';

const client = new net.Socket();

client.connect(port, host, () => {
    console.log(`Connected to Server : ${host} on ${port}`);
});

client.on('data', (data) => {
    console.log(`Received : ${data}`);
});

client.on('close', () => {
    console.log(`Client : Disconnected from server`);
});
