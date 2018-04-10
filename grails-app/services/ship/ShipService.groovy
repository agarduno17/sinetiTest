package ship

import grails.gorm.services.Service

@Service(Ship)
interface ShipService {

    Ship get(Serializable id)

    List<Ship> list(Map args)

    Long count()

    void delete(Serializable id)

    Ship save(Ship ship)

}