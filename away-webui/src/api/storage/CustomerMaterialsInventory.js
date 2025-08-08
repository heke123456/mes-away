import request from '@/utils/request'

// 查询客供材料实时库存列表
export function listCustomerMaterialsInventory(query) {
  return request({
    url: '/storage/CustomerMaterialsInventory/enlist',
    method: 'get',
    params: query
  })
}

// 查询客供材料实时库存详细
export function getCustomerMaterialsInventory(id) {
  return request({
    url: '/storage/CustomerMaterialsInventory/' + id,
    method: 'get'
  })
}

// 新增客供材料实时库存
export function addCustomerMaterialsInventory(data) {
  return request({
    url: '/storage/CustomerMaterialsInventory',
    method: 'post',
    data: data
  })
}

// 修改客供材料实时库存
export function updateCustomerMaterialsInventory(data) {
  return request({
    url: '/storage/CustomerMaterialsInventory',
    method: 'put',
    data: data
  })
}

// 删除客供材料实时库存
export function delCustomerMaterialsInventory(id) {
  return request({
    url: '/storage/CustomerMaterialsInventory/' + id,
    method: 'delete'
  })
}

// 入库完成
export function addByNumber(lmlist){
  return request({
    url: '/storage/CustomerMaterialsInventory/ByNumbner/add',
    data:lmlist,
    method: 'post',
    Headers:{
      "content-type":"application/json"
    }
  })
}

// 出库完成
export function reduceByNumber(lmlist){
  return request({
    url: '/storage/CustomerMaterialsInventory/ByNumbner/reduce',
    data:lmlist,
    method: 'post',
    Headers:{
      "content-type":"application/json"
    }
  })
}
