import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

Contract.make {
    request {
        method 'GET'
        url '/commodities/'
		headers { 
			header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		}
    }
    response {
        status 200
        body([ 
        		   [
	        		   "id" : 1,
	        		   "commodityName" : "CORN",
				   "commodityPrice" : $(regex('[0-9]{1}.[0-9]{2}')),
				   "avaliableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "id" : 2,
	        		   "commodityName" : "WHEAT",
				   "commodityPrice" : $(regex('[0-9]{1}.[0-9]{2}')),
				   "avaliableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "id" : 3,
	        		   "commodityName" : "BARLEY",
				   "commodityPrice" : $(regex('[0-9]{1}.[0-9]{2}')),
				   "avaliableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "id" : 4,
	        		   "commodityName" : "SOYBEAN",
				   "commodityPrice" : $(regex('[0-9]{1}.[0-9]{2}')),
				   "avaliableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "id" : 5,
	        		   "commodityName" : "ORANGE",
				   "commodityPrice" : $(regex('[0-9]{1}.[0-9]{2}')),
				   "avaliableUnits" : $(regex('[0-9]{8}'))
			   ]
		])
		headers { 
			header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		}
    }
}