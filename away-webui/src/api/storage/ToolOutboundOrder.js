import request from '@/utils/request'

// 查询刀具出库单列表
export function listToolOutboundOrder(query) {
  return request({
    url: '/storage/ToolOutboundOrder/list',
    method: 'get',
    params: query
  })
}

// 查询刀具出库单详细
export function getToolOutboundOrder(deliveryNoteID) {
  return request({
    url: '/storage/ToolOutboundOrder/' + deliveryNoteID,
    method: 'get'
  })
}

// 新增刀具出库单
export function addToolOutboundOrder(data) {
  return request({
    url: '/storage/ToolOutboundOrder',
    method: 'post',
    data: data
  })
}

// 修改刀具出库单
export function updateToolOutboundOrder(data) {
  return request({
    url: '/storage/ToolOutboundOrder',
    method: 'put',
    data: data
  })
}

// 删除刀具出库单
export function delToolOutboundOrder(deliveryNoteID) {
  return request({
    url: '/storage/ToolOutboundOrder/' + deliveryNoteID,
    method: 'delete'
  })
}
