package ship

class BootStrap {

    def init = { servletContext ->
        new Ship(name: 'Titanic', capacity:  2000, type:  'Trasatlantico',motorsQuantity: 6,country:'Inglaterra').save()
        new Ship(name:  'Bismark',capacity:  1000,type:  'Buque', motorsQuantity:  6,country:  'Alemania').save()
        new Ship(name:  'Golden Hind',capacity:  2500,type:  'portaviones',motorsQuantity:  8,country:  'Inglés').save()

    }
    def destroy = {
    }
}
