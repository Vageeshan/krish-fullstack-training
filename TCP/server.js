const net = require('net');
const port = 42181;
const host = '127.0.0.1';

const server = net.createServer((socket) => {
    socket.on('end', () => {
        console.log("Server: Client disconnected");
    });
});

server.on('connection', (socket) => {
    console.log(`Connected from: ${socket.remoteAddress} : ${socket.remotePort}`);
    socket.write('Hello client');
    socket.end();
})

server.on('error', (err) => {
    throw err;
});

server.listen(port, host);
