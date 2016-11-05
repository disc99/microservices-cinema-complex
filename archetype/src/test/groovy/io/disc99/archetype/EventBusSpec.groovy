package io.disc99.archetype

import spock.lang.Specification


class EventBusSpec extends Specification {
    def "event bus"() {
        setup:
        int deletedCount = 0
        AddedHandler whenAdded = new AddedHandler()
        EventHandler<Deleted> whenDeleted = {deletedCount++}
        EventBus bus = new EventBus(new HashSet<EventHandler>([whenDeleted, whenAdded]))

        when:
        bus.apply(new Added())
        bus.apply(new Deleted())

        then:
        whenAdded.count == 1
        deletedCount == 1
    }

    class AddedHandler implements EventHandler<Added> {
        int count = 0
        @Override
        void on(Added event) {
            count++
        }
    }
    class Added implements DomainEvent{}
    class Deleted implements DomainEvent{}
}