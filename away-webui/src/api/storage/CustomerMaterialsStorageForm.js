import request from '@/utils/request'

// 查询客供入库单列表
export function listCustomerMaterialsStorageForm(query) {
  return request({
    url: '/storage/CustomerMaterialsStorageForm/list',
    method: 'get',
    params: query
  })
}

// 查询客供入库单详细
export function getCustomerMaterialsStorageForm(warehouseEntryID) {
  return request({
    url: '/storage/CustomerMaterialsStorageForm/' + warehouseEntryID,
    method: 'get'
  })
}

// 新增客供入库单
export function addCustomerMaterialsStorageForm(data) {
  return request({
    url: '/storage/CustomerMaterialsStorageForm',
    method: 'post',
    data: data
  })
}

// 修改客供入库单
export function updateCustomerMaterialsStorageForm(data) {
  return request({
    url: '/storage/CustomerMaterialsStorageForm',
    method: 'put',
    data: data
  })
}

// 删除客供入库单
export function delCustomerMaterialsStorageForm(warehouseEntryID) {
  return request({
    url: '/storage/CustomerMaterialsStorageForm/' + warehouseEntryID,
    method: 'delete'
  })
}
