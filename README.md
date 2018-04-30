### *1. Create Tracker* 

----

**Return the tracker created by tracking code and carrier**

* **Url: ** `/create`

* **Method:** `GET`

* **URL Params:** 

  * **Required**:

    `USERID` = [String]

    `CARRIER` = [String]

    `TRACKINGCODE` = [String]

* **Data Params:**

  None

* **Success Response:**

  * **Code: **`200`

  * **Content: ** 

    <details><summary>`Tracker Json`</summary>
    <p>

    ```json
    {
      "id": "trk_9d408ea9fce6eqwe9cbfce35d2d69b55",
      "object": "Tracker",
      "mode": "test",
      "tracking_code": "EZ5000000005",
      "status": "return_to_sender",
      "status_detail": "return",
      "created_at": "2018-04-18T19:18:32Z",
      "updated_at": "2018-04-18T19:18:32Z",
      "signed_by": null,
      "weight": 17.6,
      "est_delivery_date": "2018-04-18T19:18:32Z",
      "shipment_id": null,
      "carrier": "FedEx",
      "tracking_details": [
        {
          "object": "TrackingDetail",
          "message": "Shipment information sent to FedEx",
          "description": null,
          "status": "pre_transit",
          "status_detail": "status_update",
          "datetime": "2018-03-19T09:42:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": null,
            "state": null,
            "country": null,
            "zip": null
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Picked up",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-19T10:06:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "NEW YORK",
            "state": "NY",
            "country": "US",
            "zip": "10014"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Departed FedEx location",
          "description": null,
          "status": "in_transit",
          "status_detail": "departed_facility",
          "datetime": "2018-03-20T04:09:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MEMPHIS",
            "state": "TN",
            "country": "US",
            "zip": "38118"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "At destination sort facility",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-21T04:49:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "ATLANTA",
            "state": "GA",
            "country": "US",
            "zip": "30320"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "At local FedEx facility",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-21T09:42:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MARIETTA",
            "state": "GA",
            "country": "US",
            "zip": "30067"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "On FedEx vehicle for delivery",
          "description": null,
          "status": "out_for_delivery",
          "status_detail": "out_for_delivery",
          "datetime": "2018-03-22T03:28:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MARIETTA",
            "state": "GA",
            "country": "US",
            "zip": "30067"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Address Does Not Exist - Returning to Sender",
          "description": null,
          "status": "return_to_sender",
          "status_detail": "return",
          "datetime": "2018-03-22T10:51:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "ATLANTA",
            "state": "GA",
            "country": "US",
            "zip": "30320"
          }
        }
      ],
      "carrier_detail": {
        "object": "CarrierDetail",
        "service": "FEDEX_GROUND",
        "container_type": "YOUR_PACKAGING",
        "est_delivery_date_local": "2875-10-22",
        "est_delivery_time_local": "19:18:32",
        "origin_location": "NEW YORK NY US",
        "origin_tracking_location": {
          "object": "TrackingLocation",
          "city": "NEW YORK",
          "state": "NY",
          "country": "US",
          "zip": "10014"
        },
        "destination_location": "ATLANTA GA US",
        "destination_tracking_location": null,
        "guaranteed_delivery_date": null,
        "alternate_identifier": null,
        "initial_delivery_attempt": "2018-03-22T10:51:32Z"
      },
      "finalized": true,
      "is_return": false,
      "public_url": "https://track.easypost.com/djE6dHJrXzlkNDA4ZWE5ZmNlNjRlOGU5Y2JmY2UzNWQyZDY5YjU1",
      "fees": [
        {
          "object": "Fee",
          "type": "TrackerFee",
          "amount": "0.00000",
          "charged": false,
          "refunded": false
        }
      ]
    }
    ```

    </p>
    </details>

* **Error Response:**

  * **Code:** ` 500`
  * **Content: ** `{"ERROR":"Sever Exception"}`

---



### *2. Delete Tracker*

------

**Delte the tracker created by tracking code, carrier  and the user ID**

- **Url: ** `/delete`

- **Method: ** ` GET`

- **URL Params:**

  **Required**:

  `USERID` = [String]

  `CARRIER` = [String]

  `TRACKINGCODE` = [String]

- **Data Params:**

  None

- **Success Response:**

  - **Code: **`200`
  - **Content: ** `{"SUCCESS" : "Delete Success"}`

- **Error Response:**

  - **Code: **`404`
  - **Content: ** `{"ERROR" : "Delete Failed with invalid tracking code"}`

---



### *3. Tracking History*

------

**Rerturn the tracking history by the user ID**

- **Url: ** ` /history`

- **Method:** `GET`

- **URL Params:** 

  **Required: **

  `USERID` = [String]

- **Data Params:**

  None

- **Success Response:**

  - **Code: **`200`
  - **Content: ** 

- **Error Response:**

  - **Code: ** `404`
  - **Content: ** `{"ERROR" : "Delete Failed with invalid tracking code"}`

------



### *4. Tracking Query*

------

**Rerturn the tracking history by the tracking code and carrier**

- **Url: ** `/query`

- **Method:** `GET`

- **URL Params** 

  **Required**:

  `USERID` = [String]

  `CARRIER` = [String]

  `TRACKINGCODE` = [String]

- **Data Params**

  None

- **Success Response**

  - **Code: **`200`

  - **Content: ** 

    <details><summary>`Tracker Json`</summary>
    <p>

    ```json
    {
      "id": "trk_9d408ea9fce6eqwe9cbfce35d2d69b55",
      "object": "Tracker",
      "mode": "test",
      "tracking_code": "EZ5000000005",
      "status": "return_to_sender",
      "status_detail": "return",
      "created_at": "2018-04-18T19:18:32Z",
      "updated_at": "2018-04-18T19:18:32Z",
      "signed_by": null,
      "weight": 17.6,
      "est_delivery_date": "2018-04-18T19:18:32Z",
      "shipment_id": null,
      "carrier": "FedEx",
      "tracking_details": [
        {
          "object": "TrackingDetail",
          "message": "Shipment information sent to FedEx",
          "description": null,
          "status": "pre_transit",
          "status_detail": "status_update",
          "datetime": "2018-03-19T09:42:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": null,
            "state": null,
            "country": null,
            "zip": null
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Picked up",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-19T10:06:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "NEW YORK",
            "state": "NY",
            "country": "US",
            "zip": "10014"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Departed FedEx location",
          "description": null,
          "status": "in_transit",
          "status_detail": "departed_facility",
          "datetime": "2018-03-20T04:09:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MEMPHIS",
            "state": "TN",
            "country": "US",
            "zip": "38118"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "At destination sort facility",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-21T04:49:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "ATLANTA",
            "state": "GA",
            "country": "US",
            "zip": "30320"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "At local FedEx facility",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-21T09:42:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MARIETTA",
            "state": "GA",
            "country": "US",
            "zip": "30067"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "On FedEx vehicle for delivery",
          "description": null,
          "status": "out_for_delivery",
          "status_detail": "out_for_delivery",
          "datetime": "2018-03-22T03:28:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MARIETTA",
            "state": "GA",
            "country": "US",
            "zip": "30067"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Address Does Not Exist - Returning to Sender",
          "description": null,
          "status": "return_to_sender",
          "status_detail": "return",
          "datetime": "2018-03-22T10:51:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "ATLANTA",
            "state": "GA",
            "country": "US",
            "zip": "30320"
          }
        }
      ],
      "carrier_detail": {
        "object": "CarrierDetail",
        "service": "FEDEX_GROUND",
        "container_type": "YOUR_PACKAGING",
        "est_delivery_date_local": "2875-10-22",
        "est_delivery_time_local": "19:18:32",
        "origin_location": "NEW YORK NY US",
        "origin_tracking_location": {
          "object": "TrackingLocation",
          "city": "NEW YORK",
          "state": "NY",
          "country": "US",
          "zip": "10014"
        },
        "destination_location": "ATLANTA GA US",
        "destination_tracking_location": null,
        "guaranteed_delivery_date": null,
        "alternate_identifier": null,
        "initial_delivery_attempt": "2018-03-22T10:51:32Z"
      },
      "finalized": true,
      "is_return": false,
      "public_url": "https://track.easypost.com/djE6dHJrXzlkNDA4ZWE5ZmNlNjRlOGU5Y2JmY2UzNWQyZDY5YjU1",
      "fees": [
        {
          "object": "Fee",
          "type": "TrackerFee",
          "amount": "0.00000",
          "charged": false,
          "refunded": false
        }
      ]
    }
    ```

    </p>
    </details>

- **Error Response**

  - **Code: **`404`
  - **Content: ** `{"ERROR" : "Query Failed with invalid tracking code"}`

------





### *5. Tracking Update*

------

**Rerturn the tracking history by the user ID**

- **Url: ** `/update`

- **Method: **`POST` 

- **URL Params**

  None

- **Data Params**

  **Required**:

  <details><summary>`Event  Json`</summary>
  <p>

  ```json
  {
    "result": {
      "id": "trk_9d408ea9fce64e8e9cbfce35d2d69b55",
      "object": "Tracker",
      "mode": "test",
      "tracking_code": "EZ5000000005",
      "status": "return_to_sender",
      "status_detail": "return",
      "created_at": "2018-04-18T19:18:32Z",
      "updated_at": "2018-04-18T19:18:32Z",
      "signed_by": null,
      "weight": 17.6,
      "est_delivery_date": "2018-04-18T19:18:32Z",
      "shipment_id": null,
      "carrier": "FedEx",
      "tracking_details": [
        {
          "object": "TrackingDetail",
          "message": "Shipment information sent to FedEx",
          "description": null,
          "status": "pre_transit",
          "status_detail": "status_update",
          "datetime": "2018-03-19T09:42:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": null,
            "state": null,
            "country": null,
            "zip": null
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Picked up",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-19T10:06:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "NEW YORK",
            "state": "NY",
            "country": "US",
            "zip": "10014"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Departed FedEx location",
          "description": null,
          "status": "in_transit",
          "status_detail": "departed_facility",
          "datetime": "2018-03-20T04:09:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MEMPHIS",
            "state": "TN",
            "country": "US",
            "zip": "38118"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "At destination sort facility",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-21T04:49:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "ATLANTA",
            "state": "GA",
            "country": "US",
            "zip": "30320"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "At local FedEx facility",
          "description": null,
          "status": "in_transit",
          "status_detail": "arrived_at_facility",
          "datetime": "2018-03-21T09:42:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MARIETTA",
            "state": "GA",
            "country": "US",
            "zip": "30067"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "On FedEx vehicle for delivery",
          "description": null,
          "status": "out_for_delivery",
          "status_detail": "out_for_delivery",
          "datetime": "2018-03-22T03:28:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "MARIETTA",
            "state": "GA",
            "country": "US",
            "zip": "30067"
          }
        },
        {
          "object": "TrackingDetail",
          "message": "Address Does Not Exist - Returning to Sender",
          "description": null,
          "status": "return_to_sender",
          "status_detail": "return",
          "datetime": "2018-03-22T10:51:32Z",
          "source": "FedEx",
          "carrier_code": null,
          "tracking_location": {
            "object": "TrackingLocation",
            "city": "ATLANTA",
            "state": "GA",
            "country": "US",
            "zip": "30320"
          }
        }
      ],
      "carrier_detail": {
        "object": "CarrierDetail",
        "service": "FEDEX_GROUND",
        "container_type": "YOUR_PACKAGING",
        "est_delivery_date_local": "2875-10-22",
        "est_delivery_time_local": "19:18:32",
        "origin_location": "NEW YORK NY US",
        "origin_tracking_location": {
          "object": "TrackingLocation",
          "city": "NEW YORK",
          "state": "NY",
          "country": "US",
          "zip": "10014"
        },
        "destination_location": "ATLANTA GA US",
        "destination_tracking_location": null,
        "guaranteed_delivery_date": null,
        "alternate_identifier": null,
        "initial_delivery_attempt": "2018-03-22T10:51:32Z"
      },
      "finalized": true,
      "is_return": false,
      "public_url": "https://track.easypost.com/djE6dHJrXzlkNDA4ZWE5ZmNlNjRlOGU5Y2JmY2UzNWQyZDY5YjU1",
      "fees": [
        {
          "object": "Fee",
          "type": "TrackerFee",
          "amount": "0.00000",
          "charged": false,
          "refunded": false
        }
      ]
    },
    "description": "tracker.updated",
    "mode": "test",
    "previous_attributes": {
      "status": "return_to_sender"
    },
    "created_at": "2018-04-18T19:19:32Z",
    "pending_urls": [
      "https://20180418t112515-dot-packtrack-200423.appspot.com"
    ],
    "completed_urls": [],
    "updated_at": "2018-04-18T19:19:32Z",
    "id": "evt_25a41bcd3af34544a93695b500778d67",
    "user_id": "user_f9994d7e43604b8494c1b1ebe19a6815",
    "status": "in_queue",
    "object": "Event"
  }
  ```

  </p>
  </details>

- **Success Response: **  

  - **Code: **`200`
  - **Content: ** `{"SUCCESS" : "Update Succeeded"}`

- **Error Response**

  - **Code: **`500`
  - **Content: ** `{"ERROR" : "Server Error"}`

------

