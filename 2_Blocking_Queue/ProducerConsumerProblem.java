/*
* A BlockingQueue is a thread-safe queue designed for producer-consumer scenarios:

It blocks producers when the queue is full.

It blocks consumers when the queue is empty.
* */
import java.util.concurrent.*;
import java.util.*;

class ProducerConsumerProblem {

    public static void main(String... args){
        BlockingQueue<Integer> basket = new ArrayBlockingQueue<>(5);

        //Producer Thread - put apple in bucket

        Thread producer = new Thread(()->{
            try{
                for(int i = 0; i< 10; i++){
                    System.out.println("Produced : "+i);
                    basket.put(i);
                    Thread.sleep(500);
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        //Conumer Thread - consume apple from bucket

        Thread consumer = new Thread(()-> {
            try{
                for(int i =0 ; i<10; i++){
                    basket.take();
                    System.out.println("Consumed : "+ i);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }



}