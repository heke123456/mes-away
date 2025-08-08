import request from '@/utils/request'

// 查询对账单列表
export function listStatementOfAccount(query) {
  return request({
    url: '/finance/StatementOfAccount/list',
    method: 'get',
    params: query
  })
}

// 查询对账单详细
export function getStatementOfAccount(statementOfAccountID) {
  return request({
    url: '/finance/StatementOfAccount/' + statementOfAccountID,
    method: 'get'
  })
}

// 新增对账单
export function addStatementOfAccount(data) {
  return request({
    url: '/finance/StatementOfAccount',
    method: 'post',
    data: data
  })
}

// 修改对账单
export function updateStatementOfAccount(data) {
  return request({
    url: '/finance/StatementOfAccount',
    method: 'put',
    data: data
  })
}

// 删除对账单
export function delStatementOfAccount(statementOfAccountID) {
  return request({
    url: '/finance/StatementOfAccount/' + statementOfAccountID,
    method: 'delete'
  })
}
