import request from '@/utils/request'

// 查询客供材料入库详细列表
export function listDetailCustomerMaterialsStorage(query) {
  return request({
    url: '/storage/DetailCustomerMaterialsStorage/list',
    method: 'get',
    params: query
  })
}

// 查询客供材料入库详细详细
export function getDetailCustomerMaterialsStorage(id) {
  return request({
    url: '/storage/DetailCustomerMaterialsStorage/' + id,
    method: 'get'
  })
}

// 新增客供材料入库详细
export function addDetailCustomerMaterialsStorage(data) {
  return request({
    url: '/storage/DetailCustomerMaterialsStorage',
    method: 'post',
    data: data
  })
}

// 修改客供材料入库详细
export function updateDetailCustomerMaterialsStorage(data) {
  return request({
    url: '/storage/DetailCustomerMaterialsStorage',
    method: 'put',
    data: data
  })
}

// 删除客供材料入库详细
export function delDetailCustomerMaterialsStorage(id) {
  return request({
    url: '/storage/DetailCustomerMaterialsStorage/' + id,
    method: 'delete'
  })
}
