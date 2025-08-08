import request from '@/utils/request'

// 查询刀具出库列表
export function listToolOutbound(query) {
  return request({
    url: '/storage/ToolOutbound/list',
    method: 'get',
    params: query
  })
}

// 查询刀具出库详细
export function getToolOutbound(id) {
  return request({
    url: '/storage/ToolOutbound/' + id,
    method: 'get'
  })
}

// 新增刀具出库
export function addToolOutbound(data) {
  return request({
    url: '/storage/ToolOutbound',
    method: 'post',
    data: data
  })
}

// 修改刀具出库
export function updateToolOutbound(data) {
  return request({
    url: '/storage/ToolOutbound',
    method: 'put',
    data: data
  })
}

// 删除刀具出库
export function delToolOutbound(id) {
  return request({
    url: '/storage/ToolOutbound/' + id,
    method: 'delete'
  })
}
