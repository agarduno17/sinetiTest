package ship

import grails.rest.Resource

@Resource(uri = '/ships')
class Ship {

    String name
    int capacity
    String type
    int motorsQuantity
    String country

    static constraints = {
        name size: 1..100, blank: false, nullable: false
        capacity range: 1..5000
        type size: 1..50, blank: false, nullable: false
        motorsQuantity range: 1..10
        country size: 1..30, blank: false, nullable: false
    }
}
