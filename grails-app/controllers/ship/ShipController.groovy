package ship

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ShipController {

    ShipService shipService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond shipService.list(params), model:[shipCount: shipService.count()]
    }

    def show(Long id) {
        respond shipService.get(id)
    }

    def create() {
        respond new Ship(params)
    }

    def save(Ship ship) {
        if (ship == null) {
            notFound()
            return
        }

        try {
            shipService.save(ship)
        } catch (ValidationException e) {
            respond ship.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'ship.label', default: 'Ship'), ship.id])
                redirect ship
            }
            '*' { respond ship, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond shipService.get(id)
    }

    def update(Ship ship) {
        if (ship == null) {
            notFound()
            return
        }

        try {
            shipService.save(ship)
        } catch (ValidationException e) {
            respond ship.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'ship.label', default: 'Ship'), ship.id])
                redirect ship
            }
            '*'{ respond ship, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        shipService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'ship.label', default: 'Ship'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'ship.label', default: 'Ship'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
