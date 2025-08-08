import request from '@/utils/request'

// 查询客供入库列表
export function listCustomerMaterialsStorage(query) {
  return request({
    url: '/storage/CustomerMaterialsStorage/list',
    method: 'get',
    params: query
  })
}

// 查询客供入库详细
export function getCustomerMaterialsStorage(id) {
  return request({
    url: '/storage/CustomerMaterialsStorage/' + id,
    method: 'get'
  })
}

// 新增客供入库
export function addCustomerMaterialsStorage(data) {
  return request({
    url: '/storage/CustomerMaterialsStorage',
    method: 'post',
    data: data
  })
}

// 修改客供入库
export function updateCustomerMaterialsStorage(data) {
  return request({
    url: '/storage/CustomerMaterialsStorage',
    method: 'put',
    data: data
  })
}

// 删除客供入库
export function delCustomerMaterialsStorage(id) {
  return request({
    url: '/storage/CustomerMaterialsStorage/' + id,
    method: 'delete'
  })
}
