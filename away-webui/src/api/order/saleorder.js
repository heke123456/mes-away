import request from '@/utils/request'

// 查询订单列表
export function listSaleorder(query) {
  return request({
    url: '/order/saleorder/enlist',
    method: 'get',
    params: query
  })
}

// 查询订单详细
export function getSaleorder(id) {
  return request({
    url: '/order/saleorder/' + id,
    method: 'get'
  })
}

// 新增订单
export function addSaleorder(data) {
  return request({
    url: '/order/saleorder',
    method: 'post',
    data: data
  })
}

// 修改订单
export function updateSaleorder(data) {
  return request({
    url: '/order/saleorder',
    method: 'put',
    data: data
  })
}

// 删除订单
export function delSaleorder(id) {
  return request({
    url: '/order/saleorder/' + id,
    method: 'delete'
  })
}
