import { Kafka } from "kafkajs";

//Establishing new kafka connection
const kafka = new Kafka({
  clientId: "employee-service",
  brokers: ["localhost:9092"],
});

const producer = kafka.producer();

const publish = async () => {
  await producer.connect().catch((error) => {
    console.log("Error occured........ ", error);
  });

  for (let i = 0; i < 10; i++) {
    await producer.send({
      topic: "employee-topic",
      messages: [
        {
          key: i.toString(),
          value: JSON.stringify({ empName: "Nairobi" + i }),
        },
      ],
    });
  }
};
publish().catch((error) => {
  console.log(error);
});
