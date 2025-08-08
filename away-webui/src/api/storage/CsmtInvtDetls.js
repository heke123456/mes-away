import request from '@/utils/request'

// 查询客供实时库存列表
export function listCsmtInvtDetls(query) {
  return request({
    url: '/storage/CsmtInvtDetls/list',
    method: 'get',
    params: query
  })
}

// 查询客供实时库存详细
export function getCsmtInvtDetls(id) {
  return request({
    url: '/storage/CsmtInvtDetls/' + id,
    method: 'get'
  })
}

// 新增客供实时库存
export function addCsmtInvtDetls(data) {
  return request({
    url: '/storage/CsmtInvtDetls',
    method: 'post',
    data: data
  })
}

// 修改客供实时库存
export function updateCsmtInvtDetls(data) {
  return request({
    url: '/storage/CsmtInvtDetls',
    method: 'put',
    data: data
  })
}

// 删除客供实时库存
export function delCsmtInvtDetls(id) {
  return request({
    url: '/storage/CsmtInvtDetls/' + id,
    method: 'delete'
  })
}
