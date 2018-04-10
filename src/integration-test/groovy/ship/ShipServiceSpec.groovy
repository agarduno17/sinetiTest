package ship

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ShipServiceSpec extends Specification {

    ShipService shipService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Ship(...).save(flush: true, failOnError: true)
        //new Ship(...).save(flush: true, failOnError: true)
        //Ship ship = new Ship(...).save(flush: true, failOnError: true)
        //new Ship(...).save(flush: true, failOnError: true)
        //new Ship(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //ship.id
    }

    void "test get"() {
        setupData()

        expect:
        shipService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Ship> shipList = shipService.list(max: 2, offset: 2)

        then:
        shipList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        shipService.count() == 5
    }

    void "test delete"() {
        Long shipId = setupData()

        expect:
        shipService.count() == 5

        when:
        shipService.delete(shipId)
        sessionFactory.currentSession.flush()

        then:
        shipService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Ship ship = new Ship()
        shipService.save(ship)

        then:
        ship.id != null
    }
}
