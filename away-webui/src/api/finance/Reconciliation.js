import request from '@/utils/request'

// 查询对账列表
export function listReconciliation(query) {
  return request({
    url: '/finance/Reconciliation/list',
    method: 'get',
    params: query
  })
}

// 查询对账详细
export function getReconciliation(id) {
  return request({
    url: '/finance/Reconciliation/' + id,
    method: 'get'
  })
}

// 新增对账
export function addReconciliation(data) {
  return request({
    url: '/finance/Reconciliation',
    method: 'post',
    data: data
  })
}

// 修改对账
export function updateReconciliation(data) {
  return request({
    url: '/finance/Reconciliation',
    method: 'put',
    data: data
  })
}

// 删除对账
export function delReconciliation(id) {
  return request({
    url: '/finance/Reconciliation/' + id,
    method: 'delete'
  })
}
