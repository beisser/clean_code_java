//package com.github.beisser.design_patterns.mediator;
//
//import io.reactivex.Observable;
//import io.reactivex.Observer;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Mediator
// *
// * manage communication between components; the components do not known each other and have no reference
// * therefore a central component manages the communication between the components and is therefore the mediator
// *
// */
//
//// Reactive Extensions are perfect for implementing an mediator
//// The Observable acts as the mediator, because it allows the subscribers to communicate with each other
//// without knowing each other
//class EventBroker extends Observable<Integer>
//{
//    private List<Observer<? super Integer>>
//            observers = new ArrayList<>();
//
//    @Override
//    protected void subscribeActual(Observer<? super Integer> observer)
//    {
//        observers.add(observer);
//    }
//
//    // By using the approach each component can send a message to all subscribers
//    public void publish(int n)
//    {
//        for (Observer<? super Integer> o : observers)
//            o.onNext(n);
//    }
//}
//
//// the player takes the broker and can now send messages through the broker / Observable
//class FootballPlayer
//{
//    private int goalsScored = 0;
//    private EventBroker broker;
//    public String name;
//    public FootballPlayer(EventBroker broker, String name)
//    {
//        this.broker = broker;
//        this.name = name;
//    }
//
//    public void score()
//    {
//        // broadcast the message to all subscribers
//        broker.publish(++goalsScored);
//    }
//}
//
//class FootballCoach
//{
//    public FootballCoach(EventBroker broker)
//    {
//        // the coach can subscribe to the mediator / observable
//        // and receives messages from now on
//        broker.subscribe(i -> {
//            System.out.println("Hey, you scored " + i + " goals!");
//        });
//    }
//}
//
//class RxEventBrokerDemo
//{
//    public static void main(String [] args)
//    {
//        EventBroker broker = new EventBroker();
//        FootballPlayer player = new FootballPlayer(broker, "jones");
//        FootballCoach coach = new FootballCoach(broker);
//
//        player.score();
//        player.score();
//        player.score();
//    }
//}