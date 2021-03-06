import org.springframework.cloud.contract.spec.Contract
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

Contract.make {
    request {
        method 'GET'
        url '/commodities/1/historicalPrice'
    }
    response {
        status 200
        body([ 
        		   [
	        		   "date" : "11/2017",
	        		   "commodityId" : fromRequest().path(1),
	        		   "commodityName" : "CORN",
				   "commodityPrice" : $(regex('[0-9]{1}\\.[0-9]{2}')),
				   "availableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "date" : "10/2017",
	        		   "commodityId" : fromRequest().path(1),
	        		   "commodityName" : "CORN",
				   "commodityPrice" : $(regex('[0-9]{1}\\.[0-9]{2}')),
				   "availableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "date" : "09/2017",
	        		   "commodityId" : 1,
	        		   "commodityName" : "CORN",
				   "commodityPrice" : $(regex('[0-9]{1}\\.[0-9]{2}')),
				   "availableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "date" : "08/2017",
	        		   "commodityId" : fromRequest().path(1),
	        		   "commodityName" : "CORN",
				   "commodityPrice" : $(regex('[0-9]{1}\\.[0-9]{2}')),
				   "availableUnits" : $(regex('[0-9]{8}'))
			   ],
			   [
	        		   "date" : "07/2017",
	        		   "commodityId" : fromRequest().path(1),
	        		   "commodityName" : "CORN",
				   "commodityPrice" : $(regex('[0-9]{1}\\.[0-9]{2}')),
				   "availableUnits" : $(regex('[0-9]{8}'))
			   ]
		])
		headers { 
			header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
		}
    }
}