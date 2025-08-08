import request from '@/utils/request'

// 查询外协对账详细列表
export function listOutsourcingReconciliation(query) {
  return request({
    url: '/finance/OutsourcingReconciliation/list',
    method: 'get',
    params: query
  })
}

// 查询外协对账详细详细
export function getOutsourcingReconciliation(id) {
  return request({
    url: '/finance/OutsourcingReconciliation/' + id,
    method: 'get'
  })
}

// 新增外协对账详细
export function addOutsourcingReconciliation(data) {
  return request({
    url: '/finance/OutsourcingReconciliation',
    method: 'post',
    data: data
  })
}

// 修改外协对账详细
export function updateOutsourcingReconciliation(data) {
  return request({
    url: '/finance/OutsourcingReconciliation',
    method: 'put',
    data: data
  })
}

// 删除外协对账详细
export function delOutsourcingReconciliation(id) {
  return request({
    url: '/finance/OutsourcingReconciliation/' + id,
    method: 'delete'
  })
}
