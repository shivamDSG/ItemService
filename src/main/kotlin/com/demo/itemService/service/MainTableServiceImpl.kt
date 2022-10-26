package com.demo.itemService.service

import com.demo.itemService.customException.NotFoundException
import com.demo.itemService.entities.MainTable
import com.demo.itemService.repository.MainTableRepo
import com.demo.itemService.mapper.UpdateItem
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
@Slf4j
class MainTableServiceImpl @Autowired constructor(val obj: MainTableRepo,val update: UpdateItem): MainTableService {

    private val log: Logger = LoggerFactory.getLogger(MainTableServiceImpl::class.java)

    override fun getAllItemDetails(): Collection<MainTable> {
        log.info("Inside getAllItemDetails")
        return obj.findAll();
    }

    override fun addNewItem(item: MainTable): ResponseEntity<String> {
        try{
            log.info("Inside addNewItem")
            obj.save(item)
            log.info("A new Item saved successfully!")
        }catch(e: Exception){
            log.error("There is some error on line 29... Read Exception: ${e.printStackTrace()}")
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went Wrong... Item Not Added")
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("A New Item Added Successfully!")
    }

    override fun searchItem(id: Int): Optional<MainTable> {
        log.info("Inside SearchItem")
        return obj.findById(id)
    }

    override fun updateItem(item: MainTable): ResponseEntity<String> {

        log.info("Inside updateItem...")
        var currentItem = obj.findByIdOrNull(item.id)
            ?: throw NotFoundException("Could Not found an Item with given id ${item.id}")

        try{
            val update = update.update(currentItem,item)
            //obj.delete(currentItem)
            log.info("Old Item deleted Successfully")
            obj.save(update)
            log.info("New Item saved Successfully")
        } catch(e: Exception){
            log.error("Error occurred while updating the data... please check the given exception ${e.printStackTrace()}")
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong... please check your code!")
        }
        return ResponseEntity.status(HttpStatus.OK).body("Item detail updated Successfully!")
    }

    override fun deleteSingleItem(id: Int): ResponseEntity<String> {
        log.info("Inside delete Single Item Method...")

        val item = obj.findByIdOrNull(id)
            ?: throw NotFoundException("Could Not found an Item with given id $id")
        try{
            obj.delete(item)
            log.info("Item with given id $id is deleted successfully!")
        }catch(e: Exception) {
            log.error("An Error Occurred while deleting the data... please check the exception ${e.printStackTrace()}")
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong... please check your code")
        }
        return ResponseEntity.status(HttpStatus.OK).body("Item with given id $id is deleted successfully!")
    }

    override fun deleteAllItem(): ResponseEntity<String> {
        log.info("Inside delete All Item")
        val itemQty: Long = obj.count()
        try{
            if(itemQty>0){
                obj.deleteAll()
                log.info("$itemQty deleted successfully!")
            } else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Data Available to delete")
            }
            log.info("All Item deleted successfully!")
        }catch(e: Exception){
            log.error("An Error Occurred while deleting all item... please check exception ${e.printStackTrace()}")
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong... please check your code once")
        }
        return ResponseEntity.status(HttpStatus.OK).body("$itemQty Item detail deleted successfully!")
    }

}