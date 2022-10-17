package com.demo.itemService.mapper

import com.demo.itemService.entities.MainTable
import org.springframework.stereotype.Component

@Component
class UpdateItem {

    fun update(currentItem: MainTable, item: MainTable): MainTable {

        if(item.name!=null){
            currentItem.name = item.name
        }
        if(item.description!=null){
            currentItem.description = item.description
        }
        if(item.isActive!=null){
            currentItem.isActive = item.isActive
        }
        if(item.createdDate!=null){
            currentItem.createdDate = item.createdDate
        }
        if(item.updatedDate!=null){
            currentItem.updatedDate = item.updatedDate
        }
        return currentItem
    }

}