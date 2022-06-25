# API CRUD pada Spring Boot dengan tema "Buku"

### Base url Buku 
```
   https://buku-aej.herokuapp.com
```

#### Table Endpoints
|Name|Endpoint|Method|
|:-----|:-----|:-----|
|ping|/v1/buku/ping_buku|Get|
|getBuku|/v1/buku|Get|
|getBukuByNama|/v1/buku/namaBuku|Get|
|addBuku|/v1/buku|Post|
|getDeleteBukuByNama|/v1/buku/namaBuku|Delete|
|getUpdateBukuByNama|/v1/buku/Update_namaBuku|Post|

### Buku Examples
#### Buku - ping
```
  Get |  https://buku-aej.herokuapp.com/v1/buku/ping_buku
```
##### Response
```
 {
    "status": true,
    "message": "Ping Buku Berhasil",
    "data": "Ini versi buku"
}
```
#### Buku - getBuku
```
  Get | https://buku-aej.herokuapp.com/v1/buku
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": [
        {
            "id": "687cf36c-c4e7-4b19-995a-4481e287c9d0",
            "namaBuku": "Sandal",
            "pengarangBuku": "Andi",
            "penerbitBuku": "Luluh"
        }
    ]
}
```
#### Buku - getBukuByNama
```
  Get | https://buku-aej.herokuapp.com/v1/buku/namaBuku
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": {
        "id": "687cf36c-c4e7-4b19-995a-4481e287c9d0",
        "namaBuku": "Sandal",
        "pengarangBuku": "Andi",
        "penerbitBuku": "Luluh"
    }
}
```
#### Buku - addBuku
```
  Post | https://buku-aej.herokuapp.com/v1/buku
```
##### Body
```
{
	"namaBuku" : "Sepatu",
	"pengarangBuku" : "Andi",
  "penerbitBuku" : "Ganu"
}
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": [
        {
            "id": "687cf36c-c4e7-4b19-995a-4481e287c9d0",
            "namaBuku": "Sandal",
            "pengarangBuku": "Andi",
            "penerbitBuku": "Luluh"
        },
        {
            "id": "ca6db119-93b7-4f44-ac89-e918ba61461f",
            "namaBuku": "Sepatu",
            "pengarangBuku": "Andi",
            "penerbitBuku": "Ganu"
        }
    ]
}
```
#### Buku - getDeleteBukuByNama
```
  Delete | https://buku-aej.herokuapp.com/v1/buku/namaBuku
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": "Hapus buku berhasil"
}
```
#### Buku - getUpdateBukuByNama
```
  Post | https://buku-aej.herokuapp.com/v1/buku/Update_namaBuku
```
##### Body
```
{
	"namaBuku" : "Sepatu",
   "pengarangBuku" : "Dini",
   "penerbitBuku" : "Ganu"
}
```
##### Response
```
{
    "status": true,
    "message": "Sukses",
    "data": "Update Buku Berhasil"
}
```
