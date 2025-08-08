import request from '@/utils/request'

// 查询客供材料材料出库列表
export function listCustomerMaterialsOutbound(query) {
  return request({
    url: '/storage/CustomerMaterialsOutbound/list',
    method: 'get',
    params: query
  })
}

// 查询客供材料材料出库详细
export function getCustomerMaterialsOutbound(id) {
  return request({
    url: '/storage/CustomerMaterialsOutbound/' + id,
    method: 'get'
  })
}

// 新增客供材料材料出库
export function addCustomerMaterialsOutbound(data) {
  return request({
    url: '/storage/CustomerMaterialsOutbound',
    method: 'post',
    data: data
  })
}

// 修改客供材料材料出库
export function updateCustomerMaterialsOutbound(data) {
  return request({
    url: '/storage/CustomerMaterialsOutbound',
    method: 'put',
    data: data
  })
}

// 删除客供材料材料出库
export function delCustomerMaterialsOutbound(id) {
  return request({
    url: '/storage/CustomerMaterialsOutbound/' + id,
    method: 'delete'
  })
}
