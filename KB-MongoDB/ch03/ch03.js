use test
db.product.find().soert({num:-1})

// product 컬렉션의 문서를 num의 내림차순으로 정렬하여 상위 10건을 출력하세요
db.product.find().sort({num:-1}).limit(10)

// product 컬렉션의 문서를 num의 내림차순으로 정렬한 상태에서 다음을 처리하세요.
db.product.find().sort({num:-1}).skip(6*10).limit(10)

// product 컬렉션에서 num이 15미만이거나 19995 초과인 것을 출력하세요.
db.product.find({$or:[
    {num: {$lt:15}},
    {num:{$gt:19995}}
    ]
})

// product 컬렉션에서 name이 '스마트폰 10', '스마트폰 100', '스마트폰 1000' 중에 하나이면 출력하세요.
db.product.find({name:{
    $in:['스마트폰10', '스마트폰100', '스마트폰1000']
}})

// product 컬렉션에서 num이 5보다 작은 문서를 출력하는데, name만 출력하세요. (_id 출력하면 안됨)
// 0이 미출력, 1이 출력하는 필
db.product.find({num:{$lt:5}},{_id:0, name:1})