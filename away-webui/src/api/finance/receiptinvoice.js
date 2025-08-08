import request from '@/utils/request'

// 查询入库发票信息列表
export function listReceiptinvoice(query) {
  return request({
    url: '/finance/receiptinvoice/list',
    method: 'get',
    params: query
  })
}

// 查询入库发票信息详细
export function getReceiptinvoice(receiptInvoiceID) {
  return request({
    url: '/finance/receiptinvoice/' + receiptInvoiceID,
    method: 'get'
  })
}

// 新增入库发票信息
export function addReceiptinvoice(data) {
  return request({
    url: '/finance/receiptinvoice',
    method: 'post',
    data: data
  })
}

// 修改入库发票信息
export function updateReceiptinvoice(data) {
  return request({
    url: '/finance/receiptinvoice',
    method: 'put',
    data: data
  })
}

// 删除入库发票信息
export function delReceiptinvoice(receiptInvoiceID) {
  return request({
    url: '/finance/receiptinvoice/' + receiptInvoiceID,
    method: 'delete'
  })
}
