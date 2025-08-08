import request from '@/utils/request'

// 查询客供材料实时库存列表
export function listCustomersuppliedmaterials(query) {
  return request({
    url: '/storage/customersuppliedmaterials/list',
    method: 'get',
    params: query
  })
}

// 查询客供材料实时库存详细
export function getCustomersuppliedmaterials(id) {
  return request({
    url: '/storage/customersuppliedmaterials/' + id,
    method: 'get'
  })
}

// 新增客供材料实时库存
export function addCustomersuppliedmaterials(data) {
  return request({
    url: '/storage/customersuppliedmaterials',
    method: 'post',
    data: data
  })
}

// 修改客供材料实时库存
export function updateCustomersuppliedmaterials(data) {
  return request({
    url: '/storage/customersuppliedmaterials',
    method: 'put',
    data: data
  })
}

// 删除客供材料实时库存
export function delCustomersuppliedmaterials(id) {
  return request({
    url: '/storage/customersuppliedmaterials/' + id,
    method: 'delete'
  })
}
