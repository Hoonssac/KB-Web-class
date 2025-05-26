show dbs
use tutorial

// tutorial 데이터베이스의 users 컬렉션에 문서 저
db.users.insert({username:"smith"})

// tutorial 데이터베이스의 users 컬렉션에 문서 질의
db.users.find()

db.users.insert({username:"jones"})
db.users.count()
db.users.find()

db.users.find({username:"jones"})

// users 컬렉션에서 usernanme이 "jones"인 문서를 찾아서 출력하세요.
// find(조건) -> select절과 유사
db.users.find({username:"smith"})

// AND 조건 : _id와 username이 모두 일치하는 문서 조회
db.users.find({
    _id: ObjectId("6833fdf7c7bbddb06bea7e0f"),
    username: "smith"
})

// 동일한 의미의 AND 조건 (명시적 $and 연산자 사용)
db.users.find({
    $and: [
        {_id : ObjectId("6833fdf7c7bbddb06bea7e0f")},
        {username: "smith"}
    ]
})

// OR 조건 : username이 "smith" 또는 "jones"인 문서 조회
db.users.find({
    $or: [
        {username: "smith"},
        {username: "jones"}
    ]
})

// username이 "smith"인 사용자 조회
db.users.find({username: "smith"})

// 문서 일부 업데이트
// $set의 경우 키 값이 존재하지 않으면 추가
db.users.updateOne(
    {username: "smith"}, // 필터 조건
    {$set: {country: "Canada"}} // 수정 내용
)

// replaceOne : 기존 도큐먼트를 완전히 다른 내용으로 대체  
db.users.replaceOne(
    {username: "smith"}, // 대체할 문서의 조건
    {country: "Canada"} // 새로 저장할 전체 문
)

db.users.find({country: "Canada"})
db.users.find()

// users 컬렉션에서 country가 Canada인 문서를 {username: "smith", country:"Canada"}로 대체하고 확인하세요 
db.users.replaceOne({country:"Canada"}, {username:"smith", country:"Canada"})

// users 컬렉션에서 username이 smith인 문서에서 country 키를 삭제하고, 삭제 여보를 확인하세요. 
// $unset : 해당 키를 삭제  
db.users.updateOne(
    {username: "smith"},
    {$unset:{country:1}} // 삭제할 필드를 1로 지정  
)

db.users.updateOne(
    {username: "smith"},
    {$set:{ // 중첩 문서 지정
        favorites:{
            cities:["Chicago", "Cheyenne"],
            movies:["Casablanca", "For a Few Dollars More", "The Sting"]
        }
    }}
)
db.users.find()

db.users.updateOne(
    {username: "jones"},
    {$set:{ // 중첩 문서 지정
        favorites:{
            movies:["Casablanca", "Rocky"]
        }
    }}
)
db.users.find().pretty()
db.users.find({"favorites.movies":"Casablanca"}).pretty()

// users 컬렉션에서 username이 smith인 문서를 삭제하고, 삭제 여부를 확인하세요
db.users.deleteOne({username:"smith"})
db.users.find({username:"smith"})

// users 컬렉션의 모든 문서를 삭제하고, 삭제 여부를 확인하세요
db.users.deleteMany({})
db.users.find()

// users 컬렉션을 삭제하세요
db.users.drop()

// 다음 형태의 문서 20,000건을 추가하세요.
use test
for (let i = 0; i < 20000; i++) {
    db.product.insertOne({
        num:i,
        name: "스마트폰"+1
    })
}

// countDocumnets: 문서 수 출력
db.product.countDocuments()

// 데이터베이스 전체 목록 출력
show dbs

// 사용중인 데이터베이스의 컬렉션 목록 출력
show collections

// 사용중인 데이터베이스와 users 컬렉션 상태 출력 
db.stats()
db.product.stats()