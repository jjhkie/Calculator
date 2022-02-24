package com.work.part2.calculator.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.work.part2.calculator.model.History

//package model에 생성한 history 테이블에 있는 정보 어떻게 저장을 하고
//조회와 삭제는 어떻게 할지 정의를 한 것이다.
@Dao
interface HistoryDao{

    //history를 전부 가져오는 코드
    @Query("SELECT * FROM history")
    fun getAll(): List<History>

    @Insert
    fun insertHistory(history: History)

    @Query("DELETE FROM history")
    fun deleteAll()

    //추가적인 코드 [ 아래 코드는 현재 프로젝트에서는 사용하지 않는다. ]
    //하나만 삭제하고 싶다면
    @Delete
    fun delete(history: History)

    //조건에 부합하는 정보만 받고 싶다면
    @Query("SELECT * FROM history WHERE result LIKE :result")
    fun findByResult(result: String): List<History>

    //조건에 부합하는 정보만 받고 싶고 하나만 받는다면
    @Query("SELECT * FROM history WHERE result LIKE :result LIMIT 1")
    fun findByResultOne(result: String): History
}