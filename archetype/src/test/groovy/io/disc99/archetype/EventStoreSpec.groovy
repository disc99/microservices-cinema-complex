package io.disc99.archetype

import io.disc99.archetype.impl.EventStoreInMemory
import spock.lang.Specification
import spock.lang.Unroll

class EventStoreSpec extends Specification {

    @Unroll
    def "store event"() {
        setup:
        EventStore store = new EventStoreInMemory()
        Identify id1 = new Id(value:"1")
        Identify id2 = new Id(value:"2")
        ItemCreated created =  new ItemCreated()
        ItemModified modified1 =  new ItemModified()
        ItemModified modified2 =  new ItemModified()
        ItemDeleted deleted =  new ItemDeleted()
        BookBought bought =  new BookBought()
        BookSold sold = new BookSold()

        when:
        store.add(new EventStreamId(Item.class, id1), created)
        store.add(new EventStreamId(Item.class, id1), modified1)
        store.add(new EventStreamId(Book.class, id1), bought)
        store.add(new EventStreamId(Item.class, id2), created)
        store.add(new EventStreamId(Book.class, id1), sold)
        store.add(new EventStreamId(Item.class, id2), modified2)
        store.add(new EventStreamId(Item.class, id1), deleted)

        then:
        store.stream(Item.class, id1).events == [created, modified1, deleted]
        store.stream(Item.class, id2).events == [created, modified2]
        store.stream(Book.class, id1).events == [bought, sold]

    }

    static class Id implements Identify {
        String value;
    }
    static class Item implements Entity {}
    static class ItemCreated implements DomainEvent {}
    static class ItemModified implements DomainEvent {}
    static class ItemDeleted implements DomainEvent {}
    static class Book implements Entity {}
    static class BookBought implements DomainEvent {}
    static class BookSold implements DomainEvent {}
}