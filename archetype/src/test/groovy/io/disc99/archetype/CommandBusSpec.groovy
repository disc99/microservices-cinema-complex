package io.disc99.archetype

import spock.lang.Specification

class CommandBusSpec extends Specification {

    def "dispatch"() {
        setup:
        CommandBus bus = new CommandBus()
        GetCommandHandler getHandler = new GetCommandHandler()
        PostCommandHandler postHandler = new PostCommandHandler()
        bus.regstor(getHandler)
        bus.regstor(postHandler)
        Post post = new Post()


        when:
        bus.dispatch(post)

        then:
        getHandler.count.size() == 0
        postHandler.count.size() == 1
        postHandler.count.contains(post)
    }

    class GetCommandHandler implements CommandHandler<Get> {
        Set<Command> count = new HashSet<>()
        @Override
        void handle(Get command) {
            count.add(command)
        }
    }
    class Get implements Command {
    }
    class PostCommandHandler implements CommandHandler<Post> {
        Set<Command> count = new HashSet<>()
        @Override
        void handle(Post command) {
            count.add(command)
        }
    }
    class Post implements Command {
    }
}