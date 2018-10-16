//package com.github.beisser.design_patterns.state;
//
//import javafx.util.Pair;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * State
// *
// * initially an object has a state
// * the behaviour of an object is determined by its state which means there are only specific events possible
// * events can transition the state of the object to another
// *
// * the transition from one state to another is usually managed by a "State Machine", the machine defines e.g.
// *      - actions which do cause the transition to another state
// *      - what actions are allowed given a certain state
// *
// * there are statemachine libs for example from spring; we should NEVER implement a custom state machine
// */
//
//// example of an lightswitch
//// the different states an object can have
//enum State {
//    TURNED_ON,
//    TURNED_OFF
//}
//
//// the events which do change the state of an object
//enum Event {
//    TURN_ON,
//    TURN_OFF
//}
//
//class StateMachine {
//
//    // given the current state, which actions are allowed and what is the resulting new state after a given
//    // event was fired
//    private static Map<State, List<Pair<Event, State>>> rules = new HashMap<>();
//    private static State currentState = State.TURNED_OFF;   // initial state
//
//    static {
//        // if turned off, the turn on event is allowed which transitions the state to turned on
//        rules.put(State.TURNED_OFF, List.of(new Pair<>(Event.TURN_ON, State.TURNED_ON)));
//        rules.put(State.TURNED_ON, List.of(new Pair<>(Event.TURN_OFF, State.TURNED_OFF)));
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println("The current state is " + currentState);
//
//        // turn on the light
//        currentState = rules.get(currentState).get(Event.TURN_ON).getValue1();
//
//        System.out.println("The current state is " + currentState);
//    }
//}
//
//
