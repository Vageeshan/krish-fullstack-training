import {Kafka} from "kafkajs";

//Establishing new kafka connection
const kafka = new Kafka({
    clientId: "employee-service",
    brokers: ["localhost:9092"],
});

const consumer = kafka.consumer({groupId: "project", retry: {initialRetryTime: 100, retries: 0}});
await consumer.subscribe({topic: "employee-topic", fromBeginning: true});

await consumer.run({
    autoCommit: false,
    eachMessage: async ({topic, partition, message}) => {
        console.log({
            partition,
            offset: message.offset,
            value: message.value.toString(),
        });

        // 1 sec delay
        await new Promise((resolve) => setTimeout(resolve, 1000));
        if (Number(message.offset) === 25) {
            throw new Error("Something went wrong......");
        }

        await consumer.commitOffsets([
            {
                topic,
                partition,
                offset: (Number(message.offset) + 1).toString()
            }
        ]);
    },
});
