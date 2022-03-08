package contracts.rad

import org.springframework.cloud.contract.spec.Contract

Contract.make {

    description(
'''
            Represents READ scenario
            - identifier = md5("default") = C21F969B5F03D33D43E04F8F136E7682
            - use uppercase md5 string
          '''
    )
    request {
        urlPath(regex("/dmi/v1/ch/C21F969B5F03D33D43E04F8F136E7682/data/ds/ncmp-datastore:running")) {
            queryParameters {
                parameter "resourceIdentifier": "myNamespace:MyElement=L2022cloudMan"
                parameter "async": "false"
            }
        }
        method POST()
        headers {
            contentType(applicationJson())
        }
        body(
                """
            {
               "operation":"read",
               "dataType":"application/yang-data+json",
               "cmHandleProperties":{
                  "subSystem":"2",
                  "targetDnPrefix": "Location=Europe",
                  "targetNode": "MyElement=L2022cloudMan",
                  "neType": "neType"
               }
            }
            """
        )
    }
    response {
        status OK()
        body("""
            {
              "myNamespace:MyElement": [
                {
                  "id": "L2022cloudMan",
                  "attributes": {
                    "dnPrefix": "Location=Europe",
                    "userLabel": "null",
                    "locationName": "null",
                    "myElementType": "neType",
                    "myElementId": "L2022cloudMan",
                    "neType": "neType"
                  }
                }
              ]
            }
            """
        )
    }
}
