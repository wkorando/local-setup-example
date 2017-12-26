import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

Contract.make {
    request {
        method 'POST'
        url '/commodities/'
        body(
        		"commodityName" : $(regex('[a-zA-Z]+')),
        		"commodityPrice" : $(regex('[0-9]{1}\\.[1-9]{2}')),
		    "availableUnits" : $(regex('[0-9]{8}'))
        )
        headers { 
			contentType(applicationJson())
		}
    }
    response {
        status 200
        body([
        		   "id" : $(regex('[0-9]{1}')),
        		   "commodityName" : "${fromRequest().body('$.commodityName')}",
			   "commodityPrice" : fromRequest().body('$.commodityPrice'),
			   "availableUnits" : fromRequest().body('$.availableUnits')
		   ])
		headers { 
			contentType(applicationJson())
		}
    }
}