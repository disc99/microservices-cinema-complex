package io.disc99.archetype

import io.disc99.archetype.impl.EventStoreInMemory
import spock.lang.Specification

class EventStoreSpec extends Specification {

    def "store event"() {
        setup:
        EventStore store = new EventStoreInMemory()
        Identify id1 = new Identify("1")
        Identify id2 = new Identify("2")
        ItemCreated created = new ItemCreated()

        when:
        store.add(new EventStreamId(Item.class, id1), created)

        then:
        store.stream(Item.class, id1).events == [created]

    }

    static class Item implements Entity {}
    static class ItemCreated implements DomainEvent {}
    static class ItemModified implements DomainEvent {}
    static class ItemDeleted implements DomainEvent {}
    static class Book implements Entity {}
    static class BookBought implements DomainEvent {}
    static class BookSold implements DomainEvent {}
}