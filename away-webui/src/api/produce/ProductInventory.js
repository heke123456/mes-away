import request from '@/utils/request'

// 查询产品库存列表
export function listProductInventory(query) {
  return request({
    url: '/produce/ProductInventory/list',
    method: 'get',
    params: query
  })
}

// 查询产品库存详细
export function getProductInventory(id) {
  return request({
    url: '/produce/ProductInventory/' + id,
    method: 'get'
  })
}

// 新增产品库存
export function addProductInventory(data) {
  return request({
    url: '/produce/ProductInventory',
    method: 'post',
    data: data
  })
}

// 修改产品库存
export function updateProductInventory(data) {
  return request({
    url: '/produce/ProductInventory',
    method: 'put',
    data: data
  })
}

// 删除产品库存
export function delProductInventory(id) {
  return request({
    url: '/produce/ProductInventory/' + id,
    method: 'delete'
  })
}


// 入库完成
export function addByNumber(lmlist){
  return request({
    url: '/produce/ProductInventory/ByNumbner/add',
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
    url: '/produce/ProductInventory/ByNumbner/reduce',
    data:lmlist,
    method: 'post',
    Headers:{
      "content-type":"application/json"
    }
  })
}
