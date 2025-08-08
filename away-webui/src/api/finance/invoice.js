import request from '@/utils/request'

// 查询发票信息列表
export function listInvoice(query) {
  return request({
    url: '/finance/invoice/list',
    method: 'get',
    params: query
  })
}

// 查询发票信息详细
export function getInvoice(id) {
  return request({
    url: '/finance/invoice/' + id,
    method: 'get'
  })
}

// 新增发票信息
export function addInvoice(data) {
  return request({
    url: '/finance/invoice',
    method: 'post',
    data: data
  })
}

// 修改发票信息
export function updateInvoice(data) {
  return request({
    url: '/finance/invoice',
    method: 'put',
    data: data
  })
}

// 删除发票信息
export function delInvoice(id) {
  return request({
    url: '/finance/invoice/' + id,
    method: 'delete'
  })
}
