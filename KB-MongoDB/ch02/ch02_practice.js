// ✅ 문제 1. theaters 컬렉션에 극장 하나 등록하기
db.theaters.insert({
    name: "CGV",
    location: "서울 강남구"
})
db.theaters.find()

// ✅ 문제 2. movies 컬렉션에 영화 2편 등록하기
db.movies.insert([
    {title: "파묘", genre: "공포", runtime: 114},
    {title: "범죄도시4", genre: "액션", runtime: 109}
])
db.movies.find()

// ✅ 문제 3. users 컬렉션에 사용자 2명 등록하기
db.users.insert([
    {name: "김지우", email: "jiwoo.kim@example.com"},
    {name: "이슬이", email: "seuli.lee@example.com"}
])
db.users.find()

// ✅ 문제 4. showtimes 컬렉션에 상영 정보 등록하기
db.movies.find({title: "파묘"})
db.theaters.find({name: "CGV", location: "서울 강남구"})
db.showtimes.insert({
    movie_id: ObjectId("68340e37c8a68e8100ea7e12"),
    theater_id: ObjectId("68340d54c8a68e8100ea7e11"),
    datetime: ISODate("2025-06-01T13:00:00Z"),
    seats: ["A1", "A2", "A3", "A4", "B1", "B2", "B3", "b4"]
})
db.showtimes.find().pretty()

// ✅ 문제 5. 등록된 영화 목록 전체 조회하기
db.movies.find()

// ✅ 문제 6. 특정 극장에서 상영 중인 영화 상영시간 목록 출력하기
db.theaters.find({name: "CGV", location: "서울 강남구"})
db.showtimes.find({theater_id: ObjectId("68340d54c8a68e8100ea7e11")})

// ✅ 문제 7. 특정 사용자의 예매 정보 등록하기
db.users.find({name: "김지우"})
db.movies.find({title:"파묘"})
db.showtimes.find({movie_id: ObjectId("68340e37c8a68e8100ea7e12")})
db.reservations.insertOne({
    user_id: ObjectId("68340ea5c8a68e8100ea7e14"),
    showtime_id: ObjectId("683413a3c8a68e8100ea7e16"),
    seats: ["A1", "A2"],
})
db.reservations.find()

// ✅ 문제 8. 특정 상영시간에 이미 예매된 좌석 목록 보기
db.movies.find({title: "파묘"}) // 68340e37c8a68e8100ea7e12
db.showtimes.find({
    movie_id: ObjectId("68340e37c8a68e8100ea7e12"),
    datetime: ISODate("2025-06-01T13:00:00Z")
})
db.reservations.find({
    showtime_id: ObjectId("683413a3c8a68e8100ea7e16")
})
db.reservations.aggregate([
    {$match: {showtime_id: ObjectId("683413a3c8a68e8100ea7e16")}},
    {$unwind: "$seats"},
    {$group: {
        _id: null,
        seats: {$addToSet: "$seats"}
    }},
    {$project: {_id: 0, seats: 1}}
])

// ✅ 문제 9. 예매된 좌석을 showtimes에서 제거하기 (차감 처리)
db.showtimes.updateOne(
  { _id: ObjectId("683413a3c8a68e8100ea7e16") },  // 실제 상영정보의 _id로 대체
  { $pull: { seats: { $in: ["A1", "A2"] } } }
)
db.showtimes.find()

// ✅ 문제 10. 예매 취소: reservations에서 삭제하고 좌석 복구하기
db.users.find({name: "김지우"})
const reservation = db.reservations.findOneAndDelete({
    user_id: ObjectId("68340ea5c8a68e8100ea7e14"),
    showtime_id: ObjectId("683413a3c8a68e8100ea7e16")
})
db.showtimes.updateOne(
    {_id: ObjectId("683413a3c8a68e8100ea7e16")},
    {$addToSet: {seats: {$each: reservation.value.seats}}}
)
db.showtimes.find()
db.reservations.find()