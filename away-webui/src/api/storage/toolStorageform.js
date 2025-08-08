import request from '@/utils/request'

// 查询刀具入库单列表
export function listToolStorageform(query) {
  return request({
    url: '/storage/toolStorageform/list',
    method: 'get',
    params: query
  })
}

// 查询刀具入库单详细
export function getToolStorageform(warehouseEntryID) {
  return request({
    url: '/storage/toolStorageform/' + warehouseEntryID,
    method: 'get'
  })
}

// 新增刀具入库单
export function addToolStorageform(data) {
  return request({
    url: '/storage/toolStorageform',
    method: 'post',
    data: data
  })
}

// 修改刀具入库单
export function updateToolStorageform(data) {
  return request({
    url: '/storage/toolStorageform',
    method: 'put',
    data: data
  })
}

// 删除刀具入库单
export function delToolStorageform(warehouseEntryID) {
  return request({
    url: '/storage/toolStorageform/' + warehouseEntryID,
    method: 'delete'
  })
}
