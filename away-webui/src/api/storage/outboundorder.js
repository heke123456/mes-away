import request from '@/utils/request'

// 查询出库单列表
export function listOutboundorder(query) {
  return request({
    url: '/storage/outboundorder/list',
    method: 'get',
    params: query
  })
}

// 查询出库单详细
export function getOutboundorder(deliveryNoteID) {
  return request({
    url: '/storage/outboundorder/' + deliveryNoteID,
    method: 'get'
  })
}

// 新增出库单
export function addOutboundorder(data) {
  return request({
    url: '/storage/outboundorder',
    method: 'post',
    data: data
  })
}

// 修改出库单
export function updateOutboundorder(data) {
  return request({
    url: '/storage/outboundorder',
    method: 'put',
    data: data
  })
}

// 删除出库单
export function delOutboundorder(deliveryNoteID) {
  return request({
    url: '/storage/outboundorder/' + deliveryNoteID,
    method: 'delete'
  })
}
