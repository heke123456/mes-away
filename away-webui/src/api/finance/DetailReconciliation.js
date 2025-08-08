import request from '@/utils/request'

// 查询对账详细列表
export function listDetailReconciliation(query) {
  return request({
    url: '/finance/DetailReconciliation/list',
    method: 'get',
    params: query
  })
}

// 查询对账详细详细
export function getDetailReconciliation(id) {
  return request({
    url: '/finance/DetailReconciliation/' + id,
    method: 'get'
  })
}

// 新增对账详细
export function addDetailReconciliation(data) {
  return request({
    url: '/finance/DetailReconciliation',
    method: 'post',
    data: data
  })
}

// 修改对账详细
export function updateDetailReconciliation(data) {
  return request({
    url: '/finance/DetailReconciliation',
    method: 'put',
    data: data
  })
}

// 删除对账详细
export function delDetailReconciliation(id) {
  return request({
    url: '/finance/DetailReconciliation/' + id,
    method: 'delete'
  })
}
