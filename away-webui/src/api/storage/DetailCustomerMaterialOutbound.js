import request from '@/utils/request'

// 查询客供材料出库详细列表
export function listDetailCustomerMaterialOutbound(query) {
  return request({
    url: '/storage/DetailCustomerMaterialOutbound/list',
    method: 'get',
    params: query
  })
}

// 查询客供材料出库详细详细
export function getDetailCustomerMaterialOutbound(id) {
  return request({
    url: '/storage/DetailCustomerMaterialOutbound/' + id,
    method: 'get'
  })
}

// 新增客供材料出库详细
export function addDetailCustomerMaterialOutbound(data) {
  return request({
    url: '/storage/DetailCustomerMaterialOutbound',
    method: 'post',
    data: data
  })
}

// 修改客供材料出库详细
export function updateDetailCustomerMaterialOutbound(data) {
  return request({
    url: '/storage/DetailCustomerMaterialOutbound',
    method: 'put',
    data: data
  })
}

// 删除客供材料出库详细
export function delDetailCustomerMaterialOutbound(id) {
  return request({
    url: '/storage/DetailCustomerMaterialOutbound/' + id,
    method: 'delete'
  })
}
