import request from '@/utils/request'

// 查询外协对账列表
export function listOutsourcingStatements(query) {
  return request({
    url: '/finance/OutsourcingStatements/list', 
    method: 'get',
    params: query
  })
}

// 查询外协对账详细
export function getOutsourcingStatements(outsourcingStatementsID) {
  return request({
    url: '/finance/OutsourcingStatements/' + outsourcingStatementsID,
    method: 'get'
  })
}

// 新增外协对账
export function addOutsourcingStatements(data) {
  return request({
    url: '/finance/OutsourcingStatements',
    method: 'post',
    data: data
  })
}

// 修改外协对账
export function updateOutsourcingStatements(data) {
  return request({
    url: '/finance/OutsourcingStatements',
    method: 'put',
    data: data
  })
}

// 删除外协对账
export function delOutsourcingStatements(outsourcingStatementsID) {
  return request({
    url: '/finance/OutsourcingStatements/' + outsourcingStatementsID,
    method: 'delete'
  })
}
